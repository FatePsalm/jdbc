package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC java数据库连接
 * JDBC是JAVA官方提供的一套接口,用于连接并操作数据库
 * 不同的数据库厂商提供了一套JDBC实现类,并以jar包形式发布,
 * 用于使我们的程序可以通过这套实现类来操作其数据库,这套jar
 * 称为"驱动",我们无需记住这些数据库提供商提供的JDBC实现类的名字
 *只要使用JDBC接口看他他们即可,以多态形式调用他们来操作数据库
 *JDBC接口:
 *1:DriverManager
 *DriverManager是实现类,用于加载数据库驱动,并与数据库连接连接,成功建立后产生Connection
 *
 *2:Connection接口
 *表示与数据库的连接,负责管理事务,创建Statement实例
 *3:statement接口
 *负责执行SQL语句
 *4:ResultSet
 *表示查询结果集
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
			 * 连接数据库步骤:
			 * 1:加载类库(驱动jar包)到JVM
			 * 2:通过DriverManager建立连接
			 *   这里会加载jar包中的JDBC实现类
			 *   来与数据库建立连接
			 *  3:通过Connection创建Statement对象
			 *  4:通过Statement执行SQL语句
			 *  5:若执行的是DQL语句,则会得到查询结果集Result
			 *  遍历该结果集得到查询内容
			 *  6:关闭连接
			 *  
			 *  1:加载驱动包
			 *  不同数据库,驱动包路径不同
			 *  2:下面代码容易出现
			 *  classNotFoundException
			 *  原因一般有两个
			 *  1:类路径写错了
			 *  2:项目没有导入驱动jar包
			 *  
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/*
			 * 2:加载驱动建立连接
			 *
				DriverManger的静态方法getConnection
				该方法要求传入三个参数:
				1:数据库地址(不同数据库格式不同)
				2:登录数据库是的用户名
				3:密码
				*/
			/*
			 * oracle的格式:
			 * jdbc:oracle:thin:@url:port:sid
			 */
			conn=DriverManager.getConnection("jdbc:oracle:thin:@172.17.85.250:1521:orcl", "openlab", "open123");
			System.out.println("与数据库建立连接."+conn);
			/*
			 * 3：创建Statement
			 * 执行不同种类的SQL语句有相应的方法
			 * 1:int executeUpdate(String sql)
			 * 专门用来执行DML语句的方法,返回值是一个整数用来表示执行了该DMl语句后影响了表中多少条数据
			 * 2:Resultset executeQuery(String sql)专门用来指定DQL语句的方法,返回值为查询结果集
			 * 3:boolean execute(string sql)
			 * 什么是SQl语句都可以指定行,但由于DML,DQL有专门的方法,所以该方法一般用来执行DDL语句
			 * .返回值为true时说明执行后有返回值,但是若执行不是DQL语句,其他类型语句执行后返回值都是false
			 */
			Statement state=conn.createStatement();
			/*
			 * 执行DDl语句,创建表userinfo
			 * 字段:
			 * id number(6)				主键
			 * username varchar2(32)	用户名
			 * password varchar2(32)	密码
			 * email varchar2(50)		邮箱
			 * nickname varchar2(32)	昵称
			 * account number(10,2)		账户余额
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
			System.out.println("表创建完毕");
		
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



































