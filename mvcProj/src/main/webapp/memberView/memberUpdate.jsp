<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정검색(memberUpdate.jsp)</title>
<link href="${pageContext.request.contextPath }/css/first.css" rel="stylesheet">
</head>
<body>
<div id="conianer">
	<h3>수정할 회원검색</h3>
	<span>${error }</span>
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		<label>아이디</label><input type="text" name="id" size="10">
		<input type="submit" value="검색"><br>
		<input type="hidden" name="job" value="update">
		
	</form>
	
	<c:set var="vo" value="${member }"/>
	<c:choose>
		<c:when test="${!empty vo }">
			<form action="" method="post">
				<label>아이디</label><input type="text" name="id" value="${vo.id }" readonly><br>
				<label>비밀번호</label><input type="password" name="passwd" value="${vo.passwd }"><br>
				<label>이름</label><input type="text" name="name" value="${vo.name }"><br>
				<label>이메일</label><input type="email" name="mail" value="${vo.mail}"><br>
				<input type="submit" value="수정">
			</form>
		</c:when>
		<c:otherwise>
			<span>${result }</span>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>