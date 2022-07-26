<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%//예외처리구문을 화면에 출력
	//msg로 파라미터를 넘김
	String param = request.getParameter("msg");
%>
	<c:catch var="ex">
	<%	//예외처리
		if(param.equals("add")){
			out.print(param);
		}
	%>
	</c:catch>
	<c:out value="${ex}"></c:out>
</body>
</html>