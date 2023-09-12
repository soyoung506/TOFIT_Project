<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="myboardList" value="${myboardMap.myboardList}"/>
<c:set var="totalMyboard" value="${myboardMap.totalMyboard}"/>
<c:set var="section" value="${myboardMap.section}"/>
<c:set var="pageNum" value="${myboardMap.pageNum}"/>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/sub_mypage03.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script src="${contextPath}/resources/js/index.js"></script>
        <c:choose>
    	<c:when test="${msg=='update'}">
			<script>
				window.onload=function () {
					alert("회원정보가 수정되었습니다.");
				}
			</script>
		</c:when>
	</c:choose>
    <title>TOFIT</title>
</head>

<body>
    	 <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <div id="content">
        <section class="mypage_head">
            <h1>MY PAGE</h1>
            <ul>
                <li><a href="${contextPath}/reserve/reserveInfo.do">예약내역</a></li>
                <li><a href="${contextPath}/payment/paymentInfo.do">결제내역</a></li>
                <li class="present_page"><a href="${contextPath}/profile/profileInfo.do">프로필</a></li>
            </ul>
        </section>
        <section class="mypage_membership profile_info">
            <h2>회원 정보</h2>
            <div class="contain">
                <p class="profileImg"><img src="${contextPath}/profile?profileImg=${profileInfo.profileImg}&id=${profileInfo.id}" alt="프로필 이미지"></p>
                <ul>
                    <li>${profileInfo.name}</li>
                    <li>${profileInfo.nickName}</li>
                    <li>${profileInfo.email}</li>
                </ul>
                <p><a href="${contextPath}/profile/gotoModi.do">회원 정보 수정 &gt;</a></p>
            </div>
        </section>
        <%-- <section class="mypage_fitnessInfo profile_info">
            <h2>피트니스 정보</h2>
            <div class="contain">
                <ul class="contain_title">
                    <li>목표</li>
                    <li>피트니스 센터</li>
                </ul>
                <ul class="contain_info">
                    <li>다이어트</li>
                    <li>00 피트니스</li>
                </ul>
                <p><a href="${contextPath}/profile/gotoModi.do">피트니스 정보 등록 &gt;</a></p>
            </div>
        </section> --%>
        <section class="mypage_board profile_info">
            <h2>나의 게시글</h2>
            <div class="contain">
                <ul class="contain_myboard">
                    <li class="myboard_title">
                        <span class="board_no">No</span>
                        <span class="board_title">글 제목</span>
                        <span class="board_view">조회수</span>
                        <span class="board_date">작성일</span>
                    </li>
                  	<c:choose>
                  		<c:when test="${empty myboardList}">
                  			<li class="myboard_content noContent">등록된 글이 없습니다.</li>
                  		</c:when>
                  		<c:when test="${!empty myboardList}">
                  			<c:forEach var="myboard" items="${myboardList}" >
                  				<li class="myboard_content">
			                        <span class="board_no">${myboard.communo}</span>
			                        <span class="board_title"><a href="${contextPath}/community/viewArticle.do?commuNo=${myboard.communo}">${myboard.title}</a></span>
			                        <span class="board_view">${myboard.watch}</span>
			                        <span class="board_date">${myboard.writeDate}</span>
			                    </li>
                  			</c:forEach>
                  		</c:when>
                  	</c:choose>
                </ul>
                <div class="pageBtn">
                	<ul class="ulBtn">
		                <c:if test="${totalMyboard !=0}">
		                	<c:if test="${totalMyboard%5==0}">
								<c:set var="totalMyboard" value="${totalMyboard-1}" />
							</c:if>
							<fmt:parseNumber var="total" value="${totalMyboard/25+1}" integerOnly="true" />
                			<c:choose>
               					<c:when test="${section > 1}">
               						<li class="previous_btn"><a href="${contextPath}/profile/profileInfo.do?_section=${section-1}&_pageNum=5">&lt;</a></li>
               					</c:when>
               					<c:otherwise>
               						<li class="previous_btn">&lt;</li>
               					</c:otherwise>
               				</c:choose>
               				<c:choose>
               					<c:when test="${section==total}">
                					<c:forEach var="page" begin="1" end="${(totalMyboard-(25*(section-1)))/5+1}" step="1">
		                				<c:choose>
											<c:when test="${page==pageNum}">
												<li class="present_btn" ><a href="${contextPath}/profile/profileInfo.do?_section=${section}&_pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${contextPath}/profile/profileInfo.do?_section=${section}&_pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:otherwise>
										</c:choose>
		                			</c:forEach>
               					</c:when>
               					<c:otherwise>
               						<c:forEach var="page" begin="1" end="5" step="1">
		                				<c:choose>
											<c:when test="${page==pageNum}">
												<li class="present_btn" ><a href="${contextPath}/profile/profileInfo.do?_section=${section}&_pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="${contextPath}/profile/profileInfo.do?_section=${section}&_pageNum=${page}">${(section-1)*5+page}</a></li>
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
               						<li class="next_btn"><a href="${contextPath}/profile/profileInfo.do?_section=${section+1}&_pageNum=1">&gt;</a></li>
               					</c:otherwise>
                			</c:choose>
		                </c:if>
                    </ul>
                </div>
            </div>
        </section>
    </div>

    <!-- footer 시작 -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>