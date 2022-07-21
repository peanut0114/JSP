package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>추가적인 정보</h3>");
		out.print("<p>Request Method: "+req.getMethod()+"</p>");//요청방식 get put host .. : 따로 지정하지 않으면 GET방식
		out.print("<p>Path Info: "+req.getPathInfo()+"</p>");
		out.print("<p>Path Traslated: "+req.getPathTranslated()+"</p>");//요청페이지 정보
		out.print("<p>Query String: "+req.getQueryString()+"</p>");
		out.print("<p>Content Length: "+req.getContentLength()+"</p>");
		out.print("<p>Content Type: "+req.getContentType()+"</p>");
	}
}

/* web.xml을 통해 매핑
	<servlet>
	<servlet-name>addInfo</servlet-name>
	<servlet-class>com.edu.AddInfoServlet</servlet-class>
	</servlet>
	<servlet-mapping>
	<servlet-name>addInfo</servlet-name>
	//addInfo 하위의 어떤 주소를 요청하든 지정 서블릿 실행시킴
	<url-pattern>/addInfo/*</url-pattern>
	//addInfo 하위의 .do형태의 주소를 받으면 서블릿 실행
	<url-pattern>/addInfo/*.do</url-pattern>
	</servlet-mapping>
*/