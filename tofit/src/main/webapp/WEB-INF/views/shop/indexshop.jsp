<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="productList" value="${proMap.productList}" />
<c:set var="totalProduct" value="${proMap.totalProduct}" />
<c:set var="section" value="${proMap.section}" />
<c:set var="pageNum" value="${proMap.pageNum}" />
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
<link rel="stylesheet" href="${contextPath}/resources/css/indexshop.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
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


		<div class="slider">
			<input type="radio" name="slide" id="slide1" checked> <input
				type="radio" name="slide" id="slide2"> <input type="radio"
				name="slide" id="slide3">
			<ul id="imgholder" class="imgs">
				<li><img src="${contextPath}/resources/images/이벤트배너.jpg"
					alt="이벤트"></li>
				<li><img src="${contextPath}/resources/images/이벤트배너2.jpg"
					alt="이벤트"></li>
				<li><img src="${contextPath}/resources/images/이벤트배너3.jpg"
					alt="이벤트"></li>
			</ul>
			<div class="bullets">
				<label for="slide1">&nbsp;</label> <label for="slide2">&nbsp;</label>
				<label for="slide3">&nbsp;</label>
			</div>
		</div>


		<div class="content_shop">
			<c:choose>
				<c:when test="${empty productList}">
					<p class="noProduct">상품이 없습니다.</p>
				</c:when>
				<c:when test="${!empty productList}">
					<c:forEach items="${productList}" var="product">
						<div class="box">
							<a href="${contextPath}/shop/productDetail.do?pNum=${product.pNum}"> <img class="img"
								src="${contextPath}/product?pImg1=${product.pImg1}&pNum=${product.pNum}" alt="${product.pName}">
							</a>
							<h2 class="heading">${product.pName}</h2>

							<div class="data">
								<fmt:formatNumber var="pPrice" value="${product.pPrice}" type="number" />
								<span class="user-id">${pPrice}원</span>
							</div>
							<p class="texts">${product.pCon}</p>
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>


		<div class="pageBtn">
			<ul class="ulBtn">
				<c:if test="${totalProduct !=0}">
					<c:if test="${totalProduct%12==0}">
						<c:set var="totalProduct" value="${totalProduct-1}" />
					</c:if>
					<fmt:parseNumber var="total" value="${totalProduct/60+1}" integerOnly="true" />
					<c:choose>
						<c:when test="${section > 1}">
							<li class="previous_btn"><a
								href="${contextPath}/center/centerMain.do?section=${section-1}&pageNum=5">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li class="previous_btn">&lt;</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${section==total}">
							<c:forEach var="page" begin="1" end="${(totalProduct-(60*(section-1)))/12+1}" step="1">
								<c:choose>
									<c:when test="${page==pageNum}">
										<li class="present_btn"><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="page" begin="1" end="5" step="1">
								<c:choose>
									<c:when test="${page==pageNum}">
										<li class="present_btn"><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
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
							<li class="next_btn"><a
								href="${contextPath}/center/centerMain.do?section=${section+1}&pageNum=1">&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</ul>
		</div>


	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>

</html>