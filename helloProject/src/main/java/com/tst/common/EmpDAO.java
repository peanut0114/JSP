package com.tst.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	// 쿼리문을 통해 데이터 가져오기
	public List<Employee> getEmpInfo(String name) {
		String sql = "select * from employees where first_name=?";
		connect(); // conn 객체
		List<Employee> list = new ArrayList<>();
		try {
			// 이름으로 사원정보 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			// 처리된 결과를 가져옴 (ResultSet)
			rs = pstmt.executeQuery();
			// 반복자를 통해 요소 출력
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체조회
	public List<Employee> EmpList() {
		String sql = "select * from employees";
		connect(); // conn 객체
		List<Employee> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//입력 : user_name, user_pass, role 받아서 db에 입력
	public boolean insertMember(String name, String pass, String role) {
		String sql = "insert into members values(?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, role);
			
			int r = pstmt.executeUpdate();	//insert, update, delete
			System.out.println(r+"건 입력됨");
			if(r>0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	//수정 : 업데이트
	public int updateMember(String name, String pass, String role) {
		int r=0;
		String sql = "update members "
				+ "	set member_password = ?,"
				+ "		member_role = ? "
				+ "	where member_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			
			r = pstmt.executeUpdate();
			System.out.println(r+"건 변경됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
	}
}
