<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>发件箱</title>
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
						<i class="ec-archive"></i> Inbox
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
				<!-- Page start here -->
				<div id="email-sidebar">
					<!-- Start #email-sidebar -->
					<div class="p15">
						<a id="write-email" href="email-write.html" class="btn btn-danger btn-block uppercase"><i class="im-quill"></i> compose</a>
					</div>
					<ul id="email-nav" class="nav nav-pills nav-stacked">
						<li><a href="email-inbox.html"><i class="ec-archive"></i> Inbox <span class="notification blue">27</span></a></li>
						<li><a href="#"><i class="ec-star"></i> Starred <span class="notification orange">2</span></a></li>
						<li><a href="#"><i class="ec-info"></i> Important <span class="notification">5</span></a></li>
						<li><a href="#"><i class="en-location2"></i> Send <span class="notification green">14</span></a></li>
						<li><a href="#"><i class="ec-pencil2"></i> Drafts <span class="notification brown">1</span></a></li>
						<li><a href="#"><i class="ec-trashcan"></i> Trash <span class="notification dark">3</span></a></li>
						<li class="nav-header">Labels</li>
						<li><a href="#"><span class="circle"></span> Work</a></li>
						<li><a href="#"><span class="circle color-red"></span> Private</a></li>
						<li><a href="#"><span class="circle color-green"></span> Travel</a></li>
						<li><a href="#"><span class="circle color-pink"></span> Promotions</a></li>
						<li><a href="#"><span class="circle color-teal"></span> Updates</a></li>
					</ul>
				</div>
				<!--End #email-sidebar -->
				<div id="email-content">
					<!-- Start #email-content -->
					<div class="email-wrapper">
						<!-- Start .email-wrapper -->
						<div class="email-toolbar col-lg-12">
							<!-- Start .email-toolbar -->
							<div class="pull-left" role="toolbar">
								<button id="email-toggle" class="email-toggle" type="button">
									<span class="sr-only">Toggle email nav</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
								</button>
								<a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Refresh inbox"><i class="ec-refresh s16"></i></a> <a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Reply"><i
									class="im-undo s16"></i></a> <a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Forward"><i class="im-redo s16"></i></a> <a href="#"
									class="btn btn-danger btn-round btn-sm tip mr5" title="Delete"><i class="ec-trashcan s16"></i></a> <a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Print"><i
									class="fa-print s16"></i></a>
							</div>
							<ul class="email-pager">
								<li class="pager-info">1-20 of 345</li>
								<li><a href="#" class="btn btn-default btn-round btn-sm"><i class="en-arrow-left4 s16"></i></a></li>
								<li><a href="#" class="btn btn-default btn-round btn-sm"><i class="en-arrow-right5 s16"></i></a></li>
							</ul>
						</div>
						<!-- End .email-toolbar -->
						<div class="email-read">
							<!-- Start .email-read -->
							<div class="email-header">
								<h3>Daily_Report1 - Daily Report Apr 27, 2014</h3>
							</div>
							<div class="email-info-bar">
								<div class="row">
									<div class="from col-lg-8">
										Monitor.Us / <a href="#"><strong>no-reply@monitor.us</strong></a> to <a href="#"><strong>me</strong></a>
									</div>
									<div class="date col-lg-4 text-right">
										<span class="email-date">Apr 27 ( 2 days ago )</span>
									</div>
								</div>
							</div>
							<div class="email-content">
								<!-- Start .email-content -->
								<!-- This is just example email text  -->
								<h4 class="text-center">Uptime monitors</h4>
								<table width="100%" cellspacing="0" border="0">
									<tbody>
										<tr>
											<td colspan="7" style="color:#666666;font-size:13px;font-weight:bold;padding-top:15px">Monitoring Location : All</td>
										</tr>
										<tr
											background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png">
											<th
												background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png"
												style="height:23px;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Test
												Name</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Type</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Group
												Name</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#739b40;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Uptime(%)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Avg
												Resp Time(ms)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#bd5757;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">
												Failures(#)</th>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">suggeelson.com_http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Default</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">1348.76</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd"><a href="http://suggelab.com" target="_blank">suggelab.com</a></td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Padrão</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">147.44</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td colspan="6" style="border-top:1px solid #dddddd">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="7" style="color:#666666;font-size:13px;font-weight:bold;padding-top:15px">Monitoring Location : Germany</td>
										</tr>
										<tr
											background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png">
											<th
												background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png"
												style="height:23px;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Test
												Name</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Type</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Group
												Name</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#739b40;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Uptime(%)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Avg
												Resp Time(ms)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#bd5757;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">
												Failures(#)</th>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">suggeelson.com_http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Default</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">1599.45</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd"><a href="http://suggelab.com" target="_blank">suggelab.com</a></td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Padrão</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">205.21</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td colspan="6" style="border-top:1px solid #dddddd">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="7" style="color:#666666;font-size:13px;font-weight:bold;padding-top:15px">Monitoring Location : US-MID</td>
										</tr>
										<tr
											background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png">
											<th
												background="https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png"
												style="height:23px;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Test
												Name</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Type</th>
											<th
												style="border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:left;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Group
												Name</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#739b40;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Uptime(%)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#666666;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">Avg
												Resp Time(ms)</th>
											<th
												style="white-space:nowrap;border-top:1px solid #dddddd;color:#bd5757;font-size:13px;font-weight:bold;text-align:right;padding:0px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd;background-image:url('https://ci5.googleusercontent.com/proxy/Ap9-c87MgOxxcZj8F6NYc3sN5ObMNmiK4MG10ievYHP7y91qn7yRznHdkQ9QJ9Fawrjbdtvc__0bQ7oBWyb9wo4qsm6082_UV8Hmb2KJY_iLpN2zUtlyIosXlobe-Dghkw=s0-d-e1-ft#http://dashboard.monitis.com/images/weeklyreports/email_report_gradient.png');background-color:#f8f8f8">
												Failures(#)</th>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">suggeelson.com_http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Default</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">1098.06</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td style="color:#127adb;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd"><a href="http://suggelab.com" target="_blank">suggelab.com</a></td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">http</td>
											<td style="color:#666666;font-size:13px;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">Padrão</td>
											<td style="color:#739b40;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">100</td>
											<td style="color:#666666;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-left:1px solid #dddddd">89.67</td>
											<td style="color:#bd5757;font-size:13px;text-align:right;border-top:1px solid #dddddd;padding:4px 2px;border-right:1px solid #dddddd;border-left:1px solid #dddddd">0</td>
										</tr>
										<tr>
											<td colspan="6" style="border-top:1px solid #dddddd">&nbsp;</td>
										</tr>
									</tbody>
								</table>
								<p style="color:#666666;margin-top:24px;font-size:11px;font-family:'Arial';line-height:19px;margin-left:auto;margin-right:auto;display:table;text-align:center">
									Copyright © 2013 - Monitor.Us. All rights reserved. All product and company names herein <br>may be trademarks of their respective owners. To the best of our knowledge, all details were
									<br>correct at the time of publishing; this information is subject to change without notice.
								</p>
								<!-- End of example email content -->
								<div class="attached-files">
									<!-- Start .attached-files -->
									<ul class="list-group">
										<li class="list-group-item"><span class="label label-danger mr10">PDF</span> <strong>Raport.pdf</strong>
											<div class="btn-group pull-right">
												<a href="#" class="btn btn-default">View</a> <a href="#" class="btn btn-default">Download</a>
											</div></li>
										<li class="list-group-item"><span class="label label-primary mr10">HTML</span> <strong>raport.html</strong>
											<div class="btn-group pull-right">
												<a href="#" class="btn btn-default">View</a> <a href="#" class="btn btn-default">Download</a>
											</div></li>
									</ul>
								</div>
								<!-- End .attached-files -->
							</div>
							<!-- End .email-content -->
						</div>
						<!-- End .email-read -->
					</div>
					<!-- End .email-wrapper -->
				</div>
				<!--End #email-content -->
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