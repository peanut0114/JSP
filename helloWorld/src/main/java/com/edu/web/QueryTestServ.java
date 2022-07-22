package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet{
	//서블렛에 get과 post 방식 처리 방식이 지정되어있음 
	//service를 따로 구현x (service구현해놓으면 doGet, doPost 따로 호출될 일이 없음)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");	//parameter:id 값을 반환
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String hobby[] = req.getParameterValues("hobby"); //배열
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		
		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID : "+id+"</p>");
		out.print("<p>비밀번호 : "+pwd+"</p>");
		out.print("<p>이름 : "+name+"</p>");
		out.print("<p>취미 :<ul>");
		for(String hob : hobby) {
			out.print("<li>"+hob+"</li>");		
		}out.print("</ul>");
		out.print("<p>성별 : "+gender+"</p>");
		out.print("<p>종교 : "+religion+"</p>");
		out.print("<p>자기소개 : "+introduction+"</p>");
		out.print("질의문자열 : "+req.getQueryString());
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("utf-8");	//문자열 처리방식 지정해야 정상적으로 처리됨
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
//		String id = req.getParameter("id");	//parameter:id 값을 반환
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String hobby[] = req.getParameterValues("hobby"); //배열
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduction = req.getParameter("introduction");
//		
//		out.print("<h3>입력받은 값</h3>");
//		out.print("<p>ID : "+id+"</p>");
//		out.print("<p>비밀번호 : "+pwd+"</p>");
//		out.print("<p>이름 : "+name+"</p>");
//		out.print("<p>취미 :<ul>");
//		for(String hob : hobby) {
//			out.print("<li>"+hob+"</li>");		
//		}out.print("</ul>");
//		out.print("<p>성별 : "+gender+"</p>");
//		out.print("<p>종교 : "+religion+"</p>");
//		out.print("<p>자기소개 : "+introduction+"</p>");
		
		
		//Post 방식의 경우 그냥 출력하면 String 깨지거나 null이 출력됨 
		//스트림으로는 한번만 읽을 수 있기 때문에 위에서 읽으면 못 가져옴..(주석처리)
		ServletInputStream sis = req.getInputStream();	//일반 queryString은론 안 됨
		int len = req.getContentLength();	//데이터 크기
		byte[] buf = new byte[len];			//크기만큼 배열 설정
		sis.readLine(buf, 0, len);				//넘어온 string을 buf에 길이만큼 담음
		String queryString = new String(buf);	//String 클래스를 통해 buf를 문자열에 넣어줌
//		out.print("질의문자열 : "+queryString);
		out.print("<p id='querystring'>"+queryString+"</p>");
		sis.close();
		out.close();
	}
}
