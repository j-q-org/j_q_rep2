package pack1;
import java.sql.*;

public class Test1 {
	public static void main(String[] args) {
		
		try {
			//1 ��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2 �������
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			  // ���ӵ�127.0.0.1 ��1521�˿�����oracle����������orcl���ݿ�
			Connection cn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println(cn);
			
			//�������ݿ����Ӳ��趼����ͬ�ģ���������������url��д����ͬ
			//3 ���ݿ����.......
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
