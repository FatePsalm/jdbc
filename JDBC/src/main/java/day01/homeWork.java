package day01;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class homeWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Connection conn=DBUtil.getConnection();
		while(true){
			
			System.out.println("请输入用户名;");
			String username=scan.next();
			System.out.println("请输入密码;");
			String password=scan.next();
			System.out.println("请确认密码;");
			String password_last=scan.next();
			System.out.println("请输入email;");
			String email=scan.next();
			System.out.println("请输入昵称;");
			String nickname=scan.next();
			System.out.println("请输入期望工资;");
			int account=Integer.parseInt(scan.next());
			
			try {
				Statement state=conn.createStatement();
				String username_sql="select username from userinfo_545058656 where username='"+username+"'";
//				System.out.println(username_sql);
				int i=state.executeUpdate(username_sql);
//				System.out.println(i);
				if(i>0){
					System.out.println("注册用户名已占用!");
					break;
				}else{
					System.out.println("恭喜你,可以注册!");
				}
				if(!password.equals(password_last)){
					System.out.println("两次输入密码不一致!");
					break;
				}
				if(!email.contains("@")){
					
					System.out.println("email不符合规范");
				}
				
				String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
						"values (seq_userinfo_id_545058656.nextval,"
						+ "'"+username+"','"+password+"','"+email+"','"+nickname+"',"+account+")";
//				System.out.println(sql);
				int in=state.executeUpdate(sql);
				if(in>0){
					System.out.println("注册成功!");
				}else{
					System.out.println("请重新注册!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
