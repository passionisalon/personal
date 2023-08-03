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
    <title>SeouLiveFindEamil</title>
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
        margin-top: 200px;
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
            <div class="findEmail_header">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>
            <div class="findEmail_body">
                <div class="individual_wrap" id="email_wrap">
                    <input type="email" id="UserEmail" name="UserEmail" placeholder="이메일 입력">
                    <button id="checkDistinctEamil" class="Btn">전송</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p id="resultComment">이메일을 입력해주십시오.</p>
                </div>
                <div class="individual_wrap" id="email_wrap">
                    <input id="UserCode" name="UserEmail" placeholder="이메일로 전송된 코드를 적어주십시오.">
                    <button id="checkCode" class="Btn">확인</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p id="resultAuth">인증코드를 입력해주십시오.</p>
                </div>
                <div class="individual_wrap">
                    <input type="submit" class="Btn" id="find_btn" value="이메일찾기" formenctype="multipart/form-data">
                    <input type="submit" class="Btn" id="cancle_btn" value="취소" formenctype="multipart/form-data">
                </div>
                <br>
            </div>
            <div class="findEmail_footer">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
    
        $(document).ready(function () {
        	var code;
        	var tempArray = [];
        	var Auth;
            $('#checkDistinctEamil').on('click',function(){
            	console.log($('#UserEmail').val());
            	
            	$.ajax({
            		type:'post',
            		url:'/user/sendEmailForFindEmail',
            		data:{userEmail : $('#UserEmail').val()},
            		dataType:'json',
            		success:function(data){
            			console.log("data : ",data);
            			
            			console.log(data.code);
            			console.log(data.Email);
            			code = data.code;
            			console.log(code);
            			tempArray = data.Email;
            			
            		},error:function(xhr,status,error){
            			console.log(xhr);
            			console.log(status);
            			console.log(error);
            		}
            	});	// end ajax
            	if(code==''){
            		$('#resultComment').text('전송되지않았습니다.').css("color","red");
            	}else{
            		$('#resultComment').text('전송되었습니다.').css("color","green");
            	}
            })	// end checkDistinctEmail
            
            $('#checkCode').on("click",function(){
            	console.log($('#UserCode').val());
            	if(code == $('#UserCode').val()){
            		$('#resultAuth').text('인증되었습니다.').css("color",'green');
            		console.log($('#resultAuth').val());
            		Auth = true;
            	}else{
            		$('#resultAuth').text('인증되지 않았습니다.').css("color",'red');
            		console.log($('#resultAuth').val());
            		Auth = false;
            	}
            });	// end checkCode
            
            $('#cancle_btn').on("click",function(){
            	self.location.href="/user/login"
            });	// end cancle_btn
            
            $('#find_btn').on("click",function(){
            	if(Auth){
            		if(tempArray == null){
            			alert("가입되지 않았습니다.");
            			self.location.href="/user/login"
;            		}
            		alert(tempArray);
            		self.location.href="/domain";
            	}else{
            		alert("이메일 인증을 해주십시오.");
            	}
            });	// end find_btn
            
        });	// end jq
    </script>
</body>
</html>