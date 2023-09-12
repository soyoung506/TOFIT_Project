<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="centerVO" value="${cenDetailMap.centerVO}" />
<c:set var="ptList" value="${cenDetailMap.ptList}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/moreCener.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<!-- <link rel="stylesheet" href="./css/index.css"> -->
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/more_center.js"></script>
<script src="${contextPath}/resources/js/center_main.js"></script>
<script src="https://kit.fontawesome.com/563943ce4b.js"
	crossorigin="anonymous"></script>
<title>TOFIT</title>
</head>
<body>
	<!-- header 시작 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<!-- header 종료 -->
	<div id="content">
		<div id="wrap">
			<div id="right_content">
				<div class="animation_canvas">
					<div class="slider_panel">
						<img class="slider_image" src="${centerVO.thumbnail}"
							alt="${centerVO.thumbnail}">
						<!--썸네일-->
					</div>
				</div>
				<div class="sec_introduce"></div>
			</div>
			<div class="offline">
				<h2>오프라인 시설 이용권</h2>
				<span>편리하게 온라인에서 구매하고 오프라인 시설을 이용하세요!</span>
				<c:forEach items="${ptList}" var="ptList">
					<div class="order_box2">
						<div class="num_count">
							<p>횟수</p>
						</div>
						<p class="order_box_t">
							<span class="big_span">${ptList.ptCount}회/${ptList.ptPeriod}
								이용권 - </span><span class="small_span">${ptList.ptCount}회/${ptList.ptPeriod}</span>
						</p>
						<fmt:formatNumber var="ptPrice" value="${ptList.ptPrice}"
							type="number" />
						<span class="price">${ptPrice}원</span> <a class="go_order"
							href="${contextPath}/center/ptPurchase.do?ptNo=${ptList.ptNo}">구매하기</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="second_section">
			<div class="r_introduce">
				<h2>시설 안내</h2>
				<ul>
					<li class="center_name">${centerVO.cenName}</li>
					<li class="center_address">${centerVO.cenAddress}</li>
					<li class="center_time"><span>운영시간</span><br>${centerVO.cenTime}</li>
					<li class="center_call"><span>전화</span><br>
						${centerVO.cenTel}</li>
				</ul>
			</div>
		</div>
	</div>
	<!--오른쪽 구역-->
	<div class="see_more">
		<div class="more_first">
			<p>
				운동 전문가님, 시설 운영자님 <br> 투핏과 함께하고 싶으신가요?
			</p>
			<a href="#">더 알아보기</a>
		</div>
		<div class="more_sec">
			<p>
				투핏의 프로그램은<br> 이렇게 진행됩니다.
			</p>
			<a href="#">더 알아보기</a>
		</div>
	</div>
	<!-- footer 시작 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>

</html>