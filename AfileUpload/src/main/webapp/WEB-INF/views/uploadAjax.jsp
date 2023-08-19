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
			$('#uploadBtn').on("click",function(e){
				var formData = new FormData();
				console.log("formData : ",formData);
				var inputFile = $("input[name='uploadFile']").prop('files');
				var files = inputFile;
				console.log("inputFile : ",inputFile);
				console.log("files : ",inputFile);
				
				
				// add File Data to forData
				for(let i = 0 ; i < inputFile.length ; i++){
					formData.append("uploadFile",inputFile[i]);
				}
				console.log("formData : ",formData);
				
				$.ajax({
					url:'/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					success : function(result){
						
						alert("Uploaded : ",result);
					},error:function(error){
						console.log("error : ",error);
					}
				});	// end ajax
				
			});	// end uploadBtn
		});	// end jq
	</script>
</body>
</html>