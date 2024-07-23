package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DAO - showAllMember
		MemberDAO member = new MemberDAO();

		ArrayList<Member> list = null;
		try {
			list = member.showAllMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
