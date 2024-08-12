<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<form id="frm">
		아이디 : <input type="text" name="id" id="id"><br>
		비밀번호 : <input type="password" name="password" id="password"><br>
		이름  : <input type="text" name="name" id="name"><br>
		<input type="button" value="가입" id="btn">
	</form>
	
	<div id="result"></div>
	
	<script>
		$("#btn").click(()=>{
			$.ajax({
				// post 방식으로
				// /serial
				// id, password, name 값 넘겨서 회원가입 하고
				// 돌아와서 result에 정보 기재
				// 요청
				type: "post",
				url: "/serial",
				data : $("#frm").serialize(),
				
				//data: {
				//	   id : $("#id").val(),
				//	   password : $("#password").val(),
				//	   name : $("#name").val()
				//	  },
				
				// 응답
				success: function(result){
					alert("회원가입 완료")
					console.log(result);
					$("#result").html(result.name + "님이 회원가입 하셨습니다.")
					$("#result").text(result.id);
					$("#result").text(result.password);
					$("#result").text(result.name);
					// $("#result").text(result)
					// $("#result")}.text("id = "+ result);
				},
				error: function(){
					alert("회원가입 실패")
				}
			});
		});
	</script>
</body>
</html>