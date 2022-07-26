<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<link href="../css/table.css" rel="stylesheet">
</head>
<body>
<div id ="container">
<%
//	String id = (String) session.getAttribute("loginId");
//	if(id!=null){
//		out.print("<h3>"+id+"님으로 로그인되었습니다.</h3>");
//		out.print("<a href='logout.jsp'>로그아웃</a>");
//	}else{
//		out.print("<h3>손님입니다.</h3>");
//	}
%>
	<c:choose>
		<c:when test="${!empty loginId}">
			<h3><c:out value="${loginId}"/>님으로 로그인했습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>손님입니다.</h3>
		</c:otherwise>
	</c:choose>
	
	
	<table border='1'>
		<thead><tr><th>번호</th><th>제목</th><th>작성자</th>
				<th>작성일자</th><th>방문횟수</th></tr>
		</thead>
		<tbody>
		<%
			BoardDAO dao = new BoardDAO();
			List<BoardVO> list = dao.boardList();
		%>
			<c:set var="boards" value="<%=list %>"/>
			<c:forEach var="vo" items="${boards}">
				<tr>
				<td><a href="boardDetail.jsp?id=${vo.boardId}">${vo.boardId}</td>
				<td>${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.createDate}</td>
				<td>${vo.cnt}</td>
				</tr>		
			</c:forEach>
		</tbody>
	</table>
	<a href="addBoard.jsp"><input type="button" value="새 글 등록"></a>
	<c:choose>
		<c:when test="${!empty loginId}">
			<a href="logout.jsp"><input type="button" value="로그아웃"></a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp"><input type="button" value="로그인"></a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>