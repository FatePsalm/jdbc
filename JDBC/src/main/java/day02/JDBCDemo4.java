package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day01.DBUtil;

/**
 * statement 只适合执行静态SQL语句
 * preparedStatement 适合执行含有动态信息的SQL
 * ps批量执行动态SQl也比statement效率高
 * 当批量执行SQL语句时,影响效率的主要因素
 * 1:若是含有动态信息时,使用pS效率比statement好
 * 减少执行过程产生,降低数据库压力和系统开销
 * 2;事物越多,效率越差
 * 3:单词发送SQL比批量发送SQL语句效率低
 * @author tarena
 *
 */
public class JDBCDemo4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username="jack";
		String email="123456@qq.com";
		String nickname="jion";
		Connection conn=DBUtil.getConnection();
		String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
					" values "+
					"(seq_userinfo_id_545058656.nextval,?,'123456',?,?,5000)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int s=0;
			for(int i=0;i<1000;i++){
				ps.setString(1,username+i);
				ps.setString(2,i+email);
				ps.setString(3,nickname+i);	
				int r=ps.executeUpdate();
				s=r;
			}
			System.out.println("插入"+s);
			
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
