<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="reserveList" value="${reserveMap.reserveList}" />
<c:set var="selectedTotal" value="${reserveMap.selectedTotal}" />
<c:set var="section" value="${reserveMap.section}" />
<c:set var="pageNum" value="${reserveMap.pageNum}" />
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
<link rel="stylesheet"
	href="${contextPath}/resources/css/sub_mypage01_PTCancel.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
    	$(document).ready(function() {
    		$('#checkAll').click(function() {
        		if($('#checkAll').is(':checked')) {
        			$('input[name=checkedRV]').prop('checked', true);
        		}else {
        			$('input[name=checkedRV]').prop('checked', false);
        		}
        	});
        	$('input[name=checkedRV]').click(function() {
        		var total=$('input[name=checkedRV]').length;
        		var checkedTotal=$('input[name=checkedRV]:checked').length;
        		if(total!=checkedTotal) {
        			$('#checkAll').prop('checked',false);
        		}else {
        			$('#checkAll').prop('checked', true);
        		}
        	});
    	});
    	
    	function cancel(obj) {
    		obj.submit();
		}
    </script>
<c:choose>
	<c:when test="${msg=='cancel'}">
		<script>
				window.onload=function () {
					alert("PT예약이 취소되었습니다.");
				}
			</script>
	</c:when>
	<c:when test="${msg=='cancelE'}">
		<script>
				window.onload=function () {
					alert("PT 예외시간이 취소되었습니다.");
				}
			</script>
	</c:when>
</c:choose>
<title>TOFIT</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div id="content">
		<section class="rcCancel_head">
			<p>
				<a class="back" href="${contextPath}/reserve/reserveInfo.do">&lt;
					뒤로가기</a>
			</p>
			<c:choose>
				<c:when test="${user=='coach'}">
					<h1>PT 예외시간 관리</h1>
				</c:when>
				<c:when test="${user=='user'}">
					<h1>PT 예약 취소</h1>
				</c:when>
			</c:choose>
		</section>
		<section class="rcCancel_body">
			<c:choose>
				<c:when test="${user=='coach'}">
					<h2>※ 예외시간 24시간 전부터 취소가 불가합니다.</h2>
				</c:when>
				<c:when test="${user=='user'}">
					<h2>※ 예약시간 24시간 전부터 예약취소가 불가합니다.</h2>
				</c:when>
			</c:choose>
			<form action="${contextPath}/reserve/reserveCancel.do" method="post"
				name="ptCancelCheck">
				<p>
					<button type="button" class="PTReservation_cancel"
						onclick="cancel(this.form)">취소</button>
				</p>
				<ul class="list_head">
					<li class="PTCheckbox"><label for="ptRv_check"></label> <input
						type="checkbox" id="checkAll" class="ptRv_check"></li>
					<li class="rvNumber">예약번호</li>
					<li class="rvCenter">피트니스 센터</li>
					<li class="rvMembership">구매한 이용권</li>
					<li class="rvTime">예약시간</li>
				</ul>
				<c:choose>
					<c:when test="${empty reserveList}">
						<ul class="reservationList">
							<li class="noReservation">예약 내역이 없습니다.</li>
						</ul>
					</c:when>
					<c:when test="${!empty reserveList}">
						<c:forEach var="reserve" items="${reserveList}">
							<ul class="reservationList">
								<li class="PTCheckbox"><label for="ptRv_check"></label> <input
									type="checkbox" name="checkedRV" value="${reserve.ptNum}"
									id="ptRv_check" class="ptRv_check"></li>
								<li class="rvNumber">${reserve.ptNum}</li>
								<li class="rvCenter">${reserve.cenName}</li>
								<li class="rvMembership">${reserve.ptPeriod}
									${reserve.ptCount}회</li>
								<li class="rvTime">${reserve.ptDate}${reserve.ptTime}</li>
							</ul>
						</c:forEach>
					</c:when>
				</c:choose>
			</form>
			<div class="pageBtn">
				<ul class="ulBtn">
					<c:if test="${selectedTotal !=0}">
						<c:if test="${selectedTotal%5==0}">
							<c:set var="selectedTotal" value="${selectedTotal-1}" />
						</c:if>
						<fmt:parseNumber var="total" value="${selectedTotal/25+1}" integerOnly="true" />
						<c:choose>
							<c:when test="${section > 1}">
								<li class="previous_btn"><a
									href="${contextPath}/reserve/gotoReserveCancel.do?section=${section-1}&pageNum=5">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li class="previous_btn">&lt;</li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${section==total}">
								<c:forEach var="page" begin="1"
									end="${(selectedTotal-(25*(section-1)))/5+1}" step="1">
									<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn"><a
												href="${contextPath}/reserve/gotoReserveCancel.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${contextPath}/reserve/gotoReserveCancel.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach var="page" begin="1" end="5" step="1">
									<c:choose>
										<c:when test="${page==pageNum}">
											<li class="present_btn"><a
												href="${contextPath}/reserve/gotoReserveCancel.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${contextPath}/reserve/gotoReserveCancel.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${section==total}">
								<li class="next_btn">&gt;</li>
							</c:when>
							<c:otherwise>
								<li class="next_btn"><a
									href="${contextPath}/reserve/gotoReserveCancel.do?section=${section+1}&pageNum=1">&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</ul>
			</div>
		</section>

	</div>

	<!-- footer 시작 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>