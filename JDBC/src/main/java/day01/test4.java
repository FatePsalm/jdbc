package day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
 * 将给定用户名所对应的用户删除
 * 程序启动后要求用户输入用户名
 * 删除userinfo表中对应的记录
 */
public class test4 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			String sql="SELECT * FROM userinfo_545058656 ";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id".toUpperCase());
				String username=rs.getString("username".toUpperCase());
				String password=rs.getString("password".toUpperCase());
				String email=rs.getString("email".toUpperCase());
				String nickname=rs.getString("nickname".toUpperCase());
				int account=rs.getInt("account");
				System.out.println(id+","+username+","+password+","+email+","+nickname+","+account);
			}
			System.out.println("请输入要删除的用户名:");
			String input=scan.next();
			sql="DELETE FROM userinfo_545058656 where username='"+input+"'";
			int i=state.executeUpdate(sql);
			if(i>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");				
			}
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
