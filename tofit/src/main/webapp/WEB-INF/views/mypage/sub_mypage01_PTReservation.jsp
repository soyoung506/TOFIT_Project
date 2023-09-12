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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage01_PTReservation.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script src='${contextPath}/resources/js/index.global.js'></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("input[name='ptTime']").change(function() {
    			var chooseTime=$("input[name='ptTime']:checked").val();
    			$('#chooseTime').text(chooseTime);
    		});
    	});
    
    	function reservePT(obj) {
    		if($('#chooseDate').text()=='----년 --월 --일') {
    			alert("날짜를 선택해 주세요.")
    		}else if($('#chooseTime').text()=='오전 --시') {
    			alert("시간을 선택해 주세요.")
    		}else {
				obj.submit();
    		}
		}
    	function backToReserveInfo(obj) {
    		obj.action="${contextPath}/reserve/reserveInfo.do";
    		obj.submit();
		}
    	
    	function getDisabledTimes(ptDate, chooseDate) {
    		let r_form=document.createElement("form");
    		r_form.setAttribute("method", "post");
    		r_form.setAttribute("action", "${contextPath}/reserve/gotoReservePT.do");
    		let inputptDate=document.createElement("input");
    		inputptDate.setAttribute("type", "hidden");
    		inputptDate.setAttribute("name", "ptDate");
    		inputptDate.setAttribute("value", ptDate);
    		r_form.appendChild(inputptDate);
    		let inputchooseDate=document.createElement("input");
    		inputchooseDate.setAttribute("type", "hidden");
    		inputchooseDate.setAttribute("name", "chooseDate");
    		inputchooseDate.setAttribute("value", chooseDate);
    		r_form.appendChild(inputchooseDate);
    		document.body.appendChild(r_form);
    		r_form.submit();
    	}
    </script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth'
        },
        navLinks: false, // can click day/week names to navigate views
        businessHours: true, // display business hours
        editable: false,
        selectable: true,
        select: function(arg) {
            // 날짜 클릭 시 이벤트 발생
            var date=arg.start;
            // 월 앞에 0붙이기
            function leftzero(value) {
            	if(value >= 10) {
            		return value;
            	}
            	var zeroValue='0'+value;
            	return zeroValue;
            }
            // 타입에 맞춰 년월일 받아오기
            var year=date.getFullYear();
            var month=leftzero(date.getMonth()+1);
            var day=leftzero(date.getDate());
            var ptDate=year+'-'+month+'-'+day;
            // input태그에 선택 날짜 세팅
            $('#ptDate').attr('value', ptDate);
            // 선택한 날짜 보여주기
            var yearKO=year+'년';
            var monthKO=month+'월';
            var dayKO=day+'일';
            var chooseDate=yearKO+' '+monthKO+' '+dayKO;
			
			getDisabledTimes(ptDate, chooseDate);
        },
        // locale: 'ko',
        events: [
            
        ]
        });

        calendar.render();
    });

    </script>
    <style>
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
        <section class="ptReserve_head">
        	<p><a class="back" href="${contextPath}/reserve/reserveInfo.do">&lt; 뒤로가기</a></p>
        	<c:choose>
        		<c:when test="${user=='coach'}">
        			<h1>PT 예외시간 설정</h1>
        		</c:when>
        		<c:when test="${user=='user'}">
        			<h1>PT 예약</h1>
        		</c:when>
        	</c:choose>
        </section>
        <section class="ptReserve_date">
            <h2>날짜 선택</h2>
            <div id="calendar"></div>
            <ul>
                <li>
                    <div class="chooseColor chooseToday"></div>
                    <span>오늘</span>
                </li>
           </ul>
           <c:choose>
        		<c:when test="${user=='coach'}">
        			<p>※ 예외설정시간 24시간 전부터 설정이 불가합니다.</p>
        		</c:when>
        		<c:when test="${user=='user'}">
        			<p>※ 예약시간 24시간 전부터 예약이 불가합니다.</p>
        		</c:when>
        	</c:choose>
        </section>
        <section class="ptReserve_time">
            <h2>시간 선택</h2>
            <form action="${contextPath}/reserve/reservePT.do" method="post" class="chooseTime" name="addPT">
            <c:choose>
               	<c:when test="${empty disabledTimes}">
             		<input type="radio" id="9t" value="오전 9시" name="ptTime"><label for="9t">9시</label>
	                <input type="radio" id="10t" value="오전 10시" name="ptTime"><label for="10t">10시</label>
	                <input type="radio" id="11t" value="오전 11시" name="ptTime"><label for="11t">11시</label>
	                <input type="radio" id="12t" value="오후 12시" name="ptTime"><label for="12t">12시</label>
	                <input type="radio" id="13t" value="오후 1시" name="ptTime"><label for="13t">13시</label>
	                <input type="radio" id="14t" value="오후 2시" name="ptTime"><label for="14t">14시</label>
	                <input type="radio" id="15t" value="오후 3시" name="ptTime"><label for="15t">15시</label>
	                <input type="radio" id="16t" value="오후 4시" name="ptTime"><label for="16t">16시</label>
	                <input type="radio" id="17t" value="오후 5시" name="ptTime"><label for="17t">17시</label>
	                <input type="radio" id="18t" value="오후 6시" name="ptTime"><label for="18t">18시</label>
	                <input type="radio" id="19t" value="오후 7시" name="ptTime"><label for="19t">19시</label>
	                <input type="radio" id="20t" value="오후 8시" name="ptTime"><label for="20t">20시</label>
	                <input type="radio" id="21t" value="오후 9시" name="ptTime"><label for="21t">21시</label>
	                <input type="radio" id="22t" value="오후 10시" name="ptTime"><label for="22t">22시</label>
                </c:when>
                <c:when test="${!empty disabledTimes}">
               		<c:forEach  var="i" begin="9" end="22" step="1">
               			<c:set var="disable" value="no" />
               			<c:choose>
               				<c:when test="${i<=11}">
               					
               					<c:set var="timeValue" value="오전 ${i}시" />
               				</c:when>
               				<c:when test="${i==12}">
               					<c:set var="timeValue" value="오후 ${i}시" />
               				</c:when>
               				<c:otherwise>
               					<c:set var="timeValue" value="오후 ${i-12}시" />
               				</c:otherwise>
               			</c:choose>
                		<c:forEach var="times" items="${disabledTimes}" >
                			<c:if test="${times==timeValue}">
	                			<input type="radio" id="${i}t" value="${disabledTimes}" name="ptTime" class="disabled" disabled><label for="${i}t">${i}시</label>
	                			<c:set var="disable" value="yes" />
                			</c:if>
                		</c:forEach>
                		<c:if test="${disable=='no'}">
                			<input type="radio" id="${i}t" value="${timeValue}" name="ptTime"><label for="${i}t">${i}시</label>
                		</c:if>
                	</c:forEach>
              	</c:when>
            </c:choose>
                <input type="hidden" id="ptDate" name="ptDate" value="${ptDate}">
            </form>
            <p class="rvChoose">PT 예약일 : 
            <c:choose>
            	<c:when test="${chooseDate==null || chooseDate.equals('')}">
            		<span id="chooseDate">----년 --월 --일 </span> 
            	</c:when>
            	<c:otherwise>
            		<span id="chooseDate">${chooseDate} </span> 
            	</c:otherwise>
            </c:choose>
            <span id="chooseTime">오전 --시</span></p>
            <button type="button" id="reserve" onclick="reservePT(addPT)">예약</button>
            <button type="button" id="cancel" onclick="backToReserveInfo(addPT)">취소</button>
        </section>
    </div>
       
    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>