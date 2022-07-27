<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInput.jsp</title>
<link href="../css/first.css" rel="stylesheet">
</head>
<body>
<div id="container">
	<h3>회원가입</h3>
	<form action="memberProc.jsp" method="post">
		<label>아이디</label><input type="text" name="id" autofocus required><br>
		<label>비밀번호</label><input type="password" name="passwd" required><br>
		<label>이름</label><input type="text" name="name" required><br>
		<label>이메일</label><input type="text" name="mail" required><br>
		<input type="submit" value="회원가입">
	</form>
</div>
</body>
</html>