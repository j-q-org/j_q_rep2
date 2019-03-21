package pack3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO ���ݲ������� �ṩ������ű�ĵ� ��ɾ�Ĳ�.....��Ԫ����
//�����ɾ�Ĳ����з����漰��������,Ҫ�ṩ��Ӧ��ʵ���࣬�������Բο���
public class EmpDao {
	public boolean addEmp(Emp emp) {

		try {
			Connection cn = DBUtil.getConn();// �������
			String insert = "insert into emp values(seq_emp.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(insert);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setFloat(5, emp.getSal());
			ps.setFloat(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn();// �ر�����
		}

		return false;
	}

	public Emp querySingleEmp(int empno) {
		try {
			Connection cn = DBUtil.getConn();
			PreparedStatement ps = cn.prepareStatement("select * from emp where empno = ?");
			ps.setInt(1, empno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// ����н�� ������Ҫ����һ��emp����
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				return emp;
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConn();
		}
		return null;
	}

	public boolean updateEmp(Emp emp) {
		// Ҫ��idΪ�������޸����������ֶ�
		try {
			Connection cn = DBUtil.getConn();
			String update = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno = ? ";
			PreparedStatement ps = cn.prepareStatement(update);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setFloat(5, emp.getSal());
			ps.setFloat(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConn();
		}

		return false;
	}
	
	
	public boolean deleteEmp(int empno) {
		// Ҫ��idΪ����ɾ������
		try {
			Connection cn = DBUtil.getConn();
			String delete = "delete from emp where empno=?";
			PreparedStatement ps = cn.prepareStatement(delete);
			ps.setInt(1, empno);
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConn();
		}

		return false;
	}

	public List<Emp> queryAllEmp(){
		ArrayList<Emp> emps = new ArrayList<Emp>();
		try {
			Connection cn = DBUtil.getConn();
			PreparedStatement ps = cn.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// ����н�� ������Ҫ����һ��emp����
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				//ÿ����ѯ�����Ķ��� ����Ҫ���뼯��
				emps.add(emp);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConn();
		}
		return emps;
	} 
	
	

}
