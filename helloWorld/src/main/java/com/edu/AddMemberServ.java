package com.edu;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 받은 파라메터를 테이블에 추가
 */
@WebServlet("/addMember")
public class AddMemberServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 user_name=user2 & user_pass=1234 & role=1 
		//페이지 호출하면 넘어올 값
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		EmpDAO dao = new EmpDAO();
		int check=0;
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//get요청, post요청 구분해서 처리
		if(req.getMethod().toUpperCase().equals("GET")) { //대문자로 바꿔서 비교	
			//get : 수정
			check= dao.updateMember(name, pass, role);
			if(check<1) {
				out.print("<script>alert('없는 정보입니다')</script>");
				out.flush();
			}
		}else {
			//post : 입력
			check= dao.insertMember(name, pass, role);
			if(check<1) {
				out.print("<script>alert('이미 등록된 사용자입니다')</script>");
				out.flush();
			}
		}
		if(check>0) {
		//DB에 입력
		dao.insertMember(name, pass, role);		
		resp.getWriter().print("Complete");
		}
	}
}
/*get.html 실행 -> 버튼 누르면 addMemeber되도록 맞춤
 * 
 * <form action="../addMember" >							//경로지정
		UserName : <input type="text" name="user_name"><br>
		PassWord : <input type="password" name="user_pass"><br>
		Role : <input type="number" name="role"><br>
		<input type="submit" value="send"><br>
	</form>
 * */
