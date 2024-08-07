package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		Member member = dao.searchMember(id);
			
			if(member!=null) {
				// 성공하면 views/search_ok.jsp 해당 정보 출력
				request.setAttribute("member", member);
				return new ModelAndView("/views/search_ok.jsp");	
			} 
				return new ModelAndView("/views/search_fail.jsp", true);	
		
	}


}
