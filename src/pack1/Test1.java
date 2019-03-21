package pack1;
import java.sql.*;

public class Test1 {
	public static void main(String[] args) {
		
		try {
			//1 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2 获得连接
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			  // 连接到127.0.0.1 以1521端口连上oracle，访问其中orcl数据库
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			
			//所有数据库连接步骤都是相同的，驱动类名与连接url的写法不同
			//3 数据库操作.......
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
