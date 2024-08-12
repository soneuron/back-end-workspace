let idSubmit = false;
let pwdSubmit = false;
id.addEventListener("input", function(e){
	// 시작은 영어로 영어, 숫자로만 10 ~ 14글자 -> 정규표현식
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
	
	// 중복체크
	$.ajax({
		type: "post",
		url: "/check",
		data: {
				id: e.target.value
			  },
		success: function(data){
			if(data){
				// 정보가 있을 때 -> 중복된 아이디입니다.
				idCheck.innerHTML = "중복된 아이디입니다. 다시 입력해주세요";
				idCheck.style.color = "red";
				idSubmit = false;
			} else{
				if(regExp.test(e.target.value)){
					idCheck.style.color = "green"
					idCheck.innerHTML = "OK";
					idSubmit = true;
				} else if(e.target.value === ""){
					idCheck.innerHTML = "";
					idSubmit = false;
				} else{
					idCheck.innerHTML = "첫글자는 영어로, 영어 또는 숫자로만 10 ~ 14 글자로 입력하세요.";
					idCheck.style.color = "red";
					idSubmit = false;
				} 
			}
		}
		
	});
	// 비어있지 않고
});

password.addEventListener("input", function(e){
	// 특수문자 하나 이상 포함
	// 대문자, 소문자 하나씩 포함 되어있는 경우
	// 숫자 하나이상 포함
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).*$/
	if(regExp.test(e.target.value)){
		pwdCheck.innerHTML = "OK";
		pwdCheck.style.color = "green";
		pwdSubmit = true;
	} else if(e.target.value === ""){
		pwdCheck.innerHTML ="";
		pwdSubmit = false;
	} else {
		pwdCheck.innerHTML = "특수문자, 대문자, 소문자, 숫자 한 개 이상 무조건 포함되어야 합니다.";
		pwdCheck.style.color = "red";
		pwdSubmit = false;
	}
});

function validate(){
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
	return idSubmit && pwdSubmit;
}