<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제 (memberDelete.jsp)</title>
<link href="${pageContext.request.contextPath }/css/first.css" rel="stylesheet">
</head>
<body>
<div id="conianer">
	<h3>삭제할 회원 검색</h3>
	<span>${error}</span>
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		<label>아이디</label><input type="text" name="id" size="10">
		<input type="submit" value="검색"><br>
		<input type="hidden" name="job" value="delete">
	</form>
		<c:set var="vo" value="${member }"/>
	<c:choose>
		<c:when test="${!empty vo }">
			<form action="${pageContext.request.contextPath}/memberDelete.do" method="post">
				<p>${vo.name }의 정보를 삭제하시겠습니까?</p>
				<input type="hidden" name="id" value="${vo.id }">
				<input type="hidden" name="name" value="${vo.name }">
				<input type="submit" value="네">
				<a href="${pageContext.request.contextPath}/index.jsp">
					<input type="button" value="아니오"></a>
			</form>
		</c:when>
		<c:otherwise>
			<span>${result}</span>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>