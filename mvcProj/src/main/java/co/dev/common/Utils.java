package co.dev.common;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	//자주 사용하는 forward 매소드를 따로 만들어서 사용
	public static void forward(HttpServletRequest req//
			, HttpServletResponse resp, String path) {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		try {
			rd.forward(req, resp);	//요청 재지정
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
