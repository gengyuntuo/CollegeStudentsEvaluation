$(document).ready(function() {
	/**
	 * 创建列表对象
	 */
	// 综合成绩测评表
	var TableZHCPInit = function() {
		var TableInit = new Object();
		/**
		 * 初始化综合测评Table
		 */
		TableInit.Init = function() {
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
					title : '③素质学分合计   ③=①+②',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return row["rcxwScore"] + row["szjfScore"];
					}
				}, {
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
		return TableInit;
	};
	// 日常行为测评表
	var TableRCXWInit = function() {
		var TableInit = new Object();
		TableInit.Init = function() {
			$('#tableRCXW').bootstrapTable({
				url : 'listSZXFRCXWBFPF.do',
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
					valign : "middle"
				}, {
					field : 'name',
					title : '姓名',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shgd',
					title : '遵守社会公德（5、0）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'wmjw',
					title : '与他人文明交往 尊重师长（5、0）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'cxls',
					title : '诚信立身 勤俭立行（5、0）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'tydl',
					title : '加强体育锻炼 提高身体素质（5、0）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'ahgw',
					title : '爱护公物 爱护校园环境 （5、0）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'xxgd',
					title : '遵守学校相关管理规定 (10)',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'cjhd',
					title : '积极参加各项活动 (10)',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'tkjl',
					title : '辅导员根据听课记录及工作笔记  (15)',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'gyjc',
					title : '辅导员根据公寓检查记录 (10)',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'rcxwScore',
					title : '总分',
					halign : "center",
					align : "center",
					valign : "middle"
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
		return TableInit;
	};
	// 素质教育教育加分表
	var TableSZJFInit = function() {
		var TableInit = new Object();
		TableInit.Init = function() {
			$('#tableSZJF').bootstrapTable({
				url : 'listSZJYJFPF.do',
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
					valign : "middle"
				}, {
					field : 'name',
					title : '姓名',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shfw',
					title : '积极为社会服务，为他人奉献（满分8分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shsj',
					title : '积极参加社会实践与志愿服务（满分12分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'bshj',
					title : '参加各类比赛获奖情况（满分15分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'xsgb',
					title : '学生干部职务加分（满分10分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					title : '素质教育加分总分（满分30分）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return row["shfw"] + row["shsj"] //
								+ row["bshj"] + row["xsgb"];
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
		return TableInit;
	};

	/**
	 * 执行
	 */
	// 1. 初始化Table
	var tableZHCP = new TableZHCPInit();
	var tableRCXW = new TableRCXWInit();
	var tableSZJF = new TableSZJFInit();
	tableZHCP.Init();
	tableRCXW.Init();
	tableSZJF.Init();
});