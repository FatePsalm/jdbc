package day02;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import day01.DBUtil;
/**
 * 批操作
 * 当需要一次性执行多条SQL语句时,可以使用批操作.
 * 缓存一组SQL语句一次性发送至数据库执行,这样
 * 可以减少客户端到数据库之间的网络调用次数,提高SQL传输效率等
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
				ps.addBatch();//添加缓存
			}
			//一次性将批处理操作缓存
			int[] i=ps.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("耗时"+(end-start)+"MS");
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
