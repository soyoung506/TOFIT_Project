<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="${contextPath}/resources/css/sub_indexshop02.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
function fn_deleteCarts(odNum) {
	location.href='${contextPath}/shop/deleteCarts.do?odNum='+odNum;
}
function fn_order(orTotal) {
	if(${!empty cartsList}) {
		alert("주문이 완료되었습니다.감사합니다.");
		location.href='${contextPath}/shop/order.do?orTotal='+orTotal;
	}else {
		alert("장바구니에 상품이 없습니다.");
	}
	
}
</script>
<title>TOFIT</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="content">
		<div class="content_tit">
			<h2>
				<strong>KEEPFIT SHOP</strong>
			</h2>
			<p>🔥 WEICOME TO HELL 🔥</p>
		</div>
		
		<hr>
		
		<div id="contentsub">
			<h1>장바구니</h1>
			
			<hr>

			<table>
				<thead>
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>가격</th>
						<th>총 가격</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty cartsList}">
							<tr><td colspan=5 class="noProduct">장바구니에 상품이 없습니다.</td></tr>
						</c:when>
						<c:when test="${!empty cartsList}">
							<c:forEach items="${cartsList}" var="carts">
								<tr class="od">
									<td class="pIMG"><a href="${contextPath}/shop/productDetail.do?pNum=${carts.pNum}"><img src="${contextPath}/product?pImg1=${carts.pImg1}&pNum=${carts.pNum}" alt="장바구니 상품">${carts.pName}</a></td>
									<td>${carts.odCount}</td>
									<fmt:formatNumber var="pPrice" value="${carts.pPrice}" type="number" />
									<td>${pPrice}원</td>
									<fmt:formatNumber var="odPrice" value="${carts.odPrice}" type="number" />
									<td>${odPrice}원</td>
									<td><button type="button" class="button" onclick="fn_deleteCarts('${carts.odNum}')">삭제</button></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>

		<div id="contentsub2">
			<hr>
			<span>총 주문 상품 개수: ${total}</span>
			
			<c:set var="totalOrder" value="0" />
			<c:if test="${!empty cartsList}">
				<c:forEach items="${cartsList}" var="carts">
					<c:set var="totalOrder" value="${totalOrder+carts.odPrice}" />
				</c:forEach>
			</c:if>
			<fmt:formatNumber var="totalOrderFormat" value="${totalOrder}" type="number" />
			<span id="totalOrder">총 주문 금액: ${totalOrderFormat}원</span>
			<hr>
			<button id="order-button" onclick="fn_order('${totalOrder}')">주문하기</button>
			<a href="${contextPath}/shop/listProduct.do"><p>계속쇼핑하기</p></a>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>