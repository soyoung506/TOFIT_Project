<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOFIT</title>
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
</head>
<body>
	<header>
		<div id="head_inner">
			<nav>
				<h1>
					<a href="${contextPath}/common/index.do"> <img
						src="${contextPath}/resources/images/logo.png" alt="로고"></a>
				</h1>
				<div class="gnb_inner">
					<ul>
						<li><a href="${contextPath }/center/centerMain.do">피트니스센터</a></li>
						<li><a href="${contextPath }/shop/listProduct.do">투핏쇼핑몰</a></li>
						<li><a href="${contextPath }/community/listCommu.do">소통게시판</a></li>
					</ul>
				</div>
				<div class="login_btn">
					<ul>
						<%
						if (session.getAttribute("isLogon") == null || session.getAttribute("isLogon") == "") {
						%>
						<li><a href="${contextPath }/member/kitresister.do">회원가입</a></li>
						<li><a href="${contextPath }/member/login.do">로그인</a></li>
						<%
						} else {
						%>
						<li><a href="${contextPath }/reserve/reserveInfo.do">마이페이지</a></li>
						<li><a href="${contextPath }/shop/listCarts.do">장바구니</a></li>
						<li><a href="${contextPath }/common/logout.do">로그아웃</a></li>
						<%
						}
						%>
					</ul>
				</div>
			</nav>
		</div>
	</header>
</body>
</html>