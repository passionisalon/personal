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
    
    <title>국정감사 게시판 회원정보 수정 페이지(부서 책임자)</title>
</head>
<link href="../../../resources/css/userModify.css" rel="stylesheet" type="text/css">
<style>


</style>
<body>
    <div class="container">
        <h1>회원수정페이지</h1>
        <div class="wrap">
            <div class="wrap1">
                이메일 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="UserEmail" name="UserEmail" placeholder="${SESS_USER_EMAIL }" value="${SESS_USER_EMAIL }" readonly="readonly">
            </div>
            
        </div>
        
        <div class="wrap">
            <div class="wrap1">
                이름 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="userName" name="userName" placeholder="부서책임자" value="" required>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                성별 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="" id="selectGender">
                    <option id="pickGender" value="남">남</option>
                    <option id="pickGender"  value="여">여</option>
                </select>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                권한 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="" id="selectAuth">
                    <option id="pickAuth" value="[자료요청자/01]">[자료요청자/01]</option>
                    <option id="pickAuth" value="[부서책임자/02]">[부서책임자/02]</option>
                    <option id="pickAuth" value="[부서담당자/03]">[부서담당자/03]</option>
                </select>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                부서 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="" id="selectDepart" disabled>
                    <option id="pickDepart" value="[부서책임자/02]">[부서책임자/02]</option>
                    <option id="pickDepart" value="[인사부서/C001]">[인사부서/C001]</option>
                </select>
            </div>
        </div>

        <div class="wrap">
            <input id="modifyBtn" type="button" value="수정">
            <input id="cancleBtn" type="button" value="취소">
        </div>

    <script>
    	$(document).ready(function(){
    		
    		$('#cancleBtn').on("click",function(){
				self.location.href="/board/mainPage";    			
    		});	// end cancleBtn
    		
    		$('#userName').on("blur",function(){
//     			console.log($('#UserEmail'.val()));
//     			console.log("userName : ", $('#userName').val());
    			if($('userName').val() != ''){
    				$('#selectDepart').removeAttr("disabled");
    			};
    		});	// end userName
    		
    		$('#selectGender').on("blur",function(){
    			console.log("selectGender : ", $('#selectGender').val());
    		});	// end userName
    		
    		var Auth;
    		$('#selectAuth').on("blur",function(){
    			console.log("selectAuth : ", $('#selectAuth').val());
    			Auth = $('#selectAuth').val();
    		});	// end userName
    		
    		var DepartMent; 
    		$('#selectDepart').on("blur",function(){
    			console.log("selectDepart : ", $('#selectDepart').val());
    			DepartMent = $('#selectDepart').val();
    		});	// end userName
    		
    		$('#modifyBtn').on("click",function(){
    			console.log("modifyBtn 클릭!");
    			
    			
    			$.ajax({
        			url:'/user/userModifyPage',
        			type:'post',
        			data:{
        				
        				email : $('#UserEmail').val() ,
        				name :$('#userName').val() ,
        				gender : $('#pickGender').val() ,
                		userauth :Auth ,
                		depart : DepartMent 
        			},
        			dataType:'json',
        			success:function(data){
        				console.log("!!!ajax성공!!!");
        				self.location.href="/board/mainPage";
        			},error:function(xhr,status,error){
        				console.log(xhr);
        				console.log(status);
        				console.log(error);
        			}	// end error
        		});	// end ajax
    		});	// modifyBtn

    		
    		
    	});	// end jq
    </script>
    </div>
</body>
</html>