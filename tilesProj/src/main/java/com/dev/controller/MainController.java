package com.dev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {
	//
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// .tiles 요청시 TilesDispatchServlet 실행 
		//jsp 밑의 main 폴더 아래 main.jsp 를 몸체 부분에 넣어 구성 
		RequestDispatcher rd = req.getRequestDispatcher("main/main.tiles");
		rd.forward(req,resp);
		
	}
	
}
