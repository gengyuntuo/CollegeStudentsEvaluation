<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header">
	<div class="container-fluid">
		<div class="navbar">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.do"> <i class="im-windows8 text-logo-element animated bounceIn"></i><span class="text-logo">测评系统</span>
				</a>
			</div>
			<nav class="top-nav" role="navigation">
				<ul class="nav navbar-nav pull-right">
					<li id="toggle-sidebar-li"><a href="#" id="toggle-sidebar"><i class="en-arrow-left2"></i> </a></li>
					<li><a href="#" class="full-screen"><i class="fa-fullscreen"></i></a></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"><i class="ec-cog"></i><span class="notification">10</span></a>
						<ul class="dropdown-menu right" role="menu">
							<li><a href="#"><i class="en-database"></i> Database <span class="notification">3</span></a></li>
							<li><a href="#"><i class="st-cube"></i> Packages <span class="notification blue">17</span></a></li>
							<li><a href="#"><i class="st-health"></i> Disconnects <span class="notification yellow">1</span></a></li>
							<li><a href="#"><i class="im-images"></i> Images <span class="notification teal">320</span></a></li>
							<li><a href="#"><i class="st-users"></i> Users <span class="notification orange">2k</span></a></li>
							<li><a href="#"><i class="st-meter"></i> Traffic <span class="notification magenta">2tb</span></a></li>
							<li><a href="#"><i class="im-coin"></i> Finances <span class="notification pink">+3k</span></a></li>
							<li><a href="#"><i class="st-folder"></i> Directories <span class="notification green">17</span></a></li>
							<li><a href="#"><i class="st-bag"></i> Orders <span class="notification purple">12</span></a></li>
							<li><a href="#"><i class="ec-contract"></i> Contracts <span class="notification dark">7</span></a></li>
						</ul></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"><i class="ec-mail"></i><span class="notification">4</span></a>
						<ul class="dropdown-menu email right" role="menu">
							<li class="mail-head">
								<div class="clearfix">
									<div class="pull-left">
										<a href="email-inbox.html"><i class="ec-archive"></i></a>
									</div>
									<span>收件箱</span>
									<div class="pull-right">
										<a href="email-inbox.html"><i class="st-pencil"></i></a>
									</div>
								</div>
							</li>
							<li class="mail-list clearfix"><a href="#"> <img src="assets/img/avatars/128.jpg" class="mail-avatar pull-left" alt="avatar">
									<p class="name">
										<span class="status"><i class="en-dot"></i></span> Jason Rivera <span class="notification">2</span> <span class="time">12:30 am</span>
									</p>
									<p class="msg">I contact you regarding my account please can you set up my pass ...</p>
							</a></li>
							<li class="mail-more"><a href="email-inbox.html">View all <i class="en-arrow-right7"></i></a></li>
						</ul></li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"> <img class="user-avatar" src="assets/img/avatars/48.jpg" alt="SuggeElson">${user.name }
					</a>
						<ul class="dropdown-menu right" role="menu">
							<li><a href="profile.html"><i class="st-user"></i> 个人中心 </a></li>
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