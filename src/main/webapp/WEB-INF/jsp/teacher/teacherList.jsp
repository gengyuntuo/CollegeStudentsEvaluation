<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>老师列表</title>
<!-- 移动设备metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Force IE9 to render in normal mode -->
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" />
<![endif]-->
<jsp:include page="../com/metas.jsp" />
<!--[if lt IE 9]>
<![endif]-->
<jsp:include page="../com/css.jsp" />
<link href="<c:url value="/assets/css/lc/bootstrap-table/bootstrap-table.min.css"/>" rel="stylesheet" />
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
						<i class="im-table2"></i> 老师列表
					</h1>
				</div>
			</div>
			<!-- End .page-header -->
			<!-- End .row -->
			<div class="outlet">
				<!-- Start .outlet -->
				<!-- Page start here ( usual with .row ) -->
				<div class="row">
					<div class="col-lg-12">
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
								<!-- <button id="btn_update" type="button" class="btn btn-success">
									<span class="fa-edit"></span> 修改
								</button> -->
								<button id="btn_delete" type="button" class="btn btn-danger">
									<span class="im-remove2"></span> 删除
								</button>
								<p></p>
							</div>
							<div>
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
		<!-- End #content -->
	</div>

	<!-- 对话框 开始 -->
	<div id="dialog-add">
		<form id="form" class="form-horizontal group-border hover-stripped">
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">姓名：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="name" type="text" class="form-control" placeholder="教师姓名">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">性别：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<select id="gender" class="form-control">
						<option value="男" selected="selected">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">邮箱：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="email" name="email" type="text" class="form-control" placeholder="邮箱（登录用户名）">
				</div>
			</div>
		</form>
	</div>
	<div id="dialog-update">
		<form id="dialog-update" class="form-horizontal group-border hover-stripped">
			<input id="uid" hidden="hidden" />
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">姓名：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="uname" type="text" class="form-control" placeholder="教师姓名">
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">性别：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
						<select id="ugender" class="form-control">
							<option value="男" selected="selected">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label style="text-align:left;" class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">邮箱：</label>
				<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
					<input id="uemail" name="uemail" type="text" class="form-control" placeholder="邮箱（登录用户名）">
				</div>
			</div>
		</form>
	</div>
	<div id="dialog-delete">确认删除！</div>
	<!-- 对话框 结束 -->

	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/pages/teacherList.js"/>"></script>
</body>
</html>