package pack2;
import java.sql.*;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			Statement st = cn.createStatement();
			
			//���û���������� д�뵽SQL�����ȥ��ִ��
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
			
			
			String insert ="insert into emp values(seq_emp.nextval,'"+name+"','"+job+"',"+mgr+",'"+hiredate+"',"+sal+","+comm+","+deptno+")";
			int result =st.executeUpdate(insert);//����Ӱ�������
			System.out.println(result);
			
			
			// �ر����ݿ�����
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
