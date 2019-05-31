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
			 * ResultSet ��ʾ��ѯ�Ľ����
			 * ����������Ĳ���:
			 * 1:���жϽ�����Ƿ�����һ����¼
			 * 2:����,����Ի�ȡ������¼���ֶε�ֵ
			 * ���˷���ֱ�����м�¼�����������
			 * ��������ط���
			 * 1:boolean next()
			 * �÷�������ָ��ָ��������һ����¼����
			 * resultset��ʾ������¼,������ֵΪfalse
			 * ���ʾû�м�¼��
			 * 2:һ��get***(string colName)����
			 * ��ȡ�ַ��������ֶ�ֵ��getstring
			 * ��ȡ������getint,��ȡС����getDouble��
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
