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
        min-height: 1000px;
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
    .listwrap , #listwrap{
        display: flex;
        width:99%;
        height: 100px;
		border: 1px #49539E solid;
        align-items: center;
        justify-content: center;
		cursor: pointer;
    }
    .listwrap > div, #listwrap > div{
        width: 10%;
        height: 100px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .listwrap > .divwrap , #listwrap > #divwrap{
        width:30%;
/*         border:1px solid red; */
    }
    .contentSeq , #cotentSeq{
        width:20px;
/*         border: 1px violet solid; */
    }
    .listwrap >div >img , #listwrap > div > img{
        width:auto;
        height:100px;
    }
    .heart .fa-heart.off , #heart #fa-heart.off{
     color:#e6e6e6;   
    }
    .heart .fa-heart.on #heart #fa-heart.on{
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
    .pageNum{
    	cursor: pointer;
        font-weight:bolder;
        font-size: larger;
    }
    #forCursor{

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
                            <option value="">전체</option>
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
                            <li id="all" value="">전체</li>
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
                        <ul class="listUl" id="listUl">
                            <li class="listwrap" id="listwrap" onclick="abc(${TravelDTO.seq})">
                                <div class="contentSeq" id="contentSeq">
                                    <a>${TravelDTO.seq}</a>
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <img src="https://picsum.photos/id/122/200" alt="샘플이미지">
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <a>${TravelDTO.title}</a>
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <a>
										<fmt:formatDate value="${TravelDTO.start_date}" pattern="yyyy년 MM월 dd일"/>
										~
										<fmt:formatDate value="${TravelDTO.end_date}" pattern="yyyy년 MM월 dd일"/>
                                    </a>
                                </div>
                                <div class="heart contentSeq" id="heart contentSeq">
                                    <i class="fas fa-heart off" id="fas fa-heart off"></i>
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
                    	<c:if test="${pageMaker.prev}">
                        	<a href="/travel/list?currPage=${pageMaker.startPage - 1}">Before</a>
                        </c:if>
                    </li>
                    
                    <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                        <li class="pageNum ${ pageMaker.cri.currPage == pageNum ? 'current':'' }">${pageNum}</li>
                    </c:forEach>
                    
                    <li class="Next">
                    	<c:if test="${pageMaker.next}">
                        <a href="/travel/list?currPage=${pageMaker.endPage + 1}">After</a>
                        </c:if>
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
	        // pagenation
			$('.pageNum').on("click",function(e){
				let selectedPageNum = e.currentTarget.textContent;
				console.log(selectedPageNum);
				self.location = "/travel/list?currPage="+selectedPageNum;
			}); // end .pageNum click
	     	
			// tap 영역
	     	$('#all').on('click',function(){
	     		console.log($('#all').attr("value"));
	     		var searchType = '';
	     		var temp = "";
	     		ajaxFunc(searchType, temp);
	     	});
			
	     	$('#performance').on('click',function(){
	     		console.log($('#performance').attr("value"));
	     		var searchType = 'performance';
	     		var temp = "";
	     		ajaxFunc(searchType, temp);
	     	});
	     	
	     	$('#outActivity').on('click',function(){
	     		console.log($('#outActivity').attr("value"));
	     		var searchType = 'outActivity';
	     		var temp = "";
	     		ajaxFunc(searchType, temp);
	     	});
	     	
	     	$('#popupStore').on('click',function(){
	     		console.log($('#popupStore').attr("value"));
	     		var searchType = 'popupStore';
	     		var temp = "";
	     		ajaxFunc(searchType, temp);
	     	});
	     	
	     	$('#exhibition').on('click',function(){
	     		console.log($('#exhibition').attr("value"));
	     		var searchType = 'exhibition';
	     		var temp = "";
	     		ajaxFunc(searchType, temp);
	     	});
			
	     	// searchType과 keyword영역
	     	$(".searchButton").on("click",function(){
	     		var searchType = $('#SearchSelector').val();
	     		console.log("searchType : ",searchType);
	     		var keyword =  $(".searchPlace").val();
	     		console.log("keyword : ",keyword);
	     		console.log("잘 작동됨");
	     		ajaxFunc(searchType,keyword);
	     	})
	     	
	     	function ajaxFunc(searchType , keyword){
	     		console.log(searchType+" , "+keyword);

	     		
	     		$.ajax({
	     			url:'/travel/SearchList',
	     			type:'post',
	     			data:{
	     				
	     				searchType : searchType,
	     				keyword : keyword
	     			},
	     			dataType:'json',
	     			success : function(data){
	     				$('.list').empty();
	     				console.log("ajax성공!!!");
	     				console.log("list : ",data.list);
	     				console.log("resultPageAmount : ",data.resultPageAmount);
	     				data.list.forEach(function(result){
	     					console.log(result);
	     				})
	     				
	     				var row;
	     				data.list.forEach(function(result){
// 	     					const startDateFormatted = formatDate(result.start_date);
// 	     				    const endDateFormatted = formatDate(result.end_date);
	     					row = '<ul class="listUl" id="listUl">'+
	     							'<li class="listwrap" id="listwrap" onclick="abc('+result.seq+')"'+
		     							'<div class="contentSeq" id="contentSeq">'+
		     								'<a>'+result.seq+'</a>'+
		     							'<div>'+
		     							'<div class="divwrap" id="divwrap">'+
		     								'<img src="https://picsum.photos/id/122/200" alt="샘플이미지">'+
		     							'</div>'+
		     							'<div class="divwrap" id="divwrap">'+
	     									'<a >'+result.title+'</a>'+
	     								'</div>'+
	     								'<div class="divwrap" id="divwrap">'+
	     									'<a >' + result.start_date + ' ~ ' + result.end_date + '</a>' +
	     								'</div>'+
	     								'<div class="heart contentSeq" id="heart contentSeq">'+
	     									'<i class="fas fa-heart off" id="fas fa-heart off"></i>'+
	     								'</div>'+
     								'</li>'+
	     						  '</ul>'
     						$('.list').append(row);
	     				});//반복문
	     				
	     			},// end success
	     			error:function(xhr,status,error){
	     				console.log(xhr);
	     				console.log(status);
	     				console.log(error);
	     				
	     			}	//end error
	     		});	// end ajax
	     	}
			
	     });	// end jq
    	
    	function abc(seq){
    		console.log(seq);
    		self.location = "/travel/view?seq="+seq;
    	};
    	
    	
    	
        
    </script>
</body>

</html>