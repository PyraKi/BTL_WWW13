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
    <script src='<c:url value="resources/js/fwslider.js"/>'></script>
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
	    	<a href="addLoaisp"><button class="btn btn-info">Thêm loại sản phẩm</button></a>
	    </nav>
		<div class="product">
		<div class="main-agileits">
			<div class="form-w3agile form1">
				<form:form action="updateSP" method="post">
					<h4>Mã sản phẩm</h4>
					<div class="key">
					
						<input class="form-control" type="text" name="idsp"
							value="${sp.idSP}" readonly="readonly">
						<div class="clearfix"></div>

					</div>

					<h4>Tên sản phẩm</h4>
					<div class="key">

						<input class="form-control" type="text" name="namesp"
							value="${sp.tenSP}" required="required">
						<div class="clearfix"></div>
					</div>

					<h4>Giá sản phẩm</h4>
					<div class="key">

						<input class="form-control" type="text" name="gia"
							value="${sp.giaSP}" required="required">
						<div class="clearfix"></div>
					</div>

					<h4>Số lượng</h4>
					<div>

						<input class="form-control" type="number" name="sl"
							value="${sp.soLuong}" required="required">
						<div class="clearfix"></div>
					</div>
					<br>
					<h4>Mô tả</h4>
					<div class="key">

						<input class="form-control" type="text" name="mota"
							value="${sp.moTa}" required="required">
						<div class="clearfix"></div>
					</div>
					<br>
					<h4>Năm sản xuất</h4>
					<div>

						<input class="form-control" required="required" type="date"
							name="namsx" value="${sp.namSXSP}" />
						<div class="clearfix"></div>
					</div>
					<br>
					<h4>Thời gian bảo hành</h4>
					<div>
						<input class="form-control" type="date" name="timebh"
							value="${sp.thoiGianBaoHanh}" required="required">
						<div class="clearfix"></div>
					</div>
					<br>
					<h4>Hình ảnh</h4>
					<div>
						<img id="image" class="rounded-circle image_avata"
							onchange="readURLReview(this)"
							src='<c:url value="/resources/images/${sp.getUrl()}"/>' alt=""> <input
							type="hidden" value="${sp.getUrl()}" name="img"> 
							<input type="file" id="fileload" name="files" title="Load file"
							accept="image/x-png,image/gif,image/jpeg" style="display: none" />
						<div class="clearfix"></div>
					</div>
					<br />

					<h4>Loại sản phẩm</h4>
					<select class="form-control" name="idlsp">
						<c:forEach items="${dslsp}" var="lsp">

							<option value="${lsp.idLoaiSP}"><p>${lsp.tenLoaiSP}</p>
							</option>

						</c:forEach>
					</select>
					<br></br>
					<input type="submit" value="Thêm/Sửa sản phẩm" class="btn btn-success">
					<a href="Quanlysp"><button type="button" class="btn btn-secondary float-right">Back</button></a>
				</form:form>
			</div>
		</div>
	<div class="clear"></div>
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