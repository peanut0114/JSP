package com.edu;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;
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
		
		//DB에 적용이 되지 않은 경우를 체크
		boolean isTrue=false;	//교수님방식 : 불린 ->Post (입력)
		int check=0;			//혜주방식 : int ->Get (수정)
		
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
			isTrue = dao.insertMember(name, pass, role);
		}
		//DB에 입력
		dao.insertMember(name, pass, role);		
		if(check>0||isTrue) resp.getWriter().print("Complete");
		else resp.getWriter().print("Failed");
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
