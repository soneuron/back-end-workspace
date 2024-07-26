<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/front" method="post">
		<input type="hidden" name="command" value="register">
	 	ID : <input type="text" name="id"><br>
		PASSWORD : <input type="password" name="password"><br>
		NAME : <input type="text" name="name"><br>
		<input type="submit" value="회원가입">
	</form>
	
	
		<!-- 회원가입 : 아이디, 비밀번호, 이름 입력 받아서
			          호출 : /register, 방식 : post
					  RegisterServlet
					  index.jsp로 이동
		 -->
	
	
</body>
</html>