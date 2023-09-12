<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${contextPath}/resources/css/news.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>TOFIT</title>
<style type="text/css">
#tr_button_modify {
	display: none;
}
#tr_button_modify_c {
	display: none;
}
</style>
<script type="text/javascript">
	function fn_enable(obj){
		document.getElementById("id_title").disabled=false;
		document.getElementById("tip_news").disabled=false;
		document.getElementById("tr_button_modify").style.display="block";
		document.getElementById("modify").style.display="none";
	}
	function fn_modify_article(obj){
		obj.action="${contextPath}/community/modArticle.do";
		obj.submit();
	}
	function backToList(obj){
		obj.action="${contextPath}/community/listCommu.do";
		obj.submit();
	}
	function fn_remove_article(url, commuNo){
		let d_form=document.createElement("form"); //동적으로 form 생성
		d_form.setAttribute("method","post");
		d_form.setAttribute("action",url);
		let articleNoInput=document.createElement("input"); //글번호 받을 인풋 태그
		articleNoInput.setAttribute("type","hidden");
		articleNoInput.setAttribute("name","commuNo");
		articleNoInput.setAttribute("value",commuNo);
		d_form.appendChild(articleNoInput);
		document.body.appendChild(d_form);
		d_form.submit(); //boardController로 감
	}
	
	function fn_enable_c(obj){
		$('.comments_c').attr("disabled", true);
		$('.comments_c').css("border", "none");
		$('.tr_button_modify_c').css("display", "none");
		$('.modify_c').css("display", "inline-block");
		$(obj).children('.comments_c').attr("disabled", false);
		$(obj).children('.comments_c').css("border", "1px solid #354F68").css("border-radius", "3px");
		$(obj).children('.tr_button_modify_c').css("display", "inline-block");
		$(obj).children('.modify_c').css("display", "none");
	}
	function fn_modify_c(obj){
		obj.action="${contextPath}/comment/updateComment.do";
		obj.submit();
	}
	
	 function fn_remove_c(url, commentNo){
		let d_form=document.createElement("form"); //동적으로 form 생성
		d_form.setAttribute("method","post");
		d_form.setAttribute("action",url);
		let articleNoInput=document.createElement("input"); //글번호 받을 인풋 태그
		articleNoInput.setAttribute("type","hidden");
		articleNoInput.setAttribute("name","commuNo");
		articleNoInput.setAttribute("value",commuNo);
		d_form.appendChild(articleNoInput);
		document.body.appendChild(d_form);
		d_form.submit(); //boardController로 감
	} 
	
	function fn_remove_c(obj){
		obj.action="${contextPath}/comment/deleteComment.do";
		obj.submit();
	}
</script>
<c:choose>
	<c:when test="${msg=='modi'}">
		<script>
			window.onload = function() {
				alert("게시글이 수정되었습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='modiFailed'}">
		<script>
			window.onload = function() {
				alert("해당 게시글의 수정 권한이 없습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='removeComment'}">
		<script>
			window.onload = function() {
				alert("해당 댓글이 삭제되었습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='removeFailedComment'}">
		<script>
			window.onload = function() {
				alert("해당 댓글의 삭제 권한이 없습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='modiComment'}">
		<script>
			window.onload = function() {
				alert("댓글이 수정되었습니다.");
			}
		</script>
	</c:when>
	<c:when test="${msg=='modiFailedComment'}">
		<script>
			window.onload = function() {
				alert("해당 댓글의 수정 권한이 없습니다.");
			}
		</script>
	</c:when>
</c:choose>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<form name="frmArticle" action="${contextPath}/" method="post"
			enctype="multipart/form-data">
			<div id="tip">
				<div class="bg">
					<h2>[ Today's Fitness ]</h2>
				</div>
				<div class="hd">
					<input type="hidden" name="commuNo" value="${commu.commuNo}">
				</div>
				<div class="tip_main">
					<div class="my_news">
						<input type="text" id="id_title" name="title" value="${commu.title}" disabled> 
						<input type="text" id="id" value="${commu.userid}" disabled> 
						<input type="text" class="date" value=" <fmt:formatDate value="${commu.writeDate}"/>" disabled>
						<input type="button" id="modify" value="수정하기" onclick="fn_enable(this.form)"> 
						<input type="button" id="tr_button_modify" value="수정적용" onclick="fn_modify_article(frmArticle)">
						<textarea id="tip_news" name="content" disabled>${commu.content}</textarea>
						<input type="button" class="modify modify_l" value="목록보기" onclick="backToList(this.form)"> 
						<input type="button" class="modify" value="삭제하기" 
								onclick="fn_remove_article('${contextPath}/community/removeArticle.do',${commu.commuNo})">
					</div>
				</div>
			</div>
		</form>
		<div id="comments">
			<ul id="comments_ul">
				<c:forEach var="cL" items="${commentList}">

					<li id="comments_li">
						<form name="${cL.commentNo}" action="${contextPath}/"
							method="post">
							<input type="hidden" name="commentNo" value="${cL.commentNo}">
							<input type="hidden" name="commuNo" value="${commu.commuNo}">
							<input id="comments_date" value="${cL.commentDate}" disabled />
							<input id="comments_id" value="${cL.commentID}" disabled /> 
							<input type="text" id="comments_c" name="commentContent"
								value="${cL.commentContent}" disabled class="comments_c" /> 
							<input type="button" id="remove_c" value="삭제" onclick="fn_remove_c(this.form)"> 
							<input type="button" id="modify_c" name="modify_c" value="수정"
								onclick="fn_enable_c(this.form)" class="modify_c">
							<input type="button" id="tr_button_modify_c" name="tr_button_modify_c"
								value="수정적용" onclick="fn_modify_c(this.form)" class="tr_button_modify_c">
						</form>
					</li>
				</c:forEach>
			</ul>
		</div>
		<form action="${contextPath}/comment/insertComment.do" method="post">
			<input type="hidden" name="commuNo" value="${commu.commuNo}">
			<input id="comment" type="text" name="commentContent"> <input
				class="submit" type="submit" value="댓글등록">
		</form>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>