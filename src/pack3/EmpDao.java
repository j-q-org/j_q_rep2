package pack3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO 数据操作对象 提供针对这张表的的 增删改查.....单元功能
//针对增删改查所有方法涉及到的数据,要提供相应的实体类，类中属性参考表
public class EmpDao {
	public boolean addEmp(Emp emp) {

		try {
			Connection cn = DBUtil.getConn();// 获得连接
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
			DBUtil.closeConn();// 关闭连接
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
				// 如果有结果 最终需要返回一个emp对象
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
		// 要以id为条件，修改其他所有字段
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
		// 要以id为条件删除数据
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
				// 如果有结果 最终需要返回一个emp对象
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				//每个查询出来的对象 都需要加入集合
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
