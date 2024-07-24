<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	
	<ul>
			<!-- 로그인 된 경우 -->
		<li><a href="/views/search.jsp">회원검색</a></li>
		<!-- 회원검색 : 검색할 아이디 입력받아서
					  호출 : /search, 방식 : get
					  SearchServlet
					  성공하면 views/search_ok.jsp 해당 정보 출력
					  실패하면 views/search_fail.jsp "검색 실패했습니다." 출력
		 -->
		 
		<li><a href="/allMember">전체회원보기</a></li>
		<!-- 전체 회원보기 : views/allMemberr.jsp에 리스트 출력 -->
		
		<li><a href="/logout">로그아웃</a></li>
		<!-- 로그아웃 : 로그인 하고 index.jsp로 이동 -->
	</ul>
</body>
</html>