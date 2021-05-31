<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Leoshop | Chi tiết sản phẩm</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<div class="main">
	<div class="section group">
     <div class="header-top">
	   <div class="wrap"> 
			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login">Account</a></li> |
					<li><a href="checkout">Wishlist</a></li> |
					<li><a href="checkout">Checkout</a></li> |
					<c:if test="!${gettk}">
						<li><a href="login">Log In</a></li> |
						<li><a href="register">Sign Up</a></li>
					</c:if>
					<c:if test="${gettk}">
						<li><a href="lougout">Logout</a></li> |
					</c:if>
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
	   <div class="header-bottom-right">
         <div class="search">	  
				<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </div>
	  <div class="tag-list">
		<ul class="icon1 sub-icon1 profile_img">
			<li><a class="active-icon c2" href="#"> </a>
				<ul class="sub-icon1 list">
					<li><h3>Giỏ hàng</h3><a href=""></a></li>
					<li><p>Kiểm tra giỏ hàng của bạn</a></p></li>
				</ul>
			</li>
		</ul>
	     <ul class="last"><li><a href="Giohang">Cart(${gh.chiTietHoaDons.size()})</a></li></ul>
	  </div>
    </div>
     <div class="clear"></div>
     </div>
	</div>
<div class="main">
<div class="mens">    
  <div class="main">
     <div class="wrap">
     	<ul class="breadcrumb breadcrumb__t"><a class="home" href="#">Home</a> / <a href="#">Dolor sit amet</a> / Lorem ipsum dolor sit amet</ul>
		<div class="cont span_2_of_3">
		  	<div class="grid images_3_of_2">
						<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image" src='<c:url value="/resources/images/${sp.url}"/>' class="img-responsive" />
								</a>
							</li>
						</ul>
						 <div class="clearfix"></div>
	            </div>
		         <div class="desc1 span_3_of_2">
		         	<h3 class="m_3">${sp.tenSP}</h3>
		             <p class="m_5">VND ${sp.giaSP} <span class="reducedfrom"> ${sp.giaSP + sp.giaSP*0.1}</span></p>
		            <p class="m_3">	<span class="m_link">Số lượng: ${sp.soLuong}</span></p>
		         	 <div class="btn_form">
						<form:form method="POST" action="addGioHang">
								<input type="hidden" value="${sp.getIdSP()}" name="idsp">
								<c:choose>
												<c:when test="${sp.getSoLuong() == 0}">
														<input type="submit" name="addToCart" value="Add to cart"
														style="pointer-events: none;">
												</c:when>
												<c:when test="${sp.getSoLuong() > 0}">
														<input type="submit" name="addToCart" value="Add to cart">
												</c:when>
									</c:choose>
							</form:form>
					 </div>
					<span class="m_link">Mô tả</span>
				     <p class="m_text2">${sp.moTa}</p>
			     </div>
			   <div class="clear"></div>	
	    <div class="clients">
	<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel();
			$("#flexiselDemo2").flexisel({
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		
			$("#flexiselDemo3").flexisel({
				visibleItems: 5,
				animationSpeed: 1000,
				autoPlay: false,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script src='<c:url value="resources/js/jquery.flexisel.js"/>' type="text/javascript"></script>
     </div>
 </div>
</div>
<div class="clear"></div>
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