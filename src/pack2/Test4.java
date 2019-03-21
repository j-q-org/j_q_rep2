package pack2;
import java.sql.*;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			
			cn.setAutoCommit(false);//开启事务
			
			Statement st = cn.createStatement();
			
			//将用户输入的数据 写入到SQL语句中去再执行
			Scanner  sc  = new Scanner(System.in);
			System.out.println("empno:");
			String empno = sc.next();
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
			
			//带条件修改多个字段，编号不可修改
			/*
			String update="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno = ? ";
			PreparedStatement ps = cn.prepareStatement(update);
			ps.setString(1, name);
			ps.setString(2, job);
			ps.setInt(3, Integer.parseInt(mgr));
			ps.setString(4, hiredate);
			ps.setFloat(5, Float.parseFloat(sal));
			ps.setFloat(6, Float.parseFloat(comm));
			ps.setInt(7, Integer.parseInt(deptno));
			ps.setInt(8, Integer.parseInt(empno));
			int result = ps.executeUpdate();
			System.out.println(result);
			*/
			
			//带条件删除
			/*
			String delete = "delete from emp where empno = ?";
			PreparedStatement ps = cn.prepareStatement(delete);
			ps.setString(1, empno);
			int result = ps.executeUpdate();
			System.out.println(result);
			*/
			
			//带条件查询 按部门与职位查询员工
			String select = "select * from emp where job=? and deptno=? ";
			PreparedStatement ps = cn.prepareStatement(select);
			ps.setString(1, job);
			ps.setInt(2, Integer.parseInt(deptno));
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("ename")+" "+rs.getString("job")+" "+rs.getInt("deptno"));
			}
			int result = ps.executeUpdate();
			
			cn.commit(); //提交事务
			//cn.rollback(); //回滚事务
			
			
			// 关闭数据库连接
			cn.close();
			
			/*
			 * DQL 查询类语句
			 * DML 操作类语句（增删改）
			 * DDL 定义语句  create  drop  alter
			 * DCL 权限授权
			 * 
			 * JDBC 只能执行DQL DML
			 */
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
