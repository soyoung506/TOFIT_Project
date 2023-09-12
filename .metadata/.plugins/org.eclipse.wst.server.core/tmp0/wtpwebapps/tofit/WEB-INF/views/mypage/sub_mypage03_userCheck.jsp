<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage03_userCheck.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <title>TOFIT</title>
    <c:choose>
    	<c:when test="${msg=='noMember'}">
			<script>
				window.onload=function () {
					alert("회원정보가 일치하지 않습니다.");
				}
			</script>
		</c:when>
	</c:choose>
	<script type="text/javascript">
		function backtoProfile(obj) {
			obj.action="${contextPath}/profile/profileInfo.do"
			obj.submit();
		}
	</script>
	<style type="text/css">
		.profile_button {
			cursor: pointer;
		}
	</style>
</head>

<body>
  	 <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
        <section class="userCheck_head">
            <h1>회원 정보 확인</h1>
        </section>
        <section class="userCheck">
            <h2><span class="userName">${profileInfo.name}</span>님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한 번 확인합니다.</h2>
            <form action="${contextPath}/profile/checkUser.do" method="post">
                <ul class="userCheck_input">
                    <li>
                        <label for="mem_id">아이디</label>
                        <input id="mem_id" type="text" class="modifyBox" value="${profileInfo.id}" disabled>
                        <input type="hidden" value="${profileInfo.id}" name="id">
                    </li>
                    <li>
                        <label for="mem_pwd">비밀번호</label>
                        <input id="mem_pwd" type="password" class="modifyBox" name="pwd">
                    </li>
                </ul>
                <ul class="userCheck_button">
                    <li>
                        <input type="button" class="button_cancel profile_button" value="취소" onclick="backtoProfile(this.form)">
                    </li>
                    <li>
                        <input type="submit" class="button_modify profile_button" value="확인">
                    </li>
                </ul>
            </form>
        </section>        
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>