<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Register</h1>
		</div>
<!-- 		col-lg-12 -->
	</div>
<!-- 	row -->
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Register</div>
<!-- 				panel heading -->
				<div class="panel-body">
					<form role="form" action="/board/register" method="post">
						<div class="form-group">
							<label>Title</label><input class="form-control" name="title">
						</div>
						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="content"></textarea>
						</div>
						<div class="form-group">
							<label>Writer</label><input class="form-control" name="writer">
						</div>
						<button type="submit" class="btn btn-default">Submit Button</button>
						<button type="reset" class="btn btn-default">Reset Button</button>	
					</form>
				</div>
<!-- 				panel-body -->
			</div>
<!-- 			panel panel-default -->
		</div>
<!-- 		col-lg-12 -->
	</div>
<!-- 	row -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">File Attach</div>
				<div class="panel-body">
					<div class="form-group uploadDiv">
						<input type="file" name="uploadFile" multiple>
					</div>
					
					<div class="uploadResult">
						<ul>
						
						</ul>
					</div>
				</div>
			</div>
<!-- 			panel panel-default -->
		</div>
<!-- 		col-lg-12 -->
	</div>
<!-- 	row -->




<%@include file="../includes/footer.jsp" %>
<script>
	$(document).ready(function(e){
		
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880; // 5MB
		
		function checkExtension(fileName,fileSize){
			if(fileSize >=maxSize){
				alert("파일 사이즈 초과");
				return false;
			}	// end if
			
			if(regex.test(fileName)){
				alert('해당 종류의 파일은 업로드 할 수 없습니다.');
				return false;
			}
			return true;
		}	// end checkExtension
		
		function showUploadResult(uploadResultArr){
			if(!uploadResultArr || uploadResultArr.length == 0 ){return;}
			
			var uploadUL = $(".uploadResult ul");
			var str="";
			$(uploadResultArr).each(function(i,obj){
				// image type
				if(obj.image){
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					str+="<li data-path='"+obj.uploadPath+"'";
					str+=" data-uuid = '"+obj.uuid+"' data-filename='"+obj.fileName+"'data-type='"+boj.image+"'"
					str+=" ><div>";
					str+="<span>"+obj.filename+"</span>";
					str+="<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='/display?fileName="+fileCallPath+"'>";
					str+="</div>";
					str+="</li>";
				}else{
					
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");

					str+="<li ";
					str+="data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
					str+="<span>"+obj.fileName+"</span>";
					str+="<button type='button' data-file='\'"+fileCallPath+"\' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='/resources/img/asuka5.png'></a>";
					str+="</div>";
					str+="</li>";
					
				}
			});// uploadReusltArr
			
			uploadUL.append(str);
		}	// end showUploadResult
		
		$("input[type='file']").change(function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			
			for(let i = 0 ; i < files.length ; i++){
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}	// end if
				formData.append("uploadFile",files[i]);
			}	// end for
			
			$.ajax({
				url:'/uploadAjaxAction',
				processData:false,
				contentType:false,
				data:formData,
				type:'post',
				dataType:'json',
				success:function(result){
					console.log("result : ",result);
					showUploadResult(result);
				},error:function(error){
					console.log(error);
				}
			});	// end ajax
			
		});	// end input change
		
		var formObj = $("form[role='form']");
		
		$("button[type='submit']").on("click",function(e){
			e.preventDefault();
			console.log("submit clicked");
		})
		
		$(".uploadResult").on("click","button",function(e){
			console.log("delete file");
			
			var targetFile = $(this).data("file");
			var type = $(this).data("type");
			
			var targetLi = $(this).closest("li");
			
			$.ajax({
				url:'/deleteFile',
				data:{
					fileName:targetFile,
					type:type
				},
				dataType:'text',
				type:'post',
				success:function(result){
					alert(result);
						targetLi.remove();
				},error: function(error){
					console.log(error);
					
				}
			});	// end ajax
			
		})	// end uploadResult click
	});	// end jq
</script>
</body>
</html>