package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;



public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//파라미터
		String id = req.getParameter("id");
		String nm = req.getParameter("name");
		
		MemberService service = MemberService.getInstance();
		service.deleteMember(id);
		
		//공유
		req.setAttribute("name", nm);
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}

}
