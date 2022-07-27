<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과(memberSearchOutput.jsp)</title>
<link href="${pageContext.request.contextPath}/css/first.css" rel="stylesheet">
</head>
<body>
<div id="container">
	<h3>검색결과</h3>
	${error }
	<c:if test="${!empty member }">
		<p>${member.id } / ${member.name } 
		/ ${member.passwd } / ${member.mail }</p>
	</c:if>
	<c:if test="${empty member }">
		<span>검색 정보가 없습니다.</span>
	</c:if>
	<jsp:include page="./home.jsp"></jsp:include>
</div>

</body>
</html>