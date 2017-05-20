<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${student.name }个人信息</title>
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

.control-label {
	margin-top: 6px;
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
						<i class="ec-user"></i>${student.name }个人信息
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
											src="<c:choose><c:when test="${not empty student.portrait }">downloadFile.do?path=${student.portrait }</c:when> <c:otherwise>assets/img/avatars/default.jpg</c:otherwise> </c:choose>"
											alt="头像">
									</div>
								</div>
								<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
									<div class="profile-name">
										${student.name }<span class="label label-success"><c:if test="${student.role == null }">同学</c:if> <c:if test="${student.role != null }">${student.role }</c:if> </span>
									</div>
									<div class="profile-quote">
										<p>${student.motto }</p>
									</div>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12" style="text-align: center;">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-6" style="padding-top: 10px;">
										<button id="edit-info-btn" type="button" class="btn btn-primary">
											<i class="fa-edit"></i> 编辑信息
										</button>
									</div>
									<c:if test="${user.userType eq 'T' }">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-6" style="padding-top: 10px;">
											<button id="edit-pass-btn" type="button" class="btn btn-primary">
												<i class="fa-edit"></i> 重置密码
											</button>
										</div>
									</c:if>
								</div>
							</div>
							<div class="panel-footer white-bg">
								<form id="student-info-form" action="studentUpdate.do" method="post">
									<!-- 隐藏域，用户的ID -->
									<input id="student-id" name="id" value="${student.id }" type="text" hidden="hidden">
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<ul class="profile-info">
											<li>昵称：<input name="nick" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.nick }"><span class="text-show">${student.nick }</span></li>
											<li>姓名：<input name="name" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.name }"><span class="text-show">${student.name }</span></li>
											<li>性别：<span class="text-show">${student.gender }</span>
												<div class="edit" style="display: inline-block;">
													<c:if test="${student.gender != '男' }">
														<input name="gender" type="radio" value="男">男 <input name="gender" type="radio" value="${student.gender }" checked="checked">女</c:if>
													<c:if test="${student.gender == '男' }">
														<input name="gender" type="radio" value="男" checked="checked">男 <input name="gender" type="radio" value="${student.gender }">女</c:if>
												</div></li>
											<li>民族：<input name="nation" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.nation }"><span class="text-show">${student.nation }</span></li>
											<li>生日：<input id="input-birthday" name="birthday" class="edit" hidden="hidden" readonly="readonly" type="text"
												value="<fmt:formatDate pattern="yyyy-MM-dd" value="${student.birthday }"/>"><span class="text-show"><fmt:formatDate pattern="yyyy-MM-dd" value="${student.birthday }" /> </span></li>
											<li>职务：<c:if test="${user.userType eq 'S' }">${student.role }</c:if> <c:if test="${user.userType eq 'T' }">
													<select name="role" class="edit" hidden="hidden">
														<option value="" <c:if test="${empty persion.role }">selected="selected"</c:if>>没有职务</option>
														<option value="班长" <c:if test="${ persion.role eq '班长' }">selected="selected"</c:if>>班长</option>
														<option value="副班长" <c:if test="${ persion.role  eq '副班长' }">selected="selected"</c:if>>副班长</option>
														<option value="团支书" <c:if test="${ persion.role  eq '团支书' }">selected="selected"</c:if>>团支书</option>
														<option value="学习委员" <c:if test="${ persion.role  eq '学习委员' }">selected="selected"</c:if>>学习委员</option>
														<option value="班级负责人" <c:if test="${ persion.role  eq '班级负责人' }">selected="selected"</c:if>>班级负责人</option>
													</select>
													<span class="text-show">${student.role }</span>
												</c:if></li>
											<li>邮箱：<input name="email" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.email }"><span class="text-show">${student.email }</span></li>
											<li>身份证：<input name="idCard" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.idCard }"><span class="text-show">${student.idCard }</span></li>
											<li>微信号：<input name="weChat" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.weChat }"><span class="text-show">${student.weChat }</span></li>
											<li>QQ号：<input name="qqNumb" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.qqNumb }"><span class="text-show">${student.qqNumb }</span></li>
											<li>支付宝：<input name="alipay" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.alipay }"><span class="text-show">${student.alipay }</span></li>
											<li>电话：<input name="phone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.phone }"><span class="text-show">${student.phone }</span></li>
											<li>地址：<input name="address" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.address }"><span class="text-show">${student.address }</span></li>
										</ul>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
										<ul class="profile-info">
											<li>户口地：<input name="resident" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.resident }"><span class="text-show">${student.resident }</span></li>
											<li>学号：${student.sno }</li>
											<li>寝室楼：<input name="dormno" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.dormno }"><span class="text-show">${student.dormno }</span></li>
											<li>寝室号：<input name="dormInfo" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.dormInfo }"><span class="text-show">${student.dormInfo }</span></li>
											<li>政治面貌：<input name="politicalStatus" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.politicalStatus }"><span class="text-show">${student.politicalStatus }</span></li>
											<li>银行卡号：<input name="bankCard" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.bankCard }"><span class="text-show">${student.bankCard }</span></li>
											<li>贫困：<input name="haveLoan" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.haveLoan }"><span class="text-show">${student.haveLoan }</span></li>
											<li>贷款：<input name="havePovertyCertificate" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.havePovertyCertificate }"><span class="text-show">${student.havePovertyCertificate }</span></li>
											<li>父亲：<input name="fatherName" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.fatherName }"><span class="text-show">${student.fatherName }</span></li>
											<li>父亲电话：<input name="fatherPhone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.fatherPhone }"><span class="text-show">${student.fatherPhone }</span></li>
											<li>母亲：<input name="motherName" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.motherName }"><span class="text-show">${student.motherName }</span></li>
											<li>母亲电话：<input name="motherPhone" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.motherPhone }"><span class="text-show">${student.motherPhone }</span></li>
											<li>座右铭：<input name="motto" class="edit" hidden="hidden" readonly="readonly" type="text" value="${student.motto }"><span class="text-show">${student.motto }</span></li>
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

	<div id="dialog-update-pass">
		<div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">新的密码</label>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<input id="input-new-pass" type="password" class="form-control" placeholder="请输入新密码">
			</div>
		</div>
		<div class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<label class="col-lg-3 col-md-3 col-sm-3 col-xs-3 control-label">重复密码</label>
			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<input id="input-new-pass-repeat" type="password" class="form-control" placeholder="请重复新密码">
			</div>
		</div>
	</div>

	<!-- End #content -->
	<!-- Javascripts -->
	<jsp:include page="../com/javascript.jsp" />
	<script src="<c:url value="/assets/js/lc/pages/studentDetail.js"/>"></script>
</body>
</html>