package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 查看emp表中的员工信息,查看empno,ename,job,sal,deptno
 * 根据sal倒序排序,每页显示5条,查看第二页的内容
 * @author tarena
 *
 */
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		int page=2;
		int pageSize=5;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl", "openlab", "open123");
			Statement state=conn.createStatement();
			String sql="select * from(select rownum rn,t.* from (select empno,ename,job,sal,deptno from emp_545058656 order by sal desc) t)"+
			"where rn between  "+((page-1)*pageSize+1)+"  and  "+(pageSize*page);
//			System.out.println(sql);
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()){
				int rn=rs.getInt("RN");
				int empno=rs.getInt("EMPNO");
				String ename=rs.getString("ENAME");
				String job=rs.getString("JOB");
				double sal=rs.getDouble("SAL");
				int deptno=rs.getInt("DEPTNO");
				System.out.println(rn+","+empno+","+ename+","+job+","+sal+","+deptno);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
