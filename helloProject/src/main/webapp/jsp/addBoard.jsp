<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
<link href="../css/first.css" rel="stylesheet">
</head>
<body>
<%	
	//세션에 저장된 로그인 정보를 이용해 로그인 상태가 아닌경우 로그인창으로 보냄
//	String user = (String) session.getAttribute("loginId");
//	if(user==null){
//		response.sendRedirect("loginForm.jsp");
//	}
%>
	<c:set var="user" value="${loginId}"/>
	<c:if test="${empty user}">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>
	<div id="container">
		<form action="insertBoard.jsp" method="post">
			<label>글제목</label><input type="text" name="title" autofocus required><br>
			<label>글내용</label><textarea name="content" required></textarea><br>
			<label>작성자</label>
				<input type="text" name="writer" value="${user}" readonly><br>
			<input type="submit" value="등록">
			<a href="boardList.jsp"><input type="button" value="취소"></a>
		</form>
	</div>
</body>
</html>