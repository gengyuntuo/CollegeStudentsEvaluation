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
			processResults : function(data) {
				console.info(data);
				return {
					results : data.items,
					pagination : {
						more : true
					// 每页30条数据
					// 注意： 返回more的值，这样Select2才可以知道是否有更多的值需要加载
					}
				};
			}
		},
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