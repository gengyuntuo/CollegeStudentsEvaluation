<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>

<title></title>
</head>

<body>
	This is my JSP page.
	<br />
	<c:forEach items="${list }" var="var">
		<h3>${var.type }:${var.setting }-->${var.value }</h3>
		<br />
	</c:forEach>
	<br>
</body>
</html>
