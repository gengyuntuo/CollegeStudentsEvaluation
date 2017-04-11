# ![沈阳理工大学校徽](http://www.sylu.edu.cn/image/xbs.jpg) CollegeStudentsEvaluation
> CollegeStudentsEvaluation为毕业设计项目

## 项目简介
该项目的主要功能为学分测评，您可以访问[沈阳理工大学学分评测系统](http://www.xuemengzihe.cn)

### 1. 用户
该项目中共有三种用户：
  1. 管理员
  2. 教师
  3. 学生（班委）

  
  
  ## 问题解决
  ### select2 在jQuery Dialog中无法搜索问题解决
  解决方案：在dialog前加入_allowInteraction的重载
  ```
	  // 解决Select2在jQuery dialog中无法搜索的问题
	$.widget("ui.dialog", $.ui.dialog, {
	    open: function () {
	        return this._super();
	    },
	    _allowInteraction: function (event) {
	        return !!$(event.target).is(".select2-search__field") || this._super(event);
	    }
	});
  ```