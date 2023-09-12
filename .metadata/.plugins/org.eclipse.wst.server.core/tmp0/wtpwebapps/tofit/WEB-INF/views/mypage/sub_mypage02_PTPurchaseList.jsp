<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="ptList" value="${ptMap.ptList}"/>
<c:set var="ptTotal" value="${ptMap.ptTotal}"/>
<c:set var="section" value="${ptMap.section}"/>
<c:set var="pageNum" value="${ptMap.pageNum}"/>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage02_PTPurchaseList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script type="text/javascript">
    	function refund(obj) {
    		var result=confirm('남은 이용권횟수에 해당하는 금액에서 10%의 수수료를 제외한 금액이 환불됩니다. \n환불하시겠습니까?')
    		if(result) {
	    		obj.submit();
    		}else {
    			
    		}
		}
    	
    </script>
    <c:choose>
    	<c:when test="${msg=='ptRefund'}">
			<script>
				window.onload=function () {
					alert("PT이용권이 환불되었습니다.");
				}
			</script>
		</c:when>
	</c:choose>
    <title>TOFIT</title>
</head>

<body>
 <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
        <section class="purchaseList_head">
        	<p><a class="back" href="${contextPath}/payment/paymentInfo.do">&lt; 뒤로가기</a></p>
            <h1>PT 이용권 구매 내역</h1>
        </section>
        <section class="purchaseList_body">
            <h2 class="blind">PT 이용권 구매 내역</h2>
            <form action="${contextPath}/payment/ptRefund.do" method="get">
            <p>
                <button type="button" class="membership_refund" onclick="refund(this.form)">환불</button>
            </p>
            <ul class="list_head">
                <li class="PTCheckbox">
                	&#32;
                </li>
                <li class="PTNumber">구매번호</li>
                <li class="PTCenter">피트니스 센터</li>
                <li class="PTMembership">구매한 이용권</li>
                <li class="PTRemain">남은 횟수</li>
                <li class="PTPayment">결제수단</li>
                <li class="PTSum">결제금액</li>
                <li class="PTDate">결제일시</li>
            </ul>
            <c:choose>
              	<c:when test="${empty ptList}">
              		<ul class="noList">
	                	구매한 PT이용권이 없습니다.
	            	</ul>
             	</c:when>
              	<c:when test="${!empty ptList}">
              		<c:forEach var="ptList" items="${ptList}" >
		              	<ul class="searchedList">
		              		<c:choose>
		              			<c:when test="${ptList.ptRemain==0}">
		              				<li class="PTCheckbox">
					                    &#32;
					                </li>
		              			</c:when>
		              			<c:otherwise>
        						   <li class="PTCheckbox">
					                    <label for="membership_check"></label>
					                    <input type="checkbox" name="checkedPT" value="${ptList.ptPaynum}" id="membership_check" class="checkIndi">
					                </li>
		              			</c:otherwise>
		              		</c:choose>
			                <li class="PTNumber">${ptList.ptPaynum}</li>
			                <li class="PTCenter">${ptList.cenName}</li>
			                <li class="PTMembership">${ptList.ptPeriod} ${ptList.ptCount}회</li>
			                <c:choose>
			                	<c:when test="${ptList.ptRefund=='y'}">
			                		<li class="PTRemain">환불</li>
			                	</c:when>
			                	<c:otherwise>
			                		<li class="PTRemain">${ptList.ptRemain}</li>
			                	</c:otherwise>
			                </c:choose>
			                
			                <li class="PTPayment">${ptList.ptPayment}</li>
			                <fmt:formatNumber var="ptSum" value="${ptList.ptSum}" type="number" />
			                <li class="PTSum">${ptSum}원</li>
			                <li class="PTDate">${ptList.ptPaydate}</li>
			            </ul>
            		</c:forEach>
            	</c:when>
            </c:choose>
            </form>
            <div class="pageBtn">
               	<ul class="ulBtn">
	                <c:if test="${ptTotal !=0}">
	                	<c:if test="${ptTotal%5==0}">
							<c:set var="ptTotal" value="${ptTotal-1}" />
						</c:if>
						<fmt:parseNumber var="total" value="${ptTotal/25+1}" integerOnly="true" />
               			<c:choose>
              					<c:when test="${section > 1}">
              						<li class="previous_btn"><a href="${contextPath}/payment/ptPayment.do?section=${section-1}&pageNum=5">&lt;</a></li>
              					</c:when>
              					<c:otherwise>
              						<li class="previous_btn">&lt;</li>
              					</c:otherwise>
              				</c:choose>
              				<c:choose>
              					<c:when test="${section==total}">
              						<c:forEach var="page" begin="1" end="${(ptTotal-(25*(section-1)))/5+1}" step="1">
	                				<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn" ><a href="${contextPath}/payment/ptPayment.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${contextPath}/payment/ptPayment.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:otherwise>
									</c:choose>
	                			</c:forEach>
              					</c:when>
              					<c:otherwise>
              						<c:forEach var="page" begin="1" end="5" step="1">
	                				<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn" ><a href="${contextPath}/payment/ptPayment.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${contextPath}/payment/ptPayment.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
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
              						<li class="next_btn"><a href="${contextPath}/payment/ptPayment.do?section=${section+1}&pageNum=1">&gt;</a></li>
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