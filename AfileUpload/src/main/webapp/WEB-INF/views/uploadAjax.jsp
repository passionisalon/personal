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
		background-color:white;
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
		align-content:center;
		text-align:center;
	}
	.uploadResult ul li img{
		width:300px;
	}
	.uploadResult ul li span{
		color:white;
	}
	.bigPictureWrapper{
		position:absolute;
		display:none;
		justify-content:center;
		align-items:center;
		top:0%;
		width:100%;
		height:100%;
		background-color:gray;
		z-index:100;
		background:rgba(255,255,255,0.5);
	}
	.bigPicture{
		position:relative;
		display:flex;
		justify-content:center;
		align-items:center;
	}
	.bigPicture img{
		width:600px;
	}
</style>
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
	
		function showImage(fileCallPath){
// 			alert("fileCallPath : "+fileCallPath);
			$(".bigPictureWrapper").css("display","flex").show();
			

			$(".bigPicture")
			.html("<img src='/display?fileName=" +encodeURI(fileCallPath)+"'>").animate({width:'100%', height: '100%'}, 1000);
		}
	
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
			
			var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr){
				var str="";
				$(uploadResultArr).each(function(i,obj){
					
					if(!obj.image){
// 						str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
						var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
						str+="<li><a href='/download?fileName="+fileCallPath+"'>"
								+"<img src='/resources/img/asuka5.png'>"+obj.fileName+"</a></li>";
					}else{
// 						str += "<li>" + obj.fileName + "</li>";
// 						var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
// 						str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
						
						var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
						console.log("fileCallPath : ",fileCallPath);
						var originPath = obj.uploadPath + "\\"+obj.uuid+"_"+obj.fileName;
						console.log("originPath : ",originPath);
						originPath = originPath.replace(new RegExp(/\\/g),"/");
						console.log("originPath : ",originPath);
						
						str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='/display?fileName="+fileCallPath+"'></a><li>";

						console.log("str : ",str);
					}	// end if-else
					
				});
				uploadResult.append(str);
			}	// end showUploadFile
			
			
			
			var cloneObj = $(".uploadDiv").clone();
			
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
						
						showUploadedFile(result);
						
						$(".uploadDiv").html(cloneObj.html());
						
					},error:function(error){
						console.log(error);
					}	// end
					
				});	// end ajax
				
				console.log("uploadBtn의 젤 밑단!");
				
			});// end uploadBtn
			
			$(".bigPictureWrapper").on("click",function(e){
				$(".bigPicture").animate({width:'0%',height:'0%'},1000);
				setTimeout(()=>{
					$(this).hide();
				},1000);
			})
		});	// end jq
	</script>
</body>
</html>