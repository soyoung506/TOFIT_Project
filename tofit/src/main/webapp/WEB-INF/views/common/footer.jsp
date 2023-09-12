<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOFIT</title>
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
	<footer>
		<div id="footer_top">
			<div class="footrt_inner">
				<h2>
					<a href="${contextPath}/common/index.do"><img
						src="${contextPath}/resources/images/logo.png" alt="로고"></a>
				</h2>
				<ul>
					<li><a href="${contextPath }/center/centerMain.do">피트니스센터</a></li>
					<li><a href="${contextPath }/shop/listProduct.do">투핏쇼핑몰</a></li>
					<li><a href="${contextPath }/community/listCommu.do">소통게시판</a></li>
				</ul>
			</div>
		</div>
		<div id="footer_main">
			<div class="footer_menu">
				<ul>
					<li>tofit.co.kr</li>
					<li>이용약관</li>
					<li>개인정보 처리 방침</li>
					<li>고객센터</li>
				</ul>
			</div>
		</div>
		<div class="footer_copy">
			<span>투데이피트니스 주식회사</span> <span>투데이피트니스 주식회사</span> <span>고객센터
				1599-3709 (평일 09:00~18:00 / 점심시간 12:00~13:00 / 주말 및 공휴일 휴무)</span> <br>
			<span>사업자등록번호 220-88-38020</span> <span>호스팅서비스제공자 : 마이크로소프트
				유한회사, 구글클라우드코리아 유한회사, 아마존웹서비시즈코리아 유한회사</span> <br>
			<address>서울특별시 종로구 종로 78 (종로2가, 미려빌딩 3층)</address>
		</div>
	</footer>
</body>
</html>