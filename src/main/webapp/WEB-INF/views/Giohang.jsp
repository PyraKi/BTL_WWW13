<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Leoshop | Cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href='<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>' 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='<c:url value="resources/css/style.css"/>' rel="stylesheet" type="text/css" media="all" />
<link href='<c:url value="resources/css/form.css"/>' rel="stylesheet" type="text/css" media="all" />
<link href='<c:url value="http://fonts.googleapis.com/css?family=Exo+2"/>' rel='stylesheet' type='text/css'>
<script type="text/javascript" src='<c:url value="resources/js/jquery1.min.js"/>'></script>
<!-- start menu -->
<link href='<c:url value="resources/css/megamenu.css"/>' rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src='<c:url value="resources/js/megamenu.js"/>'></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!--start slider -->
    <link rel="stylesheet" href='<c:url value="resources/css/fwslider.css"/>' media="all">
    <script src='<c:url value="resources/js/jquery-ui.min.js"/>'></script>
    <script src='<c:url value="resources/js/css3-mediaqueries.js"/>'></script>
    <script src='<c:url value="resources/js/fwslider.js"/>'></script>
<!--end slider -->
<script src='<c:url value="resources/js/jquery.easydropdown.js"/>'></script>
</head>
<body>
     <div class="header-top">
	   <div class="wrap"> 
			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login">Account</a></li> |
					<li><a href="">Wishlist</a></li> |
					<li><a href="">Checkout</a></li> |
					<li><a href="login">Log In</a></li> |
					<li><a href="register">Sign Up</a></li>
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	</div>
	<div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<a href="index"><img src='<c:url value="resources/images/logo.png"/>' alt=""/></a>
				</div>
				<div class="menu">
	            <ul class="megamenu skyblue">
			<li class="active grid"><a href="index">Home</a></li>
			<li><a class="color4" href="#">women</a>
				</li>				
				<li><a class="color5" href="#">Men</a>
				</li>
				<li><a class="color6" href="#">Other</a></li>
				<li><a class="color7" href="#">Purchase</a></li>
			</ul>
			</div>
		</div>
     <div class="clear"></div>
     </div>
	</div>
        </div>
        <div class="timers"></div>
        <div class="slidePrev"><span></span></div>
        <div class="slideNext"><span></span></div>
    </div>
    <!--/slider -->
          	<div class="wrap">
				<div class="product">

		<div class="container">
			<div class=" right topnav">
				<h2 class="head">YOUR SHOPPING CART</h2>
				<table class="table table-borderless table-hover">
					<tr>
						<th>Tên sản phẩm</th>
						<th>Hình Sản Phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng</th>
						<th>Tổng giá</th>
						<th>Cập nhật số lượng</th>
						<th>Xóa</th>
					</tr>
						<c:forEach var="item" items="${gioHang}" varStatus="counter">
					<tr>			
						<td>${item.getSanPham().getTenSP()}</td>
						<td><img class="img-responsive Khung" class="img-thumbnail"
								src='<c:url value="/resources/images/${item.getSanPham().getUrl()}"/>' /></td>
						<td>${item.getSanPham().getGiaSP()}</td>					
						<td>${item.getSoLuongMua() }</td>
						<td>(VND) <c:out value="${item.getSoLuongMua()*item.getSanPham().getGiaSP()}"></c:out></td>
						<td>
							<form action="Giohang" method="POST">

										<input type="hidden" name="index" value="${counter.count}">
										<input type="number" style="width: 3em;" name="soLuong"
											min="1" max="200" required="required" value="${item.getSoLuongMua() }">
										<input type="submit" name="submit" value="Cập nhật" class="btn btn-primary btn-sm">
									</form>
						</td>
						<td>
							<form action="removeGioHang" method="POST">
										<input type="hidden" name="index" value="${counter.count}">
										<input type="submit" name="submit" value="xoa" class="btn btn-danger btn-sm">
									</form>
						</td>			
					</tr>					
					</c:forEach>
					<td colspan="7">Tổng tiền :<c:out value=" ${tongDonHang}(VND)"></c:out></td>
				</table>
				<div class="button-right">
					<form action="thanhToanGH" method="POST">
					<c:forEach var="item" items="${gioHang}" varStatus="counter">
						<input type="hidden" name="idsp" value="${item.getSanPham().getIdSP()}">
						<input type="hidden" name="soLuong" value="${item.getSoLuongMua()}">
					</c:forEach>
						<input type="submit" value="Xác nhận mua" class="btn btn-primary" <c:if test="${tongDonHang == 0}"><c:out value="disabled='disabled'"/></c:if>>
					</form>
				</div>

			</div>
		</div>
	</div>
				<div class="clear"></div>
			</div>
		</div>
	   <div class="clear"></div>
	</div>
	</div>
	</div>
   <div class="footer">
		<div class="footer-top">
			<div class="wrap">
			  <div class="section group example">
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src='<c:url value="resources/images/a2.png"/>'/><span class="f-text">Miễn phí giao hàng trên 3 triệu</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="col_1_of_2 span_1_of_2">
					<ul class="f-list">
					  <li><img src='<c:url value="resources/images/a3.png"/>'/><span class="f-text">Gọi cho chúng tôi: 0283.8940 390</span><div class="clear"></div></li>
					</ul>
				</div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>
		<div class="footer-middle">
			<div class="wrap">
		   <div class="section group example">
			   <div class="section group example">
				 <div class="col_1_of_f_2 span_1_of_f_2">
				   <h3>Liên hệ chúng tôi</h3>
                        <div class="company_address">
                            <p>Địa chỉ : Số 12 Nguyễn Văn Bảo, Phường 4</p>
                            <p>Quận Gò Vấp</p>
                            <p>Thành phố Hồ Chí Minh</p>
                            <p>Phone: 0283.8940 390</p>
                            <p>Fax: 0283.8940 390</p>
                            <p>Email: <span>mail@leoshop.com</span></p>
	   		
                        </div>
                        <div class="social-media">
                              <ul>
                                 <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="Google"><a href="#" target="_blank"> </a></span></li>
                                 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Linked in"><a href="#" target="_blank"> </a> </span></li>
                                 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Rss"><a href="#" target="_blank"> </a></span></li>
                                 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="Facebook"><a href="#" target="_blank"> </a></span></li>
                             </ul>
                        </div>
				</div>
				<div class="clear"></div>
		    </div>
		   </div>
		  <div class="clear"></div>
		    </div>
		  </div>
		</div>
</body>
</html>