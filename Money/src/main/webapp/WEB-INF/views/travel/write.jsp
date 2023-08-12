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

          .tabul,
          .tabulS {
            width: 100%;
            height: 100%;

          }

          .tabul>li,
          .tabulS>li {
            /*         border: 1px solid #49539E; */
            width: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            /* 텍스트를 수직으로 정중앙에 위치 */
            font-size: 16px;
            font-weight: bold;
            color: black;
          }

          .tabul>li>input,
          .tabulS>li>input {
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
          @import url('https://fonts.googleapis.com/css?family=Questrial&display=swap');
                  .CalendarWrap {
                  	display:none;
                    background-color: white;
                    height: auto;
                    width: 400px;
                    margin: 0px;
                    padding: 20px;
                    margin: 0 auto;
                    border-radius: 5px;
                    box-shadow: 0px 40px 30px -20px rgba(0, 0, 0, 0.3);
                  }

                  td {
                    width: 50px;
                    height: 50px;
                  }

                  .Calendar {
                    text-align: center;
                  }

                  .Calendar>thead>tr:first-child>td {
                    font-family: 'Questrial', sans-serif;
                    font-size: 1.1em;
                    font-weight: bold;
                  }

                  .Calendar>thead>tr:last-child>td {
                    font-family: 'Questrial', sans-serif;
                    font-weight: 600;
                  }

                  .Calendar>tbody>tr>td>p {
                    font-family: 'Montserrat', sans-serif;
                    height: 45px;
                    width: 45px;
                    border-radius: 45px;
                    transition-duration: .2s;
                    line-height: 45px;
                    margin: 2.5px;
                    display: block;
                    text-align: center;
                  }

                  .pastDay {
                    color: lightgray;
                  }

                  .today {
                    background-color: #F5D042;
                    color: #fff;
                    font-weight: 600;
                    cursor: pointer;
                  }

                  .futureDay {
                    background-color: #FFFFFF;
                    cursor: pointer;
                  }

                  .futureDay:hover {
                    background: #eee;
                  }

                  .futureDay.choiceDay,
                  .today.choiceDay {
                    background: #0A174E;
                    color: #fff;
                    font-weight: 600;
                    cursor: pointer;
                  }
        </style>

        <body>
          <div class="TravelWrap">
            <div class="TravelContainer">
              <div class="TravelHeader">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp" />
              </div>
              <div class="TravelBody">

                <script>

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
                      <li id="startDateValue" value=""></li>
                      <li id="endDate" value="">종료일자</li>
                      <li id="endDateValue" value=""></li>
                    </ul>
                  </div>
                </div><!-- tabContainer -->
                <div class="CalendarWrap">
                  <table class="Calendar">
                    <thead>
                      <tr>
                        <td onClick="prevCalendar();" style="cursor:pointer;">&#60;</td>
                        <td colspan="5">
                          <span id="calYear"></span>년
                          <span id="calMonth"></span>월
                        </td>
                        <td onClick="nextCalendar();" style="cursor:pointer;">&#62;</td>
                      </tr>
                      <tr>
                        <td>일</td>
                        <td>월</td>
                        <td>화</td>
                        <td>수</td>
                        <td>목</td>
                        <td>금</td>
                        <td>토</td>
                      </tr>
                    </thead>

                    <tbody>
                    </tbody>
                    <tfoot>
                    	<tr>
                    		<td id="OkBtn">확인</td><td id="CancleBtn">취소</td>
                    	</tr>
                    </tfoot>
                  </table>
                </div>
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
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp" />
              </div>
            </div>
          </div>

          <script>
          	var calendarOnOff = false;
          	var startDateClick =false;
          	var endDateClick =false;
          	
          	//script
          	
                  window.onload = function () { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행
				
                  
                  
                  let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
                  let today = new Date();     // 페이지를 로드한 날짜를 저장
                  today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화
				  var selectYear = new Date().getFullYear();
                  var selectMonth = nowMonth.getMonth()+1;
                  console.log("selectYear : ", selectYear);
                  console.log("selectMonth : ",selectMonth);
                  
                  var UserChoiceDay;
                  
                  // 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
                  function buildCalendar() {

                    let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
                    let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

                    let tbody_Calendar = document.querySelector(".Calendar > tbody");
                    document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
                    document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

                    while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
                      tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
                    }

                    let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

                    for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
                      let nowColumn = nowRow.insertCell();        // 열 추가
                    }
					var j = 1;
                    for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  
					  j++;
                      let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


                      let newDIV = document.createElement("p");
                      newDIV.setAttribute("id","forClick"+j);
                      newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
                      nowColumn.appendChild(newDIV);

                      if (nowDay.getDay() == 6) {                 // 토요일인 경우
                        nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
                      }

                      if (nowDay < today) {                       // 지난날인 경우
                        newDIV.className = "pastDay";
                      }
                      else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
                        newDIV.className = "today";
                        newDIV.onclick = function () { choiceDate(this); }
                      }
                      else {                                      // 미래인 경우
                        newDIV.className = "futureDay";
                      	
                        newDIV.onclick = function () { choiceDate(this); }
                      }
                    }
                  }

                  // 날짜 선택
                  function choiceDate(newDIV) {
                    if (document.getElementsByClassName("choiceDay")[0]) {                              // 기존에 선택한 날짜가 있으면
                      document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");  // 해당 날짜의 "choiceDay" class 제거
                    }
                    newDIV.classList.add("choiceDay");           // 선택된 날짜에 "choiceDay" class 추가
                    selectYear = document.getElementById("calYear").innerText;
                    selectMonth = document.getElementById("calMonth").innerText;
                    console.log("selectYear : ", selectYear);
                    console.log(typeof selectYear)
                    console.log("selectMonth : ",selectMonth);
                    console.log(typeof selectMonth);
                    console.log("selectYear : ", selectYear);
                    console.log("selectMonth : ", selectMonth);
                    console.log("newDIV : ",newDIV);
                    
                    console.log("choiceDay : ", newDIV.innerText);
                    UserChoiceDay = newDIV.innerText;
                    console.log("UserChoiceDay : ",UserChoiceDay);
                    var choiceDay = newDIV.innerText;
                    console.log(typeof choiceDay);

                  }

                  // 이전달 버튼 클릭
                  function prevCalendar() {
                    nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
                    buildCalendar();    // 달력 다시 생성
                  }
                  // 다음달 버튼 클릭
                  function nextCalendar() {
                    nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
                    buildCalendar();    // 달력 다시 생성
                  }

                  // input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
                  function leftPad(value) {
                    if (value < 10) {
                      value = "0" + value;
                      return value;
                    }
                    return value;
                  }
          	
            // jq
            $(document).ready(function () {
              $(".cancelBtn").on("click", function () {
                location = "/travel/list";
              });	//end cancleBtn;

              $(".submitBtn").on("click", function () {

              });

              $('#performance').on('click', function () {

                $('.tabul').find('li').css("color", "black").css("backgroundColor", "#f5f5f5");
                $('#performance').css("color", "white").css("backgroundColor", "#49539E");

                console.log($('#performance').attr("value"));

              });

              $('#outActivity').on('click', function () {

                $('.tabul').find('li').css("color", "black").css("backgroundColor", "#f5f5f5");
                $('#outActivity').css("color", "white").css("backgroundColor", "#49539E");

                console.log($('#outActivity').attr("value"));

              });

              $('#popupStore').on('click', function () {

                $('.tabul').find('li').css("color", "black").css("backgroundColor", "#f5f5f5");
                $('#popupStore').css("color", "white").css("backgroundColor", "#49539E");

                console.log($('#popupStore').attr("value"));

              });

              $('#exhibition').on('click', function () {

                $('.tabul').find('li').css("color", "black").css("backgroundColor", "#f5f5f5");
                $('#exhibition').css("color", "white").css("backgroundColor", "#49539E");

                console.log($('#exhibition').attr("value"));


              });

              // 달력

              $('#startDate').on("click", function () {
                whoClick = "startDateValue";
                console.log("whoClick : ",whoClick);
                if(calendarOnOff == false){
                	window.onload = function () { buildCalendar(whoClick); };
                	$(".CalendarWrap").css("display","block");
                	calendarOnOff =true;
                	startDateClick=true;
                	console.log("calendarOnOff : ",calendarOnOff);
                	console.log("startDateClick : ",startDateClick);
                }
              })
              $('#endDate').on("click", function () {
            	  whoClick = "endDateValue";
                  console.log("whoClick : ",whoClick);
            	  if(calendarOnOff == false){
                  	$(".CalendarWrap").css("display","block");
                  	calendarOnOff =true;
                  	endDateClick=true;
                  	console.log("calendarOnOff : ",calendarOnOff);
                  	console.log("endDateClick : ",endDateClick);
                  }
              })
              $('#CancleBtn').on("click",function(){
            	  console.log("asdfasdfd : CancleBtn");
            	  
            	  
            	  $(".CalendarWrap").css("display","none");
            	  
                  selectYear = document.getElementById("calYear").innerText;
                  selectMonth = document.getElementById("calMonth").innerText;
                  console.log("selectYear : ", selectYear);
                  console.log(typeof selectYear)
                  console.log("selectMonth : ",selectMonth);
                  console.log(typeof selectMonth);
                  console.log("selectYear : ", selectYear);
                  console.log("selectMonth : ", selectMonth);
                  console.log("choiceDay : ", UserChoiceDay);
                  
                  calendarOnOff = false;
            	  startDateClick=false;
            	  endDateClick=false;
              })
              
			$('#OkBtn').on("click",function(){
            	  console.log("asdfasdfd : OkBtn");
            	  
            	  
            	  $(".CalendarWrap").css("display","none");
            	  
                  selectYear = document.getElementById("calYear").innerText;
                  selectMonth = document.getElementById("calMonth").innerText;
                  console.log("selectYear : ", selectYear);
                  console.log(typeof selectYear)
                  console.log("selectMonth : ",selectMonth);
                  console.log(typeof selectMonth);
                  console.log("selectYear : ", selectYear);
                  console.log("selectMonth : ", selectMonth);
                  console.log("choiceDay : ", UserChoiceDay);
                  
                  if(startDateClick == true){
                	  $('#startDateValue').append(selectYear+"년 "+selectMonth+"월 "+UserChoiceDay+"일");
                  }else if(endDateClick == true){
                	  $('#endDateValue').append(selectYear+"년 "+selectMonth+"월 "+UserChoiceDay+"일");
                  }
                  
                  
                  calendarOnOff = false;
            	  startDateClick=false;
            	  endDateClick=false;
              })

            }); // end jq

    //script

          </script>
        </body>

        </html>