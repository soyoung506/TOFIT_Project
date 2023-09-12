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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage03_profileModi.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
    <script src="${contextPath}/resources/js/profileModi.js"></script>
    <script type="text/javascript">
    	// 프로필 이미지 보기
	    function readImage(input) {
			if(input.files && input.files[0]) {
				let reader=new FileReader();
				reader.onload=function (event) {
					$('#preview').attr('src',event.target.result); 
					console.log(event.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
    	// 취소
    	function backToProfile(obj) {
			obj.action="${contextPath}/profile/profileInfo.do";
			obj.submit();
		}
    	// 수정
    	function modifyProfile(obj) {
			obj.action="${contextPath}/profile/modProfile.do";
			obj.submit();
		}
	    // 회원 탈퇴
	    function removeUser(obj) {
	    	var result=confirm("회원탈퇴 시, PT이용권 및 구매내역 등 모든 기록이 삭제됩니다.\n정말로 탈퇴하시겠습니까?")
			if(result) {
				obj.action="${contextPath}/profile/removeUser.do";
				obj.submit();
			}else {
				window.location.href="#";
			}
	    	
	    	
		}		
    </script>
    <title>TOFIT</title>
</head>

<body>
     	 <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
    	<form action="${contextPath}/" method="post" enctype="multipart/form-data">
        <section class="profil_head">
            <h1 class="blind">프로필 수정</h1>
            <p class="proImage"><img id="preview" src="${contextPath}/profile?profileImg=${profileInfo.profileImg}&id=${profileInfo.id}" alt="프로필 이미지"></p>
            <p class="addImage">
            	<button type="button" class="imageUpload" onclick="document.getElementById('profileImg').click();">
            		<img src="${contextPath}/resources/images/icon_picture.png" alt="프로필 이미지 수정">
            	</button>
           	</p>
           	<input type="hidden" name="profileImg" value="${profileInfo.profileImg}">
            <input type="file" id="profileImg" name="newProfileImg" onchange="readImage(this)" style="display:none;">
            <span class="nickname">${profileInfo.nickName}</span>
        </section>
        <section class="profile_membership profile_Modify">
            <h2>회원 정보</h2>
            
                <ul>
                    <li>
                        <label for="mem_id">아이디</label>
                        <input id="mem_id" type="text" class="modifyBox" value="${profileInfo.id}" disabled>
                        <input type="hidden" name="id" value="${profileInfo.id}">
                    </li>
                    <li>
                        <label for="mem_pwd">비밀번호 <strong>&#40;영문자, 숫자를 포함하여 10자리 이상&#41;</strong></label>
                        <input id="mem_pwd" type="password" class="modifyBox" name="pwd" value="${profileInfo.pwd}" onchange="checkPwd()" required>
                        <p id="checkPwd"></p>
                    </li>
                    <li>
                        <label for="mem_pwdC">비밀번호 확인</label>
                        <input id="mem_pwdC" type="password" class="modifyBox" disabled onchange="checkPwd()" required>
                        <p id="checkPwdC"></p>
                    </li>
                    <li>
                        <label for="mem_name">이름</label>
                        <input id="mem_name" type="text" class="modifyBox" value="${profileInfo.name}" disabled>
                    </li>
                    <li>
                        <label for="mem_email">이메일</label>
                        <input id="mem_email" type="email" class="modifyBox" name="email" value="${profileInfo.email}" required>
                    </li>
                    <li>
                        <label for="mem_phone">휴대전화번호 <strong>&#40;&quot;&#45;&quot;하이픈을 포함해 주세요.&#41;</strong></label>
                        <input id="mem_phone" type="tel" class="modifyBox" name="phone" value="${profileInfo.phone}">
                    </li>
                    <li>
                        <!-- 카카오 주소 api 사용 -->
                        <label for="mem_address">주소</label>
                        <input id="mem_address" type="text" class="modifyBox" name="address" value="${profileInfo.address}">
                    </li>
                    <li>
                        <label for="mem_birth">가입일</label>
                        <input id="mem_birth" type="date" class="modifyBox" value="${profileInfo.joinDate}" disabled>
                    </li>
                </ul>
            
        </section>

        <section class="profile_submit">
            <h2 class="blind">제출 버튼</h2>
            <ul>
                <li>
                    <button type="button" class="button_cancel profile_button" onclick="backToProfile(this.form)">취소</button>
                </li>
                <li>
                    <button type="button" class="button_modify profile_button" onclick="modifyProfile(this.form)">수정</button>
                </li>
            </ul>
            <p><button type="button" class="membershipOff" onclick="removeUser(this.form)">회원 탈퇴</button></p>
        </section>
    </form>
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>