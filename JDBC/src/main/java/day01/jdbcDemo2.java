package day01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ÷¥––
 * @author tarena
 *
 */
public class jdbcDemo2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("«Î ‰»Î”√ªß√˚:");
		String username=scan.next();
		System.out.println("«Î ‰»Î√‹¬Î:");
		String password=scan.next();
		System.out.println("«Î ‰»Î” œ‰:");
		String email=scan.next();
		System.out.println("«Î ‰»ÎÍ«≥∆:");
		String nickname=scan.next();
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl","openlab","open123");
			Statement state =conn.createStatement();
			String sql=" insert into userinfo_545058656 ( "+
					   " id,username,password,email,nickname,account) "+ 
					   " values ( seq_userinfo_id_545058656.nextval,"+
					   "'"+username+"','"+password+"','"+email+"','"+nickname+"',5000)";
			int i=state.executeUpdate(sql);
			System.out.println("◊¢≤·≥…π¶!"+i);
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
	public void judge(String username,String password,String email,String nickname){
		
	}
	public String input(){
		Scanner scan=new Scanner(System.in);
		System.out.println("«Î ‰»Î”√ªß√˚:");
		String username=scan.next();
		System.out.println("«Î ‰»Î√‹¬Î:");
		String password=scan.next();
		System.out.println("«Î ‰»Î” œ‰:");
		String email=scan.next();
		System.out.println("«Î ‰»ÎÍ«≥∆:");
		String nickname=scan.next();
		List<String> list=new ArrayList<String>();
		
		return username;
	}

}

