<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<link href="../css/first.css" rel="stylesheet">
</head>
<body>
<div id="container">
<%
	//로그인 실패시 전달받은 에러메세지 출력
	String msg = (String)request.getAttribute("msg");
	if(msg != null){
		out.print("<p>"+msg+"</p>");
	}
%>
	<form action="login.jsp" method='post'>
		<label>ID</label><input type="text" name="id" required><br>
		<label>PW</label><input type="password" name="pwd" required><br>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>