package day03;
/**
 * 实体类
 * 用于描述数据库中某张表的信息
 * 其每一个实例可以表示该表的一条记录
 * @author tarena
 *
 */
public class UserInfo {
	private int id;
	private String username;
	private String password;
	private String email;
	private String nickname;
	private double account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return id+","+username+","+password+","+email+","+nickname+","+account;
	}
}
