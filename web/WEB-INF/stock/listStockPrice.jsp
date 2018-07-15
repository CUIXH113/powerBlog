<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 		<!--允许缩放-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 不允许缩放 -->
		<meta name="viewport" content="width=divice-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>股价趋势图</title>
		<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath}/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/blogjs/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/echarts.js"></script>

	</head>
	<body>
<!-- data: [${dateTime0},${dateTime1},${dateTime2},${dateTime3},${dateTime4},${dateTime5},${dateTime6},${dateTime7},${dateTime8},${dateTime9}] -->
<!-- data: [${price0},${price1},${price2},${price3},${price4},${price5},${price6},${price7},${price8},${price9}] -->
		<div class="container" align="center">
			<div class="col-lg-12 btn-info" style="height: 60px; text-align: center;" align="center">
				<div class = "form-row col-lg-12">
					<div class = "col-lg-10">
						<h4 style="padding-top: 18px;">股价趋势图</h4>
					</div>
					<div class = "col-lg-2" style = "text-align: right; margin-top: 10px;">
						<input type = "button" class = "btn-info" onclick = "showLine()" value = "显示曲线" style = "font-size: 20px;"/>
					</div>
				</div>
			</div>
			
			<div id="main" style="width: 1400px; height: 600px; margin-top: 20px;" align="center"></div><!--  -->
			<script type="text/javascript">
		        // 基于准备好的dom，初始化echarts实例
		       
			    	
			        // 指定图表的配置项和数据

		        function showLine() {
			    var myChart = echarts.init(document.getElementById('main'));
			        var option = {
				            title: {
				                text: '股价'
				            },
				            tooltip: {},
				            legend: {
				                data:['股价']
				            },
				            xAxis: {
				            	data: [${aa0},${aa1},${aa2},${aa3},${aa4},${aa5},${aa6},${aa7},${aa8},${aa9}]
				            },
				            yAxis: {},
				            series: [{
				                name: '股价',
				                type: 'line',
				                
				                data: [${price0},${price1},${price2},${price3},${price4},${price5},${price6},${price7},${price8},${price9}]
				            }]
				        };
			        // 使用刚指定的配置项和数据显示图表。
			       myChart.setOption(option);
		        }
		        

			        
	  
			</script>
		</div>

	</body>
</html>