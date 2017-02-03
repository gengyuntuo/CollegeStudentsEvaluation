<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar">
	<!-- Start .sidebar-inner -->
	<div class="sidebar-inner">
		<!-- Start #sideNav -->
		<ul id="sideNav" class="nav nav-pills nav-stacked">
			<li class="top-search">
				<form>
					<input type="text" name="search" placeholder="菜单搜索 ...">
					<button type="submit" onclick="return false;">
						<i class="ec-search s20"></i>
					</button>
				</form>
			</li>
			<li><a href="index.html">首页 <i class="im-screen"></i></a></li>
			<li><a href="#">学院管理<i class="im-paragraph-justify"></i></a>
				<ul class="nav sub">
					<li><a href="instituteInfo.do"><i class="ec-pencil2"></i>信息概览</a></li>
					<li><a href="instituteList.do"><i class="im-checkbox-checked"></i>学院列表</a></li>
				</ul></li>
			<li><a href="#">教师管理<i class="im-paragraph-justify"></i></a>
				<ul class="nav sub">
					<li><a href="forms.html"><i class="ec-pencil2"></i>信息概览</a></li>
					<li><a href="form-validation.html"><i class="im-checkbox-checked"></i>学院列表</a></li>
					<li><a href="form-wizard.html"><i class="im-wand"></i>xxxxxxx</a></li>
					<li><a href="wysiwyg.html"><i class="fa-pencil"></i> WYSIWYG editor</a></li>
				</ul></li>
			<li><a href="#">班级管理<i class="im-paragraph-justify"></i></a>
				<ul class="nav sub">
					<li><a href="forms.html"><i class="ec-pencil2"></i>信息概览</a></li>
					<li><a href="form-validation.html"><i class="im-checkbox-checked"></i>学院列表</a></li>
					<li><a href="form-wizard.html"><i class="im-wand"></i>xxxxxxx</a></li>
					<li><a href="wysiwyg.html"><i class="fa-pencil"></i> WYSIWYG editor</a></li>
				</ul></li>
			<li><a href="#">学生管理<i class="im-paragraph-justify"></i></a>
				<ul class="nav sub">
					<li><a href="forms.html"><i class="ec-pencil2"></i>信息概览</a></li>
					<li><a href="form-validation.html"><i class="im-checkbox-checked"></i>学院列表</a></li>
					<li><a href="form-wizard.html"><i class="im-wand"></i>xxxxxxx</a></li>
					<li><a href="wysiwyg.html"><i class="fa-pencil"></i> WYSIWYG editor</a></li>
				</ul></li>
			<li><a href="#">成绩管理<i class="im-paragraph-justify"></i></a>
				<ul class="nav sub">
					<li><a href="forms.html"><i class="ec-pencil2"></i>信息概览</a></li>
					<li><a href="form-validation.html"><i class="im-checkbox-checked"></i>学院列表</a></li>
					<li><a href="form-wizard.html"><i class="im-wand"></i>xxxxxxx</a></li>
					<li><a href="wysiwyg.html"><i class="fa-pencil"></i> WYSIWYG editor</a></li>
				</ul></li>
			<li><a href="#"><i class="ec-mail"></i>消息管理</a>
				<ul class="nav sub">
					<li><a href="email-inbox.html"><i class="ec-archive"></i> Inbox</a></li>
					<li><a href="email-read.html"><i class="br-eye"></i> Read email</a></li>
					<li><a href="email-write.html"><i class="ec-pencil2"></i> Write email</a></li>
				</ul></li>
			<li><a href="#"><i class="ec-mail"></i>资源管理</a>
				<ul class="nav sub">
					<li><a href="email-inbox.html"><i class="ec-archive"></i> Inbox</a></li>
					<li><a href="email-read.html"><i class="br-eye"></i> Read email</a></li>
					<li><a href="email-write.html"><i class="ec-pencil2"></i> Write email</a></li>
				</ul></li>
			<li><a href="#"><i class="ec-mail"></i>系统管理</a>
				<ul class="nav sub">
					<li><a href="email-inbox.html"><i class="ec-archive"></i> Inbox</a></li>
					<li><a href="email-read.html"><i class="br-eye"></i> Read email</a></li>
					<li><a href="email-write.html"><i class="ec-pencil2"></i> Write email</a></li>
				</ul></li>
			<li><a href="charts.html">系统设置<i class="st-chart"></i></a></li>
		</ul>
		<!-- End #sideNav -->
		<!-- Start .sidebar-panel -->
		<div class="sidebar-panel">
			<h4 class="sidebar-panel-title">
				<i class="im-fire"></i> 服务器使用情况
			</h4>
			<div class="sidebar-panel-content">
				<ul class="server-stats">
					<li><span class="txt">磁盘空间</span> <span class="percent">78</span>
						<div id="usage-sparkline" class="sparkline">Loading...</div>
						<div class="pie-chart" data-percent="78"></div></li>
				</ul>
				<ul class="server-stats">
					<li><span class="txt">CPU</span> <span class="percent">56</span>
						<div id="cpu-sparkline" class="sparkline">Loading...</div>
						<div class="pie-chart" data-percent="56"></div></li>
				</ul>
				<ul class="server-stats">
					<li><span class="txt">内存</span> <span class="percent">14</span>
						<div id="ram-sparkline" class="sparkline">Loading...</div>
						<div class="pie-chart" data-percent="14"></div></li>
				</ul>
			</div>
		</div>
		<!-- End .sidebar-panel -->
	</div>
	<!-- End .sidebar-inner -->
</div>