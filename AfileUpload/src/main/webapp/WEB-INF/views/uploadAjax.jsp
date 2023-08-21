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
<style>
	.uploadResult{
		width:100%;
		background-color:gray;
	}
	.uploadResult ul{
		display:flex;
		flex-flow:row;
		justify-content:center;
		align-items:center;
	}
	.uploadResult ul li{
		list-style:none;
		padding:10px;
	}
	.uploadResult ul li img{
		width: 20px;
	}
</style>

<body>

	<h1>Upload with Ajaxaaa</h1>

	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	<div class='uploadResult'>
		<ul>
		
		</ul>
	</div>
	<button id='uploadBtn'>Upload</button>
	<script>
		$(document).ready(function(){
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880;	// 5MB
			
			function checkExtension(fileName,fileSize){
				if(fileSize >= maxSize){
					alert("파일사이즈초과!!!");
					return false;
				}	// end if
				
				if(regex.test(fileName)){
					alert("해당 종류의 파일은 업로드 할 수 없습니다.");
					return false;
				}	// end if
				
				return true;
			}
			
			var cloneObj = $(".uploadDiv").clone();
			
			$('#uploadBtn').on("click",function(e){
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']").prop('files');
				var files = inputFile;
				console.log("inputFile : ",inputFile);
				
				// add File Data to forDate
				for(let i = 0 ; i < inputFile.length ; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}	// end if
					formData.append("uploadFile",inputFile[i]);
				}
				console.log("formaData : ",formData);
				$.ajax({
					url:'/uploadAjaxAction',
					processData : false,
					contentType : false,
					data : formData,
					type:'post',
					dataType:'json',
					success : function(data){
						console.log("Ajax성공 : ",data);
						
						showUploadedFile(data);
						
						$('.uploadDiv').html(cloneObj.html());
					}
				});	// end ajax
				
			});	// end uploadBtn
			
			var uploadResult = $(".uploadResult ul");
			function showUploadedFile(uploadResultArr){
				console.log("uploadResultArr : ",uploadResultArr);
				var str = "";
				$(uploadResultArr).each(function(i,obj){
					console.log("i : ",i);
					console.log("obj : ",obj);
// 					str += "<li>" + obj.fileName + "</li>";

					if(!obj.image){
						var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
// 						str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
						str += "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>";
					}else{
						var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
						str += "<li><img src='/display?fileName"+fileCallPath+"'<li>";
					}
					
				});	// end each
				
				uploadResult.append(str);
			}	// end showUploadedFile
			
			function downloadFile(fileName) {
			    // Replace '/download/' with the actual URL of your getFile endpoint.
			    var downloadUrl = '/download/?fileName=' + fileName;
			    window.open(downloadUrl, '_blank');
			}
			
		});	// end jq
	</script>
</body>
</html>