package com.tst.web;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ch6. 상태정보 유지 기술
 * 1. ServletContext : 웹어플리케이션 단위 유지
 */
@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet{
	ServletContext sc;
	
	//각각의 객체에서 ServletContext에 접근
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//메소드를 통해 ServletContext에 접근
		sc = config.getServletContext(); //ServletConfig 객체
		//화면에 출력
		System.out.println(sc);
	}
	
	//service를 설정하지 않고 get과 post 방식 사용
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 값 가져오기 (환경변수에서 값 설정했음)
		String loc = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().print("Location : " +loc); //출력스트림
		
		String con = sc.getInitParameter("contextConfig");
		resp.getWriter().print("config : " +con);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩 방식을 환경변수에 지정해놓은 값으로 설정
		String enc = sc.getInitParameter("encoding");
		req.setCharacterEncoding(enc);	//utf-8
		resp.setCharacterEncoding(enc);
		resp.setContentType("text/plain;charset=utf-8");
		String name = req.getParameter("name");
		resp.getWriter().print("이름 : "+name);
		
	}
}

