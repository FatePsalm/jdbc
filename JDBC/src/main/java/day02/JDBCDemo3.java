package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * ��¼
 * @author tarena
 *
 */
public class JDBCDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("��¼��:");
		String username=scan.next();
		System.out.println("����:");
		String password=scan.next();
		Connection conn=DBUtil.getConnection();
		String sql="select username from userinfo_545058656 where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			/*
			 * ����ʹ��ps���ὲ��̬��Ϣƴ�ӵ�SQL�����
			 * �����Ͳ����������ƴ���˶�̬��Ϣ���ܵ��¸ı�����
			 * �����,����ʹ��ps�������sqlע�빥������
			 */
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println(username+"_��ӭʹ��!");
			}else{
				System.out.println("�û������������!");
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
		
	}

}
