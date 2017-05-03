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
			<c:forEach var="var" items="${menu }" varStatus="index">
				<li><a href="${var.url }">${var.title } <i class="${var.image }"></i></a> <c:if test="${var.menus.size() gt 0 }">
						<ul class="nav sub">
							<c:forEach var="subVar" items="${var.menus }">
								<li><a href="${subVar.url }"><i class="${subVar.image }"></i>${subVar.title }</a></li>
							</c:forEach>
						</ul>
					</c:if></li>
			</c:forEach>
		</ul>
		<!-- End #sideNav -->
	</div>
	<!-- End .sidebar-inner -->
</div>