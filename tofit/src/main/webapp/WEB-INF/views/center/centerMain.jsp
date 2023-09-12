<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="centerList" value="${cenMap.centerList}" />
<c:set var="totalCen" value="${cenMap.totalCen}" />
<c:set var="section" value="${cenMap.section}" />
<c:set var="pageNum" value="${cenMap.pageNum}" />
<c:set var="city" value="${cenMap.city}" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${contextPath}/resources/css/center_main.css">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="${contextPath}/resources/js/center_main.js"></script>
<script src="https://kit.fontawesome.com/563943ce4b.js"
	crossorigin="anonymous"></script>
<c:choose>
	<c:when test="${msg=='purchase'}">
		<script>
			window.onload = function() {
				alert("PT이용권이 구매되었습니다.");
			}
		</script>
	</c:when>
</c:choose>
<title>TOFIT</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div class="secSection_1">
			<img src="${contextPath}/resources/img/fitness(1).png"
				alt="mini_icons">
			<h2>센터안내</h2>
			<p>
				나에게 맞는 다양한 <span>피트니스 시설</span>을 <span>집 주변에서</span> 쉽게 찾아보세요.
			</p>
			<fieldset>
				<legend>검색영역</legend>
				<form action="${contextPath}/center/centerMain.do" method="get">
					<input class="search" type="text" placeholder="시설 이름으로 검색"
						name="cenName">
					<input type="hidden" name="city" value="${city}">
					<button class="search_btn" type="submit">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</form>
			</fieldset>
		</div>
		<div class="secSection_2">
			<h2>지역별 보기</h2>
			<div class="row">
				<c:choose>
					<c:when test="${city=='전체'}">
						<div class="col_local col_local_all">
							<a href="${contextPath}/center/centerMain.do?city=전체"
								class="selected">전체</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local col_local_all">
							<a href="${contextPath}/center/centerMain.do?city=전체">전체</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='서울'}">
						<div class="col_local l seoul">
							<a href="${contextPath}/center/centerMain.do?city=서울"
								class="selected">서울</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l seoul">
							<a href="${contextPath}/center/centerMain.do?city=서울" class="">서울</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='부산'}">
						<div class="col_local l busan">
							<a href="${contextPath}/center/centerMain.do?city=부산"
								class="selected">부산</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l busan">
							<a href="${contextPath}/center/centerMain.do?city=부산" class="">부산</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='인천'}">
						<div class="col_local l inchun">
							<a href="${contextPath}/center/centerMain.do?city=인천"
								class="selected">인천</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l inchun">
							<a href="${contextPath}/center/centerMain.do?city=인천" class="">인천</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='세종'}">
						<div class="col_local l sejong">
							<a href="${contextPath}/center/centerMain.do?city=세종"
								class="selected">세종</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l sejong">
							<a href="${contextPath}/center/centerMain.do?city=세종" class="">세종</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='경기'}">
						<div class="col_local l gyung">
							<a href="${contextPath}/center/centerMain.do?city=경기"
								class="selected">경기</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l gyung">
							<a href="${contextPath}/center/centerMain.do?city=경기" class="">경기</a>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${city=='제주'}">
						<div class="col_local l jeju">
							<a href="${contextPath}/center/centerMain.do?city=제주"
								class="selected">제주</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col_local l jeju">
							<a href="${contextPath}/center/centerMain.do?city=제주" class="">제주</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="all_center">
		<div class="all_center_title">
			<h2>추천 시설</h2>
			<p>당신에게 맞는 시설을 만나보세요.</p>
		</div>
		<c:choose>
			<c:when test="${empty centerList}">
				<p class="noCenter">피트니스 센터가 없습니다.</p>
			</c:when>
			<c:when test="${!empty centerList}">
				<c:forEach items="${centerList}" var="center">
					<div class="secSection_3 secSections">
						<ul class="center_recommend center3">
							<li>
								<div class="center_img">
									<a
										href="${contextPath}/center/moreCenter.do?cenNumber=${center.cenNumber}">
										<img class="recommend_img" src="${center.thumbnail}"
										alt="${center.cenName}" width="310" height="158">
									</a>
								</div>
							</li>
							<li>
								<h3>
									<input type="hidden" name="cenName" value="${center.cenName}"><a
										href="${contextPath}/center/moreCenter.do?cenNumber=${center.cenNumber}">${center.cenName}</a>
								</h3> <span>${center.cenTel}</span>

							</li>

							<li class="time">${center.cenAddress}</li>
							<li class="sns_line"><span>${center.cenTime}</span></li>
							<li class="gogogo"><a
								href="${contextPath}/center/moreCenter.do?cenNumber=${center.cenNumber}"><img
									src="${contextPath}/resources/img/right-arrow.png" alt="arrow"
									width="32" height="32"></a></li>
						</ul>
					</div>
				</c:forEach>
			</c:when>
		</c:choose>
	</div>
	<div class="bottom_sec">
		<div class="pageBtn">
			<ul class="ulBtn">
				<c:if test="${totalCen !=0}">
					<c:if test="${totalCen%12==0}">
						<c:set var="totalCen" value="${totalCen-1}" />
					</c:if>
					<fmt:parseNumber var="total" value="${totalCen/60+1}" integerOnly="true" />
					<c:choose>
						<c:when test="${section > 1}">
							<li class="previous_btn"><a
								href="${contextPath}/center/centerMain.do?section=${section-1}&pageNum=5">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li class="previous_btn">&lt;</li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${section==total}">
							<c:forEach var="page" begin="1" end="${(totalCen-(60*(section-1)))/12+1}" step="1">
								<c:choose>
									<c:when test="${page==pageNum}">
										<li class="present_btn"><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="page" begin="1" end="5" step="1">
								<c:choose>
									<c:when test="${page==pageNum}">
										<li class="present_btn"><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="${contextPath}/center/centerMain.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
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
								href="${contextPath}/center/centerMain.do?section=${section+1}&pageNum=1">&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
			</ul>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>