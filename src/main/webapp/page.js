var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#mytable').bootstrapTable({
			url : 'instituteData.do',
			method : 'GET',
			cache : true,// 禁用ajax缓存数据
			striped : false,// 设置为 true 会有隔行变色效果
			columns : [ {
				field : 'id',
				visible : false,
				title : 'id'
			}, {
				field : "numb",
				title : '学院代码',
				halign : "center",
				align : "center",
				valign : "middle",
			}, {
				field : 'name',
				title : '学院名称',
				halign : "center",
				align : "center",
				valign : "middle",
			}, {
				field : 'desc',
				title : '学院简介',
				halign : "center",
				align : "center",
				valign : "middle",
			} ]
		});
	};
	return oTableInit;
};

// 1.初始化Table
var oTable = new TableInit();
oTable.Init();