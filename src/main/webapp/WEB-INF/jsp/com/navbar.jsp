<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header">
	<div class="container-fluid">
		<div class="navbar">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.do"> <img alt="" src="assets/img/ico/logo.ico"  class="text-logo-element animated bounceIn"/><span class="text-logo">测评系统</span>
				</a>
			</div>
			<nav class="top-nav" role="navigation">
				<ul class="nav navbar-nav pull-right">
					<li id="toggle-sidebar-li"><a href="#" id="toggle-sidebar"><i class="en-arrow-left2"></i> </a></li>
					<li><a href="#" class="full-screen"><i class="fa-fullscreen"></i></a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"><i class="ec-mail"></i><span id="mail-count" class="notification"></span></a>
						<ul id="msgTip" class="dropdown-menu email right" role="menu">
						</ul></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"> <img id="user-avatar-nav" class="user-avatar" alt="头像"
							src="<c:choose><c:when test="${not empty user.portrait }">downloadFile.do?path=${user.portrait }</c:when> <c:otherwise>assets/img/avatars/default.jpg</c:otherwise> </c:choose>">${user.name }
					</a>
						<ul class="dropdown-menu right" role="menu">
							<li><a href="persionInfo.do"><i class="st-user"></i> 个人中心</a></li>
							<li><a href="file.html"><i class="st-cloud"></i> 我的文件</a></li>
							<li><a href="#"><i class="st-settings"></i> 系统设置 </a></li>
							<li><a href="logout.do"><i class="im-exit"></i> 注销登录</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
		<!-- Start #header-area -->
		<!-- End #header-area -->
	</div>
	<!-- Start .header-inner -->
</div>