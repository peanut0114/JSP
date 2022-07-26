<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String bno = request.getParameter("bno");
System.out.println(bno+"번 삭제");
BoardDAO dao = new BoardDAO();
dao.deleteBoard(Integer.parseInt(bno));

response.sendRedirect("boardList.jsp");

%>