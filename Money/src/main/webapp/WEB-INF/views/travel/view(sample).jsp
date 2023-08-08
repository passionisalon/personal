<%--
  Created by IntelliJ IDEA.
  User: sungjaehyun
  Date: 2023/05/10
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>서울, 지금 : SeouLive</title>

    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/e046991a5a.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>
<%--    <script src="../../../../resources/static/js/travel/view.js"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/travel/view.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/layout.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
    <style>
        @charset "UTF-8";

#wrap {
    width: 1200px;
    /*height: 2500px;*/
    display: block;
    margin: 0 auto;
    position: relative;
}
.spanBold {
    font-weight: bold;
}
.exam > ul {
    width: 800px;
    height: 300px;
}
/*h3 {*/
    /* margin: 30px 0px 20px 20px; */
/*}*/
/*hr {*/
/*    background: linear-gradient(50deg, #49539E 0%, #E76649 100%);*/
/*    height: 2px;*/
/*    margin: 30px 0 20px 0;*/
/*}*/
.category {
    height: 50px;
    width: 500px;
    /* border: 1px solid red; */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    /* margin-bottom: 10px; */
    /* padding: 15px; */
}
.name {
    height: 50px;
    width: 500px;
    /* border: 1px solid red; */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    /* margin-bottom: 10px; */
    /* padding: 15px; */
}
.theme {
    height: 20px;
    width: 400px;
    /* border: 1px dotted purple; */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    /* margin-bottom: 10px; */
    /* padding: 15px; */
}
.etc {
    margin: 0 0 20px 0;
}
.reg_Date {
    margin: 10px 0 10px 0;
}
.mod_Date {
    margin: 10px 0 10px 0;
}
/* .pic {
    height: 70%;
    width: 70%;
    border: 1px solid green;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    margin-bottom: 10px;
    padding: 15px;
} */
.exam {
    width: 800px;
    height: 300px;
    /* border: 1px dotted blue; */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    margin-bottom: 10px;
    /* padding: 15px; */
}
#map {
    width: 700px;
    height: 500px;
    /* border: 1px solid orange; */
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0 auto;
    margin-bottom: 10px;
    /* padding: 15px; */
}
.recom {
    /* border: 1px dotted darkgray; */
    display: flex;
    justify-content: center;
    /* align-items: center; */
    margin-bottom: 10px;
    height: 230px;
    /* padding: 15px; */
}
.recom1 {
    width: 360px;
    height: 200px;
    display: table-cell;
    float: left;
    justify-content: center;
    align-items: center;
    /* border: 1px solid darkgoldenrod; */
    margin: 0 10px 0 10px;
}
.recom2 {
    width: 360px;
    height: 200px;
    display: table-cell;
    float: left;
    justify-content: center;
    align-items: center;
    /* border: 1px solid darkgoldenrod; */
    margin: 0 10px 0 10px;
}
.recom3 {
    width: 360px;
    height: 200px;
    display: table-cell;
    float: left;
    justify-content: center;
    align-items: center;
    /* border: 1px solid darkgoldenrod; */
    margin: 0 10px 0 10px;
}
.recom-name {
    display: flex;
    justify-content: center;
    margin: 20px;
}

.swiper {
    width: 70%;
    height: 70%;
}
.swiper-slide {
    text-align: center;
    font-size: 18px;
    background: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
}
.btn {
    display: flex;
    width: 100%;
    justify-content: right;
    align-items: center;
    margin-top: 20px;
    margin-bottom: 20px;
}
.btn_modify {
    margin: 0 5px 0 5px;
}
.btn_delete {
    margin: 0 5px 0 5px;
}
.btn_list {
    margin: 0 5px 0 5px;
}
.btn_modify button {
    background: #000000;
    border-color: #000000;
    color: #ffffff;
    font-size: 14px;
    width: 100px;
    height: 40px;
    padding: 2px 8px 0 8px;
    border: none;
}
.btn_modify button:hover {
    background: #49539E;
    border-color: #49539E;
    padding: 2px 8px 0 8px;
}
.btn_delete button {
    background: #000000;
    border-color: #000000;
    color: #ffffff;
    font-size: 14px;
    width: 100px;
    height: 40px;
    padding: 2px 8px 0 8px;
    border: none;
}
.btn_delete button:hover {
    background: #49539E;
    border-color: #49539E;
    padding: 2px 8px 0 8px;
}
.btn_list button {
    background: #f1f1f1;
    border-color: #f1f1f1;
    color: #000000;
    font-size: 14px;
    width: 100px;
    height: 40px;
    padding: 2px 8px 0 8px;
    border: none;
}
.btn_list button:hover {
    background: #d8d8d8;
    border-color: #d8d8d8;
    padding: 2px 8px 0 8px;
}
/*input {*/
/*    display: flex;*/
/*    align-items: center;*/
/*    justify-content: center;*/
/*    width: 100px;*/
/*    height: 30px;*/
/*    margin: 0 10px 0 10px;*/
/*}*/
        
    </style>

    <script>
        $(function() {
            $('#listBtn').click(function() {

                <%--location.href = "/board/travel/list?currPage=${param.currPage}";--%>
                location.href = "/board/travel/list";

            });

            $('#modBtn').click(function() {

                <%--location.href = "/board/travel/modify?currPage=${param.currPage}&seq=${__BOARD__.seq}";--%>
                location.href = "/board/travel/modify?seq=${__BOARD__.seq}";
            });

            $('#delBtn').click(function () {
                if(confirm("게시글을 삭제하시겠습니까?")) {
                    let formObj = $("<form>");

                    formObj.attr("action", "/board/travel/remove");
                    formObj.attr("method", "post");
                    formObj.append("<input type='hidden' name='seq' value='${param.seq}'>");
                    formObj.appendTo("body").submit();

                    alert("게시글이 삭제되었습니다.");
                }
            });
        });
    </script>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
<%--     <jsp:include page="../../layout/header.jsp"/> --%>
</head>
<body>

<!-- 여행지 view 시작  -->
<div id="wrap">
<%--    <form action="/board/travel/remove" method="post">--%>
<%--        <input type="hidden" name="seq" value="${param.seq}">--%>
    <br>
    <div class="category">
        <h2>${__BOARD__.category}</h2>
    </div>
    <div class="name">
        <h1>${__BOARD__.title}</h1>
    </div>
    <br>
    <div class="theme">
        <span class="spanBold">${__BOARD__.address}</span>
    </div>
    <div class="etc">
        <a href="#"><i class="fa-regular fa-heart" style="color: #E76649"></i></a>
        <a href="#"><i class="fa-solid fa-share-nodes" style="color: #49539e;"></i></a>
        <i class="fas fa-eye"> ${__BOARD__.total}</i>
    </div>
    <div class="reg_Date">
        <span class="spanBold">등록일 : <fmt:formatDate value="${__BOARD__.write_Date}" pattern="yyyy. MM. dd. HH:mm:ss"/></span>
    </div>
    <div class="mod_Date">
        <span class="spanBold">수정일 : <fmt:formatDate value="${__BOARD__.modify_Date}" pattern="yyyy. MM. dd. HH:mm:ss"/></span>
    </div>

    <hr>

    <div class="swiper">

        <!-- Additional required wrapper -->
        <div class="swiper-wrapper">
            <!-- Slides -->
            <div class="swiper-slide"><img src="../../../../resources/static/img/IMG_1000.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
            <div class="swiper-slide"><img src="../../../../resources/static/img/IMG_1001.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
            <div class="swiper-slide"><img src="../../../../resources/static/img/IMG_1002.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
        </div>
        <!-- If we need pagination -->
        <div class="swiper-pagination"></div>

        <!-- If we need navigation buttons -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>

    </div>

    <h3>상세설명</h3>
    <hr>
    <div class="exam">

        <ul>
            <br>
            <hr>
            <br>
            설명 : <li>${__BOARD__.content}</li>
            <br>
            <hr>
            <br>
            <li>
                기간 : <fmt:formatDate value="${__BOARD__.start_date}" pattern="yyyy년 MM월 dd일" /> ${__BOARD__.start_time} ~
                <fmt:formatDate value="${__BOARD__.end_date}" pattern="yyyy년 MM월 dd일" /> ${__BOARD__.end_time}
            </li>
            <br>
            <hr>
            <br>
            <li> 위치 : ${__BOARD__.address}</li>
            <br>
        </ul>

    </div>

    <h3>지도</h3>
    <hr>
    <div id="map">

    </div>

<%--    <h3>추천 여행지</h3>--%>
<%--    <hr>--%>
<%--    <div class="recom">--%>

<%--        <div class="recom1">--%>
<%--            <img src="../../../../resources/static/img/IMG_1004.png" height="100%" width="100%">--%>
<%--            <div class="recom-name"><h3>추천 여행지 #1</h3></div>--%>
<%--        </div>--%>

<%--        <div class="recom2">--%>
<%--            <img src="../../../../resources/static/img/IMG_1005.png" height="100%" width="100%">--%>
<%--            <div class="recom-name"><h3>추천 여행지 #2</h3></div>--%>
<%--        </div>--%>

<%--        <div class="recom3">--%>
<%--            <img src="../../../../resources/static/img/IMG_1006.png" height="100%" width="100%">--%>
<%--            <div class="recom-name"><h3>추천 여행지 #3</h3></div>--%>
<%--        </div>--%>

<%--    </div>--%>
    <br>

    <div class="btn">
        <div class="btn_modify">
            <a href="#" onclick=""><button id="modBtn">수정</button></a>
        </div>
        <div class="btn_delete">
            <a href="#" onclick=""><button id="delBtn">삭제</button></a>
        </div>
        <div class="btn_list">
            <a href="#" onclick=""><button id="listBtn">목록</button></a>
        </div>
    <br>
    </div>
<%--    </form>--%>
</div>

<%-- <jsp:include page="/WEB-INF/views/layout/footer.jsp"/> --%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
<script>
    const swiper = new Swiper(".swiper", {

        direction: "horizontal",
        loop: true,

        pagination: {
            el: ".swiper-pagination",
            type: "bullets",
            clickable: true,
        },

        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },

        spaceBetween: 10,
        slidesPreView: "auto",
        grabCursor: true,
        centerdSlides: true,
        speed: 600,
        effect: "coverflow",
        coverflowEffect: {
            rotate: 0,
            stretch: -100,
            depth: 50,
            modifier: 1,
            slideShadows: false,
        },

    });
    const btnStart = document.querySelector(".btnStart");
    const btnStop = document.querySelector(".btnStop");

</script>
<!-- 여행지 view 끝  -->


<%-- 지도 API 시작 --%>

<!-- services 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1e94da7a1ab1c55879fcde4cfe8d086d&libraries=services"></script>
<script type="text/javascript">
<%-- 	<%@include file="../../../../resources/static/js/map.js"%> --%>
</script>

<%-- 지도 API 끝--%>
</body>

</html>
