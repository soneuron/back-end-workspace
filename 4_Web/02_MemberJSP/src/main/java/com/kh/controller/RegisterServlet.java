package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Controller - 비지니스 로직 작성 공간
		
		// index.jsp에서 /register로 요청하여
		// 요청 받은 아이디(id), 비밀번호(pwd), 이름(name)을 받는다.
		
		// 1. (있을때) 폼 값 받아온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// 2. DAO 호출 - DB 접근 필요 시
		MemberDAO member = new MemberDAO();
		boolean check = false;
		
		try {
			member.registerMember(id, pwd, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		check = true;
//		if(check) {
//			// 3. 바인딩 : 서버에서 받은 값을 결과 페이지에 보낼 때
//			request.setAttribute("name", name);
//			
//			// 결과 페이지 지정 - result.jsp
////				response.sendRedirect("result.jsp");
//			// 만약 결과 페이지로 서버에서 받은 값을 보여주려면
//			// RequestDispatcher forward 방식으로 보여주면 됌
//			request.getRequestDispatcher("result.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("fail.jsp");
//		}
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		// 중복여부 판단 후 결과 페이지2개(성공, 실패) or 페이지1개
		
	}

}
