<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${term.name }学年${clazz.classId }班测评详情</title>
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
<link href="<c:url value="/assets/css/lc/bootstrap-table/bootstrap-table.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/assets/css/lc/select2/select2.min.css" />" rel="stylesheet" />
<style type="text/css">
.select2-container--default .select2-selection--single {
	background-color: #75b9e6;
	background-image: none;
	border: 1px solid #75b9e6;
}

.panel-heading .panel-heading-content {
	padding-top: 3px;
	min-height: 34px;
}

input.edit {
	text-align: center;
	border-width: 0px;
	background-color: initial;
	width: initial;
}

input.editing {
	width: initial;
	text-align: center;
	line-height: initial;
	border-width: 1px;
	border-radius: 5px;
	background-color: initial;
}

input.editing:focus {
	border-color: #66afe9;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, 0.6);
}

a.a-btn {
	cursor: pointer;
}
span.span-btn {
	cursor: pointer;
}
</style>
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
						<i class="im-screen"></i> ${term.name }学年${clazz.classId }班测评详情
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
							<h3>班级评测信息</h3>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
						<div class="panel panel-primary plain">
							<!-- Start .panel -->
							<div class="panel-heading">
								<select id="tableSelect">
									<option value="zhcp">综合测评成绩统计表</option>
									<option value="rcxw">素质学分日常行为部分评分表</option>
									<option value="szjf">素质教育加分评分表</option>
									<option value="szjfsq">素质教育加分申请表</option>
								</select><select id="orderSelect">
									<option value="">排序方式：无</option>
									<option value="score">排序方式：成绩</option>
								</select>
								<div class="panel-heading-content" style="text-align: right;float: right">
									<button id="refreshBtn" type="button" class="btn btn-xs btn-info">
										<span class="fa-refresh"></span> 刷新
									</button>
									<button id="exportBtn" type="button" class="btn btn-xs btn-info">
										<span class="en-upload"></span> 导出
									</button>
								</div>
							</div>
							<div id="panelZHCP" class="panel-body">
								<table id="tableZHCP" class="table table-bordered">
								</table>
							</div>
							<div id="panelRCXW" class="panel-body" hidden="hidden">
								<table id="tableRCXW" class="table table-bordered">
								</table>
							</div>
							<div id="panelSZJF" class="panel-body" hidden="hidden">
								<table id="tableSZJF" class="table table-bordered">
								</table>
							</div>
							<div id="panelSZJFSQ" class="panel-body" hidden="hidden">
								<table id="tableSZJFSQ" class="table table-bordered">
								</table>
							</div>
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

	<!-- 页面中的参数 -->
	<div hidden="hidden">
		<!-- 测评ID -->
		<input id="termId" value="${term.id }" hidden="hidden" type="text">
		<!-- 班级ID -->
		<input id="classId" value="${clazz.id }" hidden="hidden" type="text">
	</div>

	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table.min.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/bootstrap-table/bootstrap-table-zh-CN.min.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/select2/select2.min.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/select2/_locale/zh-CN.js"/>"></script>
	<script src="<c:url value="/assets/js/lc/pages/monitorScoreStaticWork.js" />"></script>
</body>
</html>