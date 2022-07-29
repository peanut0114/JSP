package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;


public class FrontController extends HttpServlet {
	String enc;
	Map<String, Controller> mappings;
	
	//제일 처음 호출시 한번만 실행되는 init
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig : 환경객체를 읽어옴 (web.xml)
		//config를 통해 "charset"에 매핑된 파라미터를 가져옴
		enc = config.getInitParameter("charset");
		
		mappings = new HashMap<>();
		//memberinsert.do(key) 요청시 구현객체(value, controller타입)
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberJson.do", new MemberJsonController());
		//포워딩이 필요했는데 
		//ajax 입력
		mappings.put("/addMemberAjax.do", new AddMemberAjaxController());
		mappings.put("/removeMemberAjax.do", new RemoveMemberAjaxController());
		}
	
	//실행때마다 호출되는 service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		String uri=req.getRequestURI();
//		System.out.println("uri : "+uri);
		String contextPath = req.getContextPath();
//		System.out.println("contextPath : "+contextPath);
		String path= uri.substring(contextPath.length());//요청페이지 이후 정보
		System.out.println("path : "+path);
		
		//.do는 모두 이 페이지로 넘어온다 > 어떤 do 요청인가?
		//path를 기준으로 입력 요청인지 리스트 요청인지 구분
		Controller cntrl = mappings.get(path);//키값을 넣어주면 해당되는 값이 나올거임(init에서 값 확인)
		cntrl.execute(req, resp);	//컨트롤러의 execute 메소드 실행
	}
}
