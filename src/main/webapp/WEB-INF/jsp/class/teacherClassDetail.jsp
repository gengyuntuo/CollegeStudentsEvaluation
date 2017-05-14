<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${clazz.classId }班级详情</title>
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
						<i class="im-table2"></i> ${clazz.classId }班级学生录
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
								<button id="btn-refresh" type="button" class="btn btn-default">
									<span class="fa-refresh"></span> 刷新
								</button>
								<button id="btn-add" type="button" class="btn btn-primary">
									<span class="st-file-add"></span> 新增
								</button>
								<button id="btn-import" type="button" class="btn btn-success">
									<span class="en-download"></span> 导入
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
	<div id="dialog-add-student"></div>
	<div id="dialog-import-student">
		<form id="import-student-form" action="importStudent.do" method="post" target="iframe" enctype="multipart/form-data">
			<input id = "classId" name="classId" value="${clazz.id }" hidden="hidden">
			<div class="form-group">
				<label class="col-xs-12 col-sm-2 col-md-2 col-lg-2 control-label">文件</label>
				<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
					<input id="input-excel" name="excel" type="file" class="form-control"> <span class="help-block">目前仅支持2003版本的Excel文件，即以*.xls为扩展名的Excel文件，建议使用网站提供的模板（<a href="">点此下载</a>）
					</span>
				</div>
			</div>
			<!-- End .form-group  -->
		</form>
	</div>

	<div id="result_iframe_div" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3>导入结果</h3>
				</div>
				<div class="modal-body">
					<iframe id="iframe" name="iframe" style="border-width: 0px;    width: 100%;">对不起，您的浏览器不支持内置框架</iframe>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/pages/teacherClassDetail.js"/>"></script>
</body>
</html>