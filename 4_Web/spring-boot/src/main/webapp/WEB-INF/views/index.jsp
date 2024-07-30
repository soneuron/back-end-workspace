<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 기능</h1>
	
	<ul>
		 <c:choose>
			<c:when test="${empty member}">
				<!-- 로그인 되어 있지 않은 경우 -->
				<li><a href="/register">회원가입</a></li><br>
				<li><a href="/login">로그인</a></li>
		 	</c:when>
				<c:otherwise>
				 			<!-- 로그인 된 경우 -->
				<li><a href="/search">회원검색</a></li>
				<li><a href="/allMember">전체회원보기</a></li>
				<li><a href="/logout">로그아웃</a></li>

				</c:otherwise>
		</c:choose>
	</ul>
	
</body>
</html>