<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>登录</title>
<!-- Mobile specific metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Force IE9 to render in normal mode -->
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="author" content="SuggeElson" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="application-name" content="sprFlat admin template" />
<!-- Import google fonts - Heading first/ text second -->
<!--[if lt IE 9]>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- Css files -->
<!-- Icons -->
<link href="<c:url value="/assets/css/icons.css"/>" rel="stylesheet" />
<!-- jQueryUI -->
<link href="<c:url value="/assets/css/sprflat-theme/jquery.ui.all.css"/>" rel="stylesheet" />
<!-- Bootstrap stylesheets (included template modifications) -->
<link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" />
<!-- Plugins stylesheets (all plugin custom css) -->
<link href="<c:url value="/assets/css/plugins.css"/>" rel="stylesheet" />
<!-- Main stylesheets (template main css file) -->
<link href="<c:url value="/assets/css/main.css"/>" rel="stylesheet" />
<!-- Custom stylesheets ( Put your own changes here ) -->
<link href="<c:url value="/assets/css/custom.css"/>" rel="stylesheet" />
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value="/assets/img/ico/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<c:url value="/assets/img/ico/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value="/assets/img/ico/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" href="<c:url value="/assets/img/ico/apple-touch-icon-57-precomposed.png"/>">
<link rel="icon" href="<c:url value="/assets/img/ico/favicon.ico"/>" type="image/png">
<meta name="msapplication-TileColor" content="#3399cc" />
</head>
<body class="login-page">
	<!-- Start #login -->
	<div id="login" class="animated bounceIn">
		<img id="logo" src="<c:url value="/assets/img/logo.png" />" alt="sprFlat Logo">
		<!-- Start .login-wrapper -->
		<div class="login-wrapper">
			<ul id="myTab" class="nav nav-tabs nav-justified bn">
				<li><a href="#log-in" data-toggle="tab">登录</a></li>
			</ul>
			<div id="myTabContent" class="tab-content bn">
				<div class="tab-pane fade active in" id="log-in">
					<form class="form-horizontal mt10" action="login.do" id="login-form" role="form" method="post">
						<div class="form-group">
							<div class="col-lg-12">
								<input type="text" name="userName" id="email" class="form-control left-icon" value="" placeholder="用户名"> <i class="ec-user s16 left-input-icon"></i>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<input type="password" name="password" id="password" class="form-control left-icon" value="" placeholder="密码"> <i class="ec-locked s16 left-input-icon"></i>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<select name="role" id="role" class="form-control left-icon">
									<option selected="selected" value="3">学生</option>
									<option value="2">教师</option>
									<option value="1">管理员</option>
								</select><i class="ec-locked s16 left-input-icon"></i>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<!-- col-lg-12 start here -->
								<label class="checkbox"> <input type="checkbox" name="remember" id="remember" value="true">10天内免密码登录
								</label>
							</div>
							<!-- col-lg-12 end here -->
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-4">
								<!-- col-lg-12 start here -->
								<button class="btn btn-success pull-right" type="submit">登录</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<label style="color:red;">${tip }</label>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- End #.login-wrapper -->
	</div>
	<!-- End #login -->
	<!-- Javascripts -->
	<!-- Load pace first -->
	<script src="<c:url value="/assets/plugins/core/pace/pace.min.js"/>"></script>
	<!-- Important javascript libs(put in all pages) -->
	<script src="<c:url value="/assets/js/jquery-1.8.3.min.js"/>"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/assets/js/libs/jquery-2.1.1.min.js"/>">\x3C/script>')
	</script>
	<script src="<c:url value="/assets/js/jquery-ui.js"/>"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/assets/js/libs/jquery-ui-1.10.4.min.js"/>">\x3C/script>')
	</script>
	<!--[if lt IE 9]>
  <script type="text/javascript" src="<c:url value="/assets/js/libs/excanvas.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/assets/js/libs/respond.min.js"/>"></script>
<![endif]-->
	<!-- Bootstrap plugins -->
	<script src="<c:url value="/assets/js/bootstrap/bootstrap.js"/>"></script>
	<!-- Form plugins -->
	<script src="<c:url value="/assets/plugins/forms/icheck/jquery.icheck.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/validation/jquery.validate.js"/>"></script>
	<script src="<c:url value="/assets/plugins/forms/validation/additional-methods.min.js"/>"></script>
	<!-- Init plugins olny for this page -->
	<script src="<c:url value="/assets/js/pages/login.js"/>"></script>
</body>
</html>