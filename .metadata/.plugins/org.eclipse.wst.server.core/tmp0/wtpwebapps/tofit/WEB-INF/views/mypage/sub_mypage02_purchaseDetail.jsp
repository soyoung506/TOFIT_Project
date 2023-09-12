<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="payDetail" value="${prodpayDetail.payDetail}"/>
<c:set var="ProdDetailList" value="${prodpayDetail.ProdDetailList}"/>
<fmt:formatNumber var="orTotal" value="${payDetail.orTotal}" type="number" />
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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage02_purchaseDetail.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script type="text/javascript">
    	function refund(url, orNum) {
    		var result=confirm('부분환불은 불가합니다. 전체환불을 진행하시겠습니까?')
    		
    		if(result) {
    			let r_form=document.createElement("form");
        		r_form.setAttribute("method", "post");
        		r_form.setAttribute("action", url);
        		let inputOrNum=document.createElement("input");
        		inputOrNum.setAttribute("type", "hidden");
        		inputOrNum.setAttribute("name", "orNum");
        		inputOrNum.setAttribute("value", orNum);
        		r_form.appendChild(inputOrNum);
        		document.body.appendChild(r_form);
        		r_form.submit();
    		}else {
    			
    		}
    		
    	}
    </script>
    <c:choose>
    	<c:when test="${msg=='refund'}">
			<script>
				window.onload=function () {
					alert("환불되었습니다.");
				}
			</script>
		</c:when>
	</c:choose>
    <title>TOFIT</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	
    <div id="content">
        <section class="order_head">
        	<p><a class="back" href="${contextPath}/payment/productPayment.do">&lt; 뒤로가기</a></p>
            <h1>상품 구매 상세 내역</h1>
        </section>
        <section class="order_info orderDetail">
            <h2>주문정보</h2>
            <table>
                <tr>
                    <th>주문번호</th>
                    <td>${payDetail.orNum}</td>
                </tr>
                <tr>
                    <th>주문일자</th>
                    <td>${payDetail.orDate}</td>
                </tr>
                <tr>
                    <th>주문자</th>
                    <td>${payDetail.id}</td>
                </tr>
                <tr>
                    <th>주문처리상태</th>
                    <td>${payDetail.orResult}</td>
                </tr>
            </table>
        </section>
        <section class="pay_info orderDetail">
            <h2>결제정보</h2>
            <table>
                <tr class="totalPay">
                    <th>총 결제금액</th>
                    <td>${orTotal}원</td>
                </tr>
                <tr>
                    <th>결제수단</th>
                    <td>${payDetail.orPayment}</td>
                </tr>
            </table>
        </section>
        <section class="orderProduct_info">
            <h2>주문 상품 정보</h2>
            <table>
                <tr class="orderProduct_tblTitle">
                    <th>이미지</th>
                    <th>상품정보</th>
                    <th>수량</th>
                    <th>판매가</th>
                </tr>
                <c:forEach var="product" items="${ProdDetailList}" >
      				<tr>
                        <td><img src="${contextPath}/product?pImg1=${product.pImg1}&pNum=${product.pNum}" alt="상품 이미지"></td>
	                    <td class="proName">${product.pName}</td>
	                    <td>${product.odCount}</td>
	                    <fmt:formatNumber var="pPrice" value="${product.pPrice}" type="number" />
	                    <td>${pPrice}원</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
        <section class="delivery_info orderDetail">
            <h2>배송지정보</h2>
            <table>
                <tr>
                    <th>받으시는 분</th>
                    <td>${payDetail.id}</td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>${payDetail.orAddress}</td>
                </tr>
                <tr>
                    <th>휴대전화</th>
                    <td>${payDetail.orPhone}</td>
                </tr>
                <tr>
                    <th>배송메시지</th>
                    <td>${payDetail.orRequest}</td>
                </tr>
            </table>
            <p>
	         	<c:choose>
	         		<c:when test="${payDetail.orResult!='환불'}">
	         	        <button class="order_refund" onclick="refund('${contextPath}/payment/refundPay.do', ${payDetail.orNum})">환불</button>
	         		</c:when>
	         	</c:choose>
	    	</p>
        </section>
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>