<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    <title>join</title>
</head>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script> -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/main.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/join.css" type="text/css">

<body>
<script>
    $(document).ready(function(){
        $('#header').load("../layout/header.html");
        $('#footer').load("../layout/footer.html");
    }); // end jq
</script>
<div id="header"></div>
<%-- <jsp:include page="../layout/header.jsp"/> --%>
    <div class="container">
    
            <h2>회원가입</h2>
            <form action="/user/join" method="post">
                <div class="form_wrap1">
                    <input type="text" id="UserId" name="UserId" placeholder="아이디를 입력해주세요" required>
                    <div>
                        <button id="checkDistinctId" class="checkDistinctId">중복확인</button>
                    </div>
                </div>
                
                <div class="form_wrap1">
                    <input type="password" id="password1" name="userPw" placeholder="영문/숫자/특수문자 8자 이상 15자 이하" required>
                    <div>
                        <button id="checkPw" class="checkPw">확인</button>
                    </div>
                </div>
                <div class="form_wrap">
                    <input type="password" id="password2" name="password" placeholder="비밀번호 확인" required>
                	<div><br></div>
                	<div id="result" class="result"></div>
                </div>
                <div class="form_wrap">
                    <input type="text" id="name" name="userName" placeholder="이름" >
                </div>
                <div class="form_wrap">
                    <input type="datetime" id="birthday" name="userBirthday" placeholder="ex) 1990-01-24" >
                </div>
                <div class="form_wrap">
                    <input type="tel" id="tel" name="userPhone" placeholder="ex) 01012345678" required>
                </div>
                <div class="form_wrap1">
                    <input type="email" id="EMail" class="EMail" name="userEmail" placeholder="이메일 인증" required>
                    <div>
                        <button id="checkEmail" class="checkEmail">전송</button>
                    </div>
                </div>
                <div><br></div>
                <div class="form_wrap">
                    <input id="AuthEmail" name="AuthEmail" placeholder="메일인증" required>
                	<div><br></div>
                    <div id=mail_Check_Input class="mail_Check_Input">인증번호를 입력해주세요.</div>
                </div>
                <div class="form_wrap">
                    <select name="userGender" id="gender">
                        <option value="남">남</option>
                        <option value="여">여</option>
                    </select>
                </div>
            
                
                

            <div class="form_wrapEnd">
                <input type="submit" value="가입" id="mypage">
                <input type="button" value="취소" id="mypage">
            </div>
        
       </form>
 
    </div>  <!-- end container -->
<div id="footer"></div>
<%-- <jsp:include page="../layout/footer.jsp"/> --%>
</body>

<script>
	
	/* ------------------- 아이디 중복첵크 -------------------- */
	$('#checkDistinctId').click(function(){
		const UserId = $('#UserId').val();	//id 값 얻어오기
		console.log("Id확인 : "+UserId);
		
		if(UserId == ""){
			alert("아이디를 입력바랍니다.");
		} // end if
		
		$.ajax({
			url:'${pageContext.request.contextPath}/user/checkDistinctId?UserId='+UserId,
			type:'get',dataType:'json',
			success:function(data){
				console.log("1 중복 / 0 중복아님 : "+data);
				
				if(data == 1){
					alert("중복된아이디입니다.");
				}else{
					alert("중복되지 않았습니다.");
				}
			},
			error:function(){
				console.log("실패");
			}
		});	// end ajax
		
	})//end checkDistinctId
	/* ------------------- 아이디 중복첵크 -------------------- */
	
	/* ------------------- 비밀번호 유효성 검사 -------------------- */
	$('#checkPw').click(function(){
		const password1 = $('#password1').val();
		const password2 = $('#password2').val();
		const num = password1.search(/[0-9]/g);
		const eng = password1.search(/[a-z]/ig);
		const spe = password1.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		

		
		
		if(password1 =="" & password2 ==""){
			alert("비밀번호를 입력바랍니다.");
		}else if(password1.length < 8 || password1.length >15){
			alert("8 ~ 15 자 이내로 입력해주세요.");
			return false;
		}else if(password1.search(/\s/) != -1){
			alert("공백없이 입력하십시오.");
			return false;
		}else if(num< 0 || eng < 0 || spe <0){
			alert("영문,숫자,특수문자를 혼합하여 입력해주십시오.");
			return false;
		}else{
			alert("사용가능한 비밀번호입니다.")
			console.log("통과!");
			return true;
		}	// end if -else if -else
		
		
	});	//	end checkPw
	/* ------------------- 비밀번호 유효성 검사 -------------------- */
	
	/*  비밀번호와 비밀번호 확인 일치 검사 */
	$(document).ready(function(){
		
		$("form").submit(function(event){
			// 비밀번호 필드 값 얻기
			var password1 = $("#password1").val();
			
			// 비밀번호가 null 또는 빈 문자열인 경우
			if(!password1){
				alert("비밀번호를 입력해주세요.");
				event.preventDefault(); //폼 제출막기 
			}//end if
		});	//end form event
		
		$('#password1,#password2').blur(function(){
			var password1 = $('#password1').val();
			var password2 = $('#password2').val();
			if(password2 == ""){
				$('.result').text("비밀번호를 확인하십시오.");
				$('.result').css('color','red');
			}else if(password1 != password2){
				$('.result').text("입력한 비밀번호가 다릅니다.");
				$('.result').css('color','red');
			}else{
				$('.result').text("비밀번호가 일치합니다.");
				$('.result').css('color','green');
			} // end if-else if-else
		});	// end	password matching test 

	/* ------------------- 메일 인증  -------------------- */

		var code='';
		$('#checkEmail').click(function(){
			const EMail = $('#EMail').val();
			console.log("이메일 잘받아왔는지 확인 : "+EMail);
			const AuthEmail = $('#AuthEmail').val();
			
			$.ajax({
				type : 'get',
				url  : "${pageContext.request.contextPath}/user/mailCheck?EMail="+EMail,
				success : function(data){
					console.log("data : "+data);
					//AuthEmail.attr('disabled',false);
					code = data;
					alert('인증번호가 전송되었습니다.');
				}	//	end success
			})	// end ajax
			
			
		});	// end checkEmail
		
		$("#AuthEmail").blur(function(){
			const mail_check_input = $('#AuthEmail').val();
			console.log('AuthEmail : '+mail_check_input);
			const resultMsg = $('#mail_Check_Input');
			
			if(mail_check_input == code){
				resultMsg.html("인증번호가 일치합니다.");
				resultMsg.css('color','green');
			}else{
				resultMsg.html('인증번호가 일치하지않습니다.');
				resultMsg.css('color','red');
			}	// end if-else
		});	// end mail_check_input
		
		
	
	});	// end jq

	
	
	
</script>
</html>