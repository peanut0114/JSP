package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 서블릿 : 사원정보 리스트 출력 (EmpListServlet)
 * 사원번호, 이름, 입사일, 이메일, 급여, 직무
 * 
 * EmpDAO : empList()
 */

@WebServlet("/emplist")
public class EmpListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.EmpList();
		
		PrintWriter out = resp.getWriter();
		out.print("<table border='1'>");
		out.print("<thead><tr><th>사원번호</th><th>이름</th><th>입사일</th>"
				+ "<th>이메일</th><th>급여</th><th>직무</th></tr>");
		out.print("<tbody>");
		for(Employee emp : list) {
			out.print("<tr><td>"+emp.getEmployeeId()+"</td>"
						+"<td>"+emp.getLastName()+"</td>"
						+"<td>"+emp.getHireDate()+"</td>"
						+"<td>"+emp.getEmail()+"</td>"
						+"<td>"+emp.getSalary()+"</td>"
						+"<td>"+emp.getJobId()+"</td></tr>"
					);
		}
		out.print("</tbody></table>");
		out.close();
	}
}
