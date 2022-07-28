<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제결과(memberDeleteOutput.jsp)</title>
</head>
<body>
	<h3>${name }의 정보가 삭제되었습니다.</h3>
	<jsp:include page = "home.jsp"></jsp:include>
	<a href="${pageContext.request.contextPath}/memberView/memberDelete.jsp">계속 삭제하기</a>
</body>
</html>