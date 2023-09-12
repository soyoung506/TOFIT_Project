<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="productList" value="${productMap.productList}"/>
<c:set var="productTotal" value="${productMap.productTotal}"/>
<c:set var="section" value="${productMap.section}"/>
<c:set var="pageNum" value="${productMap.pageNum}"/>
<c:set var="startDate" value="${productMap.startDate}"/>
<c:set var="endDate" value="${productMap.endDate}"/>
<c:set var="period" value="${productMap.period}"/>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage02_productPurchaseList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script type="text/javascript">
    	function periodSearch(obj) {
    		var start=document.getElementById("startDate").value;
    		var end=document.getElementById("endDate").value;
    		var period=$('input[name=period]:checked').length;
    		
    		if(start!="" && end=="") {
    			alert('종료일을 설정해 주세요.');
    		}else if(start=="" && end!="") {
    			alert('시작일을 설정해 주세요.');
    		}else if(start=="" && end=="" && period==0) {
    			alert('기간을 설정해 주세요.');
    		}else {
	    		obj.submit();
    		}
    	}
    
    </script>
    <title>TOFIT</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	
    <div id="content">
        <section class="purchaseList_head">
        	<p><a class="back" href="${contextPath}/payment/paymentInfo.do">&lt; 뒤로가기</a></p>
            <h1>상품 구매 내역</h1>
            <form action="${contextPath}/payment/productPayment.do" method="get">
                <ul>
                    <li>기간검색</li>
                    <li>
                        <label for="startDate" class="blind">시작일설정</label>
                        <input type="date" class="startDate" id="startDate" name="startDate">
                        <span> &#126; </span>
                        <label for="endDate" class="blind">종료일설정</label>
                        <input type="date" class="endDate" id="endDate" name="endDate">
                    </li>
                    <li>
                    	<input type="radio" id="fullPeriod" value="fullPeriod" name="period"><label for="fullPeriod">전체</label>
                    	<input type="radio" id="halfPeriod" value="halfPeriod" name="period"><label for="halfPeriod">15일</label>
                    	<input type="radio" id="onePeriod" value="onePeriod" name="period"><label for="onePeriod">1개월</label>
                    	<input type="radio" id="threePeriod" value="threePeriod" name="period"><label for="threePeriod">3개월</label>
                    	<input type="radio" id="sixPeriod" value="sixPeriod" name="period"><label for="sixPeriod">6개월</label>
                    </li>
                    <li>
                        <button type="button" class="search_period" onclick="periodSearch(this.form)">검색</button>
                    </li>
                </ul>
            </form>
        </section>
        <section class="purchaseList_body">
            <h2 class="blind">검색된 상품 구매 내역</h2>
            <ul>
                <li class="list_title">
                    <ul class="list_head">
                        <li class="orderNumber">주문번호</li>
                        <li class="orderProduct">상품</li>
                        <li class="orderState">배송상태</li>
                        <li class="orderPayment">결제수단</li>
                        <li class="orderSum">결제금액</li>
                        <li class="orderDate">결제일시</li>
                    </ul>
                </li>
                <c:choose>
                 	<c:when test="${empty productList}">
                  		<li class="noList">
	                        구매한 상품이 없습니다.
	                    </li>
                 	</c:when>
                 	<c:when test="${!empty productList}">
                 		<c:forEach var="pdList" items="${productList}" >
	                 		<li><a href="${contextPath}/payment/productPayDetail.do?orNum=${pdList.orNum}">
			                    <ul class="searchedList">
			                        <li class="orderNumber">${pdList.orNum}</li>
			                        <c:choose>
	                 					<c:when test="${pdList.orCount==1}">
	                 						<li class="orderProduct">${pdList.pName}</li>
	                 					</c:when>
	                 					<c:otherwise>
	                 						<li class="orderProduct">${pdList.pName} 외 ${pdList.orCount-1}개</li>
	                 					</c:otherwise>
	                 				</c:choose>
			                        <li class="orderState">${pdList.orResult}</li>
			                        <li class="orderPayment">${pdList.orPayment}</li>
			                        <fmt:formatNumber var="orTotal" value="${pdList.orTotal}" type="number" />
			                        <li class="orderSum">${orTotal}원</li>
			                        <li class="orderDate">${pdList.orDate}</li>
			                    </ul>
			                </a></li>
                 		</c:forEach>
                 	</c:when>
                </c:choose>
            </ul>
            <div class="pageBtn">
               	<ul class="ulBtn">
	                <c:if test="${productTotal !=0}">
	                	<c:if test="${productTotal%5==0}">
							<c:set var="productTotal" value="${productTotal-1}" />
						</c:if>
						<fmt:parseNumber var="total" value="${productTotal/25+1}" integerOnly="true" />
               			<c:choose>
              					<c:when test="${section > 1}">
              						<li class="previous_btn"><a href="${contextPath}/payment/productPayment.do?section=${section-1}&pageNum=5&startDate=${startDate}&endDate=${endDate}&period=${period}">&lt;</a></li>
              					</c:when>
              					<c:otherwise>
              						<li class="previous_btn">&lt;</li>
              					</c:otherwise>
              				</c:choose>
              				<c:choose>
              					<c:when test="${section==total}">
              						<c:forEach var="page" begin="1" end="${(productTotal-(25*(section-1)))/5+1}" step="1">
	                				<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn" ><a href="${contextPath}/payment/productPayment.do?section=${section}&pageNum=${page}&startDate=${startDate}&endDate=${endDate}&period=${period}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${contextPath}/payment/productPayment.do?section=${section}&pageNum=${page}&startDate=${startDate}&endDate=${endDate}&period=${period}">${(section-1)*5+page}</a></li>
										</c:otherwise>
									</c:choose>
	                			</c:forEach>
              					</c:when>
              					<c:otherwise>
              						<c:forEach var="page" begin="1" end="5" step="1">
	                				<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn" ><a href="${contextPath}/payment/productPayment.do?section=${section}&pageNum=${page}&startDate=${startDate}&endDate=${endDate}&period=${period}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${contextPath}/payment/productPayment.do?section=${section}&pageNum=${page}&startDate=${startDate}&endDate=${endDate}&period=${period}">${(section-1)*5+page}</a></li>
										</c:otherwise>
									</c:choose>
	                			</c:forEach>
              					</c:otherwise>
              				</c:choose>
               			<c:choose>
              					<c:when test="${section==total}">
              						<li class="next_btn">&gt;</li>
              					</c:when>
              					<c:otherwise>
              						<li class="next_btn"><a href="${contextPath}/payment/productPayment.do?section=${section+1}&pageNum=1&startDate=${startDate}&endDate=${endDate}&period=${period}">&gt;</a></li>
              					</c:otherwise>
               			</c:choose>
	                </c:if>
	            </ul>
	        </div>
        </section>
        
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>