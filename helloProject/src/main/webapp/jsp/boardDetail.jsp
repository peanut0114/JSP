<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
<link href="../css/table2.css" rel="stylesheet">
</head>
<body>

	<%
	//파라미터를 읽어서 BoardDAO에서 한건 조회기능을 사용해서 화면에 출력
	String bno = request.getParameter("id");
	BoardDAO dao = new BoardDAO();
	BoardVO vo = dao.getBoard(Integer.parseInt(bno));//"3" => 3
	System.out.println(bno);
	System.out.println(vo.getBoardId());
	
	%>
	<div id="cotainer">
		<table>
			<tbody>
			<tr><th>글번호</th><td><%=vo.getBoardId()%></td></tr>
			<tr><th>제목</th><td><%=vo.getTitle() %></td></tr>
			<tr><th>내용</th><td><%=vo.getContent() %></td></tr>
			<tr><th>작성자</th><td><%=vo.getWriter() %></td></tr>
			<tr><th>작성일시</th><td><%=vo.getCreateDate() %></td></tr>
			<tr><th>조회수</th><td><%=vo.getCnt() %></td></tr>
			</tbody>
		</table>
		<a href="boardList.jsp">목록으로</a>
	</div>
	

</body>
</html>