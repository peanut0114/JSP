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
 * 2. 값을 읽어오기 getAttribute()
 * 
 *  ServletContext : 어플리케이션 단위! 웹 껐다 키면 정보가 없다
 *  (ContextTest3부터 실행해서 값 지정해야 함)
 */
@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		ServletContext sc = this.getServletContext();
		//context3에서 지정한 속성 data 의 값을 objet 타입으로 가져옴 -> Shareobject로 강제형변환
		Shareobject obj1 = (Shareobject) sc.getAttribute("data");	
		//출력스트림으로 가져온 값 출력 (지정된 값이 없으면 null예외 발생)
		resp.getWriter().print("count : "+obj1.getCount()+", str : "+obj1.getStr()+"<br>");

		Shareobject obj2 = (Shareobject) sc.getAttribute("data2");	
		resp.getWriter().print("count : "+obj2.getCount()+", str : "+obj2.getStr());
	}
}
