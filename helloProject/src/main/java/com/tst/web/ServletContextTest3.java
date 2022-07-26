package com.tst.web;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.Shareobject;
/*
 * Shareobject 공유
 * 1. 값을 지정 setAttribute()
 */
@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletContext 호출
		ServletContext sc = this.getServletContext();
		
		//필요한 값을 입력
		Shareobject obj1 = new Shareobject();
		
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트");
		sc.setAttribute("data", obj1);
		
		Shareobject obj2 = new Shareobject();		
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트2");
		sc.setAttribute("data2", obj2);
		
		resp.getWriter().print("ServletContext object add.");
		
	}
}
