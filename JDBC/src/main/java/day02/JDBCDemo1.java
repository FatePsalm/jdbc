package day02;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import day01.DBUtil;

/**
 * java.sql.statement 用来执行SQL语句,但是
 * statement只适合执行静态SQL语句,即:SQL语句中不含用拼接动态数据的地方
 * 因为拼接SQL语句会带来SQL语句的复杂提高,并且可能出现SQL注入攻击
 * java.sql.preparedStatement 是Statement的子类专门用来解决上述问题
 * PS适合执行含有动态信息的SQl语句
 * 其执行的是预编译SQL语句
 * @author tarena
 *
 */
public class JDBCDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username=scan.next();
		System.out.println("请输入密码:");
		String password=scan.next();
		System.out.println("请输入email:");
		String email=scan.next();
		System.out.println("请输入昵称:");
		String nickname=scan.next();
		 Connection conn=null;
		 try {
			conn=DBUtil.getConnection();
			/*
			 * 预编译SQL语句,特点:
			 * 所有动态信息用"?"代替.注意,只能
			 * 代替值
			 */
			String sql="insert into userinfo_545058656"+
						" (id,username,password,email,nickname,account)"+
						"  values"+
						" (seq_userinfo_id_545058656.nextval,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,nickname);
			ps.setDouble(5,5000);
//			System.out.println(sql);
			int i=ps.executeUpdate();
//			System.out.println(i);
			if(i>0){
				System.out.println("注册成功!");
			}else{
				System.out.println("注册失败!");
			}
						
		} catch (Exception e) {
			// TODO: handle exception
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
