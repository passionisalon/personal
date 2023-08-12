<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://kit.fontawesome.com/9776c2cb70.js" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
</head>
<style>
  @charset "utf-8";
  @import url('/resources/css/layout/reset.css');

  .TravelWrap {
    width: 1200px;
    height: 1300px;
    margin: 0 auto;
    border: 1px solid blue;
  }

  .TravelContainer {
    width: 1200px;
    height: 1300px;
    margin: 0 auto;
    border: 1px solid red;
  }

  .TravelBody {
    width: 1200px;
    min-height: 1200px;
    margin: 0 auto;
    border: 1px solid green;
  }

  .TravelTitle,
  .TravelSmallWrap {
    display: flex;
    justify-content: center;
  }

  /* tab */
  .tabContainer .tab {
    width: 99.7%;
    height: 50px;
    border: 1px solid #49539E;
    background-color: #f5f5f5;

  }

  .tab {
    width: 100%;

  }

  .tabul , .tabulS{
    width: 100%;
    height: 100%;

  }

  .tabul>li , .tabulS>li{
    /*         border: 1px solid #49539E; */
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    /* 텍스트를 수직으로 정중앙에 위치 */
    font-size: 16px;
    font-weight: bold;
    color:black;
  }

  .tabul>li>input , .tabulS>li>input{
    width: 100%;
    height: 95%;
  }

  #AddressBtn,
  #fileUploadBtn {
    width: 100%;
    height: 100%;
  }

  #performance {
    background: #49539E;
    color: white;
  }

  #startDate,
  #endDate,
  #locations,
  #fileUpload {
    background: #49539E;
    color: white;
  }

  .placeWrap {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50px;
  }

  .placeContainer {
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid yellowgreen;
    width: 1200px;
    height: 50px;
  }

  .placeContainer>input {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 99.5%;
    height: 50px;
  }

  .contentWrap,
  .contentContainer,
  .contentContainer>textarea {
    width: 1198px;
    height: 250px;
    resize: none;
  }

  .liInLi {
    background: white;
  }

  .kakaoMiniMap {
    width: 1200px;
    height: 500px;
  }

  .btnWrap {
    width: 1200px;
    height: 50px;
    /* display: flex; */
    /* justify-content: center; */
    border: 1px solid violet;
  }

  .btnContainer {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
  }

  .btnContainer>button {
    width: 49.8%;
    height: 100%;
    background: #49539E;
    color: white;
  }
</style>

<body>
  <div class="TravelWrap">
    <div class="TravelContainer">
      <div class="TravelHeader">
		<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
      </div>
      <div class="TravelBody">
      
      
          <style>
        #modal.modal-overlay {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
/*             background: rgba(255, 255, 255, 0.25); */
/*             box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37); */
/*             backdrop-filter: blur(1.5px); */
/*             -webkit-backdrop-filter: blur(1.5px); */
/*             border-radius: 10px; */
/*             border: 1px solid rgba(255, 255, 255, 0.18); */
        }
        #modal .modal-window {
            background: rgba( 69, 139, 197, 0.70 );
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 400px;
            height: 500px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal .title {
            padding-left: 10px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        #modal .title h2 {
            display: inline;
        }
        #modal .close-area , .ok-area{
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #modal .content {
            margin-top: 20px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        .monthHeader{
          display:flex;

        }
        .monthHeader > ul{
          display:flex;
        }
    </style>
      

    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
                <h2>날짜</h2>
            </div>
            <div class="ok-area" id="okBtn">확인</div>
            <div class="close-area">X</div>
            <div class="content">
                <p>가나다라마바사 아자차카타파하</p>
                <p>가나다라마바사 아자차카타파하</p>
                <p>가나다라마바사 아자차카타파하</p>
                <p>가나다라마바사 아자차카타파하</p>
                <div class="monthHeader" display="flex">
                  <ul>
                    <li>Before</li>
                    <li><br></li>
                    <li>Month</li>
                    <li><br></li>
                    <li>After</li>
                  </ul>
                </div>
                
               <table>
                <tr>
                  <td>일</td>
                  <td>월</td>
                  <td>화</td>
                  <td>수</td>
                  <td>목</td>
                  <td>금</td>
                  <td>토</td>
                </tr>
                <tr><td>c</td><td>d</td></tr>
                <tr><td>e</td><td>f</td></tr>
               </table>
            </div>
        </div>
    </div>
    
    <script>
    
    const modal = document.getElementById("modal")
    function modalOn() {
        modal.style.display = "flex"
    }
    function isModalOn() {
        return modal.style.display === "flex"
    }
    function modalOff() {
        modal.style.display = "none"
    }

    const closeBtn = modal.querySelector(".close-area")
    closeBtn.addEventListener("click", e => {
        modalOff()
    })
    modal.addEventListener("click", e => {
        const evTarget = e.target
        if(evTarget.classList.contains("modal-overlay")) {
            modalOff()
        }
    })
    window.addEventListener("keyup", e => {
        if(isModalOn() && e.key === "Escape") {
            modalOff()
        }
    })
    </script>
    
    
        <br>
        <div class="TravelTitle">
          <h2>여행지 글쓰기</h2>
        </div>
        <br>
        <hr>
        <br>
        <div class="TravelSmallWrap">
          <h4>카테고리</h4>
        </div>
        <br>
        <div class="tabContainer">
          <div class="tab">
            <ul class="tabul">
              <li id="performance" value="performance">공연</li>
              <li id="outActivity" value="outActivity">야외활동</li>
              <li id="popupStore" value="popupStore">팝업스토어</li>
              <li id="exhibition" value="exhibition">전시회</li>
            </ul>
          </div>
        </div><!-- tabContainer -->
        <br>
        <div class="TravelSmallWrap">
          <h4>장소명</h4>
        </div>
        <br>
        <div class="placeWrap">
          <div class="placeContainer">
            <input type="text" placeholder="장소명">
          </div>
        </div>
        <br>
        <div class="TravelSmallWrap">
          <h4>일정</h4>
        </div>
        <br>
        <div class="tabContainer">
          <div class="tab">
            <ul class="tabulS">
              <li id="startDate" value="">시작일자</li>
              <li id="startDateValue" value="">클릭</li>
              <li id="endDate" value="">종료일자</li>
              <li id="endDateValue" value="">클릭</li>
            </ul>
          </div>
        </div><!-- tabContainer -->
        <div class="contentWrap">
          <div class="contentContainer">
            <textarea name="content" id="" placeholder="내용을 입력해주세요"></textarea>
          </div>
        </div>
        <div class="tabContainer">
          <div class="tab">
            <ul class="tabulS">
              <li id="locations" value="">위치</li>
              <li id="locationAddress" value=""><input type="text"></li>
              <li id="AddressPlace" value=""><button id="AddressBtn">주소검색</button></li>
              <li id="fileUpload" value="">첨부파일</li>
              <li id="fileList" value="">aaa</li>
              <li id="fileUploadLi" value=""><button id="fileUploadBtn" type="file">파일선택</button></li>
            </ul>
          </div>
        </div><!-- tabContainer -->
        <div class="kakaoMiniMap">

        </div>
        <!-- 버튼 -->
        <div class="btnWrap">
          <div class="btnContainer">
            <button class="submitBtn">작성하기</button>
            <button class="cancelBtn">취소</button>
          </div>
        </div>
      </div><!-- TravelBody -->

      <div class="TravelFooter">
		<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
      </div>
    </div>
  </div>

  <script>
    // jq
    $(document).ready(function () {
      $(".cancelBtn").on("click",function(){
    	  location="/travel/list";
      });	//end cancleBtn;
      
      $(".submitBtn").on("click",function(){
    	  
      });
      
   	$('#performance').on('click',function(){
 		
 		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
 		$('#performance').css("color","white").css("backgroundColor","#49539E");
 		
 		console.log($('#performance').attr("value"));
 		
 	});

   	$('#outActivity').on('click',function(){
 		
 		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
 		$('#outActivity').css("color","white").css("backgroundColor","#49539E");
 		
 		console.log($('#outActivity').attr("value"));

 	});
 	
 	$('#popupStore').on('click',function(){
 		
 		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
 		$('#popupStore').css("color","white").css("backgroundColor","#49539E");
 		
 		console.log($('#popupStore').attr("value"));

 	});
 	
 	$('#exhibition').on('click',function(){
 		
 		$('.tabul').find('li').css("color","black").css("backgroundColor","#f5f5f5");
 		$('#exhibition').css("color","white").css("backgroundColor","#49539E");
 		
 		console.log($('#exhibition').attr("value"));
 		

 	});

  // 달력

    $('#startDateValue').on("click",function(){
      dateFunction("startDateValue");
    })
    $('#endDateValue').on("click",function(){
      dateFunction("endDateValue");
    })
    function dateFunction(whoClick){
	  var eleId = whoClick;
      modalOn();
	  console.log(eleId);
      console.log("sadadas");
    }
  }); // end jq

    //script

  </script>
</body>

</html>