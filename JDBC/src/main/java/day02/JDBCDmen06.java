package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * JDBC���������
 * JDBCĬ�����Զ��ύ�����,��:ÿָ��һ��DML��������ͻ��ύ
 * ��������COnnection��ά����,��ʵ���ϵ��õĻ������ݿ���������
 * 
 * ����
 * ���ת�˲���
 * ����ת���˺��û���,������ת���˺��û���,�Լ�ת�˽����ɲ���
 * @author tarena
 *
 */
public class JDBCDmen06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("������ת���˺��û���;");
		String outNmae=scan.next();
		System.out.println("������ת���˺��û���;");
		String inNmae=scan.next();
		System.out.println("������ת�˽��;");
		double num=Double.parseDouble(scan.next());
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			/**
			 * ��ϣ����������,��ô����Ҫ���Զ��ύ����ر�
			 */
			conn.setAutoCommit(false);
			String outSql="update userinfo_545058656 "
					+ 	  " set account=account-? "
					+     " where username=?";
			String inSql="update  userinfo_545058656 "
						+ " set account=account+? "
						+ " where username=?";
			PreparedStatement outPs=conn.prepareStatement(outSql);
			outPs.setDouble(1,num);
			outPs.setString(2,outNmae);
			int i=outPs.executeUpdate();
			if(i==0){
				System.out.println("ת���˺ų���!");
				conn.rollback();//�ع�����
				return;
			}
			PreparedStatement inPs=conn.prepareStatement(inSql);
			inPs.setDouble(1,num);
			inPs.setString(2,inNmae);
			i=inPs.executeUpdate();
			if(i>0){
				System.out.println("ת�����!");
				conn.commit();//�ύ����
			}else{
				System.out.println("ת���쳣!");
				conn.rollback();//�ع�����
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		}finally{
			if(conn!=null){
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
