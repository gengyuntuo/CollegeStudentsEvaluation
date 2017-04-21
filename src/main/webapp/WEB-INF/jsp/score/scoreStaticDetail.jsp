<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${term.name }学年<c:forEach var="item" items="${term.clazzes }">[${item.classId }] </c:forEach> 班测评详情
</title>
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
						<i class="im-screen"></i> ${term.name }学年
						<c:forEach var="item" items="${term.clazzes }">[${item.classId }] </c:forEach>
						班测评详情
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
							<h3>评测状态</h3>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">测评进度</h4>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6 control-label">学生申请进度</label>
									<div class="col-xs-6 col-sm-6 col-lg-6 col-md-6">
										<div class="progress progress-striped">
											<div class="progress-bar" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%;">30%</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
										<span class="help-block">学生申请进度:学生完成测评申请的数量</span>
									</div>
								</div>
								<!-- End .form-group  -->
								<div class="form-group">
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">班委工作进度</label>
									<div class="col-xs-6 col-sm-6 col-lg-6 col-md-6">
										<div class="progress progress-striped">
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
										<span class="help-block">学生申请进度:学生完成测评申请的数量</span>
									</div>
								</div>
								<!-- End .form-group  -->
								<div class="form-group">
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">教师工作进度</label>
									<div class="col-xs-6 col-sm-6 col-lg-6 col-md-6 ">
										<div class="progress progress-striped">
											<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">70%</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
										<span class="help-block">学生申请进度:学生完成测评申请的数量</span>
									</div>
								</div>
								<!-- End .form-group  -->
								<div class="form-group">
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">测评时间进度</label>
									<div class="col-xs-6 col-sm-6 col-lg-6 col-md-6 ">
										<div class="progress progress-striped">
											<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">70%</div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
										<span class="help-block">学生申请进度:学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量学生完成测评申请的数量</span>
									</div>
								</div>
								<!-- End .form-group  -->
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6 col-lg-6 col-md-6 ">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">任务统计</h4>
							</div>
							<div class="panel-body">
								<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
								<div id="main" style="height:300px"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- End .row -->
				<!-- Start .row -->
				<div class="row col-xs-12 col-sm-12 col-lg-12 col-md-12">
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="page-header">
							<h3>班级学生</h3>
						</div>
					</div>
					<div class="ow col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<!-- col-lg-12 start here -->
						<div class="panel-body">
							<div class="input-group" style="float:left;width:300px">
								<input id="search-input" type="text" class="form-control" value="" placeholder="请输入搜索内容"> <span class="input-group-btn">
									<button class="btn btn-primary" type="button" onclick="btn_search()">搜索</button>
								</span>
							</div>
							<div style="float: right">
								<button id="btn_refresh" type="button" class="btn btn-default">
									<span class="fa-refresh"></span> 刷新
								</button>
								<button id="btn_add" type="button" class="btn btn-primary">
									<span class="st-file-add"></span> 新增
								</button>
								<button id="btn_update" type="button" class="btn btn-success">
									<span class="fa-edit"></span> 修改
								</button>
								<button id="btn_delete" type="button" class="btn btn-danger">
									<span class="im-remove2"></span> 删除
								</button>
								<p></p>
							</div>
							<div class="ow col-xs-12 col-sm-12 col-lg-12 col-md-12">
								<table id="mytable" class="table table-bordered">
								</table>
							</div>
						</div>
					</div>
					<!-- col-lg-12 end here -->
				</div>
				<!-- Page End here -->
			</div>
			<!-- End .outlet -->
		</div>
		<!-- End .content-wrapper -->
		<div class="clearfix"></div>
	</div>
	<!-- End #content -->
	<div hidden="hidden">
		<input id="termId" name="termId" value="${term.id }">
	</div>

	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/echart/echarts.min.js" />"></script>
	<script src="<c:url value="/assets/js/lc/pages/scoreStaticDetail.js" />"></script>
</body>
</html>