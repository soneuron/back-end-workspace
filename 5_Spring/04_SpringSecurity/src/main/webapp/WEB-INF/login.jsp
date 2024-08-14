<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form id="frm">
		아이디 : <input type="text" name="id"> <br><br>
		비밀번호 : <input type="text" name="password"> <br><br>
		<input type="submit" value="로그인" id="login">
	</form>
	
	<script>
		$("#login").click((e)=>{
			e.preventDefault(); // 기존 이벤트 제거(submit 이벤트가 되지 안도록 이벤트 제거)
			$.ajax({
				url:"/login",
				type:"post",
				data:$("#frm").serialize(),
				success:function(data){
					console.log(data); // token값 확인
					// token 값 -> localStorage에 저장(localStorage는 localhost:8080의 검사탭에 Application에서 확인가능)
					localStorage.setItem("token", data),
					location.href = "/";
					}
			})
			
		});
	</script>
</body>
</html>