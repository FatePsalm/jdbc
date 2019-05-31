package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * 登录
 * @author tarena
 *
 */
public class JDBCDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("登录名:");
		String username=scan.next();
		System.out.println("密码:");
		String password=scan.next();
		Connection conn=DBUtil.getConnection();
		String sql="select username from userinfo_545058656 where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			/*
			 * 由于使用ps不会讲动态信息拼接到SQL语句中
			 * 这样就不会出现由于拼接了动态信息可能导致改变语义
			 * 的情况,所以使用ps不会出现sql注入攻击问题
			 */
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println(username+"_欢迎使用!");
			}else{
				System.out.println("用户名或密码错误!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
