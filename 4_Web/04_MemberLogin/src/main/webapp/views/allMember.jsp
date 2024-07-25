<%@page import="model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원</h1>
	<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PASSWORD</th>
			<th>NAME</th>
		</tr>
		<% for(Member m : list) { %>
			<tr>
				<td><%= m.getId() %></td>
				<td><%= m.getPassword() %></td>
				<td><%= m.getName() %></td>
			</tr>
		<% } %> 
	</table>
	<a href="/">메인 페이지로</a>
</body>
</html>