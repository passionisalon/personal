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
    #ll{
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
    .heart .fa-heart.on , #heart #fa-heart.on{
     color:hsl(90%, 100%, 60%);   
	
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
    .pageNum,writeBtn{
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
                            <option value="ll">전체</option>
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
                            <li id="ll" value="ll">전체</li>
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
                            <li class="listwrap" id="listwrap">
                                <div class="contentSeq" id="contentSeq">
                                    <a onclick="abc(${TravelDTO.seq})">${TravelDTO.seq}</a>
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <img src="https://picsum.photos/id/122/200" alt="샘플이미지" onclick="abc(${TravelDTO.seq})">
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <a onclick="abc(${TravelDTO.seq})">${TravelDTO.title}</a>
                                </div>
                                <div class="divwrap" id="divwrap">
                                    <a onclick="abc(${TravelDTO.seq})">
										<fmt:formatDate value="${TravelDTO.start_date}" pattern="yyyy년 MM월 dd일"/>
										~
										<fmt:formatDate value="${TravelDTO.end_date}" pattern="yyyy년 MM월 dd일"/>
                                    </a>
                                </div>
                                <div class="heart contentSeq" id="heart contentSeq">
                                    <i class="fas fa-heart off" id="fas${TravelDTO.seq}"  data-travel-seq="${TravelDTO.seq}">

                                    </i>
                                    
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
                    <button class="write_btn"><a class="writeBtn">글쓰기</a></button>
                </div>
            </div>

            <div class="TravelListFooter">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
    
   		var JavascriptSearchListFunction;
   		var CallDef;
   		
	    $(document).ready(function () {
	    	<c:forEach var="TravelDTO" items="${__TravelLIST__}">
// 	    		console.log(${TravelDTO.seq});
	    		var board_seq = ${TravelDTO.seq};
        	$.ajax({
				url:'/travel/likeList',
				type:'post',
				dataType:'json',
				data : {
					Email : '${USER_EMAIL}',
					board_seq : board_seq,
					board : 'tbl_travel'
				},
				success: function(ReturnData){
					
					console.log("ajax성공!!!@@@");
					console.log("ReturnData : ",ReturnData);
					console.log("Return번호 : ",ReturnData.board_seq);
					console.log("일치 확인 : ",ReturnData.board_seq == board_seq);
					var temp = "fas"+ReturnData.board_seq;
					console.log(temp);
					$("#"+temp).attr('class','fas fa-heart on');
					console.log("확인 : ",$("#fas+ReturnData.board_seq"));
					console.log("재확인 : ",$(temp));
// 					console.log("성공");
					

	
				},error:function(xhr,status,error){
					console.log(xhr);
					console.log(status);
					console.log(error);
				}
			});	// end ajax
			</c:forEach>
	    	
	    	
	    	
	    	// 글쓰기 버튼
	    	$('.writeBtn').on("click",function(){
	    		self.location = "/travel/write";
	    	})
	    	
	        // pagenation
			$('.pageNum').on("click",function(e){
				let selectedPageNum = e.currentTarget.textContent;
				console.log(selectedPageNum);
				self.location = "/travel/list?currPage="+selectedPageNum;
			}); // end .pageNum click
	     	
			// tap 영역
	     	$('#ll').on('click',function(){
	     		
	     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
	     		$('#ll').css("color","white").css("backgroundColor","#49539E");
	     		
// 	     		console.log("asdjfklasjdflkasdjflasdfj");
	     		console.log($('#ll').attr("value"));
	     		var searchType = 'll';
	     		var keyword = "";
	     		var JspCurrPage = 1;
	     		ajaxFunc(JspCurrPage , searchType, keyword);
	     	});
			
	     	$('#performance').on('click',function(){
	     		
	     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
	     		$('#performance').css("color","white").css("backgroundColor","#49539E");
	     		
	     		console.log($('#performance').attr("value"));
	     		var searchType = 'performance';
	     		var keyword = "";
	     		var JspCurrPage = 1;
	     		ajaxFunc(JspCurrPage , searchType, keyword);
	     	});
	     	
	     	$('#outActivity').on('click',function(){
	     		
	     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
	     		$('#outActivity').css("color","white").css("backgroundColor","#49539E");
	     		
	     		console.log($('#outActivity').attr("value"));
	     		var searchType = 'outActivity';
	     		var keyword = "";
	     		var JspCurrPage = 1;
	     		ajaxFunc(JspCurrPage , searchType, keyword);
	     	});
	     	
	     	$('#popupStore').on('click',function(){
	     		
	     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
	     		$('#popupStore').css("color","white").css("backgroundColor","#49539E");
	     		
	     		console.log($('#popupStore').attr("value"));
	     		var searchType = 'popupStore';
	     		var keyword = "";
	     		var JspCurrPage = 1;
	     		ajaxFunc(JspCurrPage , searchType, keyword);
	     	});
	     	
	     	$('#exhibition').on('click',function(){
	     		
	     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
	     		$('#exhibition').css("color","white").css("backgroundColor","#49539E");
	     		
	     		console.log($('#exhibition').attr("value"));
	     		var searchType = 'exhibition';
	     		var keyword = "";
	     		var JspCurrPage = 1;
	     		ajaxFunc(JspCurrPage , searchType, keyword);
	     	});
			
	     	// searchType과 keyword영역
	     	$(".searchButton").on("click",function(){
	     		var JspCurrPage = 1;
	     		var searchType = $('#SearchSelector').val();
// 	     		console.log("searchType : ",searchType);
	     		var keyword =  $(".searchPlace").val();
// 	     		console.log("keyword : ",keyword);
// 	     		console.log("잘 작동됨");
	     		
	     		if(searchType == ''){
	     			$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
		     		$('#all').css("color","white").css("backgroundColor","#49539E");
	     		
	     		}else{
		     		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
		     		$('#'+searchType).css("color","white").css("backgroundColor","#49539E");
	     		}

	     		ajaxFunc(JspCurrPage , searchType , keyword);
	     	});	// end searchButton;
	     	
	     	
	     	// keyword, searchType, tap을 눌렀을 경우 사용되는 function
	     	function ajaxFunc(JspCurrPage, searchType , keyword){
	     		
// 				console.log("JspCurrPage : ",JspCurrPage);
// 				console.log("searchType : ",searchType);
				var JavaScriptSearchType = searchType.id;
// 				console.log("JavaScriptSearchType : ",JavaScriptSearchType);
// 				console.log("keyword : ",keyword);
	     		
	     		$.ajax({
	     			url:'/travel/SearchList',
	     			type:'post',
	     			data:{
	     				currPages : JspCurrPage,
	     				searchType : searchType,
	     				keyword : keyword
	     			},
	     			dataType:'json',
	     			success : function(data){
	     				$('.list').empty();
// 	     				console.log("ajax성공!!!");
// 	     				console.log("list : ",data.list);
// 	     				console.log("resultPageAmount : ",data.resultPageAmount);
	     				data.list.forEach(function(result){
	     					console.log(result);
	     				})
	     				
	     				var row;
	     				data.list.forEach(function(result){
	     					const startDateFormatted = new Date(result.start_date);
	     				    const endDateFormatted = new Date(result.end_date);
	     				    const startyearmonthday = startDateFormatted.getFullYear() + "년 "+ (("00"+endDateFormatted.getMonth().toString()).slice(-2))+"월 "+(("00"+endDateFormatted.getDay().toString()).slice(-2))+"일 ";
	     				    const endyearmonthday   = endDateFormatted.getFullYear() + "년 "+ (("00"+endDateFormatted.getMonth().toString()).slice(-2)) +"월 "+(("00"+endDateFormatted.getDay().toString()).slice(-2))+"일 "
	     				    row = 
	     						'<ul class="listUl">' +
							        '<li class="listwrap" >' +
							        	'<div class="contentSeq">' +
							        		'<a onclick="abc(' + result.seq + ')">' + result.seq + '</a>' +
							        	'</div>' +
							        	'<div class="divwrap">' +
							        		'<img src="https://picsum.photos/id/122/200" alt="샘플이미지" onclick="abc(' + result.seq + ')">' +
							        	'</div>' +
							        	'<div class="divwrap">' +
							        		'<a onclick="abc(' + result.seq + ')">' + result.title + '</a>' +
							        	'</div>' +
							        	'<div class="divwrap">' +
							        		'<a onclick="abc(' + result.seq + ')">' + startyearmonthday + ' ~ ' + endyearmonthday + '</a>' +
							        	'</div>' +
							        	'<div class="heart contentSeq">' +
							        		'<i class="fas fa-heart off" id="fas fa-heart off" data-travel-seq="'+result.seq+'" ></i>' +
							        	'</div>' +
							        '</li>' +
								'</ul>';
     						$('.list').append(row);
	     				});//반복문
	     				
	     				console.log("데이터의 길이 : ",data.list.length);
	     				pppppp;
	     				// 페이지네이션 function 호출 
	     				pagenationFunc(JspCurrPage, data.resultPageAmount,searchType , keyword); 
	     				
	     			},// end success
	     			error:function(xhr,status,error){
	     				console.log(xhr);
	     				console.log(status);
	     				console.log(error);
	     				
	     			}	//end error
	     		});	// end ajax
	     	}	// ajaxFunc
	     	
	     // 수정된 부분: JavascriptSearchListFunction에 ajaxFunc 함수를 할당
	        JavascriptSearchListFunction = ajaxFunc;
	     	
	     	// 페이지네이션 function
	     	function pagenationFunc(JspCurrPage,PageAmount,searchType , keyword){
// 	     		console.log("JspCurrPage : ",JspCurrPage);
// 	     		console.log("PageAmount : ",PageAmount);
// 	     		console.log("searchType : ",searchType);
// 	     		console.log("keyword : ",keyword);
 				$('.pagenation').empty();
 				
 				// criteria
 				var currPage = JspCurrPage;
 				var amount = 10;
 				var pagesPerPage = 10;
 				var totalAmount = PageAmount;
				var realEndPage;
				var prev;
				var next;
 				
// 				console.log("currPage : ",currPage);
// 				console.log("amount : ",amount);
// 				console.log("pagesPerPage : ",pagesPerPage);
// 				console.log("totalAmount : ",totalAmount);
// 				console.log("realEndPage : ",realEndPage);
// 				console.log("prev : ",prev);
// 				console.log("next : ",next);
				
				
				// 메소드의 시작
 				endPage = Math.ceil(currPage * 1.0 / pagesPerPage) * pagesPerPage;
 				startPage = endPage - (pagesPerPage - 1);
 				realEndPage = Math.ceil( (totalAmount * 1.0) / amount );
 				if(realEndPage < endPage){
 					endPage = realEndPage;
 				}
 				
 				prev = startPage > 1;
 				next = endPage < realEndPage;
 				
 				
// 				console.log("currPage : ",currPage);
// 				console.log("amount : ",amount);
// 				console.log("pagesPerPage : ",pagesPerPage);
// 				console.log("totalAmount : ",totalAmount);
// 				console.log("realEndPage : ",realEndPage);
// 				console.log("prev : ",prev);
// 				console.log("next : ",next);
 				
 				var usePrev;
 				var Before = "Before"
 				if(prev){
 					usePrev = '<a>'+Before+'</a>';
 					$('.pagenation').append(usePrev);
 				}
 				console.log("prev : ",prev);
 				
				for(let i = 1 ; i < realEndPage+1 ; i++ ){
// 					console.log(i);
					let temp = '<li class="pageNum" id="pageNum'+i+'" onclick="def('+ "pageNum"+i+","+searchType+","+keyword+')">'+i+'</li>';
					$('.pagenation').append(temp);
				}
 				
 				var useNext;
 				var After = "After"
 				if(next){
 					useNext = '<a>'+After+'</a>'; 
 					$('.pagenation').append(useNext);
 				}
				
				console.log("next : ",next);

	     	};	// end pagenationFuc

	     	 // 클릭 이벤트 핸들러 등록
	        $(document).on('click', '.fas.fa-heart.off', likeSystem);
	        $(document).on('click', '.fas.fa-heart.on', likeSystem);
	        // likeSystem 함수 정의
	        function likeSystem() {
	            const TravelSeq = $(this).data('travel-seq');
	            var switchWord='';
// 	            console.log("heartSystem TravelSeq : ", TravelSeq);
	            console.log($(this).attr('id'));
// 	            console.log($(this).attr('class'));

// 	            if($(this).attr('class')=='fas fa-heart off'){
// 	            	console.log("맞다");
// 	            }else{
// 	            	console.log("ㄴㄴ");
// 	            }
	            
	           	if($(this).attr('class')=='fas fa-heart off'){
// 		            $(this).attr('id',"fas fa-heart on");
		            $(this).attr('class',"fas fa-heart on");
// 		            console.log("id : ",$(this).attr('id'));
// 		            console.log("class : ",$(this).attr('class'));
		            switchWord="like";
	           	}else{
// 		            $(this).attr('id',"fas fa-heart off");
		            $(this).attr('class',"fas fa-heart off");
// 		            console.log("id : ",$(this).attr('id'));
// 		            console.log("class : ",$(this).attr('class'));
		            switchWord="unlike";
	           	}
	            
	            $.ajax({
	            	url:"/travel/like",
	            	type:"post",
	            	data:{
	            		switchWord : switchWord,
	            		userEmail : "${USER_EMAIL}",
	            		board_seq : TravelSeq,
	            		board_name : "tbl_travel"
	            	},
	            	dataType:'json',
	            	success:function(data){
	            		console.log("ajax성공!!! : ",data);
	            	},error:function(xhr,status,error){
	            		console.log(xhr);
	            		console.log(status);
	            		console.log(error);
	            	}
	            });	// end ajax
	        };	// end likeSystem
	     	    	
	     });	// end jq
    	
    	
    	function abc(seq){
    		console.log(seq);
    		self.location = "/travel/view?seq="+seq;
    	};	//	end abc
    	
    	function def(pageNum,searchType,keyword){
    		if(keyword == undefined){
    			keyword = "";
    		}
//     		console.log("keyword : ",keyword);

 			var pageNumText = $(pageNum).text(); // 수정된 부분
    		
//     		console.log("searchType : ",searchType);
//     		console.log("searchType : ",searchType.toString());
    		const searchTypetoString = searchType.toString();
//     		console.log("searchType비교 : ",searchTypetoString);
    		
    		// searchType이 Object Performance로 된다, 때문에,
    		// 아래의 과정을 반드시 거쳐야 ajax통신으로 정확하게 performance로 데이터가 갈 수 있다. 
    		var searchTypeString = Object.prototype.toString.call(searchType); // 객체 타입 문자열을 가져옴
    	    var searchTypeSubstring = searchTypeString.replace(/^\[object\s(.*)\]$/, "$1").toLowerCase(); // [object Performance] 중 Performance 부분을 추출
//     	    console.log("333searchType : ", searchTypeSubstring);
    		
    	    let test;
    	    if(searchTypeSubstring=='performance'){
    	    	test = 'performance';
    	    	JavascriptSearchListFunction(pageNumText, test, keyword);
    	    }else{
    	    	test = searchType.getAttribute("value");
    	    	JavascriptSearchListFunction(pageNumText, test, keyword);
    	    }

    	}	// end def
    	
    	
    	

        
    </script>
</body>

</html>