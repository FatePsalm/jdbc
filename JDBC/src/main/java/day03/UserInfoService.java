package day03;
import java.util.List;
import java.util.Scanner;
public class UserInfoService {
	private userInfoDAO userinfoDAO=new userInfoDAO();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInfoService service =new UserInfoService();
//		service.reg();
//		service.delete();
//		service.updateUser();
		service.select();
		
		
	}
	void select(){
		long start=System.currentTimeMillis();
		List<UserInfo> list=userinfoDAO.findAll();
		for(UserInfo e:list){
			System.out.println(e);
		}
		long end=System.currentTimeMillis();
		System.out.println("查询完毕!"+(list.size())+"条.耗时"+(end-start)+"ms");
	}
	void updateUser(){
		UserInfo userinfo=new UserInfo();
		Scanner scan=new Scanner(System.in);
		System.out.println("欢迎使用信息修改系统!");
		System.out.println("请输入用户名:");
		String input=scan.next();
		List<String> list=userinfoDAO.select(input);
//		System.out.println(list);
		System.out.println("请输入密码:");
		String inputPassword=scan.next();
		if(list==null){
			System.out.println("用户不存在");
			return;
		}else if(!list.get(2).equals(inputPassword)){
			System.out.println("用户名或密码错误!");
			return;
		}
		int number=-1;
		while(number!=0){
			System.out.println("请选择修改项:\n<1>:密码\n<2>:邮箱\n<3>:昵称\n<4>:余额\n<0>:任意退出");
			number=scan.nextInt();
			switch (number) {
			case 1:
				String password=null;
				while(true){
					System.out.println("修改密码");
					password=scan.next();
					System.out.println("确认密码:");
					String passwordLast=scan.next();
					if(password.equals(passwordLast)){
						break;
					}
					System.out.println("密码不一致!");
				}
				list.set(2, password);
				break;
			case 2:
				System.out.println("修改邮箱");
				String email=scan.next();
				list.set(3, email);
				break;
			case 3:
				System.out.println("修改昵称");
				String nickname=scan.next();
				list.set(4, nickname);
				break;
			case 4:
				System.out.println("修改余额");
				String account=scan.next();
				list.set(5, account);
				break;
				
			default:
				System.out.println("正在更新数据...");
				break;
			}
//			System.out.println(list);
		}
		
		userinfo.setId(Integer.parseInt(list.get(0)));
		userinfo.setUsername(list.get(1));
		userinfo.setPassword(list.get(2));
		userinfo.setEmail(list.get(3));
		userinfo.setNickname(list.get(4));
		userinfo.setAccount(Double.parseDouble(list.get(5)));
		boolean boo=userinfoDAO.update(userinfo);
		if(!boo){
			System.out.println("修改错误!");
		}else{
			System.out.println("恭喜更新完成!");
		}
	}
	
	void delete(){
		Scanner scan=new Scanner(System.in);
		System.out.println("欢迎使用信息删除系统!");
		System.out.println("请输入删除用户名");
		String username=scan.next();
		boolean flag=userinfoDAO.deleteByUserName(username);
		if(flag){
			System.out.println("成功!");
		}else{
			System.out.println("失败!");
		}
		
	}
	void reg(){
		System.out.println("欢迎使用信息注册系统!");
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username=scan.next();
		System.out.println("请输入密码:");
		String password=scan.next();
		System.out.println("请输入邮箱:");
		String email=scan.next();
		System.out.println("请输入昵称:");
		String nickname=scan.next();
		UserInfo userinfo=new UserInfo();
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		userinfo.setEmail(email);
		userinfo.setNickname(nickname);
		userinfo.setAccount(5000);
		try {
			userinfoDAO.save(userinfo);
			System.out.println("注册成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("注册失败!");
		}
	}

}



