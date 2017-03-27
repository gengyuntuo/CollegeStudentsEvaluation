<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Load pace first -->
<script src="<c:url value="/assets/plugins/core/pace/pace.min.js"/>"></script>
<!-- Important javascript libs(put in all pages) -->
<script src="<c:url value="/assets/js/jquery-1.8.3.min.js"/>"></script>
<script>
	window.jQuery || document.write('<script src="<c:url value="/assets/js/libs/jquery-2.1.1.min.js"/>">\x3C/script>')
</script>
<script src="<c:url value="/assets/js/jquery-ui.js"/>"></script>
<script>
	window.jQuery || document.write('<script src="<c:url value="/assets/js/libs/jquery-ui-1.10.4.min.js"/>">\x3C/script>')
</script>
<!--[if lt IE 9]>
  <script type="text/javascript" src="<c:url value="/assets/js/libs/excanvas.min.js"/>"></script>
  <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <script type="text/javascript" src="<c:url value="/assets/js/libs/respond.min.js"/>"></script>
<![endif]-->
<!-- Bootstrap plugins -->
<script src="<c:url value="/assets/js/bootstrap/bootstrap.js"/>"></script>
<!-- Core plugins ( not remove ever) -->
<!-- Handle responsive view functions -->
<script src="<c:url value="/assets/js/jRespond.min.js"/>"></script>
<!-- Custom scroll for sidebars,tables and etc. -->
<script src="<c:url value="/assets/plugins/core/slimscroll/jquery.slimscroll.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js"/>"></script>
<!-- Resize text area in most pages -->
<script src="<c:url value="/assets/plugins/forms/autosize/jquery.autosize.js"/>"></script>
<!-- Proivde quick search for many widgets -->
<script src="<c:url value="/assets/plugins/core/quicksearch/jquery.quicksearch.js"/>"></script>
<script src="<c:url value="/assets/plugins/charts/flot/date.js"/>"></script>
<script src="<c:url value="/assets/plugins/charts/sparklines/jquery.sparkline.js"/>"></script>
<script src="<c:url value="/assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"/>"></script>
<script src="<c:url value="/assets/plugins/forms/icheck/jquery.icheck.js"/>"></script>
<script src="<c:url value="/assets/plugins/forms/tags/jquery.tagsinput.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/forms/tinymce/tinymce.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/misc/highlight/highlight.pack.js"/>"></script>
<script src="<c:url value="/assets/plugins/misc/countTo/jquery.countTo.js"/>"></script>
<script src="<c:url value="/assets/plugins/ui/weather/skyicons.js"/>"></script>
<script src="<c:url value="/assets/plugins/ui/notify/jquery.gritter.js"/>"></script>
<script src="<c:url value="/assets/plugins/ui/calendar/fullcalendar.js"/>"></script>
<script src="<c:url value="/assets/js/jquery.sprFlat.js"/>"></script>
<script src="<c:url value="/assets/js/app.js"/>"></script>