package day01;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接管理
 * @author tarena
 *
 */
public class DBUtil {
	private static BasicDataSource ds;//数据库连接池
	static{
		try {
			/*
			 * 加载config.properties
			 * 
			 */
			Properties prop=new Properties();
			//类加载器的getResourceAsStream方法,会依据类路径去查找.properties文件,然后返回一个
			//inputStream.
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
			//获取信息初始化属性
			String drivername=prop.getProperty("drivername");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait=Integer.parseInt(prop.getProperty("maxwait"));
			//初始化连接池
			ds=new BasicDataSource();
			//Class.forName()
			ds.setDriverClassName(drivername);
			//DriverManager.getConnection
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			//最大连接数
			ds.setMaxActive(maxActive);
			//最大等待时间
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
	 * 获取数据库连接
	 * @return
	 * @throws Exception 
	 */
	public static Connection getConnection()  {
		Connection conn=null;
		try {
			/*
			 * 连接池提供了获取连接的方法
			 * Connection getConnection()
			 * 该方法会将连接池中的空闲连接返回
			 * 若当前连接池中没有可以用空闲连接,那么
			 * 该方法会阻塞,阻塞时间有maxWait指定的值决定
			 * 在阻塞期间若有空闲连接可用会立刻返回该连接,若超时后仍没有可用连接
			 * 那么该方法会抛出超时异常
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
