package day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
 * �������û�������Ӧ���û�ɾ��
 * ����������Ҫ���û������û���
 * ɾ��userinfo���ж�Ӧ�ļ�¼
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
			System.out.println("������Ҫɾ�����û���:");
			String input=scan.next();
			sql="DELETE FROM userinfo_545058656 where username='"+input+"'";
			int i=state.executeUpdate(sql);
			if(i>0){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");				
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
