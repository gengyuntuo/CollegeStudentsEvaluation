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
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12 ">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h2 class="panel-title">详情</h2>
							</div>
							<div class="panel-body">
								<h5>${user.name }同学您好</h5>
								<b>绩点：</b><span>4.5</span><br /> <b>排名：</b><span>1</span><br /> <b>素质教育加分：</b><span>30</span><br />
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12 ">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h2 class="panel-title">素质加分申请表列表</h2>
								<div class="panel-heading-content" style="text-align: right;float: right">
									<button id="btn_add" type="button" class="btn btn-xs btn-primary">
										<span class="st-file-add"></span> 新增
									</button>
									<button id="btn_update" type="button" class="btn btn-xs btn-success">
										<span class="fa-edit"></span> 修改
									</button>
									<button id="btn_delete" type="button" class="btn btn-xs btn-danger">
										<span class="im-remove2"></span> 删除
									</button>
								</div>
							</div>
							<div class="panel-body">
								<div class="ow col-xs-12 col-sm-12 col-lg-12 col-md-12">
									<table id="mytable" class="table table-bordered">
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12 ">
						<div class="panel panel-primary">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h2 class="panel-title">
									个人业务课绩点：<span style="color:red;">4.5</span>
								</h2>
								<div class="panel-heading-content" style="text-align: right;float: right">
									<button id="btn_update_score" type="button" class="btn btn-xs btn-success">
										<span class="fa-edit"></span> 更新数据
									</button>
								</div>
							</div>
							<div class="panel-body">
								<div class="ow col-xs-12 col-sm-12 col-lg-12 col-md-12">
									<table id="myscoretable" class="table table-bordered">
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- col-lg-12 end here -->
				</div>
				<!-- Stop .row -->
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
			<input name="term" value="" hidden="hidden">
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
						<option value="社团">社团</option>
						<option value="院级">院级</option>
						<option value="校级">校级</option>
						<option value="市级">市级</option>
						<option value="省级">省级</option>
						<option value="国家级">国家级</option>
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
					<input id="input_date" name="time" type="text" class="form-control" placeholder="时间">
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
	<div id="result_iframe_div" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3>提示</h3>
				</div>
				<div class="modal-body">
					<iframe id="result_iframe" name="result_iframe" style="border-width: 0px;    width: 100%;">对不起，您的浏览器不支持内置框架</iframe>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 密码输入对话框 -->
	<div id="dialog_update_score">
		<div class="form-group col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">密码</label>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
				<input id="jxwPassword" name="password" type="password" class="form-control" placeholder="请输入教学网密码"> <span class="help-block">查询个人成绩需要连接至教学网，请输入您的教学网密码，站点不会保存您的密码！</span>
			</div>
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"></div>
			<div class="mr20 mb15">
				<img src="assets/img/svg/loading-spokes.svg" class="col-xs-4 col-sm-4 col-md-4 col-lg-4" alt="loading">
			</div>
		</div>
	</div>
	<div id="dialog-delete">确认删除！</div>
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