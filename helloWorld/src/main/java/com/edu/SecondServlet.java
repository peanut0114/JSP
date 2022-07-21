package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿을 만들려면 HttpServlet을 상속받아야함!
 * @WebServlet("/second.do")로 알려주기
 */

@WebServlet("/second.do")
public class SecondServlet extends HttpServlet {

	// 페이지 만들기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//응답정보에게 출력페이지의 컨텐트 타입지정해주기
		resp.setContentType("text/html;charset=UTF-8");
		// 출력스트림
		PrintWriter out = resp.getWriter(); 
		out.print("<h3>안녕하세요. 서블릿입니다.</h3>");
	}
}
