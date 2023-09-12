<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/index.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/index.js"></script>
<script>
	(function() {
		var w = window;
		if (w.ChannelIO) {
			return w.console.error("ChannelIO script included twice.")
		}
		var ch = function() {
			ch.c(arguments)
		};
		ch.q = [];
		ch.c = function(args) {
			ch.q.push(args)
		};
		w.ChannelIO = ch;
		function l() {
			if (w.ChannelIOInitialized) {
				return
			}
			w.ChannelIOInitialized = true;
			var s = document.createElement("script");
			s.type = "text/javascript";
			s.async = true;
			s.src = "https://cdn.channel.io/plugin/ch-plugin-web.js";
			var x = document.getElementsByTagName("script")[0];
			if (x.parentNode) {
				x.parentNode.insertBefore(s, x)
			}
		}
		if (document.readyState === "complete") {
			l()
		} else {
			w.addEventListener("DOMContentLoaded", l);
			w.addEventListener("load", l)
		}
	})();
	ChannelIO('boot', {
		"pluginKey" : "4719cc3a-a174-407b-8c4c-79697be92e42"
	});
</script>
<c:choose>
	<c:when test="${msg=='removeUser'}">
		<script>
			window.onload = function() {
				alert("회원탈퇴 되었습니다. 감사합니다.");
			}
		</script>
	</c:when>
</c:choose>
<title>TOFIT</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<body>
	<div id="content">
		<div id="main">
			<div id="main_inner">
				<div class="video">
					<video class="video_in" autoplay muted loop>
						<source
							src="${contextPath}/resources/images/SnapInsta.io-필라테스, 요가 영상 _ Pilates, Yoga Cinematic 4K-(1080p).mp4">
					</video>
				</div>
				<h1>
					<span class="big_tit1">간편한</span> <span class="big_tit2">피트니스
						서비스,<b> 투핏</b>
					</span>
				</h1>
				<P>
					<span class="small_tit1">온라인 <b>PT 예약,</b></span> <span
						class="small_tit1"><b>투핏</b>에서 지금 시작하세요.👍🏻</span>
				</P>
				<a class="cta1" href="${contextPath }/center/centerMain.do">PT
					이용권 구매</a>
				<%
				if (session.getAttribute("isLogon") == null || session.getAttribute("isLogon") == "") {
				%>
				<a class="cta2" href="${contextPath }/member/login.do">나의 피트니스
					서비스</a>
				<%
				} else {
				%>
				<a class="cta2" href="${contextPath }/reserve/reserveInfo.do">나의
					피트니스 서비스</a>
				<%
				}
				%>
			</div>
		</div>
		<div id="bg">
			<div id="big_title">
				<div class="tit_inner">
					<h3>
						<span class="bigt1">나의 PT 예약 현황을 한 눈에 확인하고 싶다면,</span> <span
							class="bigt2"><b>투핏</b> 피트니스 서비스를 시작하세요!</span>
					</h3>
					<img src="${contextPath}/resources/images/thinking.svg" alt="이모지">
					<p>
						<span class="t1">'오늘이 몇 회째지?' 고민은 그만!</span> <span class="t2">PT
							구매내역, 잔여횟수, 예약현황까지</span> <span class="t3">나만의 PT예약 관리 서비스를 만나보세요</span>
					</p>
				</div>
			</div>
			<div id="product">
				<div class="product_inner">
					<h6>피트니스 서비스의 기준, 투핏</h6>
					<h4>
						<span class="product_t1">PT 등록만 하면 끝?</span> <span
							class="product_t2">피트니스 서비스란 이런 것!</span>
					</h4>
					<p>
						<span class="product_t3">등록된 피트니스 센터에서 PT 이용권을 구매하세요.</span> <span
							class="product_t4">구매한 PT 이용권에 따라 나만의 PT일정을 예약하세요.</span> <span
							class="product_t5">일정에 문제가 생겼나요? 예약된 PT일정을 취소해 보세요.</span> <span
							class="product_t6">투핏 피트니스 서비스를 통해 PT일정을 관리하면,</span> <span
							class="product_t7"><b>나의 PT일정을 한 눈에 확인할 수 있습니다!</b></span>
					</p>
					<img class="product_pig1"
						src="${contextPath}/resources/images/1img.jpeg" alt="운동"> <img
						class="product_pig2"
						src="${contextPath}/resources/images/2im.jpeg" alt="운동">
				</div>
			</div>
			<div id="box_content">
				<div class="box1">
					<h6>투핏 제휴 피트니스 센터</h6>
					<h4>
						<span class="box1_t1">시설 좋은</span> <span class="box1_t2">피트니스
							센터를 찾으시나요?</span>
					</h4>
					<p>
						<span class="box_t3">투핏이 엄선한 피트니스 센터!</span> <span class="box_t4">청결하고
							최신형 기구로 가득한</span> <span class="box_t5">피트니스 센터만 모았습니다.</span>
					</p>
					<span class="box_t6">전문성을 갖출 코치 선생님과 함께라면</span> <b>누구나 목표 달성
						성공!</b> <img class="box1_pic"
						src="${contextPath}/resources/images/fitnessCenter.jpg"
						alt="피트니스센터">
				</div>
				<div class="box3">
					<h6>식단 고민은 끝! 투핏쇼핑몰</h6>
					<h4>
						<span class="box3_t1">전용 쇼핑몰이</span> <span class="box3_t1">마침내
							등장</span>
					</h4>
					<p>
						<span class="box3_t2"><b>운동과 식단</b>까지 </span> <span
							class="box3_t3">한번에 조절 가능하게</span> <span class="box3_t4">만들어진
							쇼핑몰</span> <span class="box3_t5">바로 투핏쇼핑몰입니다.</span> <span
							class="box3_t6">투핏쇼핑몰을 이용해</span> <span>운동뿐만 아닌 식단까지</span> <span>관리해보세요.</span>
					</p>
					<img class="box3_pig"
						src="${contextPath}/resources/images/shop.jpg" alt="음식"> <img
						class="box3_pig2" src="${contextPath}/resources/images/shop2.jpg"
						alt="음식">
				</div>
				<div class="box2">
					<h6>꿀팁 가득 소통게시판</h6>
					<h4>
						<span class="box2_t1">투핏에서</span> <span class="box2_t2">얻을
							수 있는</span> <span class="box2_t3">다양한 운동 꿀팁!</span>
					</h4>
					<p>
						<span class="box2_t4">운동하면서 생기는</span> <span class="box2_t4">다양한
							궁금증을 <b>소통게시판</b>에서 해결해 보세요!
						</span> <span class="box2_t4">전문성을 갖춘 코치 선생님과도</span> <span
							class="box2_t4">자유롭게 소통할 수 있습니다!</span>
					</p>
				</div>
				<img class="box2_pig1"
					src="${contextPath}/resources/images/discuss.png" alt="소통">
			</div>
			<div id="content_program">
				<div class="program_inner">
					<h3>
						<span class="program_t1">당신에게 FIT한</span> <span class="program_t1">투핏
							서비스는?</span>
					</h3>
					<p>
						건강한 몸 만들기, <br> 지금 투핏에서 시작하세요.
					</p>
					<div class="program_content">
						<div class="program_box1">
							<h4>
								<span>투핏</span> <span><b>피트니스 서비스</b></span> <small>간편한
									PT 관리</small>
							</h4>
							<ul>
								<li>온라인으로 PT 이용권 구매</li>
								<li>나의 일정에 맞춰 PT일정 예약 및 취소</li>
								<li>한 눈에 확인하는 나의 PT일정</li>
								<li>복잡한 절차 없이 PT 이용권 환불</li>
								<li>전문성을 갖춘 코치 선생님과 PT</li>
							</ul>
							<%
							if (session.getAttribute("isLogon") == null || session.getAttribute("isLogon") == "") {
							%>
							<a class="program_btn1" href="${contextPath }/member/login.do">나의
								피트니스 서비스</a>
							<%
							} else {
							%>
							<a class="program_btn1" href="${contextPath }/reserve/reserveInfo.do">나의
								피트니스 서비스</a>
							<%
							}
							%>
							<img class="program_pig1"
								src="${contextPath}/resources/images/mypageCalendar.png" alt="마이페이지">
						</div>
						<div class="program_box2">
							<h4>
								<span>투핏</span> <span><b>쇼핑몰</b></span> <small>간편한 헬스식품 구매</small>
							</h4>
							<ul>
								<li>다양한 헬스식품</li>
								<li>부족한 영양소를 채움</li>
								<li>맛과 건강을 함께</li>
								<li>투핏이 선정한 질리지 않는 헬스식품</li>
							</ul>
							<a class="program_btn2" href="${contextPath}/shop/listProduct.do">투핏쇼핑몰로 이동</a> <img
								class="program_pig2"
								src="${contextPath}/resources/images/shop2.jpg" alt="헬스식품">
						</div>
					</div>
				</div>
			</div>
			<div id="last_banner">
				<div class="last_inner">
					<h3>
						<span>지금 바로 시작하세요!</span>
					</h3>
					<img class="last"
						src="${contextPath}/resources/images/emoji_cool_b.svg" alt="이모티콘">
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>