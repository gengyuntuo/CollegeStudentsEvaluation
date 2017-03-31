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
	<!-- Start #content -->
	<div id="content">
		<!-- Start .content-wrapper -->
		<div class="content-wrapper">
			<div class="row">
				<!-- Start .row -->
				<!-- Start .page-header -->
				<div class="col-lg-12 heading">
					<h1 class="page-header">
						<i class="ec-archive"></i> 收件箱
					</h1>
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
						<a id="write-email" href="wrirteEmail.do" class="btn btn-danger btn-block uppercase"><i class="im-quill"></i> 写信息</a>
					</div>
					<ul id="email-nav" class="nav nav-pills nav-stacked">
						<li><a href="email-inbox.html"><i class="ec-archive"></i> 收件箱 <span class="notification blue">27</span></a></li>
						<li><a href="#"><i class="en-location2"></i> 发件箱 <span class="notification green">14</span></a></li>
						<li><a href="#"><i class="ec-trashcan"></i> 垃圾箱 <span class="notification dark">3</span></a></li>
						<li class="nav-header">标签</li>
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
									<span class="sr-only">邮箱导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
								</button>
								<a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Refresh inbox"><i class="ec-refresh s16"></i></a> <a href="#" class="btn btn-danger btn-round btn-sm tip mr5" title="Delete"><i
									class="ec-trashcan s16"></i></a> <a href="#" class="btn btn-default btn-round btn-sm tip mr5" title="Print"><i class="fa-print s16"></i></a>
							</div>
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