<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

.profile-avatar {
	cursor: pointer;
}

input.edit {
	width: 80%;
	border-width: 0px;
	background-color: inherit;
}

input.editing {
	width: 80%;
	border-width: 1px;
	inline-width: initial;
	background-color: inherit;
	border-radius: 5px;
	background-color: inherit;
}

input.editing:focus {
	border-color: #66afe9;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px rgba(102, 175, 233, 0.6);
}

div.edit {
	visibility: hidden;
}

div.editing {
	visibility: visible;
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
									<div class="profile-avatar" id="avatar-edit-div">
										<img id="user-avatar" class="img-responsive"
											src="<c:choose><c:when test="${not empty user.portrait }">downloadFile.do?path=${user.portrait }</c:when> <c:otherwise>assets/img/avatars/default.jpg</c:otherwise> </c:choose>" alt="头像">
									</div>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
									<div class="profile-name">
										${user.name }<span class="label label-success"><c:if test="${user.role == null }">同学</c:if> <c:if test="${user.role != null }">${user.role }</c:if> </span>
									</div>
									<div class="profile-quote">
										<p>${user.motto }</p>
									</div>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12" style="margin-top: 10px;padding-top: 10px;text-align: center;">
									<button id="edit-info-btn" type="button" class="btn btn-primary">
										<i class="fa-edit"></i> 编辑信息
									</button>
								</div>
							</div>
							<div class="panel-footer white-bg">
								<form id="student-info-form" action="studentUpdate.do" method="post">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<ul class="profile-info">
											<li>昵称：<input name="nick" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.nick }"><span class="text-show">${user.nick }</span></li>
											<li>姓名：<input name="name" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.name }"><span class="text-show">${user.name }</span></li>
											<li>性别：<span class="text-show">${user.gender }</span>
												<div class="edit" style="display: inline-block;">
													<c:if test="${user.gender != '男' }">
														<input name="gender" type="radio" value="男">男 <input name="gender" type="radio" value="${user.gender }" checked="checked">女</c:if>
													<c:if test="${user.gender == '男' }">
														<input name="gender" type="radio" value="男" checked="checked">男 <input name="gender" type="radio" value="${user.gender }">女</c:if>
												</div></li>
											<li>民族：<input name="nation" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.nation }"><span class="text-show">${user.nation }</span></li>
											<li>生日：<input id="input-birthday" name="birthday" class="edit" hidden="hidden" readonly="readonly" type="text" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday }"/>"><span
												class="text-show"><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday }" /> </span></li>
											<li>职务：${user.role }</li>
											<li>邮箱：<input name="email" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.email }"><span class="text-show">${user.email }</span></li>
											<li>身份证：<input name="idCard" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.idCard }"><span class="text-show">${user.idCard }</span></li>
											<li>微信号：<input name="weChat" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.weChat }"><span class="text-show">${user.weChat }</span></li>
											<li>QQ号：<input name="qqNumb" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.qqNumb }"><span class="text-show">${user.qqNumb }</span></li>
											<li>支付宝：<input name="alipay" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.alipay }"><span class="text-show">${user.alipay }</span></li>
											<li>电话：<input name="phone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.phone }"><span class="text-show">${user.phone }</span></li>
											<li>地址：<input name="address" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.address }"><span class="text-show">${user.address }</span></li>
										</ul>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<ul class="profile-info">
											<li>户口地：<input name="resident" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.resident }"><span class="text-show">${user.resident }</span></li>
											<li>学号：${user.sno }</li>
											<li>寝室楼：<input name="dormno" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.dormno }"><span class="text-show">${user.dormno }</span></li>
											<li>寝室号：<input name="dormInfo" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.dormInfo }"><span class="text-show">${user.dormInfo }</span></li>
											<li>政治面貌：<input name="politicalStatus" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.politicalStatus }"><span class="text-show">${user.politicalStatus }</span></li>
											<li>银行卡号：<input name="bankCard" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.bankCard }"><span class="text-show">${user.bankCard }</span></li>
											<li>贫困：<input name="haveLoan" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.haveLoan }"><span class="text-show">${user.haveLoan }</span></li>
											<li>贷款：<input name="havePovertyCertificate" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.havePovertyCertificate }"><span class="text-show">${user.havePovertyCertificate }</span></li>
											<li>父亲：<input name="fatherName" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.fatherName }"><span class="text-show">${user.fatherName }</span></li>
											<li>父亲电话：<input name="fatherPhone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.fatherPhone }"><span class="text-show">${user.fatherPhone }</span></li>
											<li>母亲：<input name="motherName" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.motherName }"><span class="text-show">${user.motherName }</span></li>
											<li>母亲电话：<input name="motherPhone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.motherPhone }"><span class="text-show">${user.motherPhone }</span></li>
											<li>座右铭：<input name="motto" class="edit" hidden="hidden" readonly="readonly" type="text" value="${user.motto }"><span class="text-show">${user.motto }</span></li>
										</ul>
									</div>
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

	<div id="dialog-avatar">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="height: 200px;">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<img id="preview-of-avatar" alt="头像预览"
					src="<c:choose><c:when test="${not empty user.portrait }">downloadFile.do?path=${user.portrait }</c:when> <c:otherwise>assets/img/avatars/default.jpg</c:otherwise> </c:choose>"
					style="width: 128px;height: 128px;margin: 35px;margin-left: 0px;">
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" style="text-align: center;padding-top: 35px;">
				<div>
					<form id="avatar-update-form" action="updateAvatar.do" method="post" enctype="multipart/form-data" target="submit-avatar-iframe">
						<span class="btn btn-success fileinput-button"> <i class="en-plus3"></i> <span>选择头像</span> <input id="avatar-file" type="file" name="avatar">
						</span>
					</form>
				</div>
				<div style="text-align:left;margin-top: 25px;">
					<span>请选择图片的128*128像素的图片，且大小不超过200Kb</span>
				</div>
				<div style="margin-top: 25px;">
					<span id="upload-tip-span" hidden="hidden" style="color: red;">上传中，请稍等</span>
				</div>
			</div>
		</div>
	</div>
	<!-- 用户提交图片 -->
	<iframe hidden="hidden" name="submit-avatar-iframe"></iframe>

	<!-- End #content -->
	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/pages/studentInfo.js"/>"></script>
</body>
</html>