<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>班级列表</title>
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
						<i class="im-table2"></i> 班级列表
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
					<div class="col-lg-12">
						<!-- col-lg-12 start here -->
						<div class="panel panel-default plain toggle panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<h4 class="panel-title">班级</h4>
							</div>
							<div class="panel-body">
								<table class="table">
									<thead>
										<tr>
											<th class="per5"><label class="checkbox"> <input class="check-all" type="checkbox" id="inlineCheckbox1" value="option1">
											</label></th>
											<th class="per35">Employe</th>
											<th class="per15">Position</th>
											<th class="per15">Salary</th>
											<th class="per35">Contract</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option2">
											</label></td>
											<td>Jacob Olsen</td>
											<td>Developer</td>
											<td>2530$</td>
											<td>
												<div class="progress">
													<div class="progress-bar progress-bar-success animated-bar" role="progressbar" aria-valuenow="40" style="width: 40%;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
											</label></td>
											<td>Lara James</td>
											<td>SEO</td>
											<td>3700$</td>
											<td>
												<div class="progress">
													<div class="progress-bar progress-bar-danger animated-bar" role="progressbar" aria-valuenow="89" style="width: 89%;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option4">
											</label></td>
											<td>Steve Sidwell</td>
											<td>Photographer</td>
											<td>1340$</td>
											<td>
												<div class="progress">
													<div class="progress-bar progress-bar-warning animated-bar" role="progressbar" aria-valuenow="67" style="width: 67%;"></div>
												</div>
											</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option5">
											</label></td>
											<td>Elena Dobrev</td>
											<td>Project manger</td>
											<td>5600$</td>
											<td>
												<div class="progress">
													<div class="progress-bar progress-bar-info animated-bar" role="progressbar" aria-valuenow="7" style="width: 7%;"></div>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-12 end here -->
				</div>
				<div class="row">
					<!-- Start .row -->
					<div class="col-lg-6 col-md-6">
						<!-- col-lg-6 start here -->
						<div class="panel panel-default plain toggle panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<h4 class="panel-title">Stripped table</h4>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th class="per5"><label class="checkbox"> <input class="check-all" type="checkbox" value="option1">
											</label></th>
											<th class="per40">Employe</th>
											<th class="per40">Position</th>
											<th class="per15">Salary</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option2">
											</label></td>
											<td>Jacob Olsen</td>
											<td>Developer</td>
											<td>2530$</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option3">
											</label></td>
											<td>Lara James</td>
											<td>SEO</td>
											<td>3700$</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option4">
											</label></td>
											<td>Steve Sidwell</td>
											<td>Photographer</td>
											<td>1340$</td>
										</tr>
										<tr>
											<td><label class="checkbox"> <input class="check" type="checkbox" value="option5">
											</label></td>
											<td>Elena Dobrev</td>
											<td>Project manger</td>
											<td>5600$</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-6 end here -->
					<div class="col-lg-6 col-md-6">
						<!-- col-lg-6 start here -->
						<div class="panel panel-default plain toggle panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<h4 class="panel-title">Hover table</h4>
							</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th class="per5">#</th>
											<th class="per40">Employe</th>
											<th class="per40">Position</th>
											<th class="per15">Salary</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Jacob Olsen</td>
											<td>Developer</td>
											<td>2530$</td>
										</tr>
										<tr>
											<td>2</td>
											<td>Lara James</td>
											<td>SEO</td>
											<td>3700$</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Steve Sidwell</td>
											<td>Photographer</td>
											<td>1340$</td>
										</tr>
										<tr>
											<td>4</td>
											<td>Elena Dobrev</td>
											<td>Project manger</td>
											<td>5600$</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-6 end here -->
				</div>
				<!-- End .row -->
				<div class="row">
					<!-- Start .row -->
					<div class="col-lg-12">
						<!-- col-lg-12 start here -->
						<div class="panel panel-default plain toggle panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<h4 class="panel-title">班级列表</h4>
							</div>
							<div class="panel-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th class="per5">序号</th>
											<th class="per40">班级名称</th>
											<th class="per40">班级名称</th>
											<th class="per15">班级名称</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" varStatus="index" items="${pageInfo.list }">
											<tr>
												<td>${index.count }</td>
												<td>${item.classId }</td>
												<td>${item.classId }</td>
												<td>${item.classId }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-12 end here -->
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
	<script src="<c:url value="/assets/js/pages/tables.js"/>"></script>
</body>
</html>