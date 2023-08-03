<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <title>SeouLiveChangePassword</title>
</head>
<style>
    .findEmail_wrap{
        margin: 0 auto;
        width:1200px;
        height:900px;
/*         border:1px solid red; */
    }
    .findEmail_container{
        margin: 0 auto;
        width:1000px;
        height:900px;
/*         border:1px solid blue; */
        /* display: inline-block; */
    }
    .findEmail_body{
        margin: 0 auto;
        margin-top: 100px;
        margin-bottom: 100px;
        text-align: center;
        width:500px;
        height:400px;
/*         border:1px solid green; */
    }
    .individual_wrap{
        width:100%;
        height:50px;
        display: flex;
        align-items: center;
        justify-items: center;

    }
    .individual_wrap >input ,select,p{
        width:100%;
        height:50px;
        border-radius: 10px;
        margin: 0 auto;
        text-align: center;
        justify-items: center;
        justify-content: center;
        align-items: center;
        font-size: 16px;

    }
    #email_wrap, #password_wrap{
        display:flex;
    }
    .Btn{
        width:20%;
        height:50px;
        border-radius: 10px;
        color:aliceblue;
        background-color: #49539E;
    }
</style>
<body>
    <div class="findEmail_wrap">
        <div class="findEmail_container">
            <div class="changePassword_header">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>
            <div class="findEmail_body">
                <div class="individual_wrap" id="email_wrap">
                    <input type="email" id="UserEmail" name="UserEmail" placeholder="이메일 입력">
                </div>
                <br>
                <div class="individual_wrap">
                    <p> </p>
                </div>
                <div class="individual_wrap" id="password_wrap">
                    <input type="password" id="password1" name="UserPw" placeholder="비밀번호입력">
                    <button id="checkPassword1" class="Btn">확인</button>
                </div>
                <br>
                <div class="individual_wrap" id="password_wrap">
                    <p id="resultPassword1">비밀번호를 입력해주시시오.</p>
                </div>
                <div class="individual_wrap" id="password_wrap">
                    <input type="password" id="password2" name="UserPw" placeholder="비밀번호재입력">
                    <button id="checkPassword2" class="Btn">확인</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p id="resultPassword2">비밀번호가 일치하지 않습니다.</p>
                </div>
                <div class="individual_wrap">
                    <input type="submit" class="Btn" id="change_btn" value="비밀번호변경하기" formenctype="multipart/form-data">
                    <input type="submit" class="Btn" id="cancle_btn" value="취소" formenctype="multipart/form-data">
                </div>
                <br>
            </div>
            <div class="changePassword_footer">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
        	const passwordMatching = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
        	var Email;
        	var passCondition = new Array(2).fill(false);
        	
//         	 = $('#UserEmail').val();
			$('#checkPassword1').on("click",function(){
				var checkPasswordValue = passwordMatching.test($('#password1').val());
				console.log(checkPasswordValue);
				if(checkPasswordValue){
					console.log('비밀번호 유효성 검사를 통과하였습니다.');
					passCondition[0] = true;
					$('#resultPassword1').text("비밀번호 유효성검사를 통과하였습니다.").css("color","green");
				}else{
					console.log('비밀번호 유효성 검사를 통과하지못했습니다.');
					passCondition[0] = false;
					$('#resultPassword1').text("비밀번호 유효성검사를 통과하지 못하였습니다.").css("color","red");
				}
			});	// end checkPassword1
			
			$('#checkPassword2').on("click",function(){
				
				if($('#password1').val() == $('#password2').val()){
					console.log("맞음");
					passCondition[1] = true;
					$('#resultPassword2').text("비밀번호가 일치합니다.").css("color","green");
				}else{
					console.log("틀림");
					passCondition[1] = false;
					$('#resultPassword2').text("비밀번호가 불일치합니다.").css("color","red");
				}
				
			});	// end checkPassword2
			
			$('#change_btn').on("click",function(){
				console.log("클릭됨");
				if(passCondition[0]==true & passCondition[1]){
					$.ajax({
						url:'/user/multiCheckAndChangePassword',
						type:'post',
						data:{
							Email : $('#UserEmail').val(),
							Pw : $('#password1').val()
							
						},
						dataType:'json',
						success:function(data){
							console.log("ajax 성공!!!");
							console.log(data);
						},error:function(xhr,status,error){
							console.log(xhr);
							console.log(status);
							console.log(error);
						}
						
						
					});	// end ajax
					alert("비밀번호 변경성공!!!");
					self.location.href="/user/login";
				}else{
					alert("위 이메일과 비밀번호를 확인해 주십시오.");
				}
				
			});	// end change_btn
			
			
			
            $('#cancle_btn').on("click",function(){
            	self.location.href="/user/login"
            });	// end cancle_btn  
            
        });
    </script>
</body>
</html>