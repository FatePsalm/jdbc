package day02;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import day01.DBUtil;

/**
 * java.sql.statement ����ִ��SQL���,����
 * statementֻ�ʺ�ִ�о�̬SQL���,��:SQL����в�����ƴ�Ӷ�̬���ݵĵط�
 * ��Ϊƴ��SQL�������SQL���ĸ������,���ҿ��ܳ���SQLע�빥��
 * java.sql.preparedStatement ��Statement������ר�����������������
 * PS�ʺ�ִ�к��ж�̬��Ϣ��SQl���
 * ��ִ�е���Ԥ����SQL���
 * @author tarena
 *
 */
public class JDBCDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("�������û���:");
		String username=scan.next();
		System.out.println("����������:");
		String password=scan.next();
		System.out.println("������email:");
		String email=scan.next();
		System.out.println("�������ǳ�:");
		String nickname=scan.next();
		 Connection conn=null;
		 try {
			conn=DBUtil.getConnection();
			/*
			 * Ԥ����SQL���,�ص�:
			 * ���ж�̬��Ϣ��"?"����.ע��,ֻ��
			 * ����ֵ
			 */
			String sql="insert into userinfo_545058656"+
						" (id,username,password,email,nickname,account)"+
						"  values"+
						" (seq_userinfo_id_545058656.nextval,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,nickname);
			ps.setDouble(5,5000);
//			System.out.println(sql);
			int i=ps.executeUpdate();
//			System.out.println(i);
			if(i>0){
				System.out.println("ע��ɹ�!");
			}else{
				System.out.println("ע��ʧ��!");
			}
						
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
