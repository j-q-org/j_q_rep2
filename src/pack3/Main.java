package pack3;

import java.sql.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EmpDao ed = new EmpDao();
		
		//ִ��һ�����
		/*
		Emp emp = new Emp();
		emp.setEname("����");
		emp.setJob("CLERK");
		emp.setMgr(7839);
		java.sql.Date d = new Date(1990-1900, 10-1, 1);
		emp.setHiredate(d);
		emp.setSal(5000.0f);
		emp.setComm(0);
		emp.setDeptno(40);
		
		boolean result = ed.addEmp(emp);
		System.out.println(result);
		*/
		
		
		/*
		//ִ�в�ѯһ��
		Emp emp = ed.querySingleEmp(321);
		System.out.println(emp);
		//����ѯһ���Ľ���������޸�
		emp.setDeptno(10);
		emp.setSal(6000);
		boolean result = ed.updateEmp(emp);
		System.out.println(result);
		*/
		
		//ִ��ɾ��һ��
		/*
		boolean result = ed.deleteEmp(321);
		System.out.println(result);
		*/
		
		//��ѯ����
		List<Emp> emps = ed.queryAllEmp();
		for(Emp e: emps){
			System.out.println(e);
		}
	}
}
