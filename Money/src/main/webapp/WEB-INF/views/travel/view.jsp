<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View</title>
    <script src="https://kit.fontawesome.com/9776c2cb70.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>

   

</head>
<style>
    .view_Wrap{
        width:1200px;
        height:2000px;
        margin: 0 auto;
    }
    .view_Container{
        width:1200px;
        height:2000px;
        margin: 0 auto;
    }
    .TravelView_Body{
        width:1200px;
        min-height: 1900px;
        border: 1px solid red;
    }
    .categoryTitleAddress{
        width:1200px;
        height:100px;
        text-align: center;
        border: 1px solid blue;
    }
    .etcInfo{
        width:1200px;
        height:80px;
        border:1px solid green;
    }
    .spanBold{
        font-size: large;
        font-weight: bold;
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
    .TravelInformationWrap{
        display:flex;
        justify-content: center;
        height: 300px;
    }
    .TravelInformation{
        width:1000px;
        border:1px solid green;
        height:300px;
    }
    .mapAPI{
    	width:1000px;
    	height:700px;
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
    .forCursor{
    	cursor: pointer;
    }
</style>
<body>
    
    <div class="view_Wrap">
        <div class="view_Container">
            <div class="TravelView_Header">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>
            <div class="TravelView_Body">
                <div class="categoryTitleAddress">
                    <h2>카테고리</h2>
                    <br>
                    <h1>타이틀</h1>
                    <br>
                    <h3>주소</h3>
                </div>
                <div class="etcInfo">
                    <a href="#"><i class="fa-regular fa-heart" style="color: #E76649"></i></a>
                    <a href="#"><i class="fa-solid fa-share-nodes" style="color: #49539e;"></i></a>
                    <i class="fas fa-eye"> ${__BOARD__.total}</i>
                    <br>
                    <br>
                    <div class="infoDate">
                        <span class="spanBold">등록일 : 1992년1월24일</span>
                    </div>
                    <div class="infoDate">
                        <span class="spanBold">수정일 : 1992년 1월 26일</span>
                    </div>
                </div>
                <hr>
                <div class="swiper">

                    <!-- Additional required wrapper -->
                    <div class="swiper-wrapper">
                        <!-- Slides -->
                        <div class="swiper-slide"><img src="/resources/img/IMG_1000.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
                        <div class="swiper-slide"><img src="/resources/img/IMG_1001.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
                        <div class="swiper-slide"><img src="/resources/img/IMG_1002.JPG" onclick="window.open(this.src)" style="height: 100%; width: 100%;" ></div>
                    </div>
                    <!-- If we need pagination -->
                    <div class="swiper-pagination"></div>
            
                    <!-- If we need navigation buttons -->
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
            
                </div>

                <span class="spanBold">상세설명</span>
                <hr>
                <div class="TravelInformationWrap">
                    <div class="TravelInformation">
                        <span class="spanBold">설명 : </span>
                        <br>
                        <span class="spanBold">글 끌고오기</span>
                        <br>
                        <hr>
                        <span class="spanBold">기간 : </span>
                        <span class="spanBold">기간</span>
                        <br>
                        <hr>
                        <span class="spanBold">위치 : </span>
                        <span class="spanBold">위치</span>
                    </div>
                </div>
                
                <div class="mapWrap">
                    <span class="spanBold">지도</span>
                    <hr>
                    <div class="mapAPI">
                        지도 API 끌고오기
                    </div>
                </div>

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
            
                

            </div>
            <div class="TravelView_Footer">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function () {
            $(".TravelView_Header").load("/WEB-INF/views/common/header.html");
            $(".TravelView_Footer").load("/WEB-INF/views/common/footer.html");
        });

    </script>
</body>
</html>