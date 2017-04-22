<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${term.name }年度${clazz.classId }班测评工作</title>
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
						<i class="im-screen"></i> ${term.name }年度测评详情
					</h1>
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<!-- Start .outlet -->
			<div class="outlet">
				<!-- Page start here ( usual with .row ) -->

				<!-- Start .row -->
				<div class="row col-xs-12 col-sm-12 col-lg-12 col-md-12">
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="page-header">
							<h3>评测信息</h3>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="panel panel-primary plain">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">综合测评成绩</h4>
							</div>
							<div class="panel-body">
								<table id="tableZHCP" class="table table-bordered">
								</table>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="panel panel-primary plain">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">日常行为得分</h4>
							</div>
							<div class="panel-body"></div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="panel panel-primary plain">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">素质教育得分</h4>
							</div>
							<div class="panel-body"></div>
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
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/pages/teacherScoreStaticWork.js" />"></script>
</body>
</html>