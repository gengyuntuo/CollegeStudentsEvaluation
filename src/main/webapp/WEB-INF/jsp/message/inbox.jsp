<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>收件箱</title>
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
						<div class="email-toolbar col-lg-12">
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
						<div class="email-toolbar-search col-lg-12">
							<form>
								<input type="text" class="form-control input-xlarge" name="search" placeholder="Search for email ...">
							</form>
						</div>
						<div class="email-list col-lg-12">
							<table class="table table-striped table-hover table-fixed-layout non-responsive">
								<tbody>
									<tr>
										<td class="email-select input-mini"><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Twitter</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> SuggeElson, check out your week on Twitter. <span class="text-muted small ml10">SuggeElson
													see your week in review. Theese tweets help you to make connections...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 28</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">FC Barcelona Fans</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-pink mr10">Promotions</span> Tito, eternaly remembered <span class="text-muted small ml10">Barca
													fans mobile view as web page...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 28</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">ADATA</a></td>
										<td class="email-intro"><a href="email-read.html"> A sense of speed you can't even begin to imagine <span class="text-muted small ml10">If you unable to see this message
													please click bellow ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 27</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Monitor.US</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> Daily_Report1 - Daily Report Apr 26, 2014 <span class="text-muted small ml10">Uptime
													monior, monitor location, All Test name ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 27</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">service@intl.paypal.com</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> Receipt for Your Payment to Digital Ocean, Inc.
										</a></td>
										<td class="email-date text-right input-mini">Apr 26</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Jonh Stanton</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-primary mr10">Work</span> SuggeElson, please come to office tomorrow. <span class="text-muted small ml10">We
													need to discus the new project ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 27</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Golden Sans Holiday</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-success mr10">Travel</span> Your trip to spain is arranged successful. <span
												class="text-muted small ml10">You will enjoy the trip to Barcelona, Spain ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 25</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">me, Girlfriend <span class="count-msg">(2)</span></a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-danger mr10">Private</span> Please check out this new house is awesome. <span
												class="text-muted small ml10">Will be nice to move in, he has big pool ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 25</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Support, me <span class="count-msg">(17)</span></a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-primary mr10">Work</span> The progress bar now work correctly. <span class="text-muted small ml10">I
													extract the files you send me and now all is good ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 24</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">support</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> You sold a item ! <span class="text-muted small ml10">Congratulations,
													you sold the following item - Supr Responsive admin template</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 24</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Twitter</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> SuggeElson, check out your week on Twitter. <span class="text-muted small ml10">SuggeElson
													see your week in review. Theese tweets help you to make connections...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 23</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">FC Barcelona Fans</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-pink mr10">Promotions</span> Tito, eternaly remembered <span class="text-muted small ml10">Barca
													fans mobile view as web page...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 23</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">ADATA</a></td>
										<td class="email-intro"><a href="email-read.html"> A sense of speed you can't even begin to imagine <span class="text-muted small ml10">If you unable to see this message
													please click bellow ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 22</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Monitor.US</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> Daily_Report1 - Daily Report Apr 26, 2014 <span class="text-muted small ml10">Uptime
													monior, monitor location, All Test name ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 22</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">service@intl.paypal.com</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> Receipt for Your Payment to Digital Ocean, Inc.
										</a></td>
										<td class="email-date text-right input-mini">Apr 22</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Jonh Stanton</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-primary mr10">Work</span> SuggeElson, please come to office tomorrow. <span class="text-muted small ml10">We
													need to discus the new project ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 21</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Golden Sans Holiday</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-success mr10">Travel</span> Your trip to spain is arranged successful. <span
												class="text-muted small ml10">You will enjoy the trip to Barcelona, Spain ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 21</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">me, Girlfriend <span class="count-msg">(2)</span></a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-danger mr10">Private</span> Please check out this new house is awesome. <span
												class="text-muted small ml10">Will be nice to move in, he has big pool ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 21</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">Support, me <span class="count-msg">(17)</span></a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-primary mr10">Work</span> The progress bar now work correctly. <span class="text-muted small ml10">I
													extract the files you send me and now all is good ...</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 20</td>
									</tr>
									<tr>
										<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
										</label></td>
										<td class="email-star input-mini"><i class="im-star s20"></i></td>
										<td class="email-subject"><a href="email-read.html">support</a></td>
										<td class="email-intro"><a href="email-read.html"> <span class="label label-teal mr10">Updates</span> You sold a item ! <span class="text-muted small ml10">Congratulations,
													you sold the following item - Supr Responsive admin template</span>
										</a></td>
										<td class="email-date text-right input-mini">Apr 20</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
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
	<script src="<c:url value="/assets/js/pages/email.js" />"></script>
</body>
</html>