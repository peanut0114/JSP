package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * HttpServlet 클래스를 상송받아서 구현해야 한다
 * web.xml 을 통한 매핑
 */
public class FirstServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출.");
	}
	
	/*
	 * 웹 요청이 들어오면 실행되는데... 
	 * 그 정보가 src > WEB-INF > web.xml
	 */
}
