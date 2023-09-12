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
<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/login.js"></script>
<title>TOFIT</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div class="login">
			<div class="login_inner">
				<h3>
					<img src="${contextPath}/resources/images/login.svg" alt="login">
					오늘도 함께 투핏!
				</h3>
				<div class="login_btn2">
					<div class="btn_inner">
						<a id="kakao-login-btn" href="${contextPath }/member/kitlogin.do">
							<span>투핏 로그인</span>
						</a>
					</div>
				</div>
				<br> <br> <br> <br> <span class="keepfit_login">
					투핏에 오신것을 환영합니다. </span>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>