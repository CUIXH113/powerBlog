<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="后台首页">
    <meta name="author" content="powermcl">
    <link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">

    <title>新增股票</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/blogcss/bootstrap.min.css" rel="stylesheet"> 
  	<link href="${pageContext.request.contextPath}/blogcss/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/blogcss/dashboard.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  	<link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/blogjs/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/blogjs/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/blogjs/bootstrap-datetimepicker.fr.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="col-lg-12 p-3 mb-2 bg-light text-gray-dark">
				<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4"><em>股票详情</em></h2>
						</div>
				</div>
				<form action="${pageContext.request.contextPath}/company/updateStock" method="post">
				  
				  <div class="form-row">
				  	<input type = "text" class = "form-control" id = "id" name = "id" value = "${stock.id}" hidden = "true"/>
				  	<!-- 股票代码 -->
				    <div class="form-group col-md-2">
				      <label for="stockCode" class="col-form-label" ><strong>股票代码</strong></label>
				      <input type="text" class="form-control" id="stockCode" name="stockCode" value = "${stock.stockCode }">
				    </div>
				    <!-- 上市时间 -->
				    <div class = "form-group col-md-2" style="padding-left:15px;">
				    	<label for="marketListingTime" class="col-form-label"><strong>上市时间</strong></label>
				    	<div>
					    	<input type="date" id = "marketListingTime" name = "marketListingTime" value = "${stock.marketListingTime }"  style="width:160px;"/>
				    	</div>
				    </div>
				      <!-- 股票类型 -->
				    <div class="form-group col-md-2">
				    	<label for="stockFlag" class="col-form-label" ><strong>股票类型</strong></label>
				  		<div id="stockFlag">
					      <select  class="custom-select" name="stockFlag" style="height:36px; width:160px;" value = "${stock.stockFlag }" >
					      		<option value = "1" selected="selected">请选择股票类型</option>
					      		<option value="1">美股</option>
					      		<option value="2">港股</option>
					      		<option value="3">沪股</option>
					      		<option value="4">深股</option>
					      </select>
				      	</div>
				    </div>

				    <!-- 家乡 -->
				    <div class="form-group col-md-2">
				      <label for="totalStockNum" class="col-form-label" ><strong>股票发行量</strong></label>
					  <input type="text" class="form-control" id="totalStockNum" name="totalStockNum"  value = "${stock.totalStockNum }">
				    </div>
				    <div class="form-group col-md-2">
				      <label for="unit" class="col-form-label" ><strong>单位</strong></label>
				      <div>
						  <select  class="form-control" id="unit" name="unit"  value = "${stock.unit }"  style="height:36px; width:160px;">
						  	<option value = "1" selected>请选择单位</option>
						  	<option value = "1">万</option>
						  	<option value = "2">十万</option>
						  	<option value = "3">百万</option>
						  	<option value = "4">千万</option>
						  	<option value = "5">亿</option>
						  </select>
				      </div>
				    </div>
				  	
				  </div>
	  
				  <div class="form-row">
				  		<div class="form-group col-md-3" align="left">
						  <button type="submit" class="btn btn-primary btn-lg">保存</button>
				  		</div>
				  		<div class="form-group col-md-3" align="left">
						  <button type="reset" class="btn btn-lg btn-danger" >取消</button>
				  		</div>
				  </div>
				</form>
			</div>
		</div>
		
	</body>
</html>