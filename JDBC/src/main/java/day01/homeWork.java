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
			
			System.out.println("�������û���;");
			String username=scan.next();
			System.out.println("����������;");
			String password=scan.next();
			System.out.println("��ȷ������;");
			String password_last=scan.next();
			System.out.println("������email;");
			String email=scan.next();
			System.out.println("�������ǳ�;");
			String nickname=scan.next();
			System.out.println("��������������;");
			int account=Integer.parseInt(scan.next());
			
			try {
				Statement state=conn.createStatement();
				String username_sql="select username from userinfo_545058656 where username='"+username+"'";
//				System.out.println(username_sql);
				int i=state.executeUpdate(username_sql);
//				System.out.println(i);
				if(i>0){
					System.out.println("ע���û�����ռ��!");
					break;
				}else{
					System.out.println("��ϲ��,����ע��!");
				}
				if(!password.equals(password_last)){
					System.out.println("�����������벻һ��!");
					break;
				}
				if(!email.contains("@")){
					
					System.out.println("email�����Ϲ淶");
				}
				
				String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
						"values (seq_userinfo_id_545058656.nextval,"
						+ "'"+username+"','"+password+"','"+email+"','"+nickname+"',"+account+")";
//				System.out.println(sql);
				int in=state.executeUpdate(sql);
				if(in>0){
					System.out.println("ע��ɹ�!");
				}else{
					System.out.println("������ע��!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
