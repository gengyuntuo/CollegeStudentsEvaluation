/**
 * 页面加载完成
 */
$(document).ready(function() {

	// 1. 绑定Select2控件
	$("#receiverSelect").select2({
		width : "100%",
		allowClear : true,
		placeholder : "请选择收件人",
		minimumInputLength : 1,
		language : "zh-CN",
		ajax : {
			url : "getReceiver.do",
			dataType : 'json',
			cache : true,
			data : function(params) { // page 为从1开始的页码
				// console.info(params);
				return {
					"search" : params["term"], // 搜索关键字
					"page" : params.page
				};
			},
			processResults : function(data) {
				var options = [];
				$.each(data.rows, function(index, value) {
					var item = {};
					item.id = value.id;
					item.text = (value.role == "S" ? "[学生]" : "[老师]")//
							+ "  " + value.name;
					options.push(item);
				});
				return {
					results : options,
					pagination : {
						page : 2,
						more : data.total > 10 * data.page
					}
				};
			}
		}
	});
	// 2. 按钮点击事件
	$("#sendBtn").on("click", function() {
		$.ajax({
			url : "sendMessage.do",
			type : "POST",
			data : {
				"role":"S",
				"receiverId":12,
				"withMail": true,
				"content": "content"
			},
			success : function() {
				;
			}
		});
		alert("下载当前的表单");
	});
	// 3. --------------- Tinymce for send email ------------------//
	tinymce.init({
		selector : "textarea.tinymce",
		menubar : false,
		plugins : [ "advlist " + // //
		"autolink " + //
		"lists " + //
		"link " + //
		"image " + //
		"charmap " + //
		"print " + //
		"preview " + //
		"anchor " + //
		"searchreplace " + //
		"visualblocks " + //
		"code " + //
		"fullscreen " + //
		"insertdatetime " + //
		"media table " + //
		"contextmenu " + //
		"paste" //
		],
		toolbar : "bold " + //
		"italic " + //
		"strikethrough " + //
		"bullist " + //
		"numlist " + //
		"blockquote " + //
		"hr " + //
		"alignleft " + //
		"aligncenter " + //
		"alignright " + //
		"alignjustify " + //
		"link unlink " + //
		"code " + //
		"image " + //
		"media | fullscreen" //
	});
});