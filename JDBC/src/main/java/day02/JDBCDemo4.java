package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day01.DBUtil;

/**
 * statement ֻ�ʺ�ִ�о�̬SQL���
 * preparedStatement �ʺ�ִ�к��ж�̬��Ϣ��SQL
 * ps����ִ�ж�̬SQlҲ��statementЧ�ʸ�
 * ������ִ��SQL���ʱ,Ӱ��Ч�ʵ���Ҫ����
 * 1:���Ǻ��ж�̬��Ϣʱ,ʹ��pSЧ�ʱ�statement��
 * ����ִ�й��̲���,�������ݿ�ѹ����ϵͳ����
 * 2;����Խ��,Ч��Խ��
 * 3:���ʷ���SQL����������SQL���Ч�ʵ�
 * @author tarena
 *
 */
public class JDBCDemo4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username="jack";
		String email="123456@qq.com";
		String nickname="jion";
		Connection conn=DBUtil.getConnection();
		String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
					" values "+
					"(seq_userinfo_id_545058656.nextval,?,'123456',?,?,5000)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			int s=0;
			for(int i=0;i<1000;i++){
				ps.setString(1,username+i);
				ps.setString(2,i+email);
				ps.setString(3,nickname+i);	
				int r=ps.executeUpdate();
				s=r;
			}
			System.out.println("����"+s);
			
		} catch (Exception e) {
			// TODO: handle exception
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
