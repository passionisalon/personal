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
    
    <title>국정감사 게시판 리스트 페이지(부서책임자)</title>
    
</head>
<link href="../../../resources/css/auditorManageDetailPage.css" rel="stylesheet" type="text/css">
<body>
    
    <div class="container">             <!-- container -->
        <h1>국정감사 관리게시판 상세페이지</h1>
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">아이디 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                abc@naver.com
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">이름 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                테스트1
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">부서 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                <select name="" id="">
                    <option value="">[부서책임자/02]</option>
                    <option value="">[부서담당자/03]</option>
                    <option value="">[인사부서/C001]</option>
                </select>
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">상태 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                요청중
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">제목 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                국정감사 자료 요청 드립니다.
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap">                          <!-- warp -->
            <div class="wrap1">
                <div class="wrap1_1">내용 : </div>
                <div class="wrap1_block"></div>
            </div>
            <div class="wrap2">
                한해 인사부서 자료 요청 드립니다.
            </div>
        </div>                                      <!-- warp -->
        <div class="wrap_blockLast">

        </div>
        <div class="wrap" id="wrapLast">
            <div class="wrap3">
                <input type="button" value="담당자지정">
                <input type="button" value="닫기">
            </div>
        </div>
    </div><!-- container -->
</body>
</html>