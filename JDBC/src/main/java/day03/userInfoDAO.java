package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day01.DBUtil;
/*
 * DAO数据访问对象
 * DAO是一个层次所有类的统称
 * DAO是夹在业务逻辑层与数据库之间的层次
 * 作用是将对数据库的所有操作从业务逻辑层中抽离出来
 * 使得业务逻辑层的代码只关注业务,不在关注数据的维护操作
 * 而且DAO也是可以让业务逻辑层的代码对数据的操作完全对象化
 *  
 *  UserInfoDAO
 *  针对数据库中UserInfo表的操作
 *  
 */
public class userInfoDAO {
	/**
	 * 将给定的UserInfo对象存入数据库
	 * @throws Exception 
	 */
	public List<UserInfo> findAll(){
		Connection conn=null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from userinfo_545058656 ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String nickname=rs.getString("nickname");
				double account=rs.getDouble("account");
				UserInfo userinfo=new UserInfo();
				userinfo.setId(id);
				userinfo.setUsername(username);
				userinfo.setPassword(password);
				userinfo.setEmail(email);
				userinfo.setNickname(nickname);
				userinfo.setAccount(account);
				list.add(userinfo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public List select(String userInfo){
		List<String> list=new ArrayList<String>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select id,username,password,email,nickname,account from "
					+ " userinfo_545058656 where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String id=rs.getString("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String nickname=rs.getString("nickname");
				double account=rs.getDouble("account");
				list.add(id);
				list.add(username);
				list.add(password);
				list.add(email);
				list.add(nickname);
				list.add(""+account);
				
//				System.out.println(id);
//				System.out.println(username);
//				System.out.println(password);
//				System.out.println(email);
//				System.out.println(nickname);
//				System.out.println(account);
				return list;
			}else{
//				System.out.println("用户不存在!");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	//更新用户
	public boolean update(UserInfo userInfo){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update userinfo_545058656 set"
					+ " password=?,email=?,nickname=?,account=? where username=?";	
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,userInfo.getPassword());
			ps.setString(2,userInfo.getEmail());
			ps.setString(3,userInfo.getNickname());
			ps.setDouble(4,userInfo.getAccount());
			ps.setString(5,userInfo.getUsername());
			int i=ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据异常");
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	//删除用户
	public boolean deleteByUserName(String username){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from userinfo_545058656 where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			int i=ps.executeUpdate();
			if(i>0){
//				System.out.println("删除成功!");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	public void save(UserInfo userInfo) throws Exception{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into userinfo_545058656"
					+ " (id,username,password,email,nickname,account)"
					+ " values"
					+ " (seq_dept_id545058656.nextval,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUsername());
			ps.setString(2, userInfo.getPassword());
			ps.setString(3, userInfo.getEmail());
			ps.setString(4, userInfo.getNickname());
			ps.setDouble(5, userInfo.getAccount());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
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
