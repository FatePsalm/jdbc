package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * 使用ps修改用户余额
 * 
 * @author tarena
 *
 */
public class JDBCDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入修改用户名:");
		String username=scan.next();
		System.out.println("请输入修改余额:");
		double account=Double.parseDouble(scan.next());
		Connection conn=DBUtil.getConnection();
		String sql="update userinfo_545058656 set account=? where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1,account);
			ps.setString(2,username);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("修改成功!");
			}else{
				System.out.println("修改失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
