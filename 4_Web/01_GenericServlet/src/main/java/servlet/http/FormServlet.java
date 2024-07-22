package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userId = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		
		String gender = request.getParameter("gender");
		if(gender.equals("M")) {
			gender = "남자";
		} else {
			gender = "여자";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다</h1>");
		out.println("<p>당신의 아이디는 : "+ userId +"</p>");
		out.println("<p>당신의 비밀번호는 : "+ userpwd +"</p>");
		out.println("<p>당신의 성별은 : " + gender +"</p>");
		String[] menu = request.getParameterValues("menu");
		for(String m : menu) {
			out.println("<ul><li>" + m +"</li></ul>");
		}
		out.println("</body></html>");
	}

}
