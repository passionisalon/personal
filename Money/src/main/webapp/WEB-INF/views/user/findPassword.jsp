
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
    <title>SeouLiveFindPassword</title>
</head>
<style>
    .findEmail_wrap{
        margin: 0 auto;
        width:1200px;
        height:900px;
        border:1px solid red;
    }
    .findEmail_container{
        margin: 0 auto;
        width:1000px;
        height:900px;
        border:1px solid blue;
        /* display: inline-block; */
    }
    .findEmail_body{
        margin: 0 auto;
        margin-top: 200px;
        text-align: center;
        width:500px;
        height:400px;
        border:1px solid green;
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
            <div class="FindPassword_header">
	            <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>
            <div class="findEmail_body">
                <div class="individual_wrap" id="email_wrap">
                    <input type="email" id="UserEmail" name="UserEmail" placeholder="이메일 입력">
                    <button id="checkDistinctEamil" class="Btn">전송</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p>전송되었습니다.</p>
                </div>
                <div class="individual_wrap" id="email_wrap">
                    <input type="Number" id="UserEmail" name="UserEmail" placeholder="이메일로 전송된 코드를 적어주십시오.">
                    <button id="checkNumber" class="Btn">확인</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p>이메일인증 실패.</p>
                </div>
                <div class="individual_wrap">
                    <input type="submit" class="Btn" id="join_btn" value="비밀번호찾기" formenctype="multipart/form-data">
                    <input type="submit" class="Btn" id="join_btn" value="취소" formenctype="multipart/form-data">
                </div>
                <br>
            </div>
            <div class="FindPassword_footer">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $(".FindPassword_header").load("/WEB-INF/views/common/header.html");
            $(".FindPassword_footer").load("/WEB-INF/views/common/footer.html");
        });
    </script>
</body>
</html>