<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="${contextPath}/resources/css/write.css">
<title>TOFIT</title>
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		//이미지 미리보기 구현
		function readImage(input){
			if(input.files && input.files[0]){
				let reader=new FileReader();
				reader.onload = function(event){
					$('.preview').attr('src',event.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		//다른 액션을 submit
		function toList(obj){
			obj.action="${contextPath}/community/listCommu.do";
			obj.submit();
		}
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div id="content">
		<div id="tip">
			<div class="bg">
				<h3>[ Today's Fitness ]</h3>
			</div>
			<form action="${contextPath}/community/addCommu.do" method="post">
				<div class="tip_main">
					<div class="f_option">
						<!-- <select id="font" name="font">
	                        <option>맑은고딕</option>
	                        <option>함초롱바탕</option>
	                        <option>오렌지체</option>
	                        <option>감귤체</option>
	                        <option>초콜릿체</option>
	                    </select>
	                    <select id="font_size" name="fontsize1">
	                        <option><font size=10>10</font></option>
	                        <option><font size=11>11</font></option>
	                        <option><font size=12>12</font></option>
	                        <option><font size=13>13</font></option>
	                        <option><font size=14>14</font></option>
	                        <option><font size=15>15</font></option>
	                        <!-- <input type="number" id="font_size" name="fontsize">
	                    </select> -->
						<!-- <img src="../img/bold.png" alt="bold" onclick="fn_bold">
	                    <img src="../img/lay.png" alt="lay" onclick="fn_lay">
	                    <img src="../img/line.png" alt="line" onclick="fn_line">
	                    <img class="del" src="../img/del.png" alt="del" onclick="fn_del"> -->
					</div>
					<table>
						<tr>
							<td class="label">제목</td>
							<td class="put"><input type="text" class="text" name="title"></td>
						</tr>
						<!-- <tr>
                            <td class="label">첨부파일</td>
                            <td class="put">
                            	<input type="file" name="imgFile" class="file" onchange="readImage(this)">
                            	<img class="preview" src="#" width="50" height="50" alt="">
                            </td>
                        </tr> -->
						<!-- <tr>
                            <td class="label">사용자 아이디</td>
                            <td class="put"><input type="text" name="userid"></td>
                        </tr> -->
						<!-- <tr>
                            <td class="label">링크</td>
                            <td class="put"><input type="url" name="link"></td>
                        </tr> -->
						<tr>
							<td class="label content_l">내용</td>
							<td class="put"><textarea name="content" width="630px"
									maxlength="1000"></textarea></td>
						</tr>
						<tr>
							<td id="buttons" colspan="2"><input type="button"
								value="목록보기" class="list" onclick="toList(this.form)"> <input
								type="submit" value="글등록" class="submit"></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>