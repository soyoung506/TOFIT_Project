<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="${contextPath}/resources/css/searchpwd.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/search.js"></script>
<c:choose>
	<c:when test="${msg=='noMember'}">
		<script>
			window.onload=function () {
				alert("회원정보가 존재하지 않습니다. 입력하신 내용을 다시 확인해주세요.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='findid'}">
		<script>
			window.onload=function () {
				alert("회원님의 아이디 ${id} 입니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='findpwd'}">
		<script>
			window.onload=function () {
				alert("회원님의 비밀번호는 ${pwd} 입니다.");
			}
		</script>
	</c:when>
</c:choose>
<title>TOFIT</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<article class="hero">
		<h2>아이디·비밀번호 찾기</h2>
		<div class="login-wrap">
			<div class="login-html">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">아이디 찾기</label> <input id="tab-2"
					type="radio" name="tab" class="sign-up"><label for="tab-2"
					class="tab">비밀번호 찾기</label>
				<div class="login-form">
					<form name="findId" method="post"
						action="${contextPath }/member/findID.do">
						<div class="sign-in-htm">
							<div class="group">
								<h4>이메일 주소 확인</h4>
								<h5>이메일을 이용하여 아이디를 확인하실 수 있습니다.</h5>
								<input id="name" name="name" type="text" class="input"
									placeholder="이름">
							</div>
							<div class="group">
								<!--<label for="pass" class="label">휴대폰 번호</label>-->
								<input id="email" type="text" name="email" class="input"
									data-type="text" placeholder="이메일 주소">
							</div>
							<div class="group">
								<button type="submit" onclick="loginCheck()" class="button">아이디
									찾기</button>
							</div>
						</div>
					</form>
					<form action="${contextPath }/member/findPWD.do" name="findpwd"
						method="post">
						<div class="sign-up-htm">
							<div class="group">
								<h4>휴대폰 번호 확인</h4>
								<input id="id" type="text" class="input" name="id"
									placeholder="아이디">
							</div>
							<div class="group">
								<input id="name" type="text" class="input" name="name"
									placeholder="이름">
							</div>
							<div class="group">
								<input id="phone" type="text" class="input" name="phone"
									placeholder="휴대폰 번호">
							</div>
							<div class="group">
								<button type="submit" class="button">비밀번호 찾기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</article>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>