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
<link rel="stylesheet"
	href="${contextPath}/resources/css/kitregister.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/kitresister.js"></script>
<script src="${contextPath}/resources/js/index.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    
                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수
    
                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }
    
                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                    //     document.getElementById("sample6_extraAddress").value = extraAddr;
                    
                    // } else {
                    //     document.getElementById("sample6_extraAddress").value = '';
                     }
    
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
        function addHypen(obj) {
    	    var number = obj.value.replace(/[^0-9]/g, "");
    	    var phone = "";

    	    if(number.length < 4) {
    	        return number;
    	    } else if(number.length < 7) {
    	        phone += number.substr(0, 3);
    	        phone += "-";
    	        phone += number.substr(3);
    	    } else if(number.length < 11) {
    	        phone += number.substr(0, 3);
    	        phone += "-";
    	        phone += number.substr(3, 3);
    	        phone += "-";
    	        phone += number.substr(6);
    	    } else {
    	        phone += number.substr(0, 3);
    	        phone += "-";
    	        phone += number.substr(3, 4);
    	        phone += "-";
    	        phone += number.substr(7);
    	    }
    	    obj.value = phone;
    	}
    </script>
<title>TOFIT</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div class="content_inner">
			<div class="main">
				<h4>회원가입</h4>
				<div id="reg">
					<form action="${contextPath}/member/addMember.do" method="post">
						<fieldset>
							<div>
								<input type="radio" name="admin" value="일반"> 일반회원 <input
									type="radio" name="admin" value="코치"> 코치회원
							</div>
							<div>
								<label for="id"></label> <input type="text" id="id" name="id"
									placeholder="사용할 아이디">
							</div>
							<div>
								<label for="name"></label> <input type="text" id="name"
									name="name" placeholder="이름" onchange="ck_name()"> <span
									id="MsgName" class="none">유효성체크</span>
							</div>
							<div>
								<label for="pwd"></label> <input type="password" id="pwd"
									name="pwd" placeholder="비밀번호" onchange="ck_pwd()"> <span
									id="MsgPw" class="none">유효성체크</span>
							</div>
							<div>
								<label for="pwd_ck"></label> <input type="password" id="pwd_ck"
									name="lastname" placeholder="비밀번호 확인" onchange="ck_pwd2()">
								<span id="MsgPwck" class="none">유효성체크</span>
							</div>
							<div>
								<label for="email"></label> <input type="email" id="email"
									name="email" placeholder="이메일 ( ex@codepen.com)"
									onchange="ck_email()"> <span id="MsgId" class="none">이메일</span>
							</div>
							<div>
								<label for="nick"></label> <input type="text" id="nick"
									name="nickName" placeholder="닉네임">
							</div>
							<div class="address">
								<label for="bithdate">주소</label> <input type="text"
									id="sample6_postcode" placeholder="우편번호"> <input
									type="text" id="sample6_address" name="address"
									placeholder="주소"><br> <input type="text"
									id="sample6_detailAddress" placeholder="상세주소"> <input
									type="button" onclick="sample6_execDaumPostcode()"
									value="우편번호 찾기"><br>
							</div>
							<div>
								<label for="phone"></label> <input type="tel" id="phone"
									onchange="addHypen(this)" name="phone" placeholder="전화번호">
							</div>
							<input type="submit" value="회원가입">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>