<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>提示</title>
<style type="text/css">
.content {
	text-align: center;
	background-color: blue;
	color: red;
}
</style>

<script type="text/javascript">
	window.parent.resultCallback();
</script>
</head>
<body>
	<h1 class="content">This is my JSP page.${tip }</h1>
	<br>
</body>
</html>
