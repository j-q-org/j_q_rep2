package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库连接工具类           数据库连接池
public class DBUtil {
	private static Connection cn;

	// 1 获得连接的功能
	
	public static Connection getConn() {

		try {
			// 1 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2 获得连接
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			// 连接到127.0.0.1 以1521端口连上oracle，访问其中orcl数据库
			cn = DriverManager.getConnection(url, "scott", "tiger");
			return cn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 2 关闭连接的功能
	
	public static void closeConn() {
		try {
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	// 添加一个connection属性 将获得连接与关闭连接两个方法关联起来
	// 将两个方法都写成静态的 ，以便调用时方便，属性也跟着必须改为静态的

}
