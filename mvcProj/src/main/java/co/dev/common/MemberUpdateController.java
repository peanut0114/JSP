package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;
//수정컨트롤 : memberUpdate.jsp 에서 넘어옴
public class MemberUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//파라미터 받아온 값을 vo에 담음
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String em = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setMail(em);
		
		//vo의 정보로 수정(update 쿼리)
		MemberService service = MemberService.getInstance();
		service.modifyMember(vo);
		
		//공유 : vo
		req.setAttribute("member", vo);
		//수정결과 보는 페이지로 넘어감
		Utils.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}
}
