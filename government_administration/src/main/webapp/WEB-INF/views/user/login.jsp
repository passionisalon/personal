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
    
    <title>국정감사 게시판 로그인(부서 책임자)</title>
</head>
<link href="../../../resources/css/login.css" rel="stylesheet" type="text/css">
<body>
    <div class="container">
        <h1>국정감사 게시판 로그인 페이지</h2>
            <div class="jump">

            </div>
        <div class="wrap">
            
            
            <div class="wrap_login">    <!-- start wrap_login -->
                <div class="emails">
                    아이디 : 
                </div>
                <div class="block_email">

                </div>
                <div class="emails">
                    <input id="userEmail" type="email" placeholder="아이디를 입력하세요.">
                </div>
            </div>    <!-- end wrap_login -->
           
            <div class="wrap_password">     <!-- start wrap_password -->
                <div class="passwords">
                    비밀번호 : 
                </div>
                <div class="block_password">

                </div>
                <div class="passwords">
                    <input id="userPassword" type="password" placeholder="비밀번호를 입력하세요.">
                </div>
            </div>     <!-- end wrap_password -->
            
            <div class="warp_button">     <!-- start wrap_password -->
                <div id="pp">
                    <input  id="loginBtn" type="button" value="로그인">
                    
                </div>
                <div id="pp">
                    <input id="joinPage" type="button" value="회원가입" >
                </div>
            </div>     <!-- end wrap_password -->

        </div>
        
        
    </div>
<script>
	$(document).ready(function(){

        $('#joinPage').click(function(){
            self.location.href="/user/join";
        }); // end joinPage


        $('#loginBtn').click(function(){
            console.log("로그인 버튼 활성화");

            const emailMatching= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            const passwordMatching =  /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;

            // console.log(emailMatching);
            // console.log(passwordMatching);

            var email = $('#userEmail').val();
            // console.log(email);

            var password = $('#userPassword').val();
            // console.log(password);

            var emailValueCheck = emailMatching.test(email);
            var passwordValueCheck = passwordMatching.test(password);

            // console.log("asdasd : "+emailValueCheck);
            // console.log("asdasd : "+passwordValueCheck);

            var logInSuc = false;

            if(emailValueCheck == true & passwordValueCheck == true){
                $.ajax({
                url:'/user/login',
                type:'Post',
                data:{
                    Email : email , Password : password
                },
                dataType:'json',
                success:function(data){
                    console.log("ajax성공!!!");
                    console.log(data);

                },error:function(xhr,status,error){
                    console.log(xhr);
                    console.log(status);
                    console.log(error);
                }   // end error
            
            }); // end ajax
                self.location.href="/board/mainPage";
            }else{
                alert("안됨 다시 쓰소");
            }

        }); // end loginBtn

    }); // end jq
</script>
</body>
</html>