package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * �鿴ָ��Ա������Ϣ
 * Ҫ���û������Ա��������,Ȼ�󽫸�Ա����
 * empno,ename,job,sal,deptno,dname,loc
 * �������
 * @author tarena
 *
 */
public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Connection conn=null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			System.out.println("�������ѯ����:");
			String input=scan.next().toUpperCase();
			String sql="select e.empno,e.ename,e.job,e.sal,e.deptno,d.dname,d.loc "
					+ "from emp_545058656 e join dept_545058656 d on "
					+ "e.deptno=d.deptno where e.ename='"+input+"'";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()){
					int empno=rs.getInt("EMPNO");
					String ename=rs.getString("ENAME");
					String job=rs.getString("JOB");
					double sal=rs.getDouble("SAL");
					int deptno=rs.getInt("DEPTNO");
					String dname=rs.getString("DNAME");
					String loc=rs.getString("LOC");
					System.out.println(empno+","+ename+","+job+","+sal+","+deptno+","+dname+","+loc);
				}
				System.out.println("��ѯ���!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
