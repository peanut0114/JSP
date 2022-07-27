package co.dev.common;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService service = MemberService.getInstance();
		// 입력 -> 뷰페이지
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setMail(ml);

		// insert
		service.addMember(vo);

		// 요청처리 결과 뷰페이지 전송 (vo의 주소값을 member이름으로 담음)
		req.setAttribute("member", vo);
		// member값을 전달
//		RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberInsertOutput.jsp");
//		try {
//			rd.forward(req, resp);// 요청 재지정
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Utils.forward(req, resp, "memberResult/memberInsertOutput.jsp");
	}

}
