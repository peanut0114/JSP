<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색</title>
<link href="${pageContext.request.contextPath}/css/first.css" rel="stylesheet">
</head>
<body>
<div id="container">
	<h3>회원검색</h3>
	<span>${error }</span>
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		<label>아이디</label><input type="text" name="id"><br>
		<input type="hidden" name="job" value="search">
		<input type="submit" value="검색">
	</form>
</div>
</body>
</html>