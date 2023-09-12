<%@page import="com.tofit.spring.mypage.calendar.vo.CalendarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage01.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script src='${contextPath}/resources/js/index.global.js'></script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth'
        },
        // initialDate: '2023-01-12', // 초기 설정 시간
        navLinks: false, // can click day/week names to navigate views
        businessHours: true, // display business hours
        editable: false, // 편집 가능 여부
        selectable: false, // 날짜 클릭 여부
        events: [
        	<% List<CalendarVO> calendarList=(List<CalendarVO>)request.getAttribute("reserveList"); %>
        	<%if (calendarList != null) {%>
        	<%for (CalendarVO vo : calendarList) {%>
        	{
            	title : '<%=vo.getPtTime()%> PT예약',
                start : '<%=vo.getPtDate()%>',
                color : '#4682b4'
             },
         	<%}
        	}%>
        	]
        });

        calendar.render();
    });

    </script>
    <c:choose>
    	<c:when test="${msg=='reserve'}">
			<script>
				window.onload=function () {
					alert("PT일정이 예약되었습니다.");
				}
			</script>
		</c:when>
    	<c:when test="${msg=='exemption'}">
			<script>
				window.onload=function () {
					alert("PT 예외시간이 설정되었습니다.");
				}
			</script>
		</c:when>
	</c:choose>
    <style>

    /* body {
        margin: 40px 10px;
        padding: 0;
        font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
        font-size: 14px;
    } */

    #calendar {
        max-width: 1300px;
        margin: 0 auto;
    }

    </style>

    <title>TOFIT</title>
</head>

<body>
   	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
        <section class="mypage_head">
            <h1>MY PAGE</h1>
            <ul>
                <li class="present_page"><a href="${contextPath}/reserve/reserveInfo.do">예약내역</a></li>
                <li><a href="${contextPath}/payment/paymentInfo.do">결제내역</a></li>
                <li><a href="${contextPath}/profile/profileInfo.do">프로필</a></li>
            </ul>
        </section>
        <section class="mypage_reservation calendar_info">
            <h2>피트니스 캘린더</h2>
            <c:choose>
	            <c:when test="${ptResult==true}">
	       			<p><a href="${contextPath}/reserve/gotoReservePT.do" class="reservation_first">PT예약하기 &gt;</a></p>
	           		<p><a href="${contextPath}/reserve/gotoReserveCancel.do" class="reservation_second">PT예약 취소하기 &gt;</a></p>
	       		</c:when>
	       		<%-- <c:when test="${ptResult=='coach'}">
	       			<p><a href="${contextPath}/reserve/gotoReservePT.do" class="reservation_first">PT 예외시간 설정하기 &gt;</a></p>
	           		<p><a href="${contextPath}/reserve/gotoReserveCancel.do" class="reservation_second">PT 예외시간 관리하기 &gt;</a></p>
	       		</c:when> --%>				
            </c:choose>
       		
        </section>
        <section class="mypage_calendar calendar_info">
            <div id="calendar"></div>
        </section>
    </div>
       
    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>