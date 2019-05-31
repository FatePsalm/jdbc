package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * ʹ��ps�޸��û����
 * 
 * @author tarena
 *
 */
public class JDBCDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("�������޸��û���:");
		String username=scan.next();
		System.out.println("�������޸����:");
		double account=Double.parseDouble(scan.next());
		Connection conn=DBUtil.getConnection();
		String sql="update userinfo_545058656 set account=? where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1,account);
			ps.setString(2,username);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("�޸ĳɹ�!");
			}else{
				System.out.println("�޸�ʧ��!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
