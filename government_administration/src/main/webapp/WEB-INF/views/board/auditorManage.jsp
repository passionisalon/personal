<%@ page language="java" contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    
    <title>국정감사 관리게시판 리스트 페이지(부서책임자)</title>
    
</head>
<link href="../../../resources/css/auditorManage.css" rel="stylesheet" type="text/css">
<style>
    #content{
        text-decoration : underline;
    }
    #contents{
        text-decoration : underline;
        font-weight: bolder;
    }
</style>
<body>
    
    <div class="container">  <!-- start Container -->
        
        <div class="wrap">  <!-- start warp -->

            <div class="wrap_1">    <!-- start warp_1 -->
                <h1>국정감사 관리게시판</h1>
            </div>
            <div class="wrap_1_block">

            </div>   <!-- end warp_1 -->

            <div class="wrap_2">     <!-- start warp_2 -->
                <div class="wrap_2_1">  <!-- start warp_2_1 -->
                    부서 :
                </div>              <!-- end warp_2_1 -->
                <div class="wrap_2_2">
                	<input type="text" id="depart" name="depart" 
                	value="<%
                			if(session.getAttribute("SESS_DEPART_CD")!=null){
                				if (session.getAttribute("SESS_DEPART_CD").equals("[운영부서/A001]")) {
                					out.print("운영부서");
                				}else if(session.getAttribute("SESS_DEPART_CD").equals("[지원부서/B001]")){
                					out.print("지원부서");
                				}else if(session.getAttribute("SESS_DEPART_CD").equals("[인사부서/C001]")){
                					out.print("인사부서");
                				}
                			}else{
                				out.print("안됨");
                			}
                			%>"
                	readonly="readonly">
<!--                     <select name="" id="" value=""> -->
<!--                         <option value="[요청중/0]">[인사부서/C001]</option> -->
<!--                         <option value="[처리완료/2]">[요청중/0]</option> -->
<!--                         <option value="[담당자지정/1]">[담당자지정/1]</option> -->
                        
<!--                     </select> -->
                </div>
                
                <div class="wrap_2_block"></div>
                <div class="wrap_2_5">
                    <input id="searchBtn" type="button" value="조회">
                </div>
                <div class="wrap_2_5_6_block">
                    
                </div>
                <div class="wrap_2_6">
                    <input id="mainPageBtn" type="button" value="메인페이지">
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
                                <th scope="col" id="content">내용</th>
                                <th scope="col">상태</th>
                            </tr>
                        </thead>
                        <tbody id="result">
                        	<c:forEach var="list" items="${__LIST__}">
                        	
	                            <tr>
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

	<script>
	function abc(seq){
		var temp = seq;
		console.log(temp);
         window.location.href="/board/auditorManageDetailPage?seq="+temp;
	}
	
	$(document).ready(function(){
		$('#searchBtn').on("click",function(){
			console.log("searchBtn");
			$('#result').empty();
			var department = $('#depart').val();
			console.log(department);
			var temp;
			if(department == "지원부서"){
				temp = "[지원부서/B001]";
			}else if(department == "운영부서"){
				temp = "[운영부서/A001]";
			}else{
				temp = "[인사부서/C001]";
			}
			console.log("temp : ",temp);
			var row;
			$.ajax({
				url:'/board/auditorManage',
				type:'post',
				data:{
					department : temp
				},
				dataType : 'json',
				success:function(data){
					console.log("!!!ajax성공!!!");
					console.log("data : ",data);
					console.log("data.temp : ",data.temp);
					var pp = data.temp;
					
					console.log(pp);
					
					$.each(data, function(index, item){
						
						console.log("pwdpqpwpwdp");
						console.log("asdasd",item);
						$.each(item, function(index, item2){
							console.log("item2 : ",item2);
							console.log("item2.seq : ",item2.seq);
							var ee = item2.seq;
							console.log("asdfsdfdsfsf : ",ee);
		                    row = '<tr>' +
		                        '<th><a href="/board/auditorManageDetailPage?seq=' +ee+'">' + item2.seq + '</a></th>' +
		                        '<th><a href="/board/auditorManageDetailPage?seq=' +ee+'">' + item2.email + '</a></th>' +
		                        '<th><a href="/board/auditorManageDetailPage?seq=' + item2.seq+'">' + item2.title + '</a></th>' +
		                        '<th><a href="/board/auditorManageDetailPage?seq=' + item2.seq+'">' + item2.content + '</a></th>' +
		                        '<th><a href="/board/auditorManageDetailPage?seq=' + item2.seq+'">' + item2.status + '</a></th>' +
		                        '</tr>';
		                    $('#result').append(row);
		        			console.log(row);  
						});	// inner each
						
					});	// outter each
					
					
				},error:function(xhr,status,error){
					console.log(xhr);
					console.log(status);
					console.log(error);
				}
			});	//end ajax
			
		});	// end searchBtn
		$('#mainPageBtn').on("click",function(){

			self.location.href="/board/mainPage";
		});	// end mainPageBtn
	});	// end jq
	
	</script>




    </div> <!-- end Container -->
      
</body>
</html>