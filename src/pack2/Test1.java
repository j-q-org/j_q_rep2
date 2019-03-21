package pack2;
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
			
			//3获得操作工具
			Statement st = cn.createStatement();
			//4 添加数据
			/*
			String insert ="insert into emp values(8000,'王五','CLERK','7839','3-8月-1990',2000,null,40)";
			int result =st.executeUpdate(insert);//返回影响的行数
			System.out.println(result);
			*/
			
			//5 修改数据
			/*
			String update ="update emp set sal=sal+1000 where empno = 8000";
			int result = st.executeUpdate(update);
			System.out.println(result);
			*/
			
			//6 删除数据
			/*
			String delete ="delete  from emp where empno = 8000";
			int result = st.executeUpdate(delete);
			System.out.println(result);
			*/
			//在jdbc中执行增删改 是自动提交的
			
			//7查询  结果集ResultSet
			String select ="select *  from emp";
			ResultSet rs = st.executeQuery(select);
			while(rs.next()){//判断有没有下一行
				//定位到某一行后，取出这一行中所有的字段
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				//java.sql.Date 实际就是java.util.Date的子类
				Date hiredate = rs.getDate("hiredate");
				float sal = rs.getFloat("sal");
				float comm = rs.getFloat("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno);
			}
			
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
