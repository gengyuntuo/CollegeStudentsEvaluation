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

### 2. 数据库设计：`setting`表中缺少排序字段，为了减少工作量，只好勉强使用ID来做排序

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
### 2. select2控件分段远程加载数据时失败
使用官方提供的旧版ajax配置无法处理结果数据，在新版中处理结果的属性为`processResults`,并非`results`
```javascript
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
```
返回的数据（JSON）
```javascript
{   "total_count":100,
	"page": 3,
	"items":[
		{"id":"13030504","text":"13030504" },
		{"id":"13030503","text":"13030503" },
		{"id":"13030502","text":"13030502" },
		{"id":"13030502","text":"13030502" },
		{"id":"13030504","text":"13030504" },
		{"id":"13030503","text":"13030503" },
		{"id":"13030502","text":"13030502" },
		{"id":"13030502","text":"13030502" },
		{"id":"13030504","text":"13030504" },
		{"id":"13030501","text":"13030501" }]
}
```