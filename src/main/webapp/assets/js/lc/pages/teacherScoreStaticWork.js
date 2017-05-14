/**
 * 参数
 */
var termId = $("#termId").val(); // 测评ID
var table = "zhcp"; // 显示的表格
var showClass = undefined; // 显示的班级
var order = undefined; // 排序方式

/**
 * 获取bootstrapTable的查询参数
 * 
 * @param params
 * @returns
 */
function getQueryParams(params) {
	params["termId"] = termId;
	var classId = $("#classSelect").val();
	if (classId != "") {
		params["classId"] = classId;
	}
	var order = $("#orderSelect").val();
	if (order != "") {
		params["order"] = order;
	} else {
		params["order"] = undefined;
	}
	params["tableType"] = $("#tableSelect").val(); //该参数仅在下载表格时使用
	return params;
}
/**
 * 页面加载完成
 */
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
			$('#tableZHCP').bootstrapTable( {
				url : 'listZHCPCJTJ.do',
				method : 'GET',
				queryParams : getQueryParams,
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true
				// 会有隔行变色效果
				sidePagination : 'server', 
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false,
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 20, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
				// 则显示所有记录。
				showPaginationSwitch : false, // 是否显示
				// 数据条数选择框
				clickToSelect : true,
				columns : [
					{
						width : "15%",
						field : "sno",
						title : '学生学号',
						halign : "center",
						align : "center",
						valign : "middle"
					}, {
						width : "15%",
						field : 'name',
						title : '学生姓名',
						halign : "center",
						align : "center",
						valign : "middle"
					}, {
						width : "10%",
						field : 'rcxwScore',
						title : '①日常行为得分',
						halign : "center",
						align : "center",
						valign : "middle"
					}, {
						width : "10%",
						field : 'szjfScore',
						title : '②素质活动得分',
						halign : "center",
						align : "center",
						valign : "middle",
					}, {
						width : "10%",
						title : '③素质学分合计<br/>③=①+②',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(
								value, row,
								index) {
							return row["rcxwScore"]
									+ row["szjfScore"];
						}
					}, {
						width : "10%",
						title : '④素质学分绩点',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(
								value, row,
								index) {
							return ((row["rcxwScore"] + row["szjfScore"] - 50) / 10).toFixed(4);
						}
					}, {
						width : "10%",
						field : 'xfjd',
						title : '⑤平均学分绩点',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(value, row, index) {
							return "<input id=\"editable-input-xfjd-" + row["zhId"] +
									"\" class = \"edit\" readonly = \"readonly\" value=\""
									+ value.toFixed(4) + "\"\\>";
						}
					}, {
						width : "10%",
						title : '⑥综合测评成绩<br/>⑥=⑤×80%+④×20%',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(value, row, index) {
							var sz = row["rcxwScore"] + row["szjfScore"] - 50;
							return (sz * 0.02 + row["xfjd"] * 0.8).toFixed(4);
						}
					}, {
						width : "5%",
						field : 'zhState',
						title : '状态',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(value, row, index) {
							var template = "<span class=\"badge STYLE mr10\">CONTENT</span>";
							switch (value) {
							case "Y":
								return template.replace("STYLE","badge-success").replace("CONTENT", "审核通过");
							case "T":
								return template.replace("STYLE","badge-lime").replace("CONTENT", "教师待审");
							case "M":
								return template.replace("STYLE","badge-info").replace("CONTENT", "班委待审");
							default:
								return template.replace("STYLE","badge-dark").replace("CONTENT", "未知状态");
							}
						}
					}, {
						width : "5%",
						title : '　　操作　　',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(value, row, index) {
							return "<a name=\"view\" class=\"a-btn\" id=\"info-of-id"
								+ row["zhId"]+ "\">查看</a>&nbsp;&nbsp;"
								+ "<a name=\"edit\" class= \"a-btn\" id=\"info-of-id"
								+ row["zhId"]+ "\">编辑</a>";
						}
					} ],
				onLoadSuccess : function(data) {
					$("a[name=edit]").on("click", function() {
						var btn = $(this); // 按钮
						var id = btn.attr("id").substr(10); // id
						console.info(id);
						var input_xfjd = $("#editable-input-xfjd-" + id); // 输入框（学分绩点）
						console.info(input_xfjd);
						if("edit" == input_xfjd.attr("class")) {
							input_xfjd.attr("class", "editing");
							input_xfjd.removeAttr("readonly");
							btn.html("保存");
						} else {
							// TODO数据校验
							if(input_xfjd.val().trim() == "") {
								alert("学分绩点内容不能为空！");
								return;
							}
							//TODOAJAX提交数据
							$.ajax({
								url : "updateTableZHCPCJTJ.do",
								type : "post",
								dataType : "json",
								data : {
									"id" : id, // 综合测评表id
									"pingJunXueFenJiDian" : input_xfjd.val() // 学分绩点
								},
								success : function(data) {
									// 恢复页面UI
									if(data.result == "success") {
										input_xfjd.attr("class", "edit");
										input_xfjd.attr("readonly", "readonly");
										btn.html("编辑");
									} else {
										alert(data.tip);
									}
								},
								error : function() {
									alert("请求失败，网络访问失败或者是数据异常！");
								}
							});
						}
					});
				}
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
				queryParams : getQueryParams,
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true 会有隔行变色效果
				sidePagination : 'server', // 设置在哪里进行分页，可选值为
				// 'client' 或者
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false, // 设置为 true
				// 只显示总数据数，而不显示分页按钮。需要
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 20, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
				// 则显示所有记录。
				showPaginationSwitch : false, // 是否显示 数据条数选择框
				clickToSelect : true, // 设置true
				// 将在点击行时，自动选择rediobox 和
				// checkbox
				singleSelect : true, // 设置True 将禁止多选
				idField : 'id', // 指定主键列
				cardView : false, // 设置为
				// true将显示card视图，适用于移动设备。否则为table试图，适用于pc
				showRefresh : false, // 是否显示 刷新按钮
				search : false, // 是否启用搜索框
				searchOnEnterKey : true, // 设置为
				// true时，按回车触发搜索方法，否则自动触发搜索方法
				searchAlign : "left", // 指定 搜索框 水平方向的位置。'left'
				// or 'right'
				columns : [ {
					field : "sno",
					title : '学生学号',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'name',
					title : '学生姓名',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shgd',
					title : '遵守社会公德<br/>（5、0）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-shgd-" + row["rcxwId"] +
								"\" class = \"edit\" readonly = \"readonly\" value=\""
								+ value + "\"\\>";
					}
				}, {
					field : 'wmjw',
					title : '与他人文明交往<br/>尊重师长（5、0）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-wmjw-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'cxls',
					title : '诚信立身 勤俭立行<br/>（5、0）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-cxls-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'tydl',
					title : '加强体育锻炼<br/>提高身体素质（5、0）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-tydl-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'ahgw',
					title : '爱护公物<br/>爱护校园环境 （5、0）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-ahgw-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'xxgd',
					title : '遵守学校相关<br/>管理规定 (10)',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-xxgd-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'cjhd',
					title : '积极参加各项活动<br/>(10)',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-cjhd-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'tkjl',
					title : '辅导员根据听<br/>课记录及工作笔记  (15)',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-tkjl-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'gyjc',
					title : '辅导员根据<br/>公寓检查记录 (10)',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return "<input id=\"editable-input-gyjc-" + row["rcxwId"] +
							"\" class = \"edit\" readonly = \"readonly\" value=\""
							+ value + "\"\\>";
					}
				}, {
					field : 'rcxwScore',
					title : '总分',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'rcxwState',
					title : '状态',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						var template = "<span class=\"badge STYLE mr10\">CONTENT</span>";
						switch (value) {
						case "Y":
							return template.replace("STYLE","badge-success").replace("CONTENT", "审核通过");
						case "T":
							return template.replace("STYLE","badge-lime").replace("CONTENT", "教师待审");
						case "M":
							return template.replace("STYLE","badge-info").replace("CONTENT", "班委待审");
						default:
							return template.replace("STYLE","badge-dark").replace("CONTENT", "未知状态");
						}
					}
				}, {
						title : '操作',
						halign : "center",
						align : "center",
						valign : "middle",
						formatter : function(value, row, index) {
							return "<a name=\"edit\" class= \"a-btn\" id=\"info-of-id"
								+ row["rcxwId"]+ "\">编辑</a>";
						}
				} ],
				onLoadSuccess : function(data) {
					$("a[name=edit]").on("click", function() {
						var btn = $(this); // 按钮
						var id = btn.attr("id").substr(10); // id
						var input_shgd = $("#editable-input-shgd-" + id); // 输入框（遵守社会公德（5、0））
						var input_wmjw = $("#editable-input-wmjw-" + id); // 输入框（与他人文明交往 尊重师长（5、0））
						var input_cxls = $("#editable-input-cxls-" + id); // 输入框（诚信立身 勤俭立行（5、0））
						var input_tydl = $("#editable-input-tydl-" + id); // 输入框（加强体育锻炼提高身体素质（5、0））
						var input_ahgw = $("#editable-input-ahgw-" + id); // 输入框（爱护公物爱护校园环境（5、0））
						var input_xxgd = $("#editable-input-xxgd-" + id); // 输入框（遵守学校相关管理规定(10)）
						var input_cjhd = $("#editable-input-cjhd-" + id); // 输入框（积极参加各项活动(10)）
						var input_tkjl = $("#editable-input-tkjl-" + id); // 输入框（积极参加各项活动(10)）
						var input_gyjc = $("#editable-input-gyjc-" + id); // 输入框（积极参加各项活动(10)）
						if("edit" == input_shgd.attr("class")) {
							input_shgd.attr("class", "editing");
							input_shgd.removeAttr("readonly");
							input_wmjw.attr("class", "editing");
							input_wmjw.removeAttr("readonly");
							input_cxls.attr("class", "editing");
							input_cxls.removeAttr("readonly");
							input_tydl.attr("class", "editing");
							input_tydl.removeAttr("readonly");
							input_ahgw.attr("class", "editing");
							input_ahgw.removeAttr("readonly");
							input_xxgd.attr("class", "editing");
							input_xxgd.removeAttr("readonly");
							input_cjhd.attr("class", "editing");
							input_cjhd.removeAttr("readonly");
							input_tkjl.attr("class", "editing");
							input_tkjl.removeAttr("readonly");
							input_gyjc.attr("class", "editing");
							input_gyjc.removeAttr("readonly");
							btn.html("保存");
						} else {
							// TODO数据校验
							if(input_shgd.val().trim() == "") {
								alert("“遵守社会公德“内容不能为空且取值为（5、0）！");
								return;
							}
							if(input_wmjw.val().trim() == "") {
								alert("“与他人文明交往 尊重师长“内容不能为空且取值为（5、0）！");
								return;
							}
							if(input_cxls.val().trim() == "") {
								alert("“诚信立身 勤俭立行“内容不能为空且取值为（5、0）！");
								return;
							}
							if(input_tydl.val().trim() == "") {
								alert("“加强体育锻炼 提高身体素质“内容不能为空且取值为（5、0）！");
								return;
							}
							if(input_ahgw.val().trim() == "") {
								alert("“爱护公物 爱护校园环境“内容不能为空且取值为（5、0）！");
								return;
							}
							if(input_xxgd.val().trim() == "") {
								alert("“遵守学校相关管理规定“内容不能为空且取值为（10）！");
								return;
							}
							if(input_cjhd.val().trim() == "") {
								alert("“积极参加各项活动“内容不能为空且取值为（10）！");
								return;
							}
							if(input_tkjl.val().trim() == "") {
								alert("“辅导员根据听课记录及工作笔记“内容不能为空且取值为 (15)！");
								return;
							}
							if(input_gyjc.val().trim() == "") {
								alert("“辅导员根据公寓检查记录“内容不能为空且取值为（10）！");
								return;
							}
							//TODOAJAX提交数据
							$.ajax({
								url : "updateTableSZXFRCXWBFPF.do",
								type : "post",
								dataType : "json",
								data : {
									"id" : id, // 日常行为测评表id
									"sheHuiGongDe" : input_shgd.val(),
									"wenMingJiaoWang" : input_wmjw.val(),
									"chengXinLiShen" : input_cxls.val(),
									"tiYuDuanLian" : input_tydl.val(),
									"aiHuGongWu" : input_ahgw.val(),
									"xueXiaoGuiDing" : input_xxgd.val(),
									"canJiaHuoDong" : input_cjhd.val(),
									"tingKeJiLu" : input_tkjl.val(),
									"gongYuJianCha" : input_gyjc.val()
								},
								success : function(data) {
									// 恢复页面UI
									if(data.result == "success") {
										input_shgd.attr("class", "edit");
										input_shgd.attr("readonly","readonly");
										input_wmjw.attr("class", "edit");
										input_wmjw.attr("readonly","readonly");
										input_cxls.attr("class", "edit");
										input_cxls.attr("readonly","readonly");
										input_tydl.attr("class", "edit");
										input_tydl.attr("readonly","readonly");
										input_ahgw.attr("class", "edit");
										input_ahgw.attr("readonly","readonly");
										input_xxgd.attr("class", "edit");
										input_xxgd.attr("readonly","readonly");
										input_cjhd.attr("class", "edit");
										input_cjhd.attr("readonly","readonly");
										input_tkjl.attr("class", "edit");
										input_tkjl.attr("readonly","readonly");
										input_gyjc.attr("class", "edit");
										input_gyjc.attr("readonly","readonly");
										btn.html("编辑");
									} else {
										alert(data.tip);
									}
								},
								error : function() {
									alert("请求失败，网络访问失败或者是数据解析异常！");
								}
							});
						}
					});
				}
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
				queryParams : getQueryParams,
				cache : true, // 禁用ajax缓存数据
				striped : true, // 设置为 true 会有隔行变色效果
				sidePagination : 'server', // 设置在哪里进行分页，可选值为
				// 'client' 或者
				pagination : true, // 在表格底部显示分页条
				onlyInfoPagination : false, // 设置为 true
				// 只显示总数据数，而不显示分页按钮。需要
				pageNumber : 1, // 如果设置了分页，首页页码
				pageSize : 10, // 如果设置了分页，页面数据条数
				pageList : [ 5, 10, 15, 20, 25 ], // 如果设置了分页，设置可供选择的页面数据条数。设置为All
				// 则显示所有记录。
				showPaginationSwitch : false, // 是否显示 数据条数选择框
				clickToSelect : true, // 设置true
				// 将在点击行时，自动选择rediobox 和
				// checkbox
				singleSelect : true, // 设置True 将禁止多选
				idField : 'id', // 指定主键列
				cardView : false, // 设置为
				// true将显示card视图，适用于移动设备。否则为table试图，适用于pc
				showRefresh : false, // 是否显示 刷新按钮
				search : false, // 是否启用搜索框
				searchOnEnterKey : true, // 设置为
				// true时，按回车触发搜索方法，否则自动触发搜索方法
				searchAlign : "left", // 指定 搜索框 水平方向的位置。'left'
				// or 'right'
				columns : [ {
					field : "sno",
					title : '学生学号',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'name',
					title : '学生姓名',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shfw',
					title : '积极为社会服务，<br/>为他人奉献（满分8分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'shsj',
					title : '积极参加社会实践<br/>与志愿服务（满分12分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'bshj',
					title : '参加各类比赛<br/>获奖情况（满分15分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					field : 'xsgb',
					title : '学生干部职务加分<br/>（满分10分）',
					halign : "center",
					align : "center",
					valign : "middle"
				}, {
					title : '素质教育加分总分<br/>（满分30分）',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						return row["shfw"] + row["shsj"] //
								+ row["bshj"] + row["xsgb"];
					}
				}, {
					field : 'szjfState',
					title : '状态',
					halign : "center",
					align : "center",
					valign : "middle",
					formatter : function(value, row, index) {
						var template = "<span class=\"badge STYLE mr10\">CONTENT</span>";
						switch (value) {
						case "Y":
							return template.replace("STYLE","badge-success").replace("CONTENT", "审核通过");
						case "T":
							return template.replace("STYLE","badge-lime").replace("CONTENT", "教师待审");
						case "M":
							return template.replace("STYLE","badge-info").replace("CONTENT", "班委待审");
						default:
							return template.replace("STYLE","badge-dark").replace("CONTENT", "未知状态");
						}
					}
				} ]
			});
		};
		return TableInit;
	};


	/**
	 * 页面控件及事件绑定
	 */
	// 1. 初始化Table
	var tableZHCP = new TableZHCPInit();
	var tableRCXW = new TableRCXWInit();
	var tableSZJF = new TableSZJFInit();
	tableZHCP.Init();
	tableRCXW.Init();
	tableSZJF.Init();
	// 2. 绑定Select2控件
	$("#tableSelect").select2({
		width : "20%",
		allowClear : false,
		minimumResultsForSearch : -1,
		language : "zh-CN",
	});
	$("#classSelect").select2({
		width : "20%",
		allowClear : false,
		minimumResultsForSearch : -1,
		language : "zh-CN",
	});
	$("#orderSelect").select2({
		width : "20%",
		allowClear : false,
		minimumResultsForSearch : -1,
		language : "zh-CN",
	});

	// 3. 下拉框点击事件
	$("#tableSelect").on("change", function(value) {
		$("#panelZHCP").attr("hidden", "hidden");
		$("#panelRCXW").attr("hidden", "hidden");
		$("#panelSZJF").attr("hidden", "hidden");
		// console.info("更换Table");
		// $("#tableSZJF").bootstrapTable("destroy");
		switch ($(this).val()) {
		case "zhcp":
			$("#panelZHCP").removeAttr("hidden");
			$("#tableZHCP").bootstrapTable("refresh");
			break;
		case "rcxw":
			$("#panelRCXW").removeAttr("hidden");
			$("#tableRCXW").bootstrapTable("refresh");
			break;
		case "szjf":
			$("#panelSZJF").removeAttr("hidden");
			$("#tableSZJF").bootstrapTable("refresh");
			break;
		default:
			break;
		}
	});
	$("#classSelect").on("change", function(value) {
		// $("#tableZHCP").bootstrapTable("refresh");
		$("#table" + $("#tableSelect").val().toUpperCase()).bootstrapTable("refresh");
		console.info("更换显示内容");
	});
	$("#orderSelect").on("change", function(value) {
		$("#table" + $("#tableSelect").val().toUpperCase()).bootstrapTable("refresh");
		console.info("更换排序方式");
	});
	// 4. 按钮点击事件
	$("#exportBtn").on("click", function(value) {
		 $.ajax({
		 url : "downloadScoreSheet.do",
		 type : "post",
		 data :getQueryParams({}),
		 dataType : "json",
		 success : function(data) {
			 if(data.result == "success") {
				 window.location.href = data.url;
			 } else  {
				 alert(data.tip);
			 }
		 },
		 error : function() {
			 alert("请求发送失败！");
		 }
		 });
	});
});
