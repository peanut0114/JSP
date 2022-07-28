package co.dev.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;


//Json
public class MemberJsonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//[{"name":"Hong","age":15},{"name":"Hwang","age":23}]
		resp.setContentType("text/json; charset=utf-8");
		
		MemberService service = MemberService.getInstance();
		List<MemberVO> members = service.memberList();
		//Json 형태로 만들어주는 라이브러리 이용
		JsonArray jary = new JsonArray();
		for(MemberVO vo : members) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("id", vo.getId());
			jobj.addProperty("name", vo.getName());
			jobj.addProperty("pass", vo.getPasswd());
			jobj.addProperty("mail", vo.getMail());
			
			//jary 추가
			jary.add(jobj);
		}
		
		//String json = "[{\"name\":\"Hong\",\"age\":15},{\"name\":\"Hwang\",\"age\":23}]";
		
		try {
			resp.getWriter().print(jary);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
