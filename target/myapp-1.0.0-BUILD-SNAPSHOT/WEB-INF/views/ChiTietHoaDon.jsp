<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Template</title>
<link rel="stylesheet"
	href='<c:url value="resources/css/bootstrap.css"/>'>
<link rel="stylesheet"
	href='<c:url value="resources/css/font-awesome.css"/>'>
<link rel="stylesheet" href='<c:url value="resources/css/style.css"/>'>
<link rel="stylesheet"
	href='<c:url value="resources/css/jstarbox.css"/>'>
<style>
.split {
	height: 100%;
	position: fixed;
	z-index: 1;
	overflow-x: hidden;
	padding-top: 20px;
}

.left {
	width: 30%;
	left: 0;
}

.right {
	width: 70%;
	right: 0;
}

.a {
	width: 450px;
	height: 270px;
	border: 1px solid black;
	padding: 5px;
	margin: 10px;
	margin-left: 50px;
	float: left;
	text-align: center;
}

.topnav input[type=text], h2 {
	padding: 18x;
	margin-top: 8px;
	margin-right: 16px;
	margin-left: 22px;
	font-size: 17px;
}

.topnav input[type=submit] {
	padding: 18x;
	margin-top: 8px;
	margin-right: 12px;
	font-size: 17px;
}

.img {
	margin-top: 20px;
	width: 100px;
	height: 150px;
	margin-left: 10px;
	float: left;
}

.mua {
	float: left;
	margin-top: 20px;
}

div.scrollmenu {
	background-color: #333;
	overflow: auto;
	white-space: nowrap;
}

.topnav input[type=text], h2 {
	padding: 18x;
	margin-top: 8px;
	margin-right: 16px;
	margin-left: 22px;
	font-size: 17px;
}

.head-login {
	float: right;
	text-align: right;
	color: blue;
}

.nav>li {
	float: left;
	margin-right: 15px;
}

table {
	width: 98%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

.b {
	background: #5D6D7E;
	color: white;
	font-size: 22px;
}

.nav>li>a {
	text-transform: uppercase;
	color: red;
}

.nav li {
	position: relative;
	list-style: none;
}
th, td {
  padding: 12px;
  text-align: left;
}
.nav li a {
	padding: 10px;
	line-height: 20px;
	display: inline-block;
}

.nav .sub-menu {
	display: none;
	position: absolute;
	top: 0;
	left: 100%;
	width: auto;
	background-color: #eee;
}

.nav li:hover>.sub-menu {
	display: block;
}

.nav>li>.sub-menu {
	top: 40px;
	left: 0;
}

.TK-left {
	float: right;
	padding: 7px;
	padding-left: 0px;
}

.img-right {
	float: left;
	margin-top: 40px;
	text-align: center;
	margin-left: 30px;
}

.text {size: 50px;
	
}

.mua-left {
	float: right;
}

.button-right {
	float: right;
}
p{
	float: right;
}
.Khung{
	height: 75px;
	width: 50px;
}
</style>

</head>
<body>
	<%@ include file="header.jsp" %>
	<%@ include file="menu.jsp" %>

	<div class="product">

		<div class="container">
			<div class=" right topnav">
				<h3>Chi tiết đặt hàng</h3>
				
					
						<c:forEach var="item" items="${gioHang}" varStatus="counter">
					<tr>			
						<td>${item.getSanPham().getTenSP()}</td>
						<td><img class="img-responsive Khung"
								src='<c:url value="/resources/img/Imagesp/${item.getSanPham().getUrl()}"/>' /></td>
						
						<td>${item.getSanPham().getGiaSP()}</td>					
						<td><input type="number" value="${item.getSoLuongMua() }" ></td>
						<td>(VND) <c:out value="${item.getSoLuongMua()*item.getSanPham().getGiaSP()}"></c:out></td>
						<td>
							<form action="Giohang" method="POST">

										<input type="hidden" name="index" value="${counter.count}">
										<input type="number" style="width: 5em;" name="soLuong"
											min="1" max="200" required="required" value="${item.getSoLuongMua() }">
										<input type="submit" name="submit" value="Cập nhật" class="btn btn-primary">
									</form>
					
							
							
						
					</c:forEach>
					Tổng tiền :<p><c:out value=" ${tongDonHang}(VND)"></c:out></p>
				
				<div class="button-right">
					<form action="thanhToanGH" method="POST">
					<c:forEach var="item" items="${gioHang}" varStatus="counter">
						<input type="hidden" name="idsp" value="${item.getSanPham().getIdSP()}">
						<input type="hidden" name="soLuong" value="${item.getSoLuongMua()}">
					</c:forEach>
					
						<input type="submit" value="Xác nhận mua" >
					</form>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
