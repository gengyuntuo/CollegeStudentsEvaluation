/**
 * 文档加载完成
 */
$(function() {
	var  dialog_pass = null;
	/**
	 * 对话框
	 */
	dialog_pass = $("#dialog-update-pass").dialog( {
		autoOpen : false,
		title : '重置密码',
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
			"重置" : function() {
				var newPass = $("#input-new-pass").val();
				var newPassRepeat = $("#input-new-pass-repeat").val();
				if(newPass.length < 6) {
					alert("新密码长度不足6位");
					return;
				}
				if(newPass != newPassRepeat) {
					alert("两次输入的新密码不一致");
					return;
				}
				$.ajax({
					url : "resetPassword.do",
					type : "post",
					dataType : "json",
					data : {
						"studentId" : $("#student-id").val(),
						"newPass" : newPass
					},
					success : function(data) {
						if (data.result == "success") {
							alert("密码修改成功！");
							dialog_pass.dialog("close");
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
				dialog_pass.dialog("close");
			}
		}
	});

	/**
	 * 按钮：重置密码
	 */
	$("#edit-pass-btn").on("click", function() {
		dialog_pass.dialog("open");
	});
	/**
	 * 按钮：修改个人信息
	 */
	$("#edit-info-btn").on("click", function() {
		// console.info("edit-info-btn被点击\n" + $(this).html());
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
	
	$("#edit-info-btn").on("click", function() {
		
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