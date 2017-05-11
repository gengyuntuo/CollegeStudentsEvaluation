/**
 * 文档加载完成
 */
$(function() {
	var dialog_avatar = null;
	/**
	 * 对话框
	 */
	dialog_avatar = $("#dialog-avatar").dialog( {
		autoOpen : false,
		title : '修改头像',
		width : 500,
		modal : true,
		draggable : false, // 拖动
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
			"修改" : function() {
				$.ajax({
					url : "confirmUpdateAvatar.do",
					type : "post",
					dataType : "json",
					success : function(data) {
						if (data.result == "success") {
							// TODO
							$("#user-avatar").attr( "src",
									"downloadFile.do?path=" + data.tip);
							$("#user-avatar-nav").attr( "src",
									"downloadFile.do?path=" + data.tip);
							dialog_avatar.dialog("close");
						} else {
							alert(data.tip);
						}
					},
					error : function() {
						alert("请求发送失败或者内容解析失败！");
					}
				});
			},
			"取消" : function() {
				dialog_avatar.dialog("close");
			}
		}
	});

	/**
	 * 按钮
	 */
	$("#avatar-edit-div").on("click", function() {
		dialog_avatar.dialog("open");
	});
	$("#edit-info-btn").on("click", function() {
		console.info("edit-info-btn被点击\n" + $(this).html());
		if ($(this).html().trim() == "<i class=\"fa-edit\"></i> 编辑信息") {
			var edits = $(".edit");
			$(".text-show").attr("hidden", "hidden");
			edits.attr("class", "editing");
			edits.removeAttr("readonly");
			edits.removeAttr("hidden");
			$(this).html("<i class=\"en-disk\"></i> 保存修改");
		} else {
			$("#student-info-form").submit();
			// $(".text-show").removeAttr("hidden");
			// var editings = $(".editing");
			// editings.attr("class", "edit");
			// editings.attr("hidden", "hidden");
			// editings.attr("readonly", "readonly");
			// $(this).html("<i class=\"fa-edit\"></i> 编辑信息");
		}
	});
	/**
	 * 如果选择了图片
	 */
	$("#avatar-file").on("change", function() {
		// console.info($(this).val());
		console.info($(this).val().substr(-4) == ".jpg");
		if ($(this).val().substr(-4) != ".jpg") {
			alert("图片扩展名必须是.jpg");
			return;
		}
		$("#upload-tip-span").removeAttr("hidden"); 
		$("#avatar-update-form").submit(); // 上传图片
		// $("#preview-of-avatar").attr("src", $(this).val()); // 没戏
	});

	$("#input-birthday").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
		monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', //
		'六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ]
	});
});
/**
 * 提交头像后的回调函数
 * 
 * @param result
 *            修改结果（布尔值）
 * @param info
 *            提示信息（成功时为图像的URL,失败时为提示信息）
 */
function callback(result, info) {
	if (result) {
		// console.info("图片的路径：" + info);
		$("#preview-of-avatar").attr("src", "downloadFile.do?path=" + info);
		$("#upload-tip-span").attr("hidden","hidden");
	} else {
		alert(info);
	}
}