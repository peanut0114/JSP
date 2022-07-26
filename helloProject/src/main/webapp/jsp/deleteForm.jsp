<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>﻿deleteForm.jsp</title>
</head>
<body>
<% 
int bno = Integer.parseInt(request.getParameter("bno"));

%>
<c:set var="var" value="${bno }"/>
<form action="delete.jsp">
	<p>${bno}번 글을 삭제하시겠습니까?</p>
	<input type="hidden" name="bno" value="<%=bno %>">
	<input type="submit" value="삭제">
	<a href="boardList.jsp" ><input type="button" value="취소"></a>
</form>
</body>
</html>