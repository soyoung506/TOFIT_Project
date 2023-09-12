<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
   request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업로드</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
   <form action="${contextPath}/center/addCenter.do" method="post" enctype="multipart/form-data">
      <h2 align="center">상품 등록</h2>
      <table align="center">
         <tr>
            <td width="200"><p align="right">센터 번호</p></td>
            <td width="400"><input type="text" name="cenNumber"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">센터이름</p></td>
            <td width="400"><input type="text" name="cenName"></td>
         </tr>   
         <tr>
            <td width="200"><p align="right">센터 주소</p></td>
            <td width="400"><input type="text" name="cenAddress"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">센터 번호</p></td>
            <td width="400"><input type="text" name="cenTel"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">센터 이미지</p></td>
            <td width="400"><input type="text" name="thumbnail"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">센터 시간</p></td>
            <td width="400"><input type="text" name="cenTime"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">센터 지역</p></td>
            <td width="400"><input type="text" name="city"></td>
         </tr>
         <tr>
         
         <tr>
            <td width="200">&nbsp;</td>
            <td><input type="submit" value="전송하기"><input type="reset" value="다시 입력"></td>
         </tr>
      </table>
   </form>
</body>
</html>