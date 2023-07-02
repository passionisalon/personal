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
    
    <title>국정감사 게시판 회원가입 페이지(부서 책임자)</title>
</head>
<link href="../../../resources/css/join.css" rel="stylesheet" type="text/css">
<style>


</style>
<body>
    <div class="container">
        <h1>회원가입페이지</h1>
        <div class="wrap">
            <div class="wrap1">
                아이디 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="UserEmail" name="UserEmail" placeholder="abc1@naver.com" required>
            </div>
            
        </div>
        <div class="wrap_2">
            <div class="sp"># 비밀번호는 8자리 이상이어야 합니다.</div>
        </div>
        
        <div class="wrap">
            
            <div class="wrap1">
                비밀번호 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="UserPassword" name="UserPassword" placeholder="비밀번호를 입력해주세요" required>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                비밀번호확인 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="CheckUserPassword" name="CheckUserPassword" placeholder="비밀번호를 입력해주세요" required>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                이름 : 
                <div id="block_email"></div>
            </div>
            <div>
                <input type="text" id="UserName" name="UserName" placeholder="부서책임자" required>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                성별 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="Gender" id="Gender">
                    <option id="pickGender" value="남">남</option>
                    <option id="pickGender" value="여">여</option>
                </select>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                권한 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="UserAuth" id="UserAuth" disabled="disabled">
                    <option value="[자료요청자/01]">[자료요청자/01]</option>
                    <option value="[부서책임자/02]">[부서책임자/02]</option>
                    <option value="[부서담당자/03]">[부서담당자/03]</option>
                </select>
            </div>
        </div>
        <div class="wrap">
            <div class="wrap1">
                부서 : 
                <div id="block_email"></div>
            </div>
            <div class="wrap1">
                <select name="UserDepart" id="UserDepart"  disabled="disabled">
                    <option value="[운영부서/A001]">[운영부서/A001]</option>
                    <option value="[지원부서/B001]">[지원부서/B001]</option>
                    <option value="[인사부서/C001]">[인사부서/C001]</option>
                </select>
            </div>
        </div>

        <div class="wrap">
            <input id="joinBtn" type="button" value="등록">
            <input id="cancleBtn" type="button" value="취소">
        </div>

        
    </div>
<script>
	$(document).ready(function(){
        const emailMatching= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        const passwordMatching =  /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;

        var userEmail;
		var userPassword;
		var checkuserPassword;
		var userName;
		var gender = $('#Gender').val();
        var userAuth = $('#UserAuth').val();
        var userDepart = $('#UserDepart').val();

       	var distinctCheck = false;
        var ArrayLogic = [4];
		
        // 이메일 유효성 검사
        $('#UserEmail').on("blur",function(){
        	userEmail = $('#UserEmail').val();
            var emailValueCheck = emailMatching.test(userEmail);
            if(emailValueCheck == true){
                console.log("이메일 유효성검사 OK");
                ArrayLogic[0] = true;
                console.log("ArrayLogic[0] : ",ArrayLogic[0]);
                

    		    // 이메일이 중복되었는지 확인
    		    $.ajax({
                    url:'/user/checkDistinctEmail',
                    type:'get',
                    data:{
                        userEmail : $('#UserEmail').val()
                    },
                    dataType:'json',
                    success :  function(data){
                        console.log("ajax성공!!!");
                        console.log("ajax데이터값 : ",data);
                        if(data){
                            distinctCheck = true;
                            return true;
                        }else{
                           	distinctCheck = false;
                            return false;
                        }
                    },
                    error:function(xhr,status,error){
                        console.log(xhr);
                        console.log(status);
                        console.log(error);
                    }
                });   // end ajax
                
            }else{
                alert("이메일 형식에 맞지 않습니다.");
                ArrayLogic[0] = false;
                console.log("ArrayLogic[0] : ",ArrayLogic[0]);
                return false;
            }
        }); // end UserEmail change

        // 비밀번호 유효성 검사
        $('#UserPassword').on("blur",function(){
        	userPassword = $('#UserPassword').val();
            var userPassword2 = passwordMatching.test( userPassword);
            if(userPassword2 == true){
                console.log("비밀번호 유효성검사 OK");
                ArrayLogic[1] = true;
                console.log("ArrayLogic[1] : ",ArrayLogic[1]);
            }else{
                alert("비밀번호가 형식에 맞지 않습니다.");
                ArrayLogic[1] = false;
                console.log("ArrayLogic[1] : ",ArrayLogic[1]);
                return false;
            }
        }); // end UserEmail change

        // 비밀번호와 비밀번호확인 검사
        $('#CheckUserPassword').on("blur",function(){
    		userPassword = $('#UserPassword').val();
    		checkuserPassword = $('#CheckUserPassword').val();
            if(userPassword == checkuserPassword){
                console.log("비밀번호가 일치합니다.");
                ArrayLogic[2] = true;
                console.log("ArrayLogic[2] : ",ArrayLogic[2]);
            }else{
                console.log("비밀번호가 일치하지 않습니다.");
                ArrayLogic[2] = false;
                console.log("ArrayLogic[2] : ",ArrayLogic[2]);
                return false;
            }
        });     // end CheckUserPassword;

        $('#UserName').on("blur",function(){
           // 이름 입력 또는 null 인경우
           userName = $('#UserName').val();
            if(userName){
                console.log("이름이 입력되었습니다.");
                ArrayLogic[3] = true;
                console.log("ArrayLogic[3] : ",ArrayLogic[3]);
                console.log("ArrayLogic : ",ArrayLogic);
            }else{
                console.log("이름이 비어져있습니다.");
                ArrayLogic[3] = false;
                console.log("ArrayLogic[3] : ",ArrayLogic[3]);
                return false
            }
        
        }); // end UserName;

        $('#Gender').on("blur",function(){
        	gender = $('#Gender').val();
            if($('#Gender')!=null){
                console.log($('#Gender'));
                ArrayLogic[4] = true;
            }else{
                console.log($('#Gender'));
                ArrayLogic[4] =false;
            }

            if(ArrayLogic[0]==true & ArrayLogic[1]==true &ArrayLogic[2]==true & ArrayLogic[3]==true ){
                $('#UserAuth').removeAttr("disabled");
                $('#UserDepart').removeAttr("disabled");
            }else{
                ArrayLogic[3]=false;
                console.log("위의 항목들을 통과하지 못했습니다.");
            }
        }) ;    // end Gender

        

        $('#joinBtn').on("click",function(){
        	if(distinctCheck){
        		
        	}else{
        		alert("중복된 아이디입니다.");
        		$('#UserEmail').focus();
        		return false;
        	}
			console.log("클릭성공");
		    // 위 유효성검사를 통과했지만 다시 한 번 유효성 검사를 실행한다.
		    var passArray = [];
		    // 이메일 형식이 맞는지 확인
		    if(emailMatching.test($('#UserEmail').val())){
                passArray[0]=true;
                console.log("passArray[0] : ",passArray[0]);
                
            }else{
                passArray[0]=false;
                console.log("passArray[0] : ",passArray[0]);
                $('#UserEmail').focus();
                return false;
            }

		    // 비밀번호 유효성검사 확인
		    if(passwordMatching.test($('#UserPassword').val())){
                console.log("비밀번호 유효성검사 확인");
                passArray[1] = true;
                console.log("passArray[1] : ",passArray[1]);
            }else{
                passArrayp[1] = false;
                console.log("passArray[1] : ",passArray[1]);
                $('#UserPassword').focus();
                alert("비밀번호 유효성검사를 통과하지 못했습니다.");
            }
		    // 비밀번호와 비밀번호 확인 맞는지 확인
		    if($('#UserPassword').val()==$('#CheckUserPassword').val()){
                console.log("비밀번호와 비밀번호 맞는지 확안");
                passArray[2] = true;
                console.log("passArray[3] : ",passArray[2]);
            }else{
                passArray[2] = false;
                console.log("passArray[3] : ",passArray[2]);
                $('#CheckUserPassword').focuse();
                alert("비밀번호가 맞지 않습니다.");
            }
		    // 이름이 비어져있는지 확인
		    if($('#UserName')){
                console.log('이름이 입력되었는지 확인');
                passArray[3] = true;
                console.log("passArray[4] : ",passArray[3]);
            }else{
                passArray[3] = false;
                console.log("passArray[4] : ",passArray[3]);
                $('#UserName').focus();
                alert("이름을 입력하세요");
            }
// 		    // 성별제대로 첵크했는지 확인
// 			if(distinctCheck==true){
// 				console.log("이메일 중복검사 통과!");
// 			}else{
// 				$('#UserEmail').focus();
//                 alert("이메일이 중복됩니다.");
//                 return false
// 			}

            if(passArray[0]&passArray[1]&passArray[2]&passArray[3]){
                console.log("전부 패스!!!");
                alert("통과");
                
                $.ajax({
                	url:'/user/join',
                	type:'post',
                	data:{
                		email: $('#UserEmail').val() , 
                		password : $('#UserPassword').val(), 
                		name :$('#UserName').val() ,
                		gender : $('#pickGender').val() ,
                		userauth : $('#UserAuth').val() ,
                		depart : $('#UserDepart').val() 
                	},
                	dataType:'json',
                	success:function(data){
                		console.log("!!!ajax성공!!!");
                		console.log("data : ",data);
                		self.location.href="/user/login";
                	},error:function(xhr,status,error){
                		console.log(xhr);
                		console.log(status);
                		console.log(error);
                	}	// end error
               	
                });	// end ajax
                
                
            }else{
                console.log("불통!!!");
                alert("불통");
            }

		});	// end joinBtn

        $('#cancleBtn').on("click",function(){
            self.location.href="/user/login";
        }); // end cancleBtn;

	});	// end jquery

</script>
</body>
</html>