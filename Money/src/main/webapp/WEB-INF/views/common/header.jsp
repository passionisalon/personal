<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/layout/layout.css"/>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
</head>
<body>
    <!-- í¤ë ìì -->
    <div id="header">
        <div class="wrap">
            <h1 class="logo">
                <!-- <img id="headerLogo" src="${pageContext.request.contextPath}/resources/img/img-logo.png" width="240" height="60"> -->
                <img id="headerLogo" src="/resources/img/img-logo.png" width="240" height="60">
            </h1>
            </h1>
            <ul class="bn">
                <li class="fl" id="travelBoard">여행지</li>
                <li class="fl" id="courseBoard">코스</li>
                <li class="fl" id="reviewBoard">리뷰</li>
                <li class="fl" id="freeBoard">자유게시판</li>
                <li class="fl" ><br></li>
                <li class="fl" ><br></li>
                <li class="fl" id="joinBtn">회원가입</li>
                <li class="fl" id="loginBtn">로그인</li>   
            </ul>
            <ul class="bn">
                <!-- <c:if test="${sessionScope.__AUTH__ == null}"> -->
                    <!-- <li class="fr" id="joinBtn">íìê°ì</li> -->
                    <!-- <li class="fr" id="loginBtn">ë¡ê·¸ì¸</li> -->
                <!-- </c:if> -->

                <!-- <c:if test="${sessionScope.__AUTH__ != null}">
                    <li class="fr" id="logoutBtn">ë¡ê·¸ìì</li>
                    <li class="fr" id="myPageBtn">ë§ì´íì´ì§</li>
                </c:if> -->
            </ul>

        </div>

		<script>

            $(document).ready(function(){
            	$('#loginBtn').on('click',function(){
                    self.location.href="/user/login";
            	});	// loginBtn
            	$('#joinBtn').on('click',function(){
                    self.location.href="/user/join";
            	});	// joinBtn

                $('#travelBoard').on("click",function(){
                    self.location.href="/travel/list";
                });
                // $('#courseBoard').onlcik(function(){
                //     self.location.href="/user/join";
                // });
                // $('#reviewBoard').onlcik(function(){
                //     self.location.href="/user/login";
                // });
                // $('#freeBoard').onlcik(function(){
                //     self.location.href="/user/join";
                // });
            }); // end jq
			
		</script>
		
    </div>
</body>
</html>