$(document).ready(function() {
	/**
	 * 初始化表格
	 */
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#tableZHCP').bootstrapTable({
				url : 'listZHCPCJTJ.do',
				method : 'GET',
				queryParams : function(params) {
					params["termId"] = 18;
					return params;
				},
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true 会有隔行变色效果
				sidePagination : 'server', // 设置在哪里进行分页，可选值为 'client' 或者
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false, // 设置为 true 只显示总数据数，而不显示分页按钮。需要
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 20, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
				// 则显示所有记录。
				showPaginationSwitch : false, // 是否显示 数据条数选择框
				clickToSelect : true, // 设置true 将在点击行时，自动选择rediobox 和 checkbox
				singleSelect : true, // 设置True 将禁止多选
				idField : 'id', // 指定主键列
				cardView : false, // 设置为
				// true将显示card视图，适用于移动设备。否则为table试图，适用于pc
				showRefresh : false, // 是否显示 刷新按钮
				search : false, // 是否启用搜索框
				searchOnEnterKey : true, // 设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
				searchAlign : "left", // 指定 搜索框 水平方向的位置。'left' or 'right'
				columns : [ {
					checkbox : true
				}, {
					field : "sno",
					title : '学号',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'name',
					title : '姓名',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'rcxwScore',
					title : '①日常行为得分',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'szjfScore',
					title : '②素质活动得分',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'desc',
					title : '③素质学分合计   ③=①+②',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return row["rcxwScore"] + row["szjfScore"];
					}
				}, {
					field : 'desc',
					title : '④素质学分绩点',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return (row["rcxwScore"] + row["szjfScore"] - 50) / 10;
					}
				}, {
					field : 'xfjd',
					title : '⑤平均学分绩点',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'desc',
					title : '⑥综合测评成绩     ⑥=⑤×80%+④×20%',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						var sz = row["rcxwScore"] + row["szjfScore"] - 50;
						return sz * 0.02 + row["xfjd"] * 0.8;
					}
				}, {
					field : 'zhState',
					title : '状态',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						switch (value) {
						case "Y":
							return "正常";
						}
					}
				} ]
			});
		};
		return oTableInit;
	};

	/**
	 * 执行
	 */
	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();
});