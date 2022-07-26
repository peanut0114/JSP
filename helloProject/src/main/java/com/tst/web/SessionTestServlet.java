package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = null;
		String param = req.getParameter("p"); 
		String msg = null;
		//세션 생성, 변경, 삭제
		if(param.equals("create")) {
			//요청정보(req)를 통해 값을 가져온다
			session = req.getSession(true);	//생성된 세션값이 있으면 세션 값 반환, 없으면 새로 생성해서 값 반환
			//isNew() : 기존에 존재하던 session인지 새로 생성된 값인지 확인
			if(session.isNew()) {
				//새로 생성된 경우
				msg = "새로운 세션 객체 생성";
			}else{
				//존재하던 값인 경우
				msg = "기존 세션 객체 반환";
			}
		}
		else if(param.equals("delete")) {
			session = req.getSession(false);//세션이 있다면 세션 값 반환, 존재하지 않는다면 null 리턴
			if(session != null) {
				session.invalidate();	//세션 삭제
				msg = "세션 객체 삭제";
			}else {
				msg = "삭제할 세션 객체 없음";
			}
		}
		else if(param.equals("add")) {
			session = req.getSession(true);		//세션 없으며 새로 생성
			session.setAttribute("msg","메세지를 추가함");	//객체에 msg라는 속성 추가
			msg = "세션 객체에 속성 지정함";
		}
		else if(param.equals("get")) {
			session = req.getSession(false);	//세션 없으면 null 리턴
			if(session!=null) {
				String str = (String) session.getAttribute("msg");	//속성 가져옴(object타입을 강제 형변환)
				msg = str;
			}else {
				msg = "데이터를 추출할 세션 없음";
			}
		}
		else if(param.equals("remove")) {
			session = req.getSession(false);//세션 없으면 null 리턴
			if(session != null) {
				session.removeAttribute("msg");	//속성 삭제
				msg = "세션 객체의 속성을 삭제";
			}else {
				msg = "속성을 제거할 세션 객체 없음";
			}
		}
	resp.getWriter().print("처리결과 : "+msg);
	}
/*
 *	< 실행내용 >
	실행 후 주소창에 ?p=create 추가 입력 => 새로운 세션 객체 생성
	새로고침 또는 창 추가오픈시 => 기존 세션 객체 반환
	?p=delete 입력 => 세션 객체 삭제
	새로고침 => 삭제할 세션 객체 없음
	
	다른 브라우저로 접속시 다른 유저 => 세션을 공유하지 않는다
 * 	
 */

}
