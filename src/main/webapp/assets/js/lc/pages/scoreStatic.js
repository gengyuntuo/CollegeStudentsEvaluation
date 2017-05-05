$(function() {
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#mytable').bootstrapTable({
				url : 'scoreStaticData.do',
				method : 'GET',
				queryParams : function(params) {
					return params;
				},
				cache : true,
				striped : true,
				sidePagination : 'server',
				pagination : true,
				onlyInfoPagination : false,
				pageNumber : 1,
				pageSize : 10,
				pageList : [ 5, 10, 15, 25 ],
				showPaginationSwitch : false,
				clickToSelect : true,
				singleSelect : true,
				columns : [ {
					checkbox : true
				}, {
					field : 'termId',
					visible : false,
					title : 'termId'
				}, {
					field : 'teacherId',
					visible : false,
					title : 'teacherId'
				}, {
					field : "name",
					title : '统计学期',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<a href=\"studentScoreStaticDetail"//
								+ ".do?item=" + row["termId"]//
								+ "\">" + value + "</a>";//
					}
				}, {
					field : 'teacherName',
					title : '老师',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'startDate',
					title : '开始日期',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'stopDate',
					title : '结束日期',
					halign : "center",
					align : "center",
					valign : "middle",
				} ]
			});
		};
		return oTableInit;
	};
	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();
});
