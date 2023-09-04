
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://code.jquery.com/jquery-migrate-3.4.1.js"></script>
    <title>SeouLivejoin</title>
</head>
<style>
    .join_wrap{
        margin: 0 auto;
        width:1200px;
        height:1200px;
        /* border: 1px solid red; */
    }
    .join_container{
        margin: 0 auto;
        margin-left: 100px;
        width:1000px;
        height:1200px;
        /* border: 1px solid blue; */
        display:inline-block;
    }
    .join_body{
        margin: 0 auto;
        width:1000px;
        height:1000px;
        text-align: center;
        /* border: 1px solid green; */
    }
    .individual_wrap , select{
        display:flex;
        text-align: center;
        justify-content: center;
        justify-items: center;
        align-items: center;
        margin: 0 auto;
        width:600px;
        height:50px;
        /* border:1px solid yellowgreen; */

    }
    .individual_wrap >input ,select{
        width:100%;
        height:50px;
        border-radius: 10px;
        text-align: center;
        font-size: 16px;

    }
    #email_wrap, #password_wrap{
        display:flex;
    }
    .Btn{
        width:20%;
        height:50px;
        border-radius: 10px;
        color:aliceblue;
        background-color: #49539E;
        text-align: center;
        justify-content: center;
        justify-items: center;
        align-items: center;
        font-size: 16px;
    }
    #join_btn{
        border-radius: 10px;
        color:aliceblue;
        background-color: #49539E;
    }

</style>
<body>
    <div class="join_wrap">
        <div class="join_container">
            <div class="join_header">
            	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>	
            </div>

            <div class="join_body">
				<br>
            	<br>
            	<br>
            	<br>
            	<br>
            	<br>
                <div class="individual_wrap" id="email_wrap">
                    <input type="email" id="UserEmail" name="Email" placeholder="example@gmail.com">
                    <button id="distinckedEmail" class="Btn">중복확인</button>
                </div>
                
                <div class="individual_wrap">
                    <p id="resultEmail">이메일을 입력해주십시오.</p>
                </div>
                <div class="individual_wrap" id="email_wrap">
                    <input type="email" id="SendEmail" name="SendEmail" placeholder="example@gmail.com">
                    <button id="SendEmailBtn" class="Btn">인증번호전송</button>
                </div>
                
                <div class="individual_wrap">
                    <p id="resultSendingEmail">이메일을 입력해주십시오.</p>
                </div>
                <div class="individual_wrap" id="email_wrap">
                    <input  id="checkEmailCode" name="code" placeholder="이메일로 전송된 코드를 입력해주세요">
                    <button id="checkNumber" class="Btn">인증</button>
                </div>
                <div class="individual_wrap">
                    <p id="resultCheckEmail">이메일 인증을 해주십시오.</p>
                </div>
                <div class="individual_wrap" id="password_wrap">
                    <input type="password" id="password1" name="Pw" placeholder="example123!@">
                    <button id="checkPassword1" class="Btn">확인</button>
                </div>
                <div class="individual_wrap" id="password_wrap">
                    <p id="checkPassword1Result">유효하지 않는 비밀번호입니다.</p>
                </div>
                <div class="individual_wrap" id="password_wrap">
                    <input type="password" id="password2" name="Pw" placeholder="example123!@">
                    <button id="checkPassword2" class="Btn">확인</button>
                </div>
                <div class="individual_wrap">
                    <p id="checkPassword2Result">비밀번호가 일치하지 않습니다.</p>
                </div>
                <div class="individual_wrap">
                    <input type="datetime" id="BIRTH_DATE" name="userBirthday" placeholder="19900124">
                </div>
                <br>
                <div class="individual_wrap">
                    <select name="Gender" id="GENDER">
                        <option value="man" selected>남</option>
                        <option value="women">여</option>
                    </select>
                </div>
                <br>
                <div class="individual_wrap">
                    <input type="text" id="userNickName" name="NickName" placeholder="닉네임을 지어주세요!">
                    <button id="checkNickName" class="Btn">확인</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <input type="text" id="comment" name="INTRODUCTION" placeholder="코멘트를 적어주세요">
                </div>
                <br>
                <div class="individual_wrap">
                    <div class='uploadResult'>
						<ul>
		
						</ul>
					</div>
                    <input type='file' name='uploadFile'>
                    <button id="imgUploadBtn" for="ProfileImg" class="Btn">사진 업로드</button>
                </div>
                <br>
                <div class="individual_wrap">
                    <p>
                        <input type="checkbox" id="terms">
                        <label for="terms">이용약관과 개인정보 취급방침을 확인하고 이에 동의합니다.</label>
                        <a href="#">(전체 약관보기)</a>
                    </p>
                    <span id="termsError"></span>
                </div>
                <div class="individual_wrap">
                    <input type="submit" id="join_btn" value="가입하기" formenctype="multipart/form-data">
                </div>
            </div>
            <div class="join_footer">
				<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
        	
        	
        	
        	const emailMatching= /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
        	const passwordMatching = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
        	const birthdayMatching = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
        	const nicknameMatching = /^[가-힣ㄱ-ㅎa-zA-Z0-9._ -]{2,}\$/;
        	
        	var userEmail;
        	var checkEmail; // SendEmail
        	var code;
        	var userPw;
        	var checkUserPw;
        	var userBirthDate;
        	var userGender;
        	var userNickname;
        	var userComment;
        	
        	var passCondition1 = new Array(9).fill(false); 
        	var passCondition2 = new Array(8).fill(false);
        	//0이메일,1이메일 중복확인,2이메일 확인 , 3패스워드, 4패스워드 확인, 5생년월일,6성별,7닉네임 8중복확인 
        	
        	
        	
        	
        	// 이메일 유효성 검사 
        	$('#distinckedEmail').on("click",function(){
        		userEmail = $('#UserEmail').val();
        		var emailValueCheck = emailMatching.test(userEmail);
        		if(emailValueCheck){
        			console.log(userEmail);
        			console.log("이메일 형식이 맞습니다.");
        			passCondition1[0] = true;
        			$.ajax({
        				url:'/user/distinckedEmail',
        				type:'post',
        				data:{
        					Email : $('#UserEmail').val()
        				},
        				dataType:'json',
        				success : function(data){
        					console.log("ajax성공!!!");
        					console.log("데이터 값 : ",data);
        					if(data == 1){
        						passCondition1[1] = false;
        						$('#resultEmail').text('중복된 이메일입니다.').css("color","red");
        						console.log("pass1  : "+passCondition1[1]);
        					}else{
        						passCondition1[1] = true;
        						$('#resultEmail').text('사용가능한 이메일입니다.').css("color","green");
        	        			$('#UserEmail').focus();
        	        			console.log("pass1  : "+passCondition1[1]);
        					}	// end if-else
        					
        				},error:function(xhr,status,error){
        					console.log(xhr);
        					console.log(status);
        					console.log(error);
        				}	//	end success
        			});	// end ajax
        		}else{
        			console.log(userEmail);
        			passCondition1[0] = false;
        			alert("이메일 형식이 맞지 않습니다.");
        			$('#UserEmail').text('이메일 형식이 맞지 않습니다.').css("color","red");
        			$('#UserEmail').focus();
        		}
        	}); // end distinckedEmail
			
        	$('#SendEmailBtn').on("click",function(){
        		$.ajax({
        			type:'get',
        			url:'/user/sendMailCheck',
        			data :{ Email : $('#SendEmail').val()},
        			dataType:'json',
        			success:function(data){
        				code = data;
        				alert("인증번호가 전송되었습니다.");
        				console.log(data);
        			},error:function(xhr,status,error){
        				console.log(xhr);
        				console.log(status);
        				console.log(error);
        			}
        			
        		});	//	 end ajax
        		
        	});	// end SendEmailBtn
        	
        	// 이메일 인증 
        	$('#checkNumber').on("click",function(){
        		var ll = $('#checkEmailCode').val();
        		if(code == ll){
        			console.log("코드가 정확하게 입력되었습니다.");
        			passCondition1[2] = true;
        			$('#resultCheckEmail').text('이메일 인증되었습니다.').css("color","green");
        		}else{
        			console.log("인증코드가 불일치합니다.");
        			console.log("code : ",code);
        			console.log("기입한 코드 : ",$('#checkEmailCode'.val()));
					passCondition1[2] = false;
					$('#resultCheckEmail').text('이메일 인증 실패하였습니다.').css("color","red");
					$('#checkNumber').focus();
        		}
        	});	// end checkNumber
        	
        	$('#checkPassword1').on("click",function(){
        		userPw =  $('#password1').val();
        		var checkPasswordValue = passwordMatching.test(userPw);
        		console.log(checkPasswordValue);
        		if(checkPasswordValue){
        			console.log("비밀번호 유효성 검사를 통과하였습니다.");
        			passCondition1[3]=true;
        			$('#checkPassword1Result').text('비밀번호 유효성 검사를 통과하였습니다.').css("color","green");
        		}else{
        			console.log("비밀번호 유효성 검사를 통과하지 못하였습니다.");
        			$('#checkPassword1Result').text('비밀번호 유효성 검사를 통과하지 못하였습니다.').css("color","red");
        			passCondition1[3]=false;
        			$('#password1').focus();
        		}	// end if-else
        	});	// end checkPassword1
        	
        	$('#checkPassword2').on("click",function(){
        		checkUserPw = $('#password2').val();
        		console.log(checkUserPw);
        		if(userPw === checkUserPw){
        			console.log("비밀번호가 일치합니다.");
        			passCondition1[4]=true;
        			$('#checkPassword2Result').text('비밀번호가 일치합니다.').css("color","green");
        		}else{
        			console.log("비밀번호가 불일치합니다.");
        			passCondition1[4]=false;
        			$('#checkPassword2Result').text('비밀번호가 불일치합니다.').css("color","green");
        			$('#password2').focus();
        		}	// end if-else
        		
        	});	// end checkPassword2
        	
        	$('#BIRTH_DATE').on("change",function(){
        		userBirthDate = $('#BIRTH_DATE').val();
        		console.log(userBirthDate);
        		
        		var birthdayValueCheck = birthdayMatching.test(userBirthDate);
        		console.log("생년월일 첵크 : ",birthdayValueCheck);
        		if(birthdayValueCheck){
        			console.log("생년월일 통과하였습니다.");
        			passCondition1[5]=true;
        		}else{
        			console.log("생년월일 불통!.");
        			passCondition1[5]=false;
        			$('#BIRTH_DATE').focus();
        			return false;
        		}
        		passCondition1[5]=true;
        		
        	});	// end BIRTH_DATE
        	
        	$('#GENDER').on("change",function(){
        		userGender = $('#GENDER').val();
        		console.log(userGender);
        		passCondition1[6]=true;
        	});	// end gender
        	
        	
        	$('#checkNickName').on("click",function(){
        		userNickname = $('#userNickName').val();
        		console.log(userNickname);
        		var checkNickNameValue = nicknameMatching.test(userNickname);
        		console.log(checkNickNameValue);
        		if(checkNickNameValue){
        			console.log("닉네임 유효성 검사를 통과하였습니다.!");
        			passCondition1[7]=true;
        			
        			$.ajax({
        				type:'get',
        				url:"/user/checkNickName",
        				data : { NickName : userNickname},
        				dataType : 'json',
        				success : function(data){
        					console.log("ajax성공!");
        					console.log(data);
        					if(data){
        						console.log("닉네임 중복 검사 통과!");
        						passCondition1[8]=true;
        					}else{
        						console.log("닉네임 중복 검사 불통!");
        						alert("닉네임 중복 검사 불통!");
        						passCondition1[8]=false;
        						$('#userNickName').focus();
        					}
        				},error:function(xhr,status,error){
            				console.log(xhr);
            				console.log(status);
            				console.log(error);
            			}
        			});
        		}else{
        			console.log("닉네임 유효성 검사를 통과치 못했습니다.!");
        			passCondition1[7]=false;
        		}
        	});	// end checkNickName
        	
        	$('#join_btn').on("click",function(){
        		

        		for(let i = 0 ; i < passCondition1.length ; i++){
        			if(passCondition1[i] === true){
        				console.log(passCondition1[i]);
        				console.log("passCondition1["+i+"] : "+passCondition1[i]);
        				console.log("passCondition1 패스");
        				
        			}else{
        				console.log("passCondition1["+i+"] : "+passCondition1[i]);
        				console.log("passCondition1 불통");
        				
        				return false;
        			}	// end if -else
        		}	// end for
        		
    			
    			
    			console.log("확인");

    			
        		// 이메일 유효성 검사 및 중복확인 0 1
        		var emailValueCheck = emailMatching.test($('#UserEmail').val());
        		if(emailValueCheck){
        			console.log("이메일 유효성 검사 : ",emailValueCheck);
        			passCondition2[0] = true;
        		}else{
        			alert("이메일 유효성 검사를 통과하지 못하였습니다.");
        			$('#UserEmail').focus();
        			return false;
        		}	// end if - else
        			
        		$.ajax({
        			url:'/user/distinckedEmail',
        			type:'post',
        			data:{Email : $('#UserEmail').val()},
        			dataType:'json',
        			success : function(data){
    					console.log("ajax성공!!!");
    					console.log("데이터 값 : ",data);
    					if(data === 1){
    						passCondition2[1] = false;
    						$('#resultEmail').text('중복된 이메일입니다.').css("color","red");
    						console.log("passCondition2[1] : "+passCondition2[1]);
    						$('#UserEmail').focus();
    						return false;
    					}else{
    						passCondition2[1] = true;
    						$('#resultEmail').text('사용가능한 이메일입니다.').css("color","green");
    						console.log("passCondition2[1] : "+passCondition2[1]);
    	        			
    					}	// end if-else
    					
    				},error:function(xhr,status,error){
    					console.log(xhr);
    					console.log(status);
    					console.log(error);
    				}	//	end success
        			
        		});	// end ajax
        		
        		
        		// 이메일 인증 확인 2
        		if(code == $('#checkEmailCode').val()){
        			console.log("코드가 정확하게 입력되었습니다.");
        			passCondition2[2] = true;
        			$('#resultCheckEmail').text('이메일 인증되었습니다.').css("color","green");
        		}else{
        			console.log("인증코드가 불일치합니다.");
        			console.log("code : ",code);
        			console.log("기입한 코드 : ",$('#checkEmailCode'.val()));
					passCondition2[2] = false;
					$('#resultCheckEmail').text('이메일 인증 실패하였습니다.').css("color","red");
					$('#checkNumber').focus();
					return false;
        		}
        		
        		// 비밀번호 유효성 검사 3
        		var checkPasswordValue = passwordMatching.test($('#password1').val());
        		if(checkPasswordValue){
        			console.log("비밀번호 유효성 검사를 통과하였습니다.");
        			passCondition2[3]=true;
        			$('#checkPassword1Result').text('비밀번호 유효성 검사를 통과하였습니다.').css("color","green");
        		}else{
        			console.log("비밀번호 유효성 검사를 통과하지 못하였습니다.");
        			$('#checkPassword1Result').text('비밀번호 유효성 검사를 통과하지 못하였습니다.').css("color","red");
        			passCondition2[3]=false;
        			$('#password1').focus();
        			return false;
        		}	// end if-else
        		// 비밀번호 재 검사 4
        		checkUserPw = $('#password2').val();
        		console.log(checkUserPw);
        		if(userPw === checkUserPw){
        			console.log("비밀번호가 일치합니다.");
        			passCondition2[4]=true;
        			$('#checkPassword2Result').text('비밀번호가 일치합니다.').css("color","green");
        		}else{
        			console.log("비밀번호가 불일치합니다.");
        			passCondition2[4]=false;
        			$('#checkPassword2Result').text('비밀번호가 불일치합니다.').css("color","green");
        			$('#password2').focus();
        			return false;
        		}	// end if-else
        		// 생년월일 검사 5
        		userBirthDate = $('#BIRTH_DATE').val();
        		console.log(userBirthDate);
        		
        		var birthdayValueCheck = birthdayMatching.test(userBirthDate);
        		console.log("생년월일 첵크 : ",birthdayValueCheck);
        		if(birthdayValueCheck){
        			console.log("생년월일 통과하였습니다.");
        			passCondition2[5]=true;
        		}else{
        			console.log("생년월일 불통!.");
        			passCondition2[5]=false;
        			$('#BIRTH_DATE').focus();
        			return false;
        		}	//	end if - else
				passCondition2[5]=true;
        		// 성별 검사 6
        		
        		userGender = $('#GENDER').val();
        		console.log(userGender);
        		
        		if(userGender=='man'){
        			passCondition2[6]=true;	
        		}else{
        			passCondition2[6]=true;	
        		}
        		
        	
        		// 닉네임 유효성검사 7 중복 검사 8
        		userNickname = $('#userNickName').val();
        		console.log(userNickname);
        		var checkNickNameValue = nicknameMatching.test(userNickname);
        		console.log(checkNickNameValue);
        		if(checkNickNameValue){
        			console.log("닉네임 유효성 검사를 통과하였습니다.!");
        			passCondition2[7]=true;
        			
        			$.ajax({
        				typr:'get',
        				url:"/user/checkNickName",
        				data : { NickName : userNickname},
        				dataType : 'json',
        				success : function(data){
        					console.log("ajax성공!");
        					console.log(data);
        					if(data){
        						console.log("닉네임 중복 검사 통과!");
        						passCondition2[8]=true;
        					}else{
        						console.log("닉네임 중복 검사 불통!");
        						alert("닉네임 중복 검사 불통!");
        						passCondition2[8]=false;
        						$('#userNickName').focus();
        					}
        				},error:function(xhr,status,error){
            				console.log(xhr);
            				console.log(status);
            				console.log(error);
            			}
        			});
        		}else{
        			console.log("닉네임 유효성 검사를 통과치 못했습니다.!");
        			passCondition2[7]=false;
        		}
        		
        		setTimeout(function() {
        			  console.log('Works!');
        			  abc();
        			}, 2000);
        		
        		
        		
        	});	// end join_btn
        	function abc(){
        		console.log("확인용");
        		console.log("확인용");
        		console.log("확인용");
        		for(let i = 0 ; i < passCondition2.length ; i++){
        			if(passCondition2[i] == true){
        				console.log(passCondition2[i]);
        				console.log("passCondition2["+i+"] : "+passCondition2[i]);
        				console.log("passCondition2 패스");
        				
        			}else{
        				console.log("passCondition2["+i+"] : "+passCondition2[i]);
        				console.log("passCondition2 불통");
        				
        				return false;
        			}	// end if -else
        		}	// end for
        		
        		console.log("regex : ",regex);
        		console.log("maxSize : ",maxSize);
        		
        		
        		
        		var inputFile = $("input[name='uploadFile']").get(0);
        		var selectedFile = inputFile.files[0];
        		
        		console.log("inputFile : ",inputFile);
        		console.log("selectedFile : ",selectedFile);
        		console.log("selectedFile Name : ",selectedFile.name);
        		console.log("selectedFile Size : ",selectedFile.size);
        		
        		if(checkExtension(selectedFile.name , selectedFile.size) == false){
        			alert("첨부파일 확인 검사 실패!!!");
        			return false;
        		}	// end if
        		
        		
        		var formData = new FormData();
        		console.log("formData : ",formData);
        		formData.append('Email', $('#UserEmail').val());
        		formData.append('Pw',$('#password1').val());
        		formData.append('userEmail', $('#SendEmail').val());
        		formData.append('NickName',$('#userNickName').val());
        		formData.append('BIRTH_DATE',$('#BIRTH_DATE').val());
        		formData.append('GENDER',$('#GENDER').val());
        		formData.append('INTRODUCTION',$('#comment').val());
        		formData.append('ProfileImg',selectedFile);

        		
        		
        		$.ajax({
        			type:'post',
        			url:"/user/join",
        			processData : false,
    				contentType : false,
        			data:formData,
        			dataType:'json',
        			success : function(data){
        				console.log("ajax!성공!!!");
        				console.log(data);
        				if(data ==1){
        					alert("가입성공!!!");	
        					self.location.href="/user/login";
        				}else{
        					alert("회원가입실패!!!");
        					self.location.href="/domain";
        				}
						
        			},error:function(xhr,status,error){
        				console.log(xhr);
        				console.log(status);
        				console.log(error);
        			}
        		});	// end ajax
        		
//         		$.ajax({
        			
//         		});	// end ajax
        		
        	}	//	end abc
        	
        	
        	var regex = new RegExp("(.*?)\.(jpg|jpeg|png)$");
        	var maxSize = 5242880; // 5MB
        	//변경된 부분은 정규 표현식입니다. (jpg|jpeg|png)는 jpg, jpeg, png 중 하나의 확장자와 일치하는지 확인합니다. 이제 해당 코드로 이미지 파일 업로드를 구현할 때, jpg, jpeg, png 이외의 확장자를 가진 파일은 거부됩니다.
        	
        	function checkExtension(fileName,fileSize){
        		var result = fileSize >= maxSize ? true : false;
        		console.log("파일 사이즈 첵크 : ",result);
        		console.log("파일 확장자명 첵크 : ",regex.test(fileName));
        		if(fileSize >= maxSize){
        			alert("파일 사이즈 초과!");
        			return false;
        		}	// end if
        		if(!regex.test(fileName)){
        			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
        			return false;
        		}	// end if
        		
        		return true;
        	}	// end checkExtension
        	
//         	$('#imgUploadBtn').on("click",function(){
//         		console.log("regex : ",regex);
// //         		console.log("maxSize : ",maxSize);
//         		userEmail = $('#UserEmail').val();
//         		var inputFile = $("input[name='uploadFile']").get(0);
//         		var selectedFile = inputFile.files[0];
        		
//         		console.log("inputFile : ",inputFile);
//         		console.log("selectedFile Name : ",selectedFile.name);
//         		console.log("selectedFile Size : ",selectedFile.size);
        		
        		
//         		if(checkExtension(selectedFile.name , selectedFile.size) == false){
//         			alert("첨부파일 확인 검사 실패!!!");
//         			return false;
//         		}	// end if
        		
//         		var formData = new FormData();
//         		console.log("formData : ",formData);
//         		formData.append('userEmail',userEmail);
//         		formData.append('multiFile',selectedFile);
        		
        		
//         		$.ajax({
        			
//         			url:'/user/joinUploadFile',
//     				processData : false,
//     				contentType : false,
//         			type:'post',
//         			data:formData,
//         			dataType: 'json',
//         			success : function(data){
//         				console.log("ajax통신성공!!!");
//         				console.log("data : ",data);
//         			},error:function(xhr,status,error){
//         				console.log("xhr : ",xhr);
//         				console.log("status : ",status);
//         				console.log("error : ",error);
//         			}
        			
//         		});	// end ajax
        		
        		
        		
//         	});	// end imgUploadBtn
        	
        	
        	
        });	// end jq
    </script>
</body>
</html>