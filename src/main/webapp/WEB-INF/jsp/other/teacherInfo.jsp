<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${user.name }个人信息</title>
<!-- 移动设备metas -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Force IE9 to render in normal mode -->
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<jsp:include page="../com/metas.jsp" />
<!-- Import google fonts - Heading first/ text second -->
<link rel='stylesheet' type='text/css' />
<style type="text/css">
.img-responsive {
	width: 100%;
	max-height: 150px;
}
</style>
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
						<i class="ec-user"></i>${user.name }个人信息
					</h1>
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<div class="outlet">
				<!-- Start .outlet -->
				<!-- Page start here ( usual with .row ) -->
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- col-lg-4 start here -->
						<div class="panel panel-default plain profile-widget">
							<!-- Start .panel -->
							<div class="panel-heading white-bg pl0 pr0">
								<img class="profile-image img-responsive" src="assets/img/profile-cover.jpg" alt="profile cover">
							</div>
							<div class="panel-body">
								<div class="col-lg-2 col-md-2 col-sm-4 col-xs-4">
									<div class="profile-avatar">
										<img class="img-responsive" src="assets/img/avatars/132.jpg" alt="@roybarberuk">
									</div>
								</div>
								<div class="col-lg-10 col-md-10 col-sm-8 col-xs-8">
									<div class="profile-name">
										${user.name }<span class="label label-success"><c:if test="${userType == 'A' }">管理员</c:if> <c:if test="${user.role == 'T' }">老师</c:if> </span>
									</div>
									<div class="profile-quote">
										<p>${user.motto }</p>
									</div>
								</div>
							</div>
							<div class="panel-footer white-bg">
								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<ul class="profile-info">
										<li><i class="ec-mobile"></i>昵称：${user.nick }</li>
										<li><i class="ec-location"></i>姓名：${user.name }</li>
										<li><i class="ec-mail"></i>性别：${user.gender }</li>
										<li><i class="im-office"></i>民族：${user.nation }</li>
										<li><i class="fa-bitbucket"></i>生日：${user.birthday }</li>
										<li><i class="fa-bitbucket"></i>邮箱：${user.email }</li>
										<li><i class="fa-bitbucket"></i>身份证：${user.idCard }</li>
										<li><i class="fa-bitbucket"></i>微信号：${user.weChat }</li>
										<li><i class="fa-bitbucket"></i>QQ号：${user.qqNumb }</li>
										<li><i class="fa-bitbucket"></i>支付宝：${user.alipay }</li>
										<li><i class="fa-bitbucket"></i>电话：${user.phone }</li>
										<li><i class="fa-bitbucket"></i>地址：${user.address }</li>
										<li><i class="fa-bitbucket"></i>地址：${user.resident }</li>
									</ul>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
									<ul class="profile-info">
										<li><i class="ec-mobile"></i> +234 345 887</li>
										<li><i class="ec-location"></i> Spain, Barcelona</li>
										<li><i class="ec-mail"></i> suggeelson@suggelson.com</li>
										<li><i class="im-office"></i> Web developer</li>
										<li><i class="fa-bitbucket"></i> code@suggelab.com</li>
									</ul>
								</div>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-4 end here -->
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<!-- col-lg-4 start here -->
						<div class="panel panel-default plain">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<h4 class="panel-title">
									<i class="ec-user"></i> Update info
								</h4>
							</div>
							<div class="panel-body">
								<form class="form-vertical hover-stripped" role="form">
									<div class="form-group">
										<label class="control-label">Username</label> <input type="text" class="form-control" value="SuggeElson" disabled> <a href="#" class="help-block color-red">Request new ?</a>
									</div>
									<div class="form-group">
										<label class="control-label">Full name</label> <input type="text" class="form-control" value="Jonh Doe">
									</div>
									<div class="form-group">
										<label class="control-label">Email</label> <input type="email" class="form-control" value="suggeelson@suggeelson.com">
									</div>
									<div class="form-group">
										<label class="control-label">New password</label> <input type="password" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">Repeat password</label> <input type="password" class="form-control">
									</div>
									<div class="form-group">
										<label class="control-label">More info</label>
										<textarea class="form-control" rows="3"></textarea>
									</div>
									<!-- End .form-group  -->
									<div class="form-group mb15">
										<button class="btn btn-primary">Change</button>
									</div>
									<!-- End .form-group  -->
								</form>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-4 end here -->
				</div>
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
</body>
</html>