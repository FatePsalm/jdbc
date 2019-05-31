package day02;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import day01.DBUtil;
/**
 * ������
 * ����Ҫһ����ִ�ж���SQL���ʱ,����ʹ��������.
 * ����һ��SQL���һ���Է��������ݿ�ִ��,����
 * ���Լ��ٿͻ��˵����ݿ�֮���������ô���,���SQL����Ч�ʵ�
 * 
 * @author tarena
 *
 */
public class JDBCDemo07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConnection();
		String sql="insert into userinfo_545058656 (id,username,password,email,nickname,account) "+
					" values "+
					"(seq_userinfo_id_545058656.nextval,?,'123456',?,?,5000)";
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(sql); 
			long start=System.currentTimeMillis();
			for(int i=0;i<1000;i++){
				ps.setString(1, "lock"+i);
				ps.setString(2, i+"123456@163.com");
				ps.setString(3, "rouse"+i);
				ps.addBatch();//��ӻ���
			}
			//һ���Խ��������������
			int[] i=ps.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("��ʱ"+(end-start)+"MS");
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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

	}

}
