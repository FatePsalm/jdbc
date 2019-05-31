package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC java���ݿ�����
 * JDBC��JAVA�ٷ��ṩ��һ�׽ӿ�,�������Ӳ��������ݿ�
 * ��ͬ�����ݿ⳧���ṩ��һ��JDBCʵ����,����jar����ʽ����,
 * ����ʹ���ǵĳ������ͨ������ʵ���������������ݿ�,����jar
 * ��Ϊ"����",���������ס��Щ���ݿ��ṩ���ṩ��JDBCʵ���������
 *ֻҪʹ��JDBC�ӿڿ������Ǽ���,�Զ�̬��ʽ�����������������ݿ�
 *JDBC�ӿ�:
 *1:DriverManager
 *DriverManager��ʵ����,���ڼ������ݿ�����,�������ݿ���������,�ɹ����������Connection
 *
 *2:Connection�ӿ�
 *��ʾ�����ݿ������,�����������,����Statementʵ��
 *3:statement�ӿ�
 *����ִ��SQL���
 *4:ResultSet
 *��ʾ��ѯ�����
 *
 * @author tarena
 *
 */
public class jdbcDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			/*
			 * �������ݿⲽ��:
			 * 1:�������(����jar��)��JVM
			 * 2:ͨ��DriverManager��������
			 *   ��������jar���е�JDBCʵ����
			 *   �������ݿ⽨������
			 *  3:ͨ��Connection����Statement����
			 *  4:ͨ��Statementִ��SQL���
			 *  5:��ִ�е���DQL���,���õ���ѯ�����Result
			 *  �����ý�����õ���ѯ����
			 *  6:�ر�����
			 *  
			 *  1:����������
			 *  ��ͬ���ݿ�,������·����ͬ
			 *  2:����������׳���
			 *  classNotFoundException
			 *  ԭ��һ��������
			 *  1:��·��д����
			 *  2:��Ŀû�е�������jar��
			 *  
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/*
			 * 2:����������������
			 *
				DriverManger�ľ�̬����getConnection
				�÷���Ҫ������������:
				1:���ݿ��ַ(��ͬ���ݿ��ʽ��ͬ)
				2:��¼���ݿ��ǵ��û���
				3:����
				*/
			/*
			 * oracle�ĸ�ʽ:
			 * jdbc:oracle:thin:@url:port:sid
			 */
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl", "openlab", "open123");
			System.out.println("�����ݿ⽨������."+conn);
			/*
			 * 3������Statement
			 * ִ�в�ͬ�����SQL�������Ӧ�ķ���
			 * 1:int executeUpdate(String sql)
			 * ר������ִ��DML���ķ���,����ֵ��һ������������ʾִ���˸�DMl����Ӱ���˱��ж���������
			 * 2:Resultset executeQuery(String sql)ר������ָ��DQL���ķ���,����ֵΪ��ѯ�����
			 * 3:boolean execute(string sql)
			 * ʲô��SQl��䶼����ָ����,������DML,DQL��ר�ŵķ���,���Ը÷���һ������ִ��DDL���
			 * .����ֵΪtrueʱ˵��ִ�к��з���ֵ,������ִ�в���DQL���,�����������ִ�к󷵻�ֵ����false
			 */
			Statement state=conn.createStatement();
			/*
			 * ִ��DDl���,������userinfo
			 * �ֶ�:
			 * id number(6)				����
			 * username varchar2(32)	�û���
			 * password varchar2(32)	����
			 * email varchar2(50)		����
			 * nickname varchar2(32)	�ǳ�
			 * account number(10,2)		�˻����
			 */
			String sql="create table userinfo_545058656("+
					   " id number(6), "+
					   " username varchar2(32), "+
					   " password varchar2(32), "+
					   " email varchar2(50), "+
					   " nickname varchar2(32), "+
					   " account number(10,2)  "+
					   ")";
			System.out.println(sql);
			state.execute(sql);
			System.out.println("�������");
		
		} catch (Exception e) {
			// TODO: handle exception
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



































