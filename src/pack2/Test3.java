package pack2;
import java.sql.*;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			Statement st = cn.createStatement();
			
			//将用户输入的数据 写入到SQL语句中去再执行
			Scanner  sc  = new Scanner(System.in);
			System.out.println("name:");
			String name = sc.next();
			System.out.println("job:");
			String job = sc.next();
			System.out.println("mgr:");
			String mgr = sc.next();
			System.out.println("hiredate:");
			String hiredate = sc.next();
			System.out.println("sal:");
			String sal = sc.next();
			System.out.println("comm:");
			String comm = sc.next();
			System.out.println("deptno:");
			String deptno = sc.next();
			
			//使用PreparedStatement来注入所需要的参数
			String insert = "insert into emp values(seq_emp.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(insert);
			//?代表占位符，表示此处需要填入一个数据，支持任何类型，字符串日期也不需要写''
			//将变量注入到ps中
			ps.setString(1, name);//参数1 表示处理第几个? 索引1开始，参数2表示要注入的值
			ps.setString(2, job);
			ps.setInt(3, Integer.parseInt(mgr));
			//日期在处理时可以直接使用String去替代，也可以用java.sql.Date
			ps.setString(4,hiredate);
			ps.setFloat(5, Float.parseFloat(sal));
			ps.setFloat(6, Float.parseFloat(comm));
			ps.setInt(7, Integer.parseInt(deptno));
			
			//执行这个操作
			int result = ps.executeUpdate();
			System.out.println(result);
			
			//带条件修改多个字段，编号不可修改
			//带条件删除
			//带条件查询
			
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
