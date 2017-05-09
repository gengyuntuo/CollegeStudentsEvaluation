/**
 * 文档加载完成
 */
$(function() {
	// console.info($("#userRole").val().length > 0);
	// 查看列和显示列的宽度（根据userRole的值判断是否为班委）
	var colWidth = $("#userRole").val().length > 0 ? "10%" : "20%";
	// 是否显示操作列
	var showOperationCol = $("#userRole").val().length > 0 ? true : false;
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
					width : "20%",
					field : "name",
					title : '统计学期',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					width : "20%",
					field : 'teacherName',
					title : '老师',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					width : "20%",
					field : 'startDate',
					title : '开始日期',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					width : "20%",
					field : 'stopDate',
					title : '结束日期',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					width : colWidth,
					title : '查看',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<a href=\"studentScoreStaticDetail"//
								+ ".do?item=" + row["termId"]//
								+ "\">查看</a>";//
					}
				}, {
					width : colWidth,// 列宽，在本页首部定义
					visible : showOperationCol, // 显示操作列，在本页首部定义
					title : '操作',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						// console.info("stopDate" + new Date(row["stopDate"]));
						if (new Date() > new Date(row["stopDate"]))
							return "-- --";
						return "<a href=\"monitorScore" + // 
						"StaticWork.do?item=" + // 
						row["termId"] + "\">管理</a>"; // 
					}
				} ]
			});
		};
		return oTableInit;
	};
	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();
});
