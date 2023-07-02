<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    <title>국정감사 게시판 리스트 페이지(부서책임자)</title>
    
</head>
<link href="../../../resources/css/auditor.css" rel="stylesheet" type="text/css">
<body>
    
    <div class="container">  <!-- start Container -->
        
        <div class="wrap">  <!-- start warp -->

            <div class="wrap_1">    <!-- start warp_1 -->
                <h1>국정감사게시판</h1>
            </div>
            <div class="wrap_1_block">

            </div>   <!-- end warp_1 -->

            <div class="wrap_2">     <!-- start warp_2 -->
                <div class="wrap_2_1">  <!-- start warp_2_1 -->
                    상태 :
                </div>              <!-- end warp_2_1 -->
                <div class="wrap_2_2">
                    <select name="" id="selectStatus" value="">
                        <option value="요청중">[요청중/0]</option>
                        <option value="담당자지정">[담당자지정/1]</option>
                        <option value="처리완료">[처리완료/2]</option>
                        <option value="보류">[보류/3]</option>
                    </select>
                </div>
                <div class="wrap_2_3">
                    제목 : 
                </div>
                <div class="wrap_2_4">
                    <input id="searchKeyword" type="text" placeholder="입력">
                </div>
                <div class="wrap_2_block"></div>
                <div class="wrap_2_5">
                    <input id="searchAuditor" type="button" value="조회">
                </div>
                <div class="wrap_2_5_6_block">
                    
                </div>
                <div class="wrap_2_6">
                    <input id="mainPage" type="button" value="메인페이지">
                </div>
            </div>           <!-- end warp_2 -->
            
            <div class="wrap_3">

                <div class="wrap_3_1">
                    <table class="uptable">
                        <thead>
                            <tr align="center">
                                <th scope="col">No.</th>
                                <th scope="col">아이디</th>
                                <th scope="col">재목</th>
                                <th scope="col">내용</th>
                                <th scope="col">상태</th>
                            </tr>
                        </thead>
                        <tbody id="result">
                        	<c:forEach var="list" items="${__LIST__}">
                            <tr >
                                <th onclick="abc(${list.seq})">${list.seq}</th>
                                <th onclick="abc(${list.seq})">${list.email}</th>
                                <th onclick="abc(${list.seq})">${list.title}</th>
                                <th onclick="abc(${list.seq})">${list.content}</th>
                                <th onclick="abc(${list.seq})">${list.status}</th>
                            </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

                <div class="wrap_3_2">
                    
                </div>

                <div class="wrap_3_3">
                    
                </div>

            </div>



        </div>   <!-- end warp -->
        





    </div> <!-- end Container -->
    <script>
    	$(document).ready(function(){
    		$('#mainPage').on("click",function(){
    			self.location.href="/board/mainPage";	
    		});	// end mainPage
    		
    		$('#searchAuditor').on("click",function(){
    			console.log("click");
    			$('#result').empty();
    			var SelectStatus = $('#selectStatus').val();
    			var SearchKeyword = $('#searchKeyword').val();
    			console.log(SelectStatus);
    			console.log(SearchKeyword);
    			
    			$.ajax({
    				
    				url:'/board/auditor',
    				type:'post',
    				data:{
    					status : SelectStatus,
    					keyword : SearchKeyword
    				},
    				dataType:'json',
    				success:function(data){
    					console.log("!!!!ajax성공!!!!");
    					console.log(data);
    					console.log(data[0]);
    					console.log(data[1]);
    					console.log(data.length);
    					for(let i = 0 ; i < data.length ; i++){
    						
    						console.log(data[i].seq);
    						let tempSeq = data[i].seq;
//     						console.log("tempSeq : ",tempSeq);
    						$('#result').append('<tr>');
    		    			$('#result').append('<th><a href=/board/auditorDetailPage?seq='+ data[i].seq+'>'+data[i].seq+'</th>');
    						$('#result').append('<th><a href=/board/auditorDetailPage?seq='+ data[i].seq+'>'+data[i].email+'</th>');
    						$('#result').append('<th><a href=/board/auditorDetailPage?seq='+ data[i].seq+'>'+data[i].title+'</th>');
    						$('#result').append('<th><a href=/board/auditorDetailPage?seq='+ data[i].seq+'>'+data[i].content+'</th>');
    						$('#result').append('<th><a href=/board/auditorDetailPage?seq='+ data[i].seq+'>'+data[i].status+'</th>');
    						$('#result').append('</a></tr>');
    					}
//     					console.log("!!!데이터 가져오기 성공!!!");
    				},error:function(xhr,status,error){
    					console.log(xhr);
    					console.log(status);
    					console.log(error);
    				}	// end error
    				
    			});	// end ajax
    		});	// end searchAuditor
    		
    		
    	});	// end jq
    	
    	function abc(seq){
    		var temp = seq;
    		console.log(temp);
             window.location.href="/board/auditorDetailPage?seq="+temp;
    	}
    	

    </script>
</body>
</html>