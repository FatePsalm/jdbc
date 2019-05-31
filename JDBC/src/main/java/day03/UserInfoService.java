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
		System.out.println("��ѯ���!"+(list.size())+"��.��ʱ"+(end-start)+"ms");
	}
	void updateUser(){
		UserInfo userinfo=new UserInfo();
		Scanner scan=new Scanner(System.in);
		System.out.println("��ӭʹ����Ϣ�޸�ϵͳ!");
		System.out.println("�������û���:");
		String input=scan.next();
		List<String> list=userinfoDAO.select(input);
//		System.out.println(list);
		System.out.println("����������:");
		String inputPassword=scan.next();
		if(list==null){
			System.out.println("�û�������");
			return;
		}else if(!list.get(2).equals(inputPassword)){
			System.out.println("�û������������!");
			return;
		}
		int number=-1;
		while(number!=0){
			System.out.println("��ѡ���޸���:\n<1>:����\n<2>:����\n<3>:�ǳ�\n<4>:���\n<0>:�����˳�");
			number=scan.nextInt();
			switch (number) {
			case 1:
				String password=null;
				while(true){
					System.out.println("�޸�����");
					password=scan.next();
					System.out.println("ȷ������:");
					String passwordLast=scan.next();
					if(password.equals(passwordLast)){
						break;
					}
					System.out.println("���벻һ��!");
				}
				list.set(2, password);
				break;
			case 2:
				System.out.println("�޸�����");
				String email=scan.next();
				list.set(3, email);
				break;
			case 3:
				System.out.println("�޸��ǳ�");
				String nickname=scan.next();
				list.set(4, nickname);
				break;
			case 4:
				System.out.println("�޸����");
				String account=scan.next();
				list.set(5, account);
				break;
				
			default:
				System.out.println("���ڸ�������...");
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
			System.out.println("�޸Ĵ���!");
		}else{
			System.out.println("��ϲ�������!");
		}
	}
	
	void delete(){
		Scanner scan=new Scanner(System.in);
		System.out.println("��ӭʹ����Ϣɾ��ϵͳ!");
		System.out.println("������ɾ���û���");
		String username=scan.next();
		boolean flag=userinfoDAO.deleteByUserName(username);
		if(flag){
			System.out.println("�ɹ�!");
		}else{
			System.out.println("ʧ��!");
		}
		
	}
	void reg(){
		System.out.println("��ӭʹ����Ϣע��ϵͳ!");
		Scanner scan=new Scanner(System.in);
		System.out.println("�������û���:");
		String username=scan.next();
		System.out.println("����������:");
		String password=scan.next();
		System.out.println("����������:");
		String email=scan.next();
		System.out.println("�������ǳ�:");
		String nickname=scan.next();
		UserInfo userinfo=new UserInfo();
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		userinfo.setEmail(email);
		userinfo.setNickname(nickname);
		userinfo.setAccount(5000);
		try {
			userinfoDAO.save(userinfo);
			System.out.println("ע��ɹ�!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ע��ʧ��!");
		}
	}

}



