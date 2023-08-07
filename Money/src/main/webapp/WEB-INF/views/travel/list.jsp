<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TravelList</title>
    <script src="https://kit.fontawesome.com/9776c2cb70.js" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
</head>
<style>
    @charset "utf-8";

    /* @import url('/resources/css/layout/reset.css'); */
    .TravelListWrap {
        margin: 0 auto;
        width: 1200px;
        height: 100vh;
/*         border: 1px solid blue; */
    }

    .container {
        margin: 0 auto;
        width: 1200px;
        height: 100vh;

    }

    .TravelListBody {
    
        width: 1200px;
        height: 90vh;;
/*         border: 1px solid red; */
    }
	/* search */
    .SearchContainer{
        width: 99%;
        height:50px;
    }
    .SearchWrap {
        width: 99%;
        height: 50px;
        border: 3px solid #49539E;
/*         position: absolute; */
        display: flex;
        border-radius: 10px;
    }

    .SearchSelector {
        width: 10%;
        height: 50px;
        text-align: center;
        outline: none;
        /* border: 3px solid #49539E; */
    }

    .searchButton {
        width: 10%;
        height: 50px;
        text-align: center;
        background: #49539E;
        color: #fff;
        /* border: 3px solid #49539E; */
    }

    .searchPlace {
        width: 80%;
        height: 47px;
        outline: none;
        color: #9DBFAF;
    }
    
    /* tab */
    .tabContainer .tab{
        width:99%;
        height:50px;
        border: 1px solid #49539E;
        background-color: #f5f5f5;
        border-radius: 10px;
    }
    .tab{
        width: 100%;

    }
    .tabul{
        width: 100%;
        height: 100%;
        
    }
    .tabul>li{
/*         border: 1px solid #49539E; */
        width:100%;
        display: flex;
        justify-content: center;
        align-items: center; /* 텍스트를 수직으로 정중앙에 위치 */
        font-size: 16px;
        font-weight: bold;
    }
    #all{
        background: #49539E;
        color: white;
    }
    
    /* list */
    .listwrap{
        display: flex;
        width:99%;
        height: 100px;
		border: 1px #49539E solid;
        align-items: center;
        justify-content: center;
    }
    .listwrap > div{
        width: 10%;
        height: 100px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .listwrap > .divwrap{
        width:30%;
/*         border:1px solid red; */
    }
    .contentSeq{
        width:20px;
/*         border: 1px violet solid; */
    }
    .listwrap >div >img{
        width:auto;
        height:100px;
    }
    .heart .fa-heart.off{
     color:#e6e6e6;   
    }
    .heart .fa-heart.on{
     color:hsl(0, 100%, 60%);   
    }

	/* pagenation */
    .page_wrap{
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0 auto;
        position: relative;
        text-align: center;
        padding: 10px 0;
    }
    .pagenation{
        margin: 0;
        padding: 0;
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    /* button */
    .btn_wrap{
        display: inline-block;
    }
    .write_btn{
        width: 100px;
        padding: 10px 20px;
        color: #fff;
        background-color:#49539E;
        border:0;
    }
    .btn_wrap .write_btn a{
        display: block;
        color: #fff;
    }
    .Prev , .PageNum , .Next{
        margin-left: 5px;
        margin-right: 5px;
    }
    .pagenation > li > a{
    	
        font-weight:bolder;
        font-size: larger;
    }
</style>

<body>
    <div class="TravelListWrap">
        <div class="container">
            <div class="TravelListHeader">
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>
            <div class="TravelListBody">
                <div class="SearchContainer">
                    <div class="SearchWrap">
                        <select name="Selector" class="SearchSelector" id="SearchSelector">
                            <option value="all">전체</option>
                            <option value="performance">공연</option>
                            <option value="outActivity">야외활동</option>
                            <option value="popupStore">팝업스토어</option>
                            <option value="exhibition">전시회</option>
                        </select>
                        <input type="text" class="searchPlace" placeholder="검색내용을 입력하세요" name="keyword">
                        <button type="submit" class="searchButton">
                            <i class="fa fas fa-search"></i>
                        </button>
                    </div> <!-- SearchWrap -->
                </div>
                <br>
                <br>
                <div class="tabContainer">
                    <div class="tab">
                        <ul class="tabul">
                            <li id="all" value="total">전체</li>
                            <li id="performance" value="performance">공연</li>
                            <li id="outActivity" value="outActivity">야외활동</li>
                            <li id="popupStore" value="popupStore">팝업스토어</li>
                            <li id="exhibition" value="exhibition">전시회</li>
                        </ul>
                    </div>
                </div><!-- tabContainer -->
                <br>
                <div class="listContainer">
                    <div class="list">
                    <c:forEach var="TravelDTO" items="${__TravelLIST__}">
                        <ul class="listUl">
                            <li class="listwrap">
                                <div class="contentSeq">
                                    <a href="">${TravelDTO.seq}</a>
                                </div>
                                <div class="divwrap">
                                    <img src="https://picsum.photos/id/122/200" alt="샘플이미지">
                                </div>
                                <div class="divwrap">
                                    <a href="">${TravelDTO.title}</a>
                                </div>
                                <div class="divwrap">
                                    <a href="">
										<fmt:formatDate value="${TravelDTO.start_date}" pattern="yyyy년 MM월 dd일"/>
										~
										<fmt:formatDate value="${TravelDTO.end_date}" pattern="yyyy년 MM월 dd일"/>
                                    </a>
                                </div>
                                <div class="heart contentSeq">
                                    <i class="fas fa-heart off"></i>
                                </div>
                            </li>
                        </ul>
       				</c:forEach>
                    </div>
                </div><!-- listContainer -->
                
                

            </div><!-- TravelListBody -->

            <div class="page_wrap">
                <ul class="pagenation">
                    <li class="Prev">
                        <a href="">Before</a>
                    </li>
                    <li class="PageNum">
                    	<c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <a href="">${pageNum}</a>
                        </c:forEach>
                    </li>
                    <li class="Next">
                        <a href="">After</a>
                    </li>
                </ul>
                <div class="writeBtn_wrap">
                    <button class="write_btn"><a href="">글쓰기</a></button>
                </div>
            </div>

            <div class="TravelListFooter">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $(".TravelListHeader").load("/WEB-INF/views/common/header.html");
        });
        $(document).ready(function () {
            $(".TravelListFooter").load("/WEB-INF/views/common/footer.html");
        });

    </script>
</body>

</html>