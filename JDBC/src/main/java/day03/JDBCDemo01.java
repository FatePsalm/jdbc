package day03;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import day01.DBUtil;

/**
 *�����Զ�����
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
			 * ����һ������,��Ϊ"IT"���ڵ�Ϊ"BEIJING"
			 * ͬʱ����һ��Ա��"JACK,CLERK,3000"��Ա��ΪIT��Ա��
			 */
			String deptSql="insert into dept_545058656"
						+ "  (deptno,dname,loc)"
						+ "	  values"
						+ "  (seq_dept_id545058656.nextval,?,?)";
			/*
			 * ����PSʱָ���ڶ�������,��������һ���ַ�������,�����е�ÿ��Ԫ��Ӧ����һ���ֶ���
			 * ����ͨ��PSִ��DML������,���ظü�¼��Ӧ�ֶε�ֵ
			 */
			PreparedStatement dps=conn.prepareStatement(deptSql,new String[]{"deptno"});
			dps.setString(1, "IT");
			dps.setString(2, "BEIJING");
			dps.executeUpdate();
			/*
			 * ��ȡ�����������ָ���ֶε�ֵ
			 * ���ؽ��Ϊһ���������ʽ
			 */
			ResultSet rs=dps.getGeneratedKeys();
			rs.next();
			/*
			 * ��ȡ��һ���ֶε�ֵ(deptno)
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
			System.out.println("����ɹ�!");
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
