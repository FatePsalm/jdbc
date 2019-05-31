package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import day01.DBUtil;

/**
 * JDBC的事物控制
 * JDBC默认是自动提交事物的,即:每指定一条DML操作事物就会提交
 * 事物是在COnnection中维护的,但实际上调用的还是数据库的事物机制
 * 
 * 事物
 * 完成转账操作
 * 输入转出账号用户名,在输入转入账号用户名,以及转账金额完成操作
 * @author tarena
 *
 */
public class JDBCDmen06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入转出账号用户名;");
		String outNmae=scan.next();
		System.out.println("请输入转入账号用户名;");
		String inNmae=scan.next();
		System.out.println("请输入转账金额;");
		double num=Double.parseDouble(scan.next());
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			/**
			 * 若希望控制事务,那么首先要将自动提交事务关闭
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
				System.out.println("转出账号出错!");
				conn.rollback();//回滚事务
				return;
			}
			PreparedStatement inPs=conn.prepareStatement(inSql);
			inPs.setDouble(1,num);
			inPs.setString(2,inNmae);
			i=inPs.executeUpdate();
			if(i>0){
				System.out.println("转账完成!");
				conn.commit();//提交事务
			}else{
				System.out.println("转入异常!");
				conn.rollback();//回滚事务
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
