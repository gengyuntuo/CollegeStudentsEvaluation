$(document).ready(function() {
	function plotChartDemo() {
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '各学院在校生信息'
			},
			tooltip : {},
			legend : {
				data : [ '学生数' ]
			},
			xAxis : {
				data : [ "信息学院", "经济管理", "电气自动化", "艺术", "车辆", "兵器" ]
			},
			yAxis : {},
			series : [ {
				name : '学生数',
				type : 'bar',
				data : [ 5, 20, 36, 10, 10, 20 ]
			} ]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	}
	plotChartDemo();
});