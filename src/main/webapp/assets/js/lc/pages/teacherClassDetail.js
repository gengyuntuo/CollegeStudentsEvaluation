$(function() {
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#mytable').bootstrapTable({
				url : 'studentData.do',
				method : 'GET',
				queryParams : function(params) {
					params["search"] = checkSearchText(); // 如果有内容，则带搜索参数请求页面
					params["classId"] = $("#classId").val();
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
					width : "20%",
					field : "sno",
					title : '学生学号',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<a href=\"studentDetail.do?"// 
								+ "item=" + row.id + "\">" + value + "</a>"; //
					}
				}, {
					width : "10%",
					field : "name",
					title : '学生姓名',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<a href=\"studentDetail.do?"// 
								+ "item=" + row.id + "\">" + value + "</a>"; //
					}
				}, {
					width : "5%",
					field : 'role',
					title : '班级职务',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					width : "5%",
					field : 'nation',
					title : '民族',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					width : "5%",
					field : 'gender',
					title : '性别',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					width : "25%",
					field : 'email',
					title : '邮箱',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					width : "30%",
					field : 'phone',
					title : '手机',
					halign : "center",
					align : "center",
					valign : "middle"
				} ]
			});
		};
		return oTableInit;
	};
	var dialog_add = null, dialog_import = null;
	dialog_add = $("#dialog-add-student").dialog({
		autoOpen : false,
		title : '添加学生',
		height : 500,
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
					url : 'instituteAdd.do',
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
		}
	});
	dialog_import = $("#dialog-import-student").dialog({
		autoOpen : false,
		title : '导入学生',
		height : 260,
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
			"导入" : function() {
				var excel = $("#input-excel");
				if (excel.val().substr(-4) != ".xls") {
					alert("请选择扩展名为.xls的文件");
					return;
				}
				$("#import-student-form").submit();
			},
			"取消" : function() {
				dialog_import.dialog("close");
			}
		}
	});

	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2. 绑定单击事件到刷新按钮
	$('#btn-refresh').click(function() {
		$("#search-input").val(""); // 清除搜索框内容
		$('#mytable').bootstrapTable('refresh', { // 更新数据
			query : { // 在刷新时设置记录偏移量为0，也就是从第一条记录开始查询
				offset : 0
			}
		});
	});

	// 3. 绑定单击事件到添加按钮
	$('#btn-add').click(function() {
		console.info("添加dialog-add-student");
		dialog_add.dialog("open");
	});

	// 4. 绑定单击事件到导入按钮
	$('#btn-import').click(function() {
		console.info("导入dialog-import-student");
		dialog_import.dialog("open");
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
/**
 * 导入学生信息的回调函数
 */
function callback(result, tip) {
	$("#result_iframe_div").modal();
}