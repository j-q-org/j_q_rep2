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
			
			//ʹ��PreparedStatement��ע������Ҫ�Ĳ���
			String insert = "insert into emp values(seq_emp.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(insert);
			//?����ռλ������ʾ�˴���Ҫ����һ�����ݣ�֧���κ����ͣ��ַ�������Ҳ����Ҫд''
			//������ע�뵽ps��
			ps.setString(1, name);//����1 ��ʾ����ڼ���? ����1��ʼ������2��ʾҪע���ֵ
			ps.setString(2, job);
			ps.setInt(3, Integer.parseInt(mgr));
			//�����ڴ���ʱ����ֱ��ʹ��Stringȥ�����Ҳ������java.sql.Date
			ps.setString(4,hiredate);
			ps.setFloat(5, Float.parseFloat(sal));
			ps.setFloat(6, Float.parseFloat(comm));
			ps.setInt(7, Integer.parseInt(deptno));
			
			//ִ���������
			int result = ps.executeUpdate();
			System.out.println(result);
			
			//�������޸Ķ���ֶΣ���Ų����޸�
			//������ɾ��
			//��������ѯ
			
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
