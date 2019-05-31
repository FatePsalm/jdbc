package day02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import day01.DBUtil;

public class JDBCDemo08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn=DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			long start =System.currentTimeMillis();
			for(int i=0;i<1000;i++){
				String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
						" values "+
						"(seq_userinfo_id_545058656.nextval,'user"+i+"','123456','email@"+i+"','pass"+i+"',5000)";
				state.addBatch(sql);
			}
			int[] date=state.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("Íê³É,ºÄÊ±:"+(end-start)+"MS");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
