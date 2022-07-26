package com.tst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.EmpDAO;
import com.tst.common.Employee;

@WebServlet("/empSearch")
public class EmployeeSearch extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보가 가진 파라미터 가져오기
		String fName = req.getParameter("first_name");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(fName);
		req.setAttribute("data", list);	//list의 주소값 연결
		
		RequestDispatcher rd = req.getRequestDispatcher("empResult.jsp");
		rd.forward(req, resp);
		
	}
}
