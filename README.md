# ![沈阳理工大学校徽](http://www.sylu.edu.cn/image/xbs.jpg) CollegeStudentsEvaluation
> CollegeStudentsEvaluation为毕业设计项目

## 项目简介
该项目的主要功能为学分测评，您可以访问[沈阳理工大学学分评测系统](http://www.xuemengzihe.cn)

### 1. 用户
该项目中共有三种用户：
  1. 管理员
  2. 教师
  3. 学生（班委）

## 开发阶段重要说明
### 1. 数据库设计：素质加分申请表
数据库设计中素质加分申请表的表名为`t_szjyjfpf`， 在开发中发现该表并非必须存在，可以删除，但是鉴于项目扩展及项目修改的时效问题，所以暂时保留该表的存在；20170415号决定在每次更新素质加分申请表的时候维护该表的数据，虽然这样是冗余的，但是鉴于部分业务的特殊情况所以仍然使用该表

## 问题解决
### 1. select2 在jQuery Dialog中无法搜索问题解决
 **解决方案：**在dialog前加入_allowInteraction的重载
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

