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
	System.out.println(bno+"번 게시물 선택");
	
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
	<%
		// 작성자가 아니면 수정 버튼 보이지 않게 막는 법
		//String loginId=(String) session.getAttribute("loginId");
		//if(loginId !=null && loginId.equals(vo.getWriter())){
	%>
		<a href="updateForm.jsp?bno=<%=bno%>">
			<input type="button" value="글수정"></a>
		<a href="deleteForm.jsp?bno=<%=vo.getBoardId()%>">
			<input type="button" value="삭제"></a>
	<%	
		//}
	%>
		<a href="boardList.jsp"><input type="button" value="목록으로"></a>
	</div>
	

</body>
</html>