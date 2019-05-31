package day01;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ���ݿ����ӹ���
 * @author tarena
 *
 */
public class DBUtil {
	private static BasicDataSource ds;//���ݿ����ӳ�
	static{
		try {
			/*
			 * ����config.properties
			 * 
			 */
			Properties prop=new Properties();
			//���������getResourceAsStream����,��������·��ȥ����.properties�ļ�,Ȼ�󷵻�һ��
			//inputStream.
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			//��ȡ��Ϣ��ʼ������
			String drivername=prop.getProperty("drivername");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait=Integer.parseInt(prop.getProperty("maxwait"));
			//��ʼ�����ӳ�
			ds=new BasicDataSource();
			//Class.forName()
			ds.setDriverClassName(drivername);
			//DriverManager.getConnection
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			//���������
			ds.setMaxActive(maxActive);
			//���ȴ�ʱ��
			ds.setMaxWait(maxWait);
			
//			System.out.println(drivername);
//			System.out.println(url);
//			System.out.println(username);
//			System.out.println(password);
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection()  {
		Connection conn=null;
		try {
			/*
			 * ���ӳ��ṩ�˻�ȡ���ӵķ���
			 * Connection getConnection()
			 * �÷����Ὣ���ӳ��еĿ������ӷ���
			 * ����ǰ���ӳ���û�п����ÿ�������,��ô
			 * �÷���������,����ʱ����maxWaitָ����ֵ����
			 * �������ڼ����п������ӿ��û����̷��ظ�����,����ʱ����û�п�������
			 * ��ô�÷������׳���ʱ�쳣
			 */
			return ds.getConnection();
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return conn;
	}
}
