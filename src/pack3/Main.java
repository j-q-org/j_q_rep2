package pack3;

import java.sql.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EmpDao ed = new EmpDao();
		
		//执行一次添加
		/*
		Emp emp = new Emp();
		emp.setEname("张三");
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
		//执行查询一个
		Emp emp = ed.querySingleEmp(321);
		System.out.println(emp);
		//将查询一个的结果立即做修改
		emp.setDeptno(10);
		emp.setSal(6000);
		boolean result = ed.updateEmp(emp);
		System.out.println(result);
		*/
		
		//执行删除一个
		/*
		boolean result = ed.deleteEmp(321);
		System.out.println(result);
		*/
		
		//查询所有
		List<Emp> emps = ed.queryAllEmp();
		for(Emp e: emps){
			System.out.println(e);
		}
	}
}
