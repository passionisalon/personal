<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Upload with Ajax</h1>
	
	
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	
	<button id='uploadBtn'>Upload</button>
	<script>
		$(document).ready(function(){
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880;	// 5MB
			
			function checkExtension(fileName, fileSize){
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과!!!");
					return false;
				}	// end if
				
				if(regex.test(fileName)){
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}	// end if
				
				return true;
			}
			
			
			$('#uploadBtn').on("click",function(e){
				var formData = new FormData();
				console.log("formData : ",formData);
				var inputFile = $("input[name='uploadFile']").prop('files');
				var files = inputFile;
				console.log("inputFile : ",inputFile);
				console.log("files : ",inputFile);
				
				
				// add File Data to forData
				for(let i = 0 ; i < inputFile.length ; i++){
					
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					
					formData.append("uploadFile",inputFile[i]);
				}
				console.log("formData : ",formData);
				
				$.ajax({
					url:'/uploadAjaxAction',
					processData : false,
					contentType : false,
					data :formData,
					type : 'POST',
					success : function(data){
						alert("성공!!");
// 						alert("Uploaded : ",data);
					},error:function(xhr,status,error){
						console.log("Ajax오류 발생 : ");
						console.log("상태 코드 : ",xhr.status);
						console.log("error : ",error);
					}
				});	// end ajax
				
			});	// end uploadBtn
		});	// end jq
	</script>
</body>
</html>