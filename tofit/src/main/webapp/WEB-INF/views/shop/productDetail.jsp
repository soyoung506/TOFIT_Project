<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" href="${contextPath}/resources/css/sub_indexshop.css">
<script src="${contextPath}/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	function fn_purchase(isLogon, obj) {
		if(isLogon=='true') {
			obj.action="${contextPath}/shop/purchasePro.do";
			obj.submit();
		}else {
			alert('로그인 후 구매가 가능합니다');
			location.href='${contextPath}/member/kitlogin.do?action=/shop/productDetail.do?pNum='+${productVO.pNum};
		}
	}
	function fn_carts(isLogon, obj) {
		if(isLogon=='true') {
			obj.action="${contextPath}/shop/addCarts.do";
			obj.submit();
		}else {
			alert('로그인 후 장바구니가 가능합니다');
			location.href='${contextPath}/member/kitlogin.do?action=/shop/productDetail.do?pNum='+${productVO.pNum};
		}
	}
	
	
	 // 상품 수량 변경
	 var price = ${productVO.pPrice}; // 상품 가격

	 function updatePrice() {
	   var input = document.getElementById('quantity');
	   var value = parseInt(input.value, 10);
	   value = isNaN(value) ? 1 : value;
	   var totalPrice = price * value;
	   var priceElement = document.getElementById('price');
	   priceElement.innerText = totalPrice.toLocaleString() + '원';
	   $('input[name=odPrice]').val(totalPrice);
	 }
	 
	 function increment() {
	   var input = document.getElementById('quantity');
	   var value = parseInt(input.value, 10);
	   value = isNaN(value) ? 1 : value;
	   value++;
	   input.value = value;
	   updatePrice();
	 }
	 
	 function decrement() {
	   var input = document.getElementById('quantity');
	   var value = parseInt(input.value, 10);
	   value = isNaN(value) ? 1 : value;
	   value--;
	   if(value < 1) {
	     value = 1;
	   }
	   input.value = value;
	   updatePrice();
	 }


	 function handleKeyPress(event) {
	  if (event.keyCode === 13) {
	    updatePrice();
	  }
	}

</script>
<title>TOFIT</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="content">
		<div class="content_tit">
			<h2>
				<strong>KEEPFIT SHOP</strong>
			</h2>
			<p>🔥 WEICOME TO HELL 🔥</p>
		</div>


		<div class="slider">
			<input type="radio" name="slide" id="slide1" checked> <input
				type="radio" name="slide" id="slide2"> <input type="radio"
				name="slide" id="slide3">
			<ul id="imgholder" class="imgs">
				<li><img src="${contextPath}/resources/images/이벤트배너.jpg" alt="이벤트"></li>
				<li><img src="${contextPath}/resources/images/이벤트배너2.jpg" alt="이벤트"></li>
				<li><img src="${contextPath}/resources/images/이벤트배너3.jpg" alt="이벤트"></li>
			</ul>
			<div class="bullets">
				<label for="slide1">&nbsp;</label> <label for="slide2">&nbsp;</label>
				<label for="slide3">&nbsp;</label>
			</div>
		</div>


		<div id="content_lest">

			<div id="left">
				<img src="${contextPath}/product?pImg1=${productVO.pImg1}&pNum=${productVO.pNum}" alt="상세메뉴"> <img
					src="${contextPath}/resources/images/배송.jpg" alt="상세메뉴">
			</div>



			<div id="right">

				<h2>
					<strong>${productVO.pName}</strong>
				</h2>
				<hr>

				<ul>
					<li>원산지 <span>${productVO.pOri}</span>
					</li>
					<li>구매혜택 <span>488포인트 적립혜택!</span>
					</li>
					<li>배송방법 <span>택배</span>
					</li>
					<li>배송비무료 <span>도서상관 배송비 추가</span>
					</li>
				</ul>
				<form name="purchasePro" action="" method="get">
					<div id="right_button">
						<h3>수량</h3>
						<div class="but">
							<button type="button" onclick="decrement()">-</button>
							<input type="number" id="quantity" name="odCount"
								onkeypress="handleKeyPress(event)" value="1" min="1">
							<button type="button" onclick="increment()">+</button>
							<fmt:formatNumber var="pPrice" value="${productVO.pPrice}" type="number" />
							<span>가격:</span> <span id="price">${pPrice}원</span>
							<input type="hidden" name="pNum" value="${productVO.pNum}">
							<input type="hidden" name="odPrice" value="${productVO.pPrice}">
						</div>
					</div>
	
					<div id="right_button2">
						<button type="button" class="button1" onclick="fn_purchase('${isLogon}', this.form)">구매하기</button>
						<button type="button" class="button2" onclick="fn_carts('${isLogon}', this.form)">장바구니</button>
					</div>
				</form>
			</div>
		</div>

		<div id="content_lest2">
			<hr>
			<div id="content2_text">
				<section id="text">
					<h2>회원가입시 적립금 2000원 증정!</h2>
					<h3>휴무안내</h3>
					<P>정기배송 변경날짜는 톡톡으로 연락부탁드립니다.</P>
				</section>
				<img src="${contextPath}/product2?pImg2=${productVO.pImg2}&pNum=${productVO.pNum}" alt="배너">
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>

</html>