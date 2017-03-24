<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学院概述</title>
<!-- 移动设备metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Force IE9 to render in normal mode -->
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<jsp:include page="../com/metas.jsp" />
<!-- Import google fonts - Heading first/ text second -->
<link rel='stylesheet' type='text/css' />
<!--[if lt IE 9]>
<![endif]-->
<jsp:include page="../com/css.jsp" />
</head>
<body>
	<!-- Start #header -->
	<jsp:include page="../com/navbar.jsp"></jsp:include>
	<!-- End #header -->
	<!-- Start #sidebar -->
	<jsp:include page="../com/sidebar.jsp"></jsp:include>
	<!-- End #sidebar -->
	<!-- Start #content -->
	<div id="content">
		<!-- Start .content-wrapper -->
		<div class="content-wrapper">
			<div class="row">
				<!-- Start .row -->
				<!-- Start .page-header -->
				<div class="col-lg-12 heading">
					<h1 class="page-header">
						<i class="im-screen"></i> 学院概述
					</h1>
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<!-- Start .outlet -->
			<div class="outlet">
				<!-- Page start here ( usual with .row ) -->
				<div class="row">
					<!-- Start .row -->
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="carousel-tile carousel vertical slide">
							<div class="carousel-inner">
								<div class="item active">
									<div class="tile red">
										<div class="tile-icon">
											<i class="br-cart s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">${list.total }</div>
											<h3>学院数</h3>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="tile orange">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="ec-cog s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">${list.total }</div>
											<h3>学院数</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Carousel -->
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="carousel-tile carousel slide">
							<div class="carousel-inner">
								<div class="item active">
									<div class="tile blue">
										<div class="tile-icon">
											<i class="st-chat s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">24</div>
											<h3>New Comments</h3>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="tile brown">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="ec-mail s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">17</div>
											<h3>New emails</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Carousel -->
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="carousel-tile carousel vertical slide">
							<div class="carousel-inner">
								<div class="item active">
									<div class="tile green">
										<div class="tile-icon">
											<i class="ec-users s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">325</div>
											<h3>New users</h3>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="tile purple">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="ec-search s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">2540</div>
											<h3>Searches</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Carousel -->
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="carousel-tile carousel slide">
							<div class="carousel-inner">
								<div class="item active">
									<div class="tile teal">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="ec-images s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">45</div>
											<h3>New images</h3>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="tile magenta">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="ec-share s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">3548</div>
											<h3>Posts shared</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End Carousel -->
					</div>
				</div>
				<!-- End .row -->
				<!-- Start .row -->
				<div class="row"></div>
				<!-- End .row -->
				<!-- Page End here -->
			</div>
			<!-- End .outlet -->
		</div>
		<!-- End .content-wrapper -->
		<div class="clearfix"></div>
	</div>
	<!-- End #content -->
	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="assets/js/pages/dashboard.js"></script>
</body>
</html>