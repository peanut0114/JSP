<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<link href="../css/first.css" rel="stylesheet">
</head>
<body>
<div id="container">    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pwd");
	
	//로그인 시도시 에러메세지 전달하기
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	BoardDAO dao = new BoardDAO();
	if(dao.loginCheck(id,pw)==null){
		//request 객체를 요청페이지에 포워딩 > getAttribute로 msg(에러메세지)읽자
		request.setAttribute("msg","아이디와 비밀번호를 확인하세요");
		rd.forward(request,response);	
		
		//response.sendRedirect("loginForm.jsp"); //페이지 이동하지만 공유 불가
	}else{
		session.setAttribute("loginId",id);
		System.out.println("login.");
		response.sendRedirect("boardList.jsp");
	}
%>
</div>
</body>
</html>