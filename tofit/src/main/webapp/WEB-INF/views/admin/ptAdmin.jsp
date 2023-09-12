<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	width: 1200px;
	border: 1px solid #ccc;
}
th, td {
	border: 1px solid #ccc;
}
.popup {
    position: fixed;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.8);
    top: 0;
    left: 0;
    z-index: 100;
    display: none;
}
.popup_content {
    position: absolute;
    width: 800px;
    height: 400px;
    background-color: #fff;
    left: 50%;
    transform: translateX(-50%);
    top: 60px;
    padding: 30px;
    box-sizing: border-box;
}
.stopMembership {
	background-color: #ccc;
}
</style>
<script src="${contextPath}/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
function openPopup() {
	$('.popup').fadeIn();
}
function cancelAdd() {
	$('.popup').fadeOut();
}
</script>
<c:choose>
   	<c:when test="${msg=='disabled'}">
		<script>
			window.onload=function () {
				alert("PT이용권이 비활성화 되었습니다.");
			}
		</script>
	</c:when>
   	<c:when test="${msg=='add'}">
		<script>
			window.onload=function () {
				alert("PT이용권이 추가되었습니다.");
			}
		</script>
	</c:when>
</c:choose>
<title>TOFIT ADMIN</title>
</head>
<body>
	<h1>PT이용권 관리</h1>
	<form action="${contextPath}/administration/ptDisabled.do" method="post" name="ptDisabled">
	<button type="button" onclick="openPopup()">추가</button>
	<button>비활성화</button>
		<table>
			<tr>
				<th>&#32;</th><th>이용권 번호</th><th>피트니스 센터</th><th>코치</th><th>기간</th><th>횟수</th><th>가격</th><th>비고</th>
			</tr>
			<c:choose>
	            <c:when test="${empty ptList}">
		            <tr>
						<td colspan=8>PT이용권이 없습니다.</td>
					</tr>
	            </c:when>
	            <c:when test="${!empty ptList}">
	             	<c:forEach var="ptList" items="${ptList}" >
	             		<c:choose>
	             			<c:when test="${ptList.centerMembership=='이용권 중지'}">
	             				<tr class="stopMembership">
			             			<td>&#32;</td>
									<td>${ptList.ptNo}</td>
									<td>${ptList.fkCenNumber} / ${ptList.cenName}</td>
									<td>${ptList.ptCoach} / ${ptList.name}</td>
									<td>${ptList.ptPeriod}</td>
									<td>${ptList.ptCount}</td>
									<td>${ptList.ptPrice}</td>
									<td>${ptList.centerMembership}</td>
								</tr>
	             			</c:when>
	             			<c:otherwise>
		             			<tr>
			             			<td><input type="radio" value="${ptList.ptNo}" name="ptNo"></td>
									<td>${ptList.ptNo}</td>
									<td>${ptList.fkCenNumber} / ${ptList.cenName}</td>
									<td>${ptList.ptCoach} / ${ptList.name}</td>
									<td>${ptList.ptPeriod}</td>
									<td>${ptList.ptCount}</td>
									<td>${ptList.ptPrice}</td>
									<td>${ptList.centerMembership}</td>
								</tr>
	             			</c:otherwise>
	             		</c:choose>
	             	</c:forEach>
	            </c:when>
	        </c:choose>
		</table>
	</form>
	<div class="popup">
		<div class="popup_content">
			<form action="${contextPath}/administration/ptAdd.do" method="post" name="ptAdd">
				피트니스 센터 : <select name="fkCenNumber">
								<c:forEach var="cenList" items="${cenList}">
									<option value="${cenList.cenNumber}">${cenList.cenNumber} / ${cenList.cenName}</option>
								</c:forEach>
		                    </select><br>
				코치 : <select name="ptCoach">
							<c:forEach var="coachList" items="${coachList}">
									<option value="${coachList.id}">${coachList.id} / ${coachList.name}</option>
							</c:forEach>
		              </select><br>
				기간 : <select name="ptPeriod">
		                  <option value="1개월">1개월</option>
		                  <option value="2개월">2개월</option>
		                  <option value="3개월">3개월</option>
		                  <option value="4개월">4개월</option>
		                  <option value="5개월">5개월</option>
		                  <option value="6개월">6개월</option>
		                  <option value="7개월">7개월</option>
		                  <option value="8개월">8개월</option>
		                  <option value="9개월">9개월</option>
		                  <option value="10개월">10개월</option>
		                  <option value="11개월">11개월</option>
		                  <option value="12개월">12개월</option>
		              </select><br>
				횟수 : <input type="number" name="ptCount"><br>
				가격 : <input type="number" name="ptPrice"><br>
				비고 : <input type="text" name="centerMembership"><br>
				<button type="button" onclick="cancelAdd()">취소</button>
				<button>추가</button>
			</form>
		</div>	
	</div>
	
</body>
</html>