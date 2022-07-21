package com.edu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServ extends HttpServlet {
	//init() --> request, response --> service()
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");//전세계 모든 언어를 나타냄
		//네트워크정보
		PrintWriter out = resp.getWriter();
		out.print("<h3>네트워크정보</h3>");
		out.print("<p>Request Schema: "+req.getScheme()+"</p>");
		out.print("<p>Server Name: "+req.getServerName()+"</p>");
		out.print("<p>Server Address: "+req.getLocalAddr()+"</p>");
		out.print("<p>Server Port: "+req.getServerPort()+"</p>");
		out.print("<p>Client Address: "+req.getRemoteAddr()+"</p>");
		out.print("<p>Client Host: "+req.getRemoteHost()+"</p>");
		out.print("<p>Client Port: "+req.getRemotePort()+"</p>");
		
		String str = "<h3>URL정보</h3>";
		str+="<p>Request URI: "+req.getRequestURI()+"</p>";//어플리케이션 정보, 요청하는 페이지
		str+="<p>Request URL: "+req.getRequestURL()+"</p>";//요청 프로토콜, 포트정보, 서버정보
		str+="<p>Context Path: "+req.getContextPath()+"</p>";	//서버정보 빼고 제일 상위 정보
		str+="<p>Request Protocol: "+req.getProtocol()+"</p>";
		str+="<p>Servlet Path: "+req.getServletPath()+"</p>";
		
		//요청정보의 헤더에 포함됨 것들
		str +="<h3>요청헤더 정보</h3>";
		Enumeration<String> en =req.getHeaderNames();
		while(en.hasMoreElements()) {
			String elem = en.nextElement();	//하나씩 값(헤더이름)을 가져온다
			String headVal = req.getHeader(elem);	//헤더이름을 받아 값을 리턴
			
			str += "<p>"+elem + ", " + headVal + "</p>";
		}
		
		out.print(str);
		out.close();
		
	}
}
