
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SeouLiveLogin</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
</head>
<style>
    @import url('reset.css');

    .login_wrap {
        margin: 0 auto;
        width: 1200px;
        height: 700px;
    }

    .container {
        width: 1200px;
        height: 700px;
        /* border: 1px solid red; */
    }

    .login_body {
        margin-top: 100px;
        width: 1200px;
        height: 600px;
        /* border: 1px solid blue; */
        /* padding-left: -100px; */
    }

    .login_header,
    .login_footer {
        padding-left: 100px;
    }

    .loginBox {
        margin: 100px auto;
        width: 600px;
        height: 500px;
        /* border: 1px solid yellow; */
        text-align: center;
    }

    h2 {
        text-align: center;
        font-weight: bolder;
    }

    #findAndJoin {
        display: flex;
        justify-content: center;
    }
    #findAndJoin > span{
        margin-left: 5px;
        margin-right: 5px;
    }

    .form_wrap {
        width: 600px;
        height: 50px;
    }

    .form_wrap input {
        width: 60%;

        padding: 10px;
        border-radius: 10px;
        border: 1px solid rgb(233, 233, 233);
    }

    #rememberMeDiv {
        display: flex;
        justify-content: center;
    }
    #rememberMe{
        width:15px;
        height:15px;
        margin-right: 10px;
    }
    .form_wrap> #loginBtn{
        width: 60%;
        height: 100%;;
        border-radius:10px;
        font-size:16px;
        font-weight: bold;
        /* background-color: rgb(178, 133, 215); */
        background-color: #49539E;
        color: #fff;
        cursor: pointer;
    }
</style>

<body>
    <div class="login_wrap">
        <div class="container">
            <div class="login_header">
            <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>

            <div class="login_body">
                <div class="loginBox">
                    <h2>로그인</h2>
                    <br>
                    <form action="/user/login" method="post">
                        <div class="form_wrap">
                            <input type="email" name="Email" placeholder="example@gmail.com">
                        </div>
                        <br>
                        <div class="form_wrap">
                            <input type="password" name="Pw" placeholder="yourPassword">
                        </div>
                        <div class="form_wrap" id="rememberMeDiv">
                            <input type="checkbox" name="rememberMe" id="rememberMe">
                            
                            <label for="rememberMe">로그인 상태 유지</label>
                        </div>
                        <div class="form_wrap">
                            <button type="submit" value="login" id="loginBtn">로그인</button>
                        </div>
                    </form>
                    <br>
                    <div class="form_wrap" id="findAndJoin">
                        <span class="forgot">
                            <a href="/member/find_email">아이디 찾기</a>
                          </span>
                          <span class="forgot">
                            <a href="/member/find_password">비밀번호 찾기</a>
                          </span>
                          <span>
                            <a href="/member/join/email">회원가입</a>
                          </span>
                    </div>
                </div>
            </div>
            <div class="login_footer">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $(".login_header").load("/WEB-INF/views/common/header.jsp");
        });
        $(document).ready(function () {
            $(".login_footer").load("/WEB-INF/views/common/footer.jsp");
        });
    </script>
</body>

</html>