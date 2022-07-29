package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;



public class RemoveMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO 삭제처리 -> json 반환
		resp.setContentType("text/json;charset=utf-8");
		String id = req.getParameter("id");	//spa 요청정보의 id값을 읽음
		
		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.deleteMember(id);
		
		//{"retCode":"Success"}	값을 넘겨줌
		try {	
			if(isDeleted)
				resp.getWriter().print("{\"retCode\":\"Success\"}");
			else
				resp.getWriter().print("{\"retCode\":\"Fail\"}");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
