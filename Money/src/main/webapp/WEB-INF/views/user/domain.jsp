<%--
  Created by IntelliJ IDEA.
  User: nayoung
  Date: 2023/05/10
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SeouLive</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout/domain.css">
</head>

<body>

    <!-- <div id="domain_header"> -->
    <div class="domain_wrap">
        <div class="domain_container">
            <div id="domain_header">
                <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/header.jsp"/>
            </div>

            <div id="domain_body">
                <div class="domain_gesipan" id="domain_travel">
                    <div class="domain_title" id="domain_travel_title">
                        <a href="">여행지</a>
                    </div>
                    <div class="domain_list" id="domain_travel_list">
                        <ul class="ulLine">
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                        </ul>
                    </div>  <!-- domain_travel_list -->
                </div>
                <div class="domain_gesipan" id="domain_travel">
                    <div class="domain_title" id="domain_travel_title">
                        <a href="">코스</a>
                    </div>
                    <div class="domain_list" id="domain_travel_list">
                        <ul class="ulLine">
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                        </ul>
                    </div>  <!-- domain_travel_list -->
                </div>
                <div class="domain_gesipan" id="domain_travel">
                    <div class="domain_title" id="domain_travel_title">
                        <a href="">리뷰</a>
                    </div>
                    <div class="domain_list" id="domain_travel_list">
                        <ul class="ulLine">
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                            <li>
                                <div id="photo">
                                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                </div>
                                <div id="writer_title">
                                    <p>석촌호수</p>
                                </div>
                            </li>
                        </ul>
                    </div>  <!-- domain_travel_list -->
                </div>
                
            </div><!-- <div id="domain_body"></div> -->
            <div id="domain_footer">
				<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/footer.jsp"/>
            </div>
        </div><!-- <div class="domain_container"> -->
        

    </div><!-- <div class="domain_wrap"> -->

    <script>
        $(document).ready(function(){
            $("#domain_header").load("/WEB-INF/views/common/header.jsp");
        });
        $(document).ready(function(){
            $("#domain_footer").load("/WEB-INF/views/common/footer.jsp");
        });
    </script>
    
</body>

</html>