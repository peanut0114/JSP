<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%	//문자 타입으로 넘어온 bno를 받아온다
		String bno = request.getParameter("bno");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
//		String loginId=(String) session.getAttribute("loginId");
//		String condition="";
//		if(!(loginId !=null && loginId.equals(vo.getWriter()))){
//			condition="disabled";
//		}
	%>
	<c:set var="vo" value="${vo }"/>
	<c:set var="loinId" value="${bno}"></c:set>
	<c:choose>
		<c:when test="${!(!empty loginId)&& loginId.equals(vo.writer)}">
			<c:set var="condition" value="disabled"/>
		</c:when>
	</c:choose>
  <form action="update.jsp">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="<%=vo.getBoardId() %>" readonly></td></tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="<%=vo.getTitle() %>"></td></tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="<%=vo.getContent()%>"></td></tr>
		<tr><td><input type="submit" value="수정" ${condition}></td></tr>
	</table>
  </form>
</body>
</html>