<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
<link href="../css/first.css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<form action="insertBoard.jsp" method="post">
			<label>글제목</label><input type="text" name="title"><br>
			<label>글내용</label><textarea name="content"></textarea><br>
			<label>작성자</label><input type="text" name="writer"><br>
			<input type="submit" value="등록">
		</form>
	</div>
</body>
</html>