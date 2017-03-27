$(function() {
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#mytable').bootstrapTable({
				url : 'classData.do',
				method : 'GET',
				queryParams : function(params) {
					params["search"] = checkSearchText(); // 如果有内容，则带搜索参数请求页面
					// console.info(params);
					return params;
				}, // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含limit, offset, search,
				// sort, order 否则, 需要包含: pageSize, pageNumber, searchText,
				// sortName, sortOrder. 返回false将会终止请求
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true 会有隔行变色效果
				sidePagination : 'server', // 设置在哪里进行分页，可选值为 'client' 或者
				// 'server'。设置 'server'时，必须设置
				// 服务器数据地址（url）或者重写ajax方法
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false, // 设置为 true 只显示总数据数，而不显示分页按钮。需要
				// pagination='True'
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
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
					field : 'id',
					visible : false,
					title : 'id'
				}, {
					field : 'majorId',
					visible : false,
					title : 'majorId'
				}, {
					field : 'teacherId',
					visible : false,
					title : 'teacherId'
				}, {
					field : "className",
					title : '班级',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'studyYear',
					title : '学制',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'mname',
					title : '专业',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'tname',
					title : '老师',
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

	// 2. 绑定按钮事件
	var dialog_add, dialog_update, dialog_delete, form = $('#form');
	// 添加对话框
	dialog_add = $("#dialog-add").dialog({
		autoOpen : false,
		title : '添加学院',
		height : 600,
		width : 500,
		modal : true,
		resizable : false, // 窗口大小不可调
		show : { // 窗口显示
			effect : "blind",
			duration : 800
		},
		hide : { // 窗口隐藏
			effect : "explode",
			duration : 1000
		},
		overlay : {
			opacity : 0.5
		},
		buttons : {
			"添加" : function() {
				// 获取并验证表单内容
				var numb = $("#numb").val();
				var name = $("#name").val();
				var desc = $("#desc").val();
				// TODO 数据合法性校验
				$.ajax({
					url : 'classAdd.do',
					type : 'POST',
					data : {
						"iNumb" : numb,
						"iName" : name,
						"desc" : desc
					},
					success : function(data) {
						var result = eval(data);
						if (result["tip"] != undefined)
							alert("添加失败！" + result["tip"]);
						// 添加成功，同时更新数据
						$('#mytable').bootstrapTable('refresh');
						dialog_add.dialog("close");
					},
					error : function(data) {
						alert("添加失败！");
					}
				});
			},
			"取消" : function() {
				dialog_add.dialog("close");
			}
		},
		close : function() { // 关闭窗口
			form[0].reset();
		}
	});
	// 修改对话框
	dialog_update = $("#dialog-update").dialog({
		autoOpen : false,
		title : '修改学院',
		height : 600,
		width : 500,
		modal : true,
		resizable : false, // 窗口大小不可调
		show : { // 窗口显示
			effect : "blind",
			duration : 800
		},
		hide : { // 窗口隐藏
			effect : "explode",
			duration : 1000
		},
		overlay : {
			opacity : 0.5
		},
		buttons : {
			"修改" : function() {
				var id = $('#uid').val();
				var numb = $('#unumb').val();
				var name = $('#uname').val();
				var desc = $('#udesc').val();
				// TODO 数据合法性校验
				$.ajax({
					url : 'classUpdate.do',
					type : 'POST',
					data : {
						"id" : id,
						"iNumb" : numb,
						"iName" : name,
						"desc" : desc
					},
					success : function(data) {
						var result = eval(data);
						if (result["tip"] != undefined) {
							alert("修改失败！" + result["tip"]);
							return;
						}
						// 修改成功，同时更新数据
						$('#mytable').bootstrapTable('refresh');
						dialog_update.dialog("close");
					},
					error : function(data) {
						alert("修改失败！");
					}
				});
			},
			"取消" : function() {
				dialog_update.dialog("close");
			}
		},
		close : function() { // 关闭窗口
			form[0].reset();
		}
	});
	// 删除对话框
	dialog_delete = $("#dialog-delete").dialog({
		autoOpen : false,
		title : '删除提醒',
		modal : true,
		resizable : false, // 窗口大小不可调
		show : { // 窗口显示
			effect : "blind",
			duration : 100
		},
		hide : { // 窗口隐藏
			effect : "explode",
			duration : 500
		},
		overlay : {
			opacity : 0.5
		},
		buttons : {
			"删除" : function() {
				var obj = $('#mytable').bootstrapTable('getSelections')[0]; // 获取选择的行
				$.ajax({
					url : 'classDelete.do',
					type : 'POST',
					data : {
						"id" : obj["id"]
					},
					success : function(data) {
						var result = eval(data);
						if (result["tip"] != undefined) {
							alert("删除失败！" + result["tip"]);
							return;
						}
						// 删除成功，同时更新数据
						$('#mytable').bootstrapTable('refresh');
						dialog_delete.dialog("close");
					},
					error : function(data) {
						alert("删除失败！");
					}
				});
			},
			"取消" : function() {
				dialog_delete.dialog("close");
			}
		},
		close : function() { // 关闭窗口
		}
	});

	// 绑定单击事件到添加按钮，打开窗口
	$('#btn_add').click(function() {
		dialog_add.dialog("open");
	});
	// 绑定单击事件到修改按钮，打开窗口
	$('#btn_update').click(function() {
		var obj = $('#mytable').bootstrapTable('getSelections')[0];
		if (obj == undefined) {
			alert("请选择行！");
			return;
		}
		$('#uid').val(obj['id']);
		$('#unumb').val(obj['numb']);
		$('#uname').val(obj['name']);
		$('#udesc').val(obj['desc']);
		// console.info(obj);
		dialog_update.dialog("open");
	});
	// 绑定单击事件到删除按钮，打开窗口
	$('#btn_delete').click(function() {
		var obj = $('#mytable').bootstrapTable('getSelections')[0]; // 获取选择的行
		if (obj == undefined) {
			alert("请选择一行！");
			return;
		}
		dialog_delete.dialog("open");
		// console.info($('#mytable').bootstrapTable('getSelections')); //
		// 获取选择的行，获得是数组
		// $('#mytable').bootstrapTable('refresh');更新数据
	});
	// 绑定单击事件到刷新按钮
	$('#btn_refresh').click(function() {
		$("#search-input").val(""); // 清除搜索框内容
		$('#mytable').bootstrapTable('refresh', { // 更新数据
			query : { // 在刷新时设置记录偏移量为0，也就是从第一条记录开始查询
				offset : 0
			}
		});
	});

});
// 搜索按钮事件
function btn_search() {
	$('#mytable').bootstrapTable('refresh', { // 更新数据
		query : { // 在搜索时设置记录偏移量为0，也就是从第一条记录开始
			offset : 0
		}
	});
}
// 查询搜索框的输入，如果有输入则返回输入的内容，没有输入则返回undefined
function checkSearchText() {
	// console.info("checkSearchText() function Run!");
	var search = $("#search-input").val();
	// console.info("search=>" + search);
	if (search.trim() == "")
		search = undefined;
	return search;
}