package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DQL
 * @author tarena
 *
 */
public class jdbcDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl", "openlab", "open123");
			Statement state=conn.createStatement();
			String sql="SELECT id,username,password,email,nickname,account "
					   +" FROM userinfo_545058656";
			ResultSet rs=state.executeQuery(sql);
			/*
			 * ResultSet 表示查询的结果集
			 * 遍历结果集的步骤:
			 * 1:先判断结果集是否还有吓一条记录
			 * 2:若有,则可以获取该条记录各字段的值
			 * 若此反复直到所有记录都被遍历完毕
			 * 遍历的相关方法
			 * 1:boolean next()
			 * 该方法会让指针指向结果集吓一跳记录并是
			 * resultset表示该条记录,若返回值为false
			 * 则表示没有记录了
			 * 2:一组get***(string colName)方法
			 * 获取字符串类型字段值用getstring
			 * 获取整数用getint,获取小数用getDouble等
			 */
			while(rs.next()){
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String nickname=rs.getString("nickname");
				double account=rs.getDouble("account");
				System.out.println(id+","+username+","+password+","+email+","+nickname+","+account);
			}
			
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
