<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/main.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/login.css" type="text/css">
<script>
    $(document).ready(function(){
        $('#header').load("../layout/header.jsp");
        $('#footer').load("../layout/footer.jsp");
        
        $('#joinPage').click(function(){
        	location.href="/user/join";
        });
    }); // end jq
</script>
<div id="header"></div>
<%-- <jsp:include page="../layout/header.jsp"/> --%>
<body>
    <div class="container">
        <h2>아이디 로그인</h2>
        <form action="" method="post">
            <div class="form_wrap">
                <input type="text" id="email" name="userId" placeholder="아이디를 입력해주세요" required>
            </div>
            <div class="form_wrap">
                <input type="password" id="password" name="userPw" placeholder="비밀번호를 입력해주세요" required>
            </div>
            <div>
                <input type="checkbox" name="rememberMe" id="rememberMe">
                <label for="rememberMe">로그인 상태 유지</label>
            </div>
            <div class="form_wrap">
                <input type="submit" value="로그인" id="mypage">
            </div>
        </form>

        <div class="find_wrap">
            <div class="finding_wrap">
                <span class="forgot">
                    <a href="">아이디 찾기</a>
                </span>
                <span class="forgot">
                    <a href="">비밀번호 찾기</a>
                </span>
            </div>
            <div class="join">
                <a href="/user/join" id="joinPage">회원가입</a>
            </div>
        </div>
    </div>
</body>
<div id="footer"></div>
<%-- <jsp:include page="../layout/footer.jsp"/> --%>
</html>