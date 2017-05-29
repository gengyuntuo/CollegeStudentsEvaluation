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
					item.id = value.id + "," + value.role;
					item.text = (value.role == "S" ? "[学生]" : "[老师]")//
							+ "  " + value.name;
					options.push(item);
				});
				// console.info(options);
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
	// SELECT2 绑定change事件
	// $("#receiverSelect").on("change", function(e) {
	// log("change " + JSON.stringify({
	// val : e.val,
	// added : e.added,
	// removed : e.removed
	// }));
	// });
	// 2. 按钮点击事件
	$("#sendBtn").on("click", function() {
		var receiverIdAndRole = $("#receiverSelect").val();
		if (receiverIdAndRole == undefined //
				|| receiverIdAndRole == null //
				|| receiverIdAndRole.trim() == "") {
			alert("选选择收信人");
			return;
		}
		var receiverId = receiverIdAndRole.split(",")[0];
		var receiverRole = receiverIdAndRole.split(",")[1];
		var subject = $("#subject").val();
		if (subject == undefined //
				|| subject == null //
				|| subject.trim().length < 1) {
			alert("请输入主题");
			return;
		}
		var content = $("#email-text").val();
		if (content == undefined //
				|| content == null //
				|| content.trim().length < 1) {
			alert("请输入内容");
			return;
		}
		var withMail = $("#withMail").attr("checked");
		// console.info(receiverIdAndRole);
		// console.info(subject);
		// console.info(content);
		// console.info(withMail);
		$.ajax({
			url : "sendMessage.do",
			type : "POST",
			data : {
				"type" : receiverRole,
				"receiverId" : receiverId,
				"title" : subject,
				"content" : content,
				"withMail" : "checked" == withMail ? "Y" : "N"
			},
			success : function(data) {
				console.info(data);
				alert(data.result + data.tip);
			}
		});
	});
	// 3. xheditor文本编辑器
	$("#email-text").xheditor({tools:"full",skin:"o2007silver",html5Upload:false});
});