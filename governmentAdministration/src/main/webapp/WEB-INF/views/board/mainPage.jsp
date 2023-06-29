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
    
    <title>국정감사 게시판 메인 페이지(부서 책임자)</title>
</head>
<link href="../../../resources/css/mainPage.css" rel="stylesheet" type="text/css">
<style>

</style>
<body>
    <div class="container">             <!-- start container -->
        <div class="wrap">              <!-- start wrap -->
            
            <div class="wrap_1">        <!-- start wrap_1 -->
                <div class="wrap_1_1">
                    <div class="blocks_1"></div>
                    <h1>${SESS_USER_NM }님(${SESS_USER_EMAIL }) 환영합니다.</h1>
                </div>
                <div class="blocks_2"></div>
                <div class="wrap_1_2">
                    
                    <div class="wrap_1_2_1">
                        <input id="modifyInformation" type="button" value="회원정보수정">
                        <input id="logoutBtn" type="button" value="로그아웃">
                    </div>
                </div>
            </div>                                                  <!-- end wrap_1 -->
            <div class="blocks_2"></div>
            
            <div class="wrap_2">                                    <!-- start wrap_2 -->
                <div class="wrap_2_1" id="wrap_2_1">
                	<input type="button" id="gesipan1" value="국정감사게시판">
                	
                	<c:if test="${SESS_AUTH_CD == '[부서책임자/02]'}">
						
						<input type="button" id="gesipan2" value="국정감사 관리게시판">                		
                	</c:if>
                	                
                
                    

                </div>
                
                <div class="wrap_2_2">
                    
                    <div class="blocks_2"></div>
                    <div class="blocks_2"></div>
                    <div class="blocks_2"></div>
                    <div class="blocks_2"></div>
                    <div class="blocks_2"></div>
                    <div class="blocks_2"></div>

                </div>
                
            </div>                                                  <!-- end wrap_2 -->
            


        </div>                      <!-- end wrap -->
        
        <script>
        	$(document).ready(function(){
//         		
        		
        		
        		$("#logoutBtn").on("click",function(){
        			$.ajax({
        				url:"/user/logout",
        				type:"post",
        				dataType:"json",
        				success:function(response){
        					console.log(" 1 = 성공 / 0=실패");
        			    	  console.log(response);
        			    	  if(response == 1 ) {
        			    		  alert("로그아웃 되었습니다.");
        			    		  console.log("로그아웃 성공");
        			    		  window.location.replace("/user/login");
        			    	  }  else {
        			    		  console.log("로그아웃 실패");
        			    		  location.reload();
        			    	  }
        			        // 여기에 로그아웃 성공 후 수행할 동작을 추가할 수 있습니다.
        			      },	// end sueess
        			      error: function(xhr, status, error) {
        			        console.log("요청 실패");
        			        // 여기에 로그아웃 실패 후 수행할 동작을 추가할 수 있습니다.
        			      }	// end error
        				
        				
        			});// end ajax
        		})
        		
        		$('#modifyInformation').on("click",function(){
        			self.location.href="/user/userModifyPage";
        		});	// end #modifyInformationg
        		
        	});	// end jq
        </script>

        
    </div>                          <!-- end container -->
</body>
</html>