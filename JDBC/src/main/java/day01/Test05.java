package day01;
/**
 * 模拟完成登录功能
 * 要求用户输入用户名和密码
 * 然后去表中查询该用户,若查询出来则显示
 * 欢迎你!nickname,你当前余额为:5000
 * 若输入错误则显示用户名或密码错误
 * 2:完成注册功能
 * 注册的同时,要求检测用户名不允许重复
 * 3;将课堂所有案列写至少一遍
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			while(true){
				System.out.println("请输入用户名:");
				String inputusername=scan.next();
				System.out.println("请输入密码:");
				String inputpassword=scan.next();
				String sql="select username,password,nickname,account from userinfo_545058656 "
						+ "where username='"+inputusername+"' and password='"+inputpassword+"'";
//				System.out.println(sql);
				int i=state.executeUpdate(sql);
//				System.out.println(i);
				if(i>0){
//					sql="select nickname,account from userinfo_545058656 where username='"+inputusername+"'";
//					System.out.println(sql);
					ResultSet rs=state.executeQuery(sql);
					rs.next();
					String nickname=rs.getString("nickname".toUpperCase());
					double account=rs.getDouble("account".toUpperCase());
					System.out.println("欢迎你!"+nickname+",你当前余额为:"+account);
					break;
				}else{
					System.out.println("用户名或密码错误");
				}
			}
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
