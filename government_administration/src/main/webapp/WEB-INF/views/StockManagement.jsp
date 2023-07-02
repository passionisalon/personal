<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>stockManagement</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/main.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/cs/stockManagement.css" type="text/css">


<div id="header"></div>
<%-- <jsp:include page="../layout/header.jsp"/> --%>

<body>
    <div class="container">
        <div class="container_wrap">
            <h2>전체리스트</h2>
            &nbsp;
            <br>

<%--             <form id="searchForm" name="searchForm" method="get" action="${pageContext.request.contextPath}/board/StockManagement"> <!-- start form --> --%>
<!--             </form> end form -->
				<form method="post" action="${pageContext.request.contextPath}/board/StockManagement" accept-charset="UTF-8">
				<input type="hidden" name="categoryDTO" value="CategoryValue" />
                <div class="Line1"> <!-- start Line1 -->
                    <div class="wrap_Line1">카테고리</div>
                    <div class="wrap_Line1_Sub">
                        <select style="width:200px; height:50px;" name="selectCategoryfirst" id="selectCategoryfirst" class="selectCategoryfirst">
                            <option name="" value="">전체</option>
                            <option name="" value="의류">의류</option>
                            <option name="" value="침구">침구</option>
                            <option name="" value="가구">가구</option>
                                                                                                                                                                                                                         
                        </select>
                    </div>	<!-- 카테고리 -->

                    <div class="wrap_Line1">1차</div>
                    <div class="wrap_Line1_Sub">
                        <select style="width:200px; height:50px;" name="selectCategorySecond" id="selectCategorySecond" class="selectCategorySecond">
<!--                             <option value="">전체</option> -->
<!--                             <option value="남성">남성</option> -->
<!--                             <option value="여성">여성</option> -->
<!--                             <option value="티셔츠">티셔츠</option> -->
<!--                             <option value="바지">바지</option> -->
                        </select>
                    </div>	<!-- 1차 -->

                    <div class="wrap_Line1">2차</div>
                    <div class="wrap_Line1_Sub">
                        <select style="width:200px; height:50px;" name="selectCategoryThird" id="selectCategoryThird" class="selectCategoryThird">
<!--                             <option value="">전체</option> -->
<!--                             <option value="티셔츠">티셔츠</option> -->
<!--                             <option value="바지">바지</option> -->
<!--                             <option value="슈트">슈트</option> -->
                        </select>
                    </div>	<!-- 2차 -->
			
				</form>
                    <div class="wrap_Line1">
                        <input class="Search" id="Search" style="width:100px; height:50px;" type="submit" value="조회" >

                    </div>
                </div> <!-- end Line1 -->
                
          
            

            &nbsp;
            <br>

            <div class="Line2"> <!-- start Line2 -->
                <table class="uptable">
                    <thead>
                        <tr align="center">
                            <th scope="col">상품코드</th>
                            <th scope="col">상품명</th>
                            <th scope="col">제조사명</th>
                            <th scope="col">단위명</th>
                            <th scope="col">재고수량</th>
                            <th scope="col">재고여부</th>
                            <th scope="col">사용여부</th>
                        </tr>
                    </thead>
                    <tbody id="basic" class="basic">
                        <c:forEach items="${__LIST__}" var="list" varStatus="status">
                        <input type="hidden" id="pCode" value=${list.productcode}>
	                        <tr>
	                        
	                            <td id="${list.rownum}"><a href="#" id="productcodes"  >${list.productcode}</a></td>
	                            <td id="${list.rownum}"><a href="#" id="${list.productcode}" onclick="abc(${list.productcode})">${list.productname}</a></td>
	                            <td id="${list.rownum}"><a href="#" id="companys" >${list.company}</a></td>
	                            <td id="${list.rownum}"><a href="#" id="unitnames">${list.unitname}</a></td>
	                            <td id="${list.rownum}"><a href="#" id="amounst" >${list.amount}</a></td>
	                            <td id="${list.rownum}"><input type="checkbox" name="" value="" disabled></td>
	                            <td id="${list.rownum}"><input type="checkbox" name="" value="" disabled></td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> <!-- end Line2 -->

            &nbsp;
            <br>

            <div class="Line3"> <!-- start Line3 -->
                <div class="wrap_Line3">
                    <div class="wrap_Line3_sub1">상품코드</div>
                    <div class="wrap_Line3_sub2" id="productcode">
                   		<input type="text" id="inputproductcode" class="wrap_Line3_sub2" name="Updateproductcode" value=""  style='text-align:center'>
                    
                    </div>
                </div>
                <div class="wrap_Line3">
                    <div class="wrap_Line3_sub1">상품명</div>
                    <div class="wrap_Line3_sub2" id="productname">
                    	<input type="text" id="inputproductname" class="wrap_Line3_sub2" name="Updateproductname" value=""  style='text-align:center'>
                    
                    </div>
                </div>
                <div class="wrap_Line3">
                    <div class="wrap_Line3_sub1">제조사명</div>
                    <div class="wrap_Line3_sub2" id="company">
                    	<input type="text" id="inputcompany" class="wrap_Line3_sub2" name="Updatecompany" value="" style='text-align:center'>
                    </div>
                </div>
                <div class="wrap_Line3">
                    <div class="wrap_Line3_sub1">단위명</div>
                    <div class="wrap_Line3_sub2" id="unitname">
                    	<input type="text" id="inputunitname" class="wrap_Line3_sub2" name="Updateunitname" value="" style='text-align:center'>
                    </div>
                </div>
                <div class="wrap_Line3">
                    <div class="wrap_Line3_sub1" >입고수량</div>
                    <div class="wrap_Line3_sub2" id="amount">
                    	<input type="text" id="inputamount" class="wrap_Line3_sub2" name="Updateamount" value=""  style='text-align:center'>
                    </div>
                </div>
            </div> <!-- end Line3 -->

            &nbsp;
            <br>

            <div class="Line4"> <!-- start Line4 -->
                <form action="" method="get">
                    <div class="wrap_Line4">
                        <div class="wrap_Line4_sub3"></div>
                        <div class="wrap_Line4_sub1"><input id="modify" type="button" value="수정"></div>
                        <div class="wrap_Line4_sub3"></div>
                        <div class="wrap_Line4_sub2"><input id="cancle" type="button" value="취소"></div>
                        <div class="wrap_Line4_sub3"></div>
                    </div>
                    <div><br><br><br><br><br></div>
                </form>
            </div> <!-- end Line4 -->
            
<%--         <jsp:include page="../layout/footer.jsp"/> --%>
        </div>
        
    </div> <!-- end container -->
<script type="text/javascript">
    $(document).ready(function () {
        $('#header').load("../layout/header.html");
        $('#footer').load("../layout/footer.html");
        
     // 페이지 로드 시 초기 선택 값을 기반으로 두 번째 카테고리와 세 번째 카테고리 선택 요소를 업데이트합니다.
        updateSecondCategory();
        updateThirdCategory();

        // selectCategoryfirst 값이 변경되면 두 번째 카테고리를 업데이트합니다.
        $('#selectCategoryfirst').on('change', function() {
            updateSecondCategory();
        });

        // selectCategorySecond 값이 변경되면 세 번째 카테고리를 업데이트합니다.
        $('#selectCategorySecond').on('change', function() {
            updateThirdCategory();
        });
        
		$('#cancle').on('click',function(){
			self.location.href='/user/login';
		});	// cancle
		
		$('#modify').on('click',function(){
			console.log("기서씨!");
			var ProductCode = $('#inputproductcode').val();
			var ProductName = $('#inputproductname').val();
			var Company = $('#inputcompany').val();
			var UnitName = $('#inputunitname').val();
			var Amount = $('#inputamount').val();
			console.log("sss:",ProductCode);
			console.log("sss:",ProductName);
			console.log("sss:",Company);
			console.log("sss:",UnitName);
			console.log("sss:",Amount);
			
			$.ajax({
				url:'/board/productUpdate',
				type:'post',
				data: {
					productcode : ProductCode,
					productname : ProductName,
					company : Company,
					unitname : UnitName,
					amount : Amount
				},
				dataType:'json',
				success:function(data){
// 					$('#inputproductcode').empty();
// 					$('#inputproductname').empty();
// 					$('#inputcompany').empty();
// 					$('#inputunitname').empty();
// 					$('#inputamount').empty();
					
					console.log(data.productcode);
					console.log(data.productname);
					console.log(data.company);
					console.log(data.unitname);
					console.log(data.amount);
					$('#inputproductcode').attr("value",data.productcode);
					$('#inputproductname').attr("value",data.productname);
					$('#inputcompany').attr("value",data.company);
					$('#inputunitname').attr("value",data.unitname);
					$('#inputamount').attr("value",data.amount);
				},	// end success
				error:function(xhr,status,error){
					console.log(error);
					console.log(xhr);
					console.log(status);
				}	// end error
			});	// end ajax
			console.log("수정성공");
		});	// modify
        
        
//         $('#productcodes').on('click',function(){
//         	var productCode = $('#pCode').val(); // 삼품 코드 가져오기
//         	console.log("pcode : " + productCode);
        	
//         	$.ajax({
//         		url:'/board/productClick',
//         		type:'get',
//         		data: {
//         			productcode: productCode
//         		},
//         		dataType:'json',
//         		success:function(data){
        			
//         			$('#inputproductcode').empty();
//         			$('#inputproductname').empty();
//         			$('#inputcompany').empty();
//         			$('#inputunitname').empty();
//         			$('#inputamount').empty();
        			
//         			console.log(data.productcode);
//         			$('#inputproductcode').attr("value",data.productcode);
//         			$('#inputproductname').attr("value",data.productname);
//         			$('#inputcompany').attr("value",data.company);
//         			$('#inputunitname').attr("value",data.unitname);
//         			$('#inputamount').attr("value",data.amount);
//         		},	// end success
//         		eeror:function(xhr,status,error){
//         			console.log(error);
//         			console.log(xhr);
//         			console.log(status);
//         		}
//         	});	// ajax
//         });//productcode
        
        
    });	// end jq
    
    function abc(productCode) {
    	var temp = productCode.id;
  	  	console.log(temp);
  	$.ajax({
		url:'/board/productClick',
		type:'get',
		data: {
			productcode: temp
		},
		dataType:'json',
		success:function(data){
			
			$('#inputproductcode').empty();
			$('#inputproductname').empty();
			$('#inputcompany').empty();
			$('#inputunitname').empty();
			$('#inputamount').empty();
			
			console.log(data.productcode);
			$('#inputproductcode').attr("value",data.productcode);
			$('#inputproductname').attr("value",data.productname);
			$('#inputcompany').attr("value",data.company);
			$('#inputunitname').attr("value",data.unitname);
			$('#inputamount').attr("value",data.amount);
		},	// end success
		error:function(xhr,status,error){
			console.log(error);
			console.log(xhr);
			console.log(status);
		}
	});	// ajax
  	}
    

    function updateSecondCategory() {
        var firstCategory = $('#selectCategoryfirst').val();
        var secondCategorySelect = $('#selectCategorySecond');

        // 두 번째 카테고리 선택 요소 초기화
        secondCategorySelect.empty();

        // 두 번째 카테고리 선택 요소 업데이트
        if (firstCategory === '의류') {
        	secondCategorySelect.append('<option value="">전체</option>');
        	secondCategorySelect.append('<option value="남성">남성</option>');
        	secondCategorySelect.append('<option value="여성">여성</option>');
        	secondCategorySelect.append('<option value="티셔츠">티셔츠</option>');
        	secondCategorySelect.append('<option value="바지">바지</option>');
        } else if (firstCategory === '침구') {
        	secondCategorySelect.append('<option value="">전체</option>');
        	secondCategorySelect.append('<option value="베개">베개</option>');
        	secondCategorySelect.append('<option value="이불">이불</option>');
        	secondCategorySelect.append('<option value="침대">침대</option>');
        } else if (firstCategory === '가구') {
        	secondCategorySelect.append('<option value="">전체</option>');
        	secondCategorySelect.append('<option value="옷장">옷장</option>');
        	secondCategorySelect.append('<option value="책상">책상</option>');
        } else {
            var secondCategories = [];
        }

        // 세 번째 카테고리 선택 요소 업데이트
        updateThirdCategory();
    }

    function updateThirdCategory() {
        var secondCategory = $('#selectCategorySecond').val();
        var thirdCategorySelect = $('#selectCategoryThird');

        // 세 번째 카테고리 선택 요소 초기화
        thirdCategorySelect.empty();

        // 세 번째 카테고리 선택 요소 업데이트
        if (secondCategory === '남성') {
            
        	thirdCategorySelect.append('<option value="">전체</option>');
        	thirdCategorySelect.append('<option value="바지">바지</option>');
        	thirdCategorySelect.append('<option value="슈트">슈트</option>');
        	thirdCategorySelect.append('<option value="티셔츠">티셔츠</option>');
//             var thirdCategories = ['전체','바지', '슈트', '티셔츠'];
        } else if (secondCategory === '여성') {
        	thirdCategorySelect.append('<option value="">전체</option>');
        	thirdCategorySelect.append('<option value="양말">양말</option>');
            thirdCategorySelect.append('<option value="치마">치마</option>');
            thirdCategorySelect.append('<option value="티셔츠">티셔츠</option>');
            thirdCategorySelect.append('<option value="팬츠">팬츠</option>');
//             var thirdCategories = ['전체','양말', '치마', '티셔츠', '팬츠'];
        } else if (secondCategory === '옷장') {
        	thirdCategorySelect.append('<option value="">전체</option>');
        	thirdCategorySelect.append('<option value="벽걸이옷장">벽걸이옷장</option>');
        	thirdCategorySelect.append('<option value="작은옷장">작은옷장</option>');
        	thirdCategorySelect.append('<option value="큰옷장">큰옷장</option>');
//             var thirdCategories = ['전체','벽걸이옷장', '작은옷장', '큰옷장'];
        } else if (secondCategory === '책상') {
        	thirdCategories.append('<option value="">전체</option>');
            thirdCategories.append('<option value="벽걸이옷장">벽걸이옷장</option>');
            thirdCategories.append('<option value="작은옷장">작은옷장</option>');
//             var thirdCategories = ['전체','사무실용책상', '학생용책상'];
        } else if (secondCategory === '침대') {
//             var thirdCategories = ['전체','더블침대', '싱글침대', '킹침대'];
        	thirdCategories.append('<option value="">전체</option>');
            thirdCategories.append('<option value="더블침대">더블침대</option>');
            thirdCategories.append('<option value="싱글침대">싱글침대</option>');
            thirdCategories.append('<option value="킹침대">킹침대</option>');
        } else {
            var thirdCategories = [];
        }

        // 세 번째 카테고리 선택 요소에 옵션 추가
        thirdCategories.forEach(function(category) {
            var option = $('<option></option>').attr('value', category).text(category);
            thirdCategorySelect.append(option);
        });
    }
    
</script>


</body>

<div id="footer">
	
</div>


<script>
	$(document).ready(function(){
		
		
		

	});	// end jq
</script>

</html>