/**
 * 页面加载完成
 */
$(document).ready(function() {

	// 1. 绑定Select2控件
	$("#receiverSelect").select2({
		width : "100%",
		allowClear : false,
		palceholder : "收件人",
		language : "zh-CN",
		minimumInputLength : 1,
		ajax : {
			url : "data.json",
			dataType : 'json',
			quietMillis : 250, // 当输入框接收输入后多长时间开始发送请求
			data : function(term, page) { // page 为从1开始的页码
				return {
					"search" : term["term"], // 搜索关键字
					"page" : page, // 页码
				};
			},
			results : function(data, page) {
				console.info(data);
				console.page(page);
				var more = (page * 30) < data.total_count; // 不管是否有更多的结果都要这样做
				return {
					results : data["items"],
					more : more// 注意： 返回more的值，这样Select2才可以知道是否有更多的值需要加载
				};
			}
		},
		formatResult : select2FormatResult,
		formatSelection : select2FormatSelection,
		escapeMarkup : function(m) {
			return m;
		}
	});
	// 2. 按钮点击事件
	$("#exportBtn").on("click", function() {
		// $.ajax({
		// url : "",
		// type : "",
		// data : {},
		// success : function() {
		// ;
		// }
		// });
		alert("下载当前的表单");
	});
});
/**
 * 函数定义
 */
// 格式化Select2下拉列表项
function select2FormatResult(repo) {
	var markup = "";
	return markup;
}

// 格式化Select2选择项
function select2FormatSelection(repo) {
	return repo.full_name;
}