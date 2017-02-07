<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>专业概述</title>
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
	<!-- Start #right-sidebar -->
	<jsp:include page="../com/rightsidebar.jsp"></jsp:include>
	<!-- End #right-sidebar -->
	<!-- Start #content -->
	<div id="content">
		<!-- Start .content-wrapper -->
		<div class="content-wrapper">
			<div class="row">
				<!-- Start .row -->
				<!-- Start .page-header -->
				<div class="col-lg-12 heading">
					<h1 class="page-header">
						<i class="im-screen"></i> 专业概述
					</h1>
					<!-- Start .bredcrumb -->
					<ul id="crumb" class="breadcrumb">
					</ul>
					<!-- End .breadcrumb -->
					<!-- Start .option-buttons -->
					<div class="option-buttons">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group">
								<a id="clear-localstorage" class="btn tip" title="Reset panels position"> <i class="ec-refresh color-red s24"></i>
								</a>
							</div>
							<div class="btn-group dropdown">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1"><i class="br-grid s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu1">
									<div class="option-dropdown">
										<div class="shortcut-button">
											<a href="#"> <i class="im-pie"></i> <span>Earning Stats</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-images color-dark"></i> <span>Gallery</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="en-light-bulb color-orange"></i> <span>Fresh ideas</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-link color-blue"></i> <span>Links</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-support color-red"></i> <span>Support</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="st-lock color-teal"></i> <span>Lock area</span>
											</a>
										</div>
									</div>
								</div>
							</div>
							<div class="btn-group dropdown">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu2"><i class="ec-pencil s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2">
									<div class="option-dropdown">
										<div class="row">
											<p class="col-lg-12">Quick post</p>
											<form class="form-horizontal" role="form">
												<div class="form-group">
													<div class="col-lg-12">
														<input type="text" class="form-control" placeholder="Enter title">
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<textarea class="form-control wysiwyg" placeholder="Enter text"></textarea>
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<input type="text" class="form-control tags1" placeholder="Enter tags">
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<button class="btn btn-default btn-xs">Save Draft</button>
														<button class="btn btn-success btn-xs pull-right">Publish</button>
													</div>
												</div>
												<!-- End .form-group  -->
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="btn-group">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu3"><i class="ec-help s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu3">
									<div class="option-dropdown">
										<p>
											First time visitor ? <a href="#" id="app-tour" class="btn btn-success ml15">Take app tour</a>
										</p>
										<hr>
										<p>
											Or check the <a href="#" class="btn btn-danger ml15">FAQ</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End .option-buttons -->
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<div class="outlet">
				<!-- Start .outlet -->
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
											<div class="number">${pageInfo.total }</div>
											<h3>专业数</h3>
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
											<div class="number">${pageInfo.total }</div>
											<h3>专业数</h3>
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
				<div class="row">
					<!-- Start .row -->
					<div class="col-lg-6 col-md-6 sortable-layout">
						<!-- Start col-lg-6 -->
						<div class="panel panel-teal toggle panelMove panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="im-bars"></i> Page views
								</h4>
							</div>
							<div class="panel-body">
								<div id="stats-pageviews" style="width: 100%; height:250px;"></div>
							</div>
							<div class="panel-footer teal-bg">
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="tile teal m0">
										<div class="tile-content text-center pl0 pr0">
											<div id="countToday" class="number">75</div>
											<h3>Today</h3>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="tile teal m0">
										<div class="tile-content text-center pl0 pr0">
											<div id="countYesterday" class="number">69</div>
											<h3>Yesterday</h3>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="tile teal m0">
										<div class="tile-content text-center pl0 pr0">
											<div id="countWeek" class="number">380</div>
											<h3>This Week</h3>
										</div>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="tile teal m0">
										<div class="tile-content text-center pl0 pr0">
											<div id="countTotal" class="number">1254</div>
											<h3>Total</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End .panel -->
						<div class="panel panel-brown panelMove">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="st-camera"></i> Instagram activity
								</h4>
								<div class="pull-right mt10">
									<a href="#" class="color-grayspr">@SuggeElson</a>
								</div>
							</div>
							<div class="panel-body p0">
								<div class="instagram-widget">
									<div class="instagram-widget-header gray-bg">
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<!-- col-lg-4 start here -->
											<a href="#">
												<p class="instagram-widget-text">Followers</p> <strong class="instagram-widget-number">1256</strong>
											</a>
										</div>
										<!-- col-lg-4 end here -->
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<!-- col-lg-4 start here -->
											<a href="#">
												<p class="instagram-widget-text">Following</p> <strong class="instagram-widget-number">345</strong>
											</a>
										</div>
										<!-- col-lg-4 end here -->
										<div class="col-lg-4 col-md-4 col-xs-4 text-center">
											<!-- col-lg-4 start here -->
											<a href="#">
												<p class="instagram-widget-text">Shots</p> <strong class="instagram-widget-number">176</strong>
											</a>
										</div>
										<!-- col-lg-4 end here -->
									</div>
									<div class="instagram-widget-image">
										<div id="instagram-widget" class="carousel slide">
											<!-- Indicators -->
											<ol class="carousel-indicators dotstyle">
												<li data-target="#instagram-widget" data-slide-to="0" class="active"><a href="#">Image 1</a></li>
												<li data-target="#instagram-widget" data-slide-to="1"><a href="#">Image 2</a></li>
												<li data-target="#instagram-widget" data-slide-to="2"><a href="#">Image 3</a></li>
											</ol>
											<div class="carousel-inner">
												<figure class="item active">
													<img class="img-responsive" src="assets/img/instagram/instagram.jpg" alt="image">
												</figure>
												<figure class="item">
													<img class="img-responsive" src="assets/img/instagram/instagram2.jpg" alt="image">
												</figure>
												<figure class="item">
													<img class="img-responsive" src="assets/img/instagram/instagram3.jpg" alt="image">
												</figure>
											</div>
										</div>
										<!-- End Carousel -->
									</div>
									<div class="instagram-widget-footer">
										<div class="col-lg-6 col-md-6 col-xs-6 text-center">
											<!-- col-lg-6 start here -->
											<p>
												<a href="#"> <i class="ec-chat mr5"></i> <strong class="instagram-widget-number">17</strong>
												</a>
											</p>
										</div>
										<!-- col-lg-6 end here -->
										<div class="col-lg-6 col-md-6 col-xs-6 text-center">
											<!-- col-lg-6 start here -->
											<p>
												<a href="#"> <i class="ec-heart mr5"></i> <strong class="instagram-widget-number">27</strong>
												</a>
											</p>
										</div>
										<!-- col-lg-6 end here -->
									</div>
								</div>
							</div>
						</div>
						<!-- End .panel -->
						<div class="panel panel-default panelMove plain">
							<!-- Start .panel -->
							<div class="panel-heading white-bg"></div>
							<div class="panel-body p0">
								<div id="calendar"></div>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- End col-lg-6 -->
					<div class="col-lg-6 col-md-6 sortable-layout">
						<!-- Start col-lg-6 -->
						<div class="panel panel-primary plain toggle panelMove panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="im-bars"></i> Week Earnings
								</h4>
							</div>
							<div class="panel-body blue-bg">
								<div id="stats-earnings" style="width: 100%; height:250px;"></div>
							</div>
							<div class="panel-footer white-bg">
								<div id="stats-category-earnings" class="col-lg-6 col-md-12" style="height:150px;"></div>
								<div id="stats-earnings-bars" class="col-lg-6 col-md-12" style="height:150px;"></div>
							</div>
						</div>
						<!-- End .panel -->
						<div class="weather-widget panel panel-primary plain toggle panelMove panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">Weather now</h4>
							</div>
							<div class="panel-body blue-bg text-center">
								<canvas id="weather-now" width="128" height="128"></canvas>
								<p class="weather-location">
									<strong>23&deg;C</strong> Madrid
								</p>
							</div>
							<div class="panel-footer white-bg text-center">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<!-- col-lg-3 start here -->
									<p class="weather-day">MON</p>
									<canvas id="forecast-now" width="64" height="64"></canvas>
									<p class="weather-degree">23&deg;C</p>
								</div>
								<!-- col-lg-3 end here -->
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<!-- col-lg-3 start here -->
									<p class="weather-day">TUE</p>
									<canvas id="forecast-day1" width="64" height="64"></canvas>
									<p class="weather-degree">17&deg;C</p>
								</div>
								<!-- col-lg-3 end here -->
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<!-- col-lg-3 start here -->
									<p class="weather-day">WED</p>
									<canvas id="forecast-day2" width="64" height="64"></canvas>
									<p class="weather-degree">15&deg;C</p>
								</div>
								<!-- col-lg-3 end here -->
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
									<!-- col-lg-3 start here -->
									<p class="weather-day">THU</p>
									<canvas id="forecast-day3" width="64" height="64"></canvas>
									<p class="weather-degree">18&deg;C</p>
								</div>
								<!-- col-lg-3 end here -->
							</div>
						</div>
						<!-- End .panel -->
						<div class="panel panel-default toggle panelMove panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">
									<i class="fa-list"></i> ToDo
								</h4>
							</div>
							<div class="panel-body">
								<div class="todo-widget">
									<div class="todo-header">
										<div class="todo-search">
											<form>
												<input type="text" class="form-control" name="search" placeholder="Search for todo ...">
											</form>
										</div>
										<div class="todo-add">
											<a href="#" class="btn btn-primary tip" title="Add new todo"><i class="im-plus"></i></a>
										</div>
									</div>
									<h4 class="todo-period">Today</h4>
									<ul class="todo-list" id="today">
										<li class="todo-task-item"><label class="checkbox"> <input type="checkbox">
										</label>
											<div class="todo-priority normal tip" title="Normal priority">
												<i class="im-radio-checked"></i>
											</div> <span class="todo-category label label-primary"> javascript </span>
											<div class="todo-task-text">Add scroll function to template</div>
											<button type="button" class="close todo-close">&times;</button></li>
										<li class="todo-task-item"><label class="checkbox"> <input type="checkbox">
										</label>
											<div class="todo-priority high tip" title="High priority">
												<i class="im-radio-checked"></i>
											</div> <span class="todo-category label label-brown"> less </span>
											<div class="todo-task-text">Fix main less file</div>
											<button type="button" class="close todo-close">&times;</button></li>
										<li class="todo-task-item task-done"><label class="checkbox"> <input type="checkbox" checked>
										</label>
											<div class="todo-priority high tip" title="High priority">
												<i class="im-radio-checked"></i>
											</div> <span class="todo-category label label-info"> html </span>
											<div class="todo-task-text">Change navigation structure</div>
											<button type="button" class="close todo-close">&times;</button></li>
									</ul>
									<h4 class="todo-period">Tomorrow</h4>
									<ul class="todo-list" id="tomorrow">
										<li class="todo-task-item"><label class="checkbox"> <input type="checkbox">
										</label>
											<div class="todo-priority tip" title="Low priority">
												<i class="im-radio-checked"></i>
											</div> <span class="todo-category label label-dark"> css </span>
											<div class="todo-task-text">Create slide panel widget</div>
											<button type="button" class="close todo-close">&times;</button></li>
										<li class="todo-task-item"><label class="checkbox"> <input type="checkbox">
										</label>
											<div class="todo-priority medium tip" title="Medium priority">
												<i class="im-radio-checked"></i>
											</div> <span class="todo-category label label-danger"> php </span>
											<div class="todo-task-text">Edit the main controller</div>
											<button type="button" class="close todo-close">&times;</button></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- End col-lg-6 -->
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