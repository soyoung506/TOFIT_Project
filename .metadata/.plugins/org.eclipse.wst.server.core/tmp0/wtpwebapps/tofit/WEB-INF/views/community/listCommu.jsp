<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="commuList" value="${articleMap.commuList}" />
<c:set var="totArticles" value="${articleMap.totalArticles}" />
<c:set var="section" value="${articleMap.section}" />
<c:set var="pageNum" value="${articleMap.pageNum}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/bulletin_new.css">
<title>TOFIT</title>
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fn_commuForm(isLogon, commuForm, loginForm) {
		if(isLogon=='true') {
			location.href=commuForm;
		}else {
			alert('로그인 후 글쓰기가 가능합니다');
			location.href=loginForm+'?action=/community/commuForm.do';
		}
	}
	function fn_viewArticle(isLogon, viewArticle, loginForm) {
		if(isLogon=='true') {
			location.href='${contextPath}'+viewArticle;
		}else {
			alert('로그인 후 게시글 열람이 가능합니다');
			location.href=loginForm+'?action='+viewArticle;
		}
	}
</script>
<c:choose>
	<c:when test="${msg=='remove'}">
		<script>
			window.onload = function() {
				alert("게시글이 삭제되었습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='removeFailed'}">
		<script>
			window.onload = function() {
				alert("해당 게시글의 삭제 권한이 없습니다.");
			}
		</script>
	</c:when>
</c:choose>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div id="tip">
			<div class="bg">
				<h3>[ Today's Fitness ]</h3>
			</div>
			<div class="tip_main">
				<ul>
					<c:choose>
						<c:when test="${empty commuList}">
							<li>
								<p>등록된 글이 없슴.</p>
							</li>
						</c:when>
						<c:when test="${!empty commuList}">
							<c:forEach var="article" items="${commuList}">
								<li><a
									href="javascript:fn_viewArticle('${isLogon}', '/community/viewArticle.do?commuNo=${article.commuNo}', '${contextPath}/member/kitlogin.do')">
										${article.title} </a>
									<p class="date">
										<fmt:formatDate value="${article.writeDate}" />
									</p>
									<p id="id" left="0">${article.userid}</p>
									<p id="eye_p1">조회수</p>
									<p id="eye_p2">${article.watch}</p></li>
							</c:forEach>
						</c:when>

					</c:choose>
				</ul>
				<p class="write">
					<a href="javascript:fn_commuForm('${isLogon}', '${contextPath}/community/commuForm.do', '${contextPath}/member/kitlogin.do')">+글쓰기</a>
				</p>
				<div class="pageBtn">
					<ul class="ulBtn">
						<c:if test="${totArticles != 0}">
							<c:if test="${totArticles%15==0}">
								<c:set var="totArticles" value="${totArticles-1}" />
							</c:if>
							<fmt:parseNumber var="total" value="${totalArticles/75+1}" integerOnly="true" />
							<c:choose>
								<c:when test="${section > 1}">
									<li class="previous_btn"><a
										href="${contextPath}/community/listCommu.do?section=${section-1}&pageNum=5">&lt;</a></li>
								</c:when>
								<c:otherwise>
									<li class="previous_btn">&lt;</li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${section==total}">
									<c:forEach var="page" begin="1" end="${(totArticles-(75*(section-1)))/15+1}" step="1">
										<c:choose>
											<c:when test="${page==pageNum}">
												<li class="present_btn"><a
													href="${contextPath}/community/listCommu.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="${contextPath}/community/listCommu.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach var="page" begin="1" end="5" step="1">
										<c:choose>
											<c:when test="${page==pageNum}">
												<li class="present_btn"><a
													href="${contextPath}/community/listCommu.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
											</c:when>
											<c:otherwise>
												<li><a
													href="${contextPath}/community/listCommu.do?section=${section}&pageNum=${page}">${(section-1)*5+page}</a></li>
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
										href="${contextPath}/community/listCommu.do?section=${section+1}&pageNum=1">&gt;</a></li>
								</c:otherwise>
							</c:choose>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>