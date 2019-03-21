package pack2;
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
			
			//3��ò�������
			Statement st = cn.createStatement();
			//4 �������
			/*
			String insert ="insert into emp values(8000,'����','CLERK','7839','3-8��-1990',2000,null,40)";
			int result =st.executeUpdate(insert);//����Ӱ�������
			System.out.println(result);
			*/
			
			//5 �޸�����
			/*
			String update ="update emp set sal=sal+1000 where empno = 8000";
			int result = st.executeUpdate(update);
			System.out.println(result);
			*/
			
			//6 ɾ������
			/*
			String delete ="delete  from emp where empno = 8000";
			int result = st.executeUpdate(delete);
			System.out.println(result);
			*/
			//��jdbc��ִ����ɾ�� ���Զ��ύ��
			
			//7��ѯ  �����ResultSet
			String select ="select *  from emp";
			ResultSet rs = st.executeQuery(select);
			while(rs.next()){//�ж���û����һ��
				//��λ��ĳһ�к�ȡ����һ�������е��ֶ�
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				//java.sql.Date ʵ�ʾ���java.util.Date������
				Date hiredate = rs.getDate("hiredate");
				float sal = rs.getFloat("sal");
				float comm = rs.getFloat("comm");
				int deptno = rs.getInt("deptno");
				System.out.println(empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno);
			}
			
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
