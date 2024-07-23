<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member member = (Member) request.getAttribute("member"); 
	if(member!=null){ %>
	<h1>회원 정보 결과</h1>
	<ul>
		<li>ID : <%=member.getId() %></li>
		<li>PASSWORD : <%=member.getPassword() %></li>
		<li>NAME : <%=member.getName() %></li>
	</ul>
	<% } else { %>
	<h1>회원 정보가 없습니다.</h1>
	<% } %>
</body>
</html>