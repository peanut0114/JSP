package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		System.out.println("id : " + id);

		MemberService service = MemberService.getInstance();
		service.getMember(id);
		//입력값이 없는경우
		if (id.isEmpty()) {
			req.setAttribute("error", "id를 입력하세요");
			if (job.equals("search")) {
				Utils.forward(req, resp, "memberView/memberSearch.jsp");
			} else if (job.equals("update")) {
				Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			} else if (job.equals("delete")) {
				Utils.forward(req, resp, "memberView/memberDelete.jsp");
			}
			return;
		}
		req.setAttribute("member", service.getMember(id));
		
		//입력값이 있는 경우
		MemberVO vo = service.getMember(id);
		//해당 아이디의 회원정보가 없는 경우
		if(vo==null) {
			req.setAttribute("result", "검색된 정보가 없습니다.");
		}
		req.setAttribute("member", vo);
		//경로 설정
		if (job.equals("search")) {
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		} else if (job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		} else if (job.endsWith("delete")) {
			Utils.forward(req, resp, "memberView/memberDelete.jsp");
		}
	}

}
