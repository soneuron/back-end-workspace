<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 기능</h1>
	
	<ul>
		<!-- 로그인 되어 있지 않은 겨우 -->
		<li><a href="/views/register.jsp">회원가입</a></li>

<br>
		 
		<li><a href="/views/login.jsp">로그인</a></li>
		<!-- 로그인 : 아이디, 비밀번호 입력 받아서
					 호출 : /login, 방식 : post
					 LoginServlet : 세션 데이터 바인딩
					 로그인 끝나고 index.jsp로 이동(로그인 된 상태)
		 -->
	</ul>
	
</body>
</html>