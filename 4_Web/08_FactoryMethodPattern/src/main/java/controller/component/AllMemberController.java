package controller.component;

import java.util.ArrayList;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

public class AllMemberController implements Controller {
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = dao.allMember();
		
		request.setAttribute("list", list);

	return new ModelAndView("/views/allMember.jsp", true);

	}
	
}
