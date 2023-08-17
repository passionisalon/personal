
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <!-- layout css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/older/css/layout/myPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/older/css/layout/layout.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

    <script src="https://kit.fontawesome.com/7ae3a6a91c.js" crossorigin="anonymous"></script>

	<script>
        //   console.log("<%= session.getAttribute("__AUTH__") %>");
    </script>
</head>
<style>
    @charset "utf-8";

.mypage_wrap{
    width: 1200px;
    margin: 0 auto;
    margin-top: 50px;
}
.mypage_wrap{
    width: 1200px;
    height: auto;
    margin: 0 auto;
    margin-top: 50px;
    padding-bottom: 30px;
    overflow: hidden;
}
.clear::after{
    content:'';
    display:block;
    clear:both;
}

.mypage_wrap .susb_tit{
    margin-bottom: 50px;
}

.mypage_wrap .myCont{
    float: left;
}

.left_menu{}
.left_menu .user_box{
    border: 2px solid #f5f5f5;
    margin: 0 auto;
    padding: 40px;
    text-align: center;
    box-shadow: 5px 5px 5px 5px #ededed;
}
.left_menu .user_box img{
    display: block;
    width: 100px;
    height: 100px;
}
.left_menu .user_box .user_id{
    display: inline-block;
    padding-top: 5px;
}

.left_menu ul.side_menu{
    display: block;
    width: 184px;
    margin-top: 40px;
}
.left_menu ul.side_menu li{
    padding: 15px 20px;
    background-color: #f7f8ff;
    border: 1px solid #49539E;
    border-bottom: 0;
    cursor: pointer;
}
.left_menu ul.side_menu li:last-of-type{
    border: 1px solid #49539E;
}
.left_menu ul.side_menu li a{
    display: block;
    text-align: center;
    color: #49539E;
}

.left_menu ul.side_menu li:hover{
    background-color: #49539E;
    transition: 0.3s ease-out;
}
.left_menu ul.side_menu li:hover a{
    color: #fff;
}

/* right_menu */
.right_menu{
    margin-left: 156px;
}

.right_menu .my_box{
    width: 860px;
}

.right_menu .my_box .more_btn{
    display: inline-block;
    float: right;
}
.right_menu .my_box .more_btn:hover{
    text-decoration: underline;
}

.right_menu .my_box .fa-chevron-right{
    padding-left: 5px;
}
.right_menu .my_box .my_cont_box{
    margin-bottom: 30px;
}
.right_menu .my_box .my_cont_box:last-of-type{
    margin-bottom: 0;
}
.right_menu .my_box .my_cont_box h2{
    display: inline-block;
    padding: 0 0 15px 10px;
}

.right_menu .my_box .my_cont_box .container{
	overflow:hidden;
    /* height: 150px; */
    height:auto;
    padding: 20px 30px;
	background: #f7f8ff;
    border: 1px solid #ededed;
}
/*  */

.right_menu .my_box .like_cont .list_thumType {
    display: flex;
    flex-wrap: wrap; /* Display images in a flex container and wrap them */
    gap: 20px; /* Add some gap between images */
}

/*  */
.right_menu .my_box .like_cont .list_thumType li.thum{
    float: left;
    /* position: relative; */
    padding: 15px 0 9px;
    margin-right: 24px;
}
.right_menu .my_box .like_cont .list_thumType li.thum:last-of-type{
    margin-right: 0;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo{
    position: relative;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo a img{
    width: 140px;
    height: 94px;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo .flag{
    position: absolute;
    top: 0;
    left: 0;
    font-size: 12px;
    padding: 0 5px;
    box-sizing: border-box;
    min-width: 48px;
    height: 28px;
    line-height: 28px;
    color: #fff;
    text-align: center;
    line-height: 28px;
    letter-spacing: -0.35px;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo .type_ing{
    background-color: #ff3333;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo .fa-heart.on{
    position: absolute;
    right: 5px;
    top: 5px;
    color: #ff3333;
    font-size: 20px;
}
.right_menu .my_box .like_cont .list_thumType li.thum .photo .type_before{
    background-color: #13294b;
}

.right_menu .my_box .like_cont .list_thumType li.thum .area_txt .tit{
    font-weight: 600;
    margin-top: 10px;
}

/* 내 리뷰 */
.right_menu .my_box .my_cont_box .my_review::after{
    content:'';
    display:block;
    clear:both;
}
.right_menu .my_box .my_cont_box .my_review{
    /* float: left; */
    /* display: block; */
    height: auto;
    background-color: #fff;
    margin-bottom: 5px;
}
.right_menu .my_box .my_cont_box .my_review img{
    float: left;
    width: 150px;
    height: 100px;
}
.right_menu .my_box .my_cont_box .my_review .desc_wrap{
    width: 620px;
    display: inline-block;
    padding-left: 20px;
    padding-top: 10px;
    word-break: break-all;
    word-wrap: break-word;
}
.right_menu .my_box .my_cont_box .my_review .desc_wrap h4{
    padding-bottom: 10px;
}
.right_menu .my_box .my_cont_box .my_review .desc_wrap .desc{
    /* display: inline-block;
    line-height: 1.3; */
}

/* */
#pagination {
	display: flex;
	margin: 0 auto;
	height: 50px;
	text-align: center !important;
}
#pagination ul {
    float: right;
    list-style: none;
    text-align: center;

    font-size: 18px;
    font-weight: bold;
    
 }
 #pagination ul >li {
    float: left;

    width: 40px;
    height: 30px;
    /* vertical-align: middle; */
  	/* border: 1px solid black; */

    line-height: 30px;
    cursor: pointer;
}
.Prev, .Next {
    width: 70px !important;

    color: white;
    background-color: royalblue;
}
.current {
    border: 3px outset gold;
}
#pagination ul::after {
    content: '';
    display: block;
    clear: both;
}
</style>
<body>
<!-- <%-- header --%> -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>



<div class="mypage_wrap">

    <h1 class="susb_tit">마이페이지</h1>


    <!-- 프로필/사이드메뉴 -->
    <div class="myCont left_menu clear">
        <!-- 프로필 -->
        <p class="user_box">
            <img src="/resources/img/user.png" alt="프로필">
            <span class="user_id">"${USER_NICKNAME}"</span>
        </p>
        <!-- 사이드메뉴 -->
        <ul class="side_menu">
            <li><a href="#">회원정보 수정</a></li>
            <li><a href="/member/change_password" id="change_password">비밀번호 변경</a></li>
<!--             <li><a href="#">팔로워/팔로잉</a></li> -->
            <li><a href="/board/cs/view">고객센터</a></li>
            <li><a href="/member/remove">회원탈퇴</a></li>
        </ul>
    </div>

    <!-- 찜목록/내리뷰/내코스 -->
    <!-- 찜목록/내리뷰/내코스 -->
    <div class="myCont right_menu">
        <div class="my_box my_like">
            <!-- 찜목록 -->
            <div class="my_cont_box like_cont">
                <h2>찜목록</h2>
                <p class="more_btn">
<!--                 	<a href="/board/review/list" id="likeList1">더보기</a> -->
<!--                 	<i class="fas fa-chevron-right"></i> -->
                </p>
                <div class="container">
                    <ul class="list_thumType flnon">
                        <c:forEach var="Like" items="${__LIKELIST__}">
                            <li class="thum thum_2">
                                <div class="photo">
                                	<a href="/${Like.board}/view?seq=${Like.seq}">
	                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                    </a>
                                </div>
                                <div class="area_txt">
                                    <div class="tit">
                                        <a href="/${Like.board}/view?seq=${Like.seq}">${Like.title}</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </div>



            <!--              내 리뷰 -->
            <div class="my_cont_box">
                <h2>내 리뷰</h2>
                <p class="more_btn"><a href="/board/review/list" id="likeList2">더보기</a><i
                        class="fas fa-chevron-right"></i></p>

                <c:forEach var="BoardVO" items="${__REVIEW__}">
                    <div class="container my_review">
                        <a href="/board/review/view?seq=${ BoardVO.seq }"><img
                                src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=1ec32eb6-aac2-4c5a-9e56-9ac1c817afd6"
                                alt="마포 나만의 여행"></a>
                        <div class="desc_wrap">
                            <h4>

                                <a href="/board/review/view?seq=${ BoardVO.seq }">${ BoardVO.title
                                        }</a>
                            </h4>
                            <p class="desc_wrap">

                                <a href="/board/review/view?seq=${ BoardVO.seq }">${ BoardVO.content
                                        }</a>
                            </p>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <!-- 내 코스 -->
<!--             <div class="my_cont_box my_course"> -->
<!--                 <h2>내 코스</h2> -->
<!--                 <p class="more_btn"><a href="/board/course/list" id="courseBoard">더보기</a><i -->
<!--                         class="fas fa-chevron-right"></i></p> -->
<!--                 <div class="container"> -->

<!--                     <ul> -->
<%--                         <c:forEach var="course" items="${__COURSE__}"> --%>


<%--                             <a id="MyCourse" href="/board/course/get?seq=${course.seq}"> --%>
<%--                                 <li>${course.TITLE}</li> --%>
<!--                             </a> -->

<%--                         </c:forEach> --%>


<!--                     </ul> -->



<!--                 </div> -->
<!--             </div> -->
            <div class="my_box my_like">
            <!-- 내 코스 -->
            <div class="my_cont_box like_cont">
                <h2>내 코스</h2>
                <p class="more_btn"><a href="/board/course/list" id="likeList1">더보기</a><i
                        class="fas fa-chevron-right"></i></p>
                <div class="container">
                    <ul class="list_thumType flnon">

                        <c:forEach var="course" items="${__COURSE__}">
                            <li class="thum thum_2">
                                <div class="photo"><a href="/board/course/get?seq=${course.seq}">

                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04"
                                         alt="석촌호수 벚꽃축제"></a>
                                    <!--                                                             <em class="flag type_before">진행전</em></a> -->
                                    <!--                                                         <i class="fas fa-heart on"></i> -->
                                </div>
                                <div class="area_txt">
                                    <div class="tit">
                                        <a
                                                href="/board/review/view?seq=${course.seq}">${course.TITLE}</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                        
                    </ul>
                </div>

            </div>

        </div>
    </div>

</div>

<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>


</body>


<script>
    $(function(){
        $('#change_password').click(function(){
            location.href="/member/change_password";
        }); // function change_password;
        $('#likeList1').click(function(){
        	location.href="/board/review/list";
        })	// likeList1
        $('#likeList2').click(function(){
        	location.href="/board/review/list";
        })	// likeList2
        $('#courseBoard').click(function(){
        	location.href="/board/course/list";
        })	// courseBoard
        
        //--------------- page ------------------//
        $('.pageNum').on('click',function(e){
            let selectedPageNum = e.currentTarget.textContent;
            console.log(e.currentTarget.textContent);
            location.href="/mypage/mypage?currPage="+selectedPageNum;
        })  //pageNum
    });    // jq
</script>
</html>


