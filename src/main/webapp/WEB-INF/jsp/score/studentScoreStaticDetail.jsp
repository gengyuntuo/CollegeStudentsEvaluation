<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${term.name }年度${clazz.classId }班测评详情</title>
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
<link href="<c:url value="/assets/css/lc/select2/select2.min.css" />" rel="stylesheet" />
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
						<i class="im-screen"></i> ${term.name }年度${user.sno }-${user.name }同学测评详情
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
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h4 class="panel-title">测评进度</h4>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">名称：</label>
									<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
										<select name="name2" class="form-control">
											<option>qrqwerqwerqwerqwe</option>
											<option>rqwerqwerqwerqwerqw</option>
											<option>qwerqwerqwerqwer</option>
											<option>qwerqwerqwerqwerqwrqwrw</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6 control-label">素质教育加分</label>
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
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">日常行为得分</label>
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
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">学科成绩绩点</label>
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
									<label class="col-xs-6 col-sm-6 col-lg-6 col-md-6  control-label">综合测评得分</label>
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
							<h3>素质加分申请</h3>
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
				<!-- Stop .row -->

				<!-- Start .row -->
				<div class="row col-xs-12 col-sm-12 col-lg-12 col-md-12">
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="page-header">
							<h3>个人学科成绩</h3>
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
								<button id="btn_add2" type="button" class="btn btn-primary">
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
								<table id="mytable2" class="table table-bordered">
								</table>
							</div>
						</div>
					</div>
					<!-- col-lg-12 end here -->
				</div>
				<!-- Stop row -->

				<!-- Page End here -->
			</div>
			<!-- End .outlet -->
		</div>
		<!-- End .content-wrapper -->
		<div class="clearfix"></div>
	</div>
	<!-- End #content -->

	<!-- 对话框 开始-->
	<!-- 创建素质教育加分申请表 -->
	<div id="dialog-add">
		<form id="form" action="createSZJYJFSQ.do" target="result_iframe" method="post" enctype="multipart/form-data" class="form-horizontal group-border hover-stripped">
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">名称：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<select id="select_type" name="type" class="form-control">
						<option></option>
						<!-- 只有添加了空的option才可以使清除按钮生效 -->
						<option value="game">比赛</option>
						<option value="cadre">干部</option>
					</select>
				</div>
			</div>
			<div id="div_level" class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">等级：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<select id="select_level" name="level" class="form-control">
						<option></option>
						<!-- 只有添加了空的option才可以使清除按钮生效 -->
						<option value="cadre">社团</option>
						<option value="cadre">院级</option>
						<option value="cadre">校级</option>
						<option value="cadre">市级</option>
						<option value="cadre">省级</option>
						<option value="game">国家级</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">名称：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="input_name" name="name" type="text" class="form-control" placeholder="名称">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">时间：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="input_date" name="date" type="text" class="form-control" placeholder="时间">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">依据：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="input_evidence" name="evidence" type="text" class="form-control" placeholder="依据">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">凭证：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="input_file" name="file" type="file" class="form-control" placeholder="凭证">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">分数：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="input_score" name="score" type="number" class="form-control" placeholder="分数">
				</div>
			</div>
		</form>
	</div>
	<!-- 创建素质教育加分申请表结果 -->
	<div id="result_iframe_div" hidden="hidden">
		<iframe id="result_iframe" name="result_iframe">对不起，您的浏览器不支持内置框架</iframe>
	</div>

	<!-- 对话框 结束-->

	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/select2/select2.min.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/select2/_locale/zh-CN.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/echart/echarts.min.js" />"></script>
	<script src="<c:url value="/assets/js/lc/pages/studentScoreStaticDetail.js" />"></script>
</body>
</html>