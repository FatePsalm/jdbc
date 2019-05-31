package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建一个序列
 * seq_userinfo_id_545058656
 * 从1开始步进为1
 * @author tarena
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl", "openlab", "open123");
			Statement state=conn.createStatement();
			String seq="create SEQUENCE seq_userinfo_id_545058656 "+ 
					   "start with 1 increment by 1";
			state.execute(seq);
			System.out.println("序列序列创建完毕!");
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
