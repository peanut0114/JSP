package com.tst.web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*﻿ site.html -> dispatch1 -> dispatch2 (매개값 넘기기)
 * 
 * dispatch1 : dispatch2로 요청 재지정
 */
@WebServlet("/dispatch1")
public class DispatchTest1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		resp.getWriter().print("<h3>Dispatch page 1</h3>");
		
		
		String title = req.getParameter("title");
		String authr = req.getParameter("author");
		String publi = req.getParameter("publish");
		
		req.setAttribute("param1", title);
		req.setAttribute("param2", authr);
		req.setAttribute("param3", publi);
		
		//dispatch2로 요청 재실행
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		rd.forward(req, resp);	//매개값 그대로 넘김

		
//		rd.include(req, resp);	//dispatch2로 넘어가 출력 후 다시 1으로 와서 1도 출력
		//결과 : 주소는 dispatch1이 뜨고 화명의 결과는 dipatch2가 보인다
	
	}
}
