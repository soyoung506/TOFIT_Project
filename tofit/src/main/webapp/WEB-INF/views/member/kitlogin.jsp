<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/kit.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<c:if test="${result == 'loginFailed'}">
	<script>
		window.onload=function(){
		alert("로그인 정보가 일치하지 않습니다. 다시 입력해 주세요 "); }
	</script>
</c:if>
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/kitlogin.js"></script>
<title>TOFIT</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div class="content_inner">
			<h3>
				<img src="${contextPath}/resources/images/logo.svg" alt="logo">
				<br> 들어오셔서 기뻐요!
			</h3>
			<p>투핏 전용 로그인</p>
			<form action="${contextPath}/member/login.do" name="frmlogin"
				method="post">
				<div class="form">
					<label class="email">아이디</label> <input id="inpud_id" type="text"
						class="user_id" name="id" placeholder="아이디를 입력해주세요">
				</div>
				<div class="form_pw">
					<label class="passward">비밀번호</label> <input id="inpud_pw"
						type="password" class="user_pwd" name="pwd"
						placeholder="비밀번호를 입력해주세요">
				</div>
				<div class="check">
					<input type="checkbox" class="chk" id="recheck"> <label
						class="chke" for="recheck">로그인 기억하기</label>
				</div>
				<button type="submit" class="login_button" id="btn_log"
					onclick="loginCheck()">로그인</button>
				<div class="forget_pw">
					<a href="${contextPath}/member/searchpwd.do">아이디/비밀번호를 잊으셨나요?</a>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>