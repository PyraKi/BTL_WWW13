<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Leoshop | Login</title>
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
    <script src='<c:url value="resources/js/fwslider.js"/>'></script>z`
<!--end slider -->
<script src='<c:url value="resources/js/jquery.easydropdown.js"/>'></script>
</head>
<body>
     <div class="header-top">
	   <div class="wrap"> 
			 <div class="cssmenu">
				<ul>
					<li><a href="logout">Logout</a></li>
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
	    <nav class="navbar navbar-light bg-light">
	    	<a href="Quanlysp"><button class="btn btn-info">Quản lý sản phẩm</button></a>
	    	<a href="Quanlylsp"><button class="btn btn-info">Quản lý loại sản phẩm</button></a>
	    	<a href="Quanlyhoadon"><button class="btn btn-info">Quản lý hóa đơn</button></a>
	    	<a href="addSanpham"><button class="btn btn-info">Thêm sản phẩm</button></a>
	    </nav>
		<div class="clearfix"></div>
		<div class="product">
		<div class="container">
			<h3 style="color: red">${tenSP}</h3>
			<div class=" right topnav">
				<div id="#dvPreview1"></div>
				<table class="table table-borderless table-hover">
					<tr>

						<th>Mã Sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Đơn giá sản phẩm</th>
						<th>Số lượng</th>
						<th>Hình</th>
						<th>Edit</th>
						<th>Remove</th>
					</tr>

					<c:forEach var="sp" items="${dssp }">
						<tr>

							<th>${sp.getIdSP()}</th>
							<th>${sp.getTenSP()}</th>
							<th>${sp.getGiaSP()}</th>
							<th>${sp.getSoLuong()}</th>
							<th><img
								src='<c:url value="/resources/images/${sp.getUrl()}"/>'
								class="img-responsive Khung" class="img-thumbnail"></th>
							<!-- <form method="Post" action="addSua">
							<input type="hidden" value="${sp.getIdSP()}" name="idan"/><input class='myBtn' type="submit" value="Edit"/>
						</form> -->
							<th><c:url var="addCcUrl"
									value="/addSua?idspan=${sp.getIdSP()}" />
								<p>
									<a class="btn btn-info" href="${addCcUrl}">Edit</a>
								</p></th>
							<form action="quanlysp" method="post">
								<input type="hidden" value="${sp.getIdSP()}" name="idspan">
								<th><button class="btn btn-danger" type="submit"
										value="remove">Remove</button></th>
							</form>
						</tr>

						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 style="text-align: center">Cập nhật sản phẩm</h4>
									</div>
									<div class="modal-body">
										<form action="addSP" method="post">
											<input type="hidden" name="idan" value="${sp.getIdSP()}">
											<h4>Tên sản phẩm : ${sp.getTenSP()}</h4>

											<h4>Giá sản phẩm : ${sp.getGiaSP()}</h4>

											<h4>Số lượng : ${sp.getSoLuong()}</h4>

											<h4>Mô tả : ${sp.getMoTa()}</h4>

											<h4>Hình ảnh : ${sp.getUrl()}</h4>

											<br /> <br />

										</form>
									</div>
									<div class="modal-footer"></div>
								</div>
							</div>
						</div>
					</c:forEach>
				</table>
			</div> 
			</div>
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