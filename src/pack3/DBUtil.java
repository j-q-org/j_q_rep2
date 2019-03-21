package pack3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���ݿ����ӹ�����           ���ݿ����ӳ�
public class DBUtil {
	private static Connection cn;

	// 1 ������ӵĹ���
	
	public static Connection getConn() {

		try {
			// 1 ��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2 �������
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
			// ���ӵ�127.0.0.1 ��1521�˿�����oracle����������orcl���ݿ�
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

	// 2 �ر����ӵĹ���
	
	public static void closeConn() {
		try {
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	// ���һ��connection���� �����������ر���������������������
	// ������������д�ɾ�̬�� ���Ա����ʱ���㣬����Ҳ���ű����Ϊ��̬��

}
