<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学院</title>
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
											<i class="fa-tasks s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">${list.total }</div>
											<h3>专业个数</h3>
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
											<i class="im-office s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">24</div>
											<h3>班级个数</h3>
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
											<i class="im-users s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">325</div>
											<h3>学生人数</h3>
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
								<div class="item active" onclick="javascript:window.location.href='index.do'">
									<div class="tile teal">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="im-office s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">45</div>
											<h3>历史班级数</h3>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="tile brown">
										<!-- tile start here -->
										<div class="tile-icon">
											<i class="im-users s64"></i>
										</div>
										<div class="tile-content">
											<div class="number">3548</div>
											<h3>历史学生数</h3>
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
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<div class="page-header">
							<h4>学院简介</h4>
						</div>
						<div class="panel panel-primary">
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia, suscipit, autem sit natus deserunt officia error odit ea minima soluta ratione maxime molestias fugit explicabo
								aspernatur praesentium quisquam voluptatum fuga delectus quidem quas aliquam minus at corporis libero? Modi, aperiam, pariatur, sequi illum dolore consequuntur aspernatur eos hic officia
								doloribus magnam impedit autem maiores alias consectetur tempore explicabo. Ducimus, minima, suscipit unde harum numquam ipsa laboriosam cupiditate nemo repellendus at? Dolorum dicta nemo
								quaerat iusto.</p>
						</div>
					</div>
				</div>
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