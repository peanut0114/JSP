package com.edu.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * <서블릿의 동시 요청 처리>
 * 서블릿에서 컨테이너는 요청마다 인스턴스(객체)를 각각 만들지 않고 공유한다 (힙영역)
 * 스택영역에 각각의 스레드를 생성한다 (메모리를 훨씬 적게 사용한다)  
 */
@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{
	String str2;
	
	//전역(맴버)변수 : 힙 영역에 할당
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		str2 = req.getParameter("msg");	//msg 파라미터를 읽음
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h2>처리결과(전역변수)</h2>");
		
		int num = 0;
		while(num++<10) {
			out.print(str2+" : "+ num + "<br>");
			out.flush();	//캐시를 비움
			try {
				Thread.sleep(1000); //1초 간격으로 실행되도록 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>Done : "+str2+"</h2>");
		//전역변수를 사용하기 때문에 실행중에 다른 유저가 다른 값을 입력하면 값이 바뀌어 출력
	}
	
//	//로컬변수 : 스레드별 스택에 할당
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String str = req.getParameter("msg");	//msg 파라미터를 읽음
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.print("<h2>처리결과(지역변수)</h2>");
//		
//		int num = 0;
//		while(num++<10) {
//			out.print(str+" : "+ num + "<br>");
//			out.flush();	//캐시를 비움
//			try {
//				Thread.sleep(1000); //1초 간격으로 실행되도록 
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		out.print("<h2>Done : "+str+"</h2>");
//		//동일한 doGet이지만 객제마다 변수 간섭x 다른 유저가 다르게 입력하면 다른 값 뜬다
//	}
	
}
