package day01;
/**
 * ģ����ɵ�¼����
 * Ҫ���û������û���������
 * Ȼ��ȥ���в�ѯ���û�,����ѯ��������ʾ
 * ��ӭ��!nickname,�㵱ǰ���Ϊ:5000
 * �������������ʾ�û������������
 * 2:���ע�Ṧ��
 * ע���ͬʱ,Ҫ�����û����������ظ�
 * 3;���������а���д����һ��
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
				System.out.println("�������û���:");
				String inputusername=scan.next();
				System.out.println("����������:");
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
					System.out.println("��ӭ��!"+nickname+",�㵱ǰ���Ϊ:"+account);
					break;
				}else{
					System.out.println("�û������������");
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
