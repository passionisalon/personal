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
		align-content:center;
		text-align:center;
	}
	.uploadResult ul li img{
/* 		width: 20px; */
		width:100px;
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
		width:6600px;
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
	
	<div class='bigPictureWrapper'>
		<div class='bigPicture'>
		
		</div>
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
// 						var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
// 						var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);

// 						str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
// 						str += "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>";

						var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
						var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
						
						str += "<li><div><a href='/download?fileName="+fileCallPath+"'>"+
								"<img str='/resources/img/attach.png'>"+obj.fileName+"</a>"+
								"<span data-file=\'"+fileCallPath+"\' data-type='file'>x</span>"+
								"<div></li>"
					}else{
// 						var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
// 						str += "<li><img src='/display?fileName"+fileCallPath+"'<li>";
// 						var originPath = obj.uploadPath + "\\"+obj.uuid+"_"+obj.fileName;
// 						originPath = originPath.replace(new RegExp(/\\/g),"/");
// 						str += "<li><a href=\"javascript:showImage(\'"+originPath+"\')\"><img src='/display?fileName="+fileCallPath+"'></a><li>";
						var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+")"+obj.fileName);
						var originPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;
						originPath = originPath.replace(new RegExp(/\\/g),"/");
						str += "<li><a href=\"javascript;showImage(\'"+originPath+"\')\">"+
								"<img sre='display/fileName="+fileCallPath+"'></a>"+
								"<span data-file=\'"+fileCallPath+"\' data-type='image'>x</span>"+
								"<li>";
					}
					
				});	// end each
				
				uploadResult.append(str);
			}	// end showUploadedFile
			
			$(".bigPictureWrapper").on("click",function(e){
				$(".bigPicture").animate({width:'0%',height:'0%'},1000);
				setTimeout(()=>{
					$(this).hide();
				},1000);
			})
			
			
			function showImage(fileCallPath){
				
				$('.bigPictureWrapper').css('display','flex').show();
				
				$('.bigPicture').html("<img src='/display?fileName=" + encodeURIComponent(fileCallPath) + "'>").animate({ width: '100%', height: '100%' }, 1000);

				
			};	// end showImage
			
		});	// end jq
	</script>
</body>
</html>