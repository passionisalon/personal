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

    
    <title>국정감사 게시판 리스트 페이지(부서책임자)</title>
    
</head>
<link href="../../../resources/css/auditorManageDetailPage.css" rel="stylesheet" type="text/css">
<body>
    
    <div class="container">             <!-- container -->
        <h1>국정감사 관리게시판 상세페이지</h1>
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">아이디 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
            	<div id="uEmail" value="${__DTO__.email}">${__DTO__.email}</div>
                
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">이름 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                ${__DTO__.name}
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">부서 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                <select name="" id="SelectDepart">
                    <option id="de" value="[부서책임자/02]">[부서책임자/02]</option>
                    <option id="de" value="[부서담당자/03]">[부서담당자/03]</option>
                    <option id="de" value="[자료요청자/01]">[자료요청자/01]</option>
                </select>
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">상태 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                ${__DTO__.status}
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">제목 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                ${__DTO__.title}
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">내용 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                ${__DTO__.content}
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap_blockLast">

        </div>
        <div class="wrap" id="wrapLast">
            <div class="wrap3">
                <input id="selectBTN" type="button" value="담당자지정">
                <input id="CloseBtn" type="button" value="닫기">
            </div>
        </div>
    </div><!-- container -->
    <script>
    	$(document).ready(function(){
    		$('#CloseBtn').on("click",function(){
    			self.location.href="/board/auditorManage";
    		});	// end 
    		
    		$('#selectBTN').on("click",function(){

				var UserEmail = $('#uEmail').text();
    			var temp = $('#SelectDepart').val();
    			console.log("UserEmail : ",UserEmail);
    			console.log("temp : ",temp);
				
    			$.ajax({
    				url:'/board/updateManagePosting',
    				type:'post',
    				data:{
    					email : UserEmail,
    					UserAuth : temp
    				},
    				dataType : 'json',
    				success:function(data){
    					console.log("!!!!ajax성공!!!!");
    				},error:function(xhr,status,error){
    					console.log(xhr);
    					console.log(status);
    					console.log(error);
    				}
    			});	//end ajax
    			
    		});	// end
    	})
    </script>
</body>
</html>