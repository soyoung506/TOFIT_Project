<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="ptPaymentInfo" value="${paymentMap.ptPaymentInfo}"/>
<c:set var="orderList" value="${paymentMap.orderList}"/>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage02.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <title>TOFIT</title>
</head>

<body>
     <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
        <section class="mypage_head">
            <h1>MY PAGE</h1>
            <ul>
                <li><a href="${contextPath}/reserve/reserveInfo.do">예약내역</a></li>
                <li class="present_page"><a href="${contextPath}/payment/paymentInfo.do">결제내역</a></li>
                <li><a href="${contextPath}/profile/profileInfo.do">프로필</a></li>
            </ul>
        </section>
        <section class="mypage_fitness payment_info">
            <h2>PT 이용권 구매 내역</h2>
            <p><a href="${contextPath}/payment/ptPayment.do">구매 내역 더보기 &gt;</a></p>
            <table>
                <thead>
                    <tr class="payment_tblHead">
                        <th>피트니스 센터</th>
                        <th>구매한 이용권</th>
                        <th>남은 횟수</th>
                        <th>결제 일시</th>
                    </tr>
                </thead>
                <tbody>
                	<c:choose>
                  		<c:when test="${empty ptPaymentInfo}">
	                  		<tr>
		                        <td colspan=4>이용중인 PT 이용권이 없습니다.</td>
		                    </tr>
                  		</c:when>
                  		<c:when test="${!empty ptPaymentInfo}">
                  			<tr>
		                        <td class="cenName">${ptPaymentInfo.cenName}</td>
		                        <td class="ptPeriod">${ptPaymentInfo.ptPeriod} ${ptPaymentInfo.ptCount}회</td>
		                        <td class="ptRemain">${ptPaymentInfo.ptRemain}회</td>
		                        <td class="ptPaydate">${ptPaymentInfo.ptPaydate}</td>
		                    </tr>
                  		</c:when>
                  	</c:choose>
                </tbody>
            </table>
        </section>
        <section class="mypage_healthfood payment_info">
            <h2>상품 구매 내역</h2>
            <p><a href="${contextPath}/payment/productPayment.do">구매 내역 더보기 &gt;</a></p>
            <table>
                <thead>
                    <tr class="payment_tblHead">
                        <th>상품</th>
                        <th>결제 금액</th>
                        <th>배송 상태</th>
                        <th>결제 일시</th>
                    </tr>
                </thead>
                <tbody>
                	<c:choose>
                  		<c:when test="${empty orderList}">
	                  		<tr>
		                        <td colspan=4>구매한 상품이 없습니다.</td>
		                    </tr>
                  		</c:when>
                  		<c:when test="${!empty orderList}">
                  			<c:forEach var="order" items="${orderList}" >
                  				<tr>
                  					<c:choose>
                  						<c:when test="${order.orCount==1}">
                  							<td class="odTitle">${order.pName}</td>
                  						</c:when>
                  						<c:otherwise>
					                        <td class="odTitle">${order.pName} 외 ${order.orCount-1}개</td>
                  						</c:otherwise>
                  					</c:choose>
                  					<fmt:formatNumber var="orTotal" value="${order.orTotal}" type="number" />
			                        <td class="orTotal">${orTotal}원</td>
			                        <td class="orResult">${order.orResult}</td>
			                        <td class="orDate">${order.orDate}</td>
			                    </tr>
                  			</c:forEach>
                  		</c:when>
                  	</c:choose>
                </tbody>
            </table>
        </section>
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>