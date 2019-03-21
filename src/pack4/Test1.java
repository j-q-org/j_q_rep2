package pack4;
import java.sql.*;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Test1 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			//调用存储过程
			CallableStatement cs = cn.prepareCall("{call myproc3(?,?,?)}");
			//1 设置输入参数
			cs.setInt(1, 10);
			//2 注册输出参数,声明参数类型
			
			cs.registerOutParameter(2, OracleTypes.NUMBER);
			cs.registerOutParameter(3, OracleTypes.NUMBER);
			cs.execute();//执行存储过程
			
			//获得输出参数结果
			float avg=cs.getFloat(2);
			float max=cs.getFloat(3);
			System.out.println(avg+" "+max);
			
			
			// 关闭数据库连接
			cn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
