/**
 * 解决Select2在jQuery dialog中无法搜索的问题
 */
$.widget("ui.dialog", $.ui.dialog, {
	open : function() {
		return this._super();
	},
	_allowInteraction : function(event) {
		return !!$(event.target).is(".select2-search__field")
				|| this._super(event);
	}
});

/**
 * 变量初始化
 */
// 对话框、弹出框、提示框
var dialog_add = null;
// 表单
var form = $("form");

$(document).ready(function() {
	/**
	 * 初始化表格
	 */
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#mytable').bootstrapTable({
				url : 'listSZJYJFSQ.do',
				method : 'GET',
				queryParams : function(params) {
					params["termId"] = 1;
					return params;
				}, // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含limit, offset,
				// search,
				// sort, order 否则, 需要包含: pageSize, pageNumber,
				// searchText,
				// sortName, sortOrder. 返回false将会终止请求
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true 会有隔行变色效果
				sidePagination : 'server', // 设置在哪里进行分页，可选值为 'client'
				// 或者
				// 'server'。设置 'server'时，必须设置
				// 服务器数据地址（url）或者重写ajax方法
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false, // 设置为 true
				// 只显示总数据数，而不显示分页按钮。需要
				// pagination='True'
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 20, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
				// 则显示所有记录。
				showPaginationSwitch : false, // 是否显示 数据条数选择框
				clickToSelect : true, // 设置true 将在点击行时，自动选择rediobox 和
				// checkbox
				singleSelect : true, // 设置True 将禁止多选
				idField : 'id', // 指定主键列
				cardView : false, // 设置为
				// true将显示card视图，适用于移动设备。否则为table试图，适用于pc
				showRefresh : false, // 是否显示 刷新按钮
				search : false, // 是否启用搜索框
				searchOnEnterKey : true, // 设置为
				// true时，按回车触发搜索方法，否则自动触发搜索方法
				searchAlign : "left", // 指定 搜索框 水平方向的位置。'left' or
				// 'right'
				columns : [ {
					checkbox : true
				}, {
					field : 'id',
					visible : false,
					title : 'id'
				}, {
					field : "name",
					title : '名称',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'type',
					title : '类型',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'time',
					title : '时间',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'level',
					title : '等级',
					halign : "center",
					align : "center",
					valign : "middle",
				}, {
					field : 'evidence',
					title : '证明',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<a href=\"downloadFile.do?path=" //
								+ row["filePath"] + "\">" + value + "</a>";
					}
				}, {
					field : 'score',
					title : '分数',
					halign : "center",
					align : "center",
					valign : "middle",
				} ]
			});
		};
		return oTableInit;
	};

	/**
	 * 创建素质教育加分申请表
	 */
	// 添加对话框
	dialog_add = $("#dialog-add").dialog({
		autoOpen : false,
		title : '添加素质教育加分申请',
		height : 600,
		width : 500,
		modal : true,
		draggable : false, // 拖动
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
				// TODO 数据合法性校验
				$("#form").submit();
			},
			"取消" : function() {
				dialog_add.dialog("close");
			}
		},
		close : function() { // 关闭窗口
			form[0].reset();
		}
	});

	/**
	 * 按钮事件绑定
	 */
	// 绑定单击事件到添加按钮，打开窗口
	$('#btn_add').click(function() {
		dialog_add.dialog("open");
	});
	// 绑定单击事件到添加按钮，打开窗口
	$('#btn_update').click(function() {
	});
	// 绑定单击事件到添加按钮，打开窗口
	$('#btn_delete').click(function() {
	});

	/**
	 * 执行
	 */
	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();
	// 2.绑定select2控件
	$("#select_type").select2({
		width : "100%",
		minimumResultsForSearch : -1, // 当结果总数大于或等于该值时才显示搜索框，-1时不显示搜索框
		placeholder : "请选择加分类型",
		allowClear : true,
		language : "zh-CN"
	});
	$("#select_level").select2({
		width : "100%",
		minimumResultsForSearch : -1, // 当结果总数大于或等于该值时才显示搜索框，-1时不显示搜索框
		placeholder : "请选择比赛等级",
		allowClear : true,
		language : "zh-CN"
	});
	$("#select_type").on("change", function(e) {
		if ("game" == $(this).val()) {
			$("#input_name").attr("placeholder", "请输入比赛名称");
			$("#div_level").removeAttr("hidden");
		} else if ("cadre" == $(this).val()) {
			$("#div_level").attr("hidden", "hidden");
			$("#input_name").attr("placeholder", "请输入职务名称");
		} else if ("" == $(this).val()) {
			// $("#div_level").remove("hidden");
			$("#input_name").attr("placeholder", "请输入名称");
			console.info("什么都没选！");
		}
		// console.info($(this).val());
	});
	// DataPicker
	$(function() {
		$("#input_date").datepicker({
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
			monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', //
			'六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ]
		});
	});
});

/**
 * 自定义的函数
 */
// 结果窗口的回调函数
function resultCallback(result) {
	if (result) {
		// 添加成功
		$("#form")[0].reset(); // 清空表单
		dialog_add.dialog("close"); // 关闭对话框
		$("#mytable").bootstrapTable('refresh');
	}
	$("#result_iframe_div").modal();
}