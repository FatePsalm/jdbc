package day01;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ���������
 */
import java.util.Scanner;
public class Test06 {
	private static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
					
			String email=email();
			System.out.println(email);

	}
	public static String username(){
		Connection conn=DBUtil.getConnection();
		String username=null;
		try {
			Statement state=conn.createStatement();
			while(true){
				System.out.println("�������û���:");
				username=scan.next();
				String sql="select username from userinfo_545058656 where username='"+username+"'";
				int i=state.executeUpdate(sql);
				if(i>0){
					System.out.println("�û�����ռ��!");
				}else{
					System.out.println("��ϲ��!�û�����ע��!");
					break;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return username;
		
	}
	public static String email(){
		String input=null;
		while(true){
			System.out.println("emali");
			input=scan.next();
			String reg="[A-Za-z0-9]{5,16}@\\w{2,6}\\.\\w{2,3}+";
			if(input.matches(reg)&&input.contains("@")){
				System.out.println("����");
				break;
			}else{
				System.out.println("NO");
			}
			
		}
		return input;
	}
	public void password(){
		System.out.println("����������:");
		String password=scan.next();
		System.out.println("ȷ������:");
		String password_last=scan.next();
		if(!password.equals(password_last)){
			System.out.println("���벻һ��!");
		}
	}

}
