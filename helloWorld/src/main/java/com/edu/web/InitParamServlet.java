package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//생성(생성자) -> ServletConfig -> init(sc) -> service(rq,rs)
public class InitParamServlet extends HttpServlet {
	String id;
	String pw;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id"); //id라는 파라미터
		pw = config.getInitParameter("password");
	}
	
	public InitParamServlet() {
		System.out.println("InitParamServlet 호출");
		//호출 하지 않아도 자동으로 실행됨 (web.xml에서 load-on-startup설정함)
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p>ID : "+id+"</p>");
		out.print("<p>비밀번호 : "+pw+"</p>");

	}
}
