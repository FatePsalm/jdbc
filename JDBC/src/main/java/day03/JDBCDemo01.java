package day03;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import day01.DBUtil;

/**
 *返回自动主键
 * @author tarena
 *
 */
public class JDBCDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		try {
			conn=DBUtil.getConnection();
			/*
			 * 插入一个部门,名为"IT"所在地为"BEIJING"
			 * 同时插入一个员工"JACK,CLERK,3000"该员工为IT部员工
			 */
			String deptSql="insert into dept_545058656"
						+ "  (deptno,dname,loc)"
						+ "	  values"
						+ "  (seq_dept_id545058656.nextval,?,?)";
			/*
			 * 创建PS时指定第二个参数,还参数是一个字符串数组,数组中的每个元素应当是一个字段名
			 * 标明通过PS执行DML操作后,返回该记录对应字段的值
			 */
			PreparedStatement dps=conn.prepareStatement(deptSql,new String[]{"deptno"});
			dps.setString(1, "IT");
			dps.setString(2, "BEIJING");
			dps.executeUpdate();
			/*
			 * 获取插入的数据中指定字段的值
			 * 返回结果为一个结果集形式
			 */
			ResultSet rs=dps.getGeneratedKeys();
			rs.next();
			/*
			 * 获取第一个字段的值(deptno)
			 */
			int deptno=rs.getInt(1);
			String empSql="insert into emp_545058656"
						+ " (empno,ename,job,sal,deptno)"
						+ " values"
						+ " (seq_emp_id545058656.nextval,?,?,?,?)";
			PreparedStatement eps=conn.prepareStatement(empSql);
			eps.setString(1, "JACK");
			eps.setString(2, "CLERK");
			eps.setInt(3, 3000);
			eps.setInt(4, deptno);
			eps.executeUpdate();			
			System.out.println("插入成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
