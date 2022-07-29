package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원정보 등록 -> json 값 반화
		resp.setContentType("text/json; charset=utf-8");
		//MemberInsertController 와 동일부분
		MemberService service = MemberService.getInstance();
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setMail(ml);

		service.addMember(vo);
		
		//MemberInsertController 는 포워딩이 필요했는데 얘는 x
		//json 타입 반환
		Gson gson = new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(vo));	//id,name,passwd,mail로 넘어감
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
