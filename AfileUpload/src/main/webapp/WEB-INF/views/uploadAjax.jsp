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
		<button id='uploadBtn'>Upload</button>
	</div>
	<div class='uploadResult'>
		<ul>
		
		</ul>
	</div>
	<div class='bigPictureWrapper'>
		<div class='bigPicture'>
		
		</div>
	</div>
	<script>
		$(document).ready(function(){
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880;	// 5MB
			
			function checkExtension(fileName, fileSize){
				if(fileSize >=maxSize){
					alert("파일 사이즈 초과!");
					return false;
				}	// end if
				
				if(regex.test(fileName)){
					alert("해당 종류이 파일은 업로드 할 수 없습니다.");
					return false;
				}	// end if
				
				return true;
			}	// end checkExtension
			
			
			
			$('#uploadBtn').on("click",function(e){
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				console.log(files);
				
				// add File Data to formData
				for(let i = 0 ; i < files.length ; i++){
					
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					
					
					formData.append("uploadFile",files[i]);
					console.log("formData : ",formData);
					console.log("uploadFile : ",inputFile);
				}	// end for
				
				$.ajax({
					url : '/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'post',
					dataType: 'json',
					success:function(result){
						console.log("ajax통신성공!!!!!");
						console.log("data : ",result);
					},error:function(error){
						console.log(error);
					}	// end
					
				});	// end ajax
				
				console.log("uploadBtn의 젤 밑단!");
				
			});// end uploadBtn
			
		});	// end jq
	</script>
</body>
</html>