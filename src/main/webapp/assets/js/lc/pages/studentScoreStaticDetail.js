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

$(document).ready(function() {
	/**
	 * 变量初始化
	 */
	// 对话框、弹出框、提示框
	var dialog_add = null;
	// 表单
	var form = $("form");

	/**
	 * 初始化表格
	 */
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#mytable').bootstrapTable({
				url : 'instituteData.do',
				method : 'GET',
				queryParams : function(params) {
					params["search"] = checkSearchText(); // 如果有内容，则带搜索参数请求页面
					// console.info(params);
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

	/**
	 * 绘制条形图
	 */
	function plotChartDemo() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '各学院在校生信息'
			},
			tooltip : {},
			legend : {
				data : [ '学生数' ]
			},
			xAxis : {
				data : [ "信息学院", "经济管理", "电气自动化", "艺术", "车辆", "兵器" ]
			},
			yAxis : {},
			series : [ {
				name : '学生数',
				type : 'bar',
				data : [ 5, 20, 36, 10, 10, 20 ]
			} ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}

	/**
	 * 自定义函数
	 */
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

	/**
	 * 执行
	 */
	// 1. 初始化Table
	var oTable = new TableInit();
	oTable.Init();
	// 2. 绘条形图
	plotChartDemo();
	// 3.绑定select2控件
	$(".select2").select2({
		placeholder : "请选择类型",
		allowClear : true,
		language : "zh-CN"
	});
});

/**
 * 自定义的函数
 */
// 结果窗口的回调函数
function resultCallback() {
	$("#result_iframe_div").removeAttr("hidden");
	$("#result_iframe_div").modal("show");
}