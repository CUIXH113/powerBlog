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

    <title>添加股价</title>

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
			<div class="col-lg-12 p-3 mb-2 bg-light text-gray-dark" align="center">
				<form action="${pageContext.request.contextPath}/stock/addStockPrice" method="post">
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" "><em>添加股价</em></h2>
						</div>
					</div>
					<!-- 股票代码-->
				  <div class="form-row">
				  	<input type="text" name="stockId" value="${stockId}" hidden="true">
				    <div class="form-group col-md-1" style="margin-left: 200px;">
				      <label for="stockCode" class="col-form-label" ><strong>股票代码</strong></label>
				      <input type="text" class="form-control" id="stockCode" name="stockCode" readonly="true" value="${stockCode}">
				    </div>
				    <div class = "form-group col-md-1">
				     	<label for="markDate" class="col-form-label" ><strong>时间</strong></label>
				    	<input type="date" name = "markDate"/>
				    </div>
				    <!-- 当前股价 -->
				    <div class="form-group col-md-5" style="margin-left: 60px;">
				      <label for="stockPrice" class="col-form-label" ><strong>当前股价</strong></label>
				      <input type="text" class="form-control" id="stockPrice" name="price" >
				    </div>
				  </div>
				  <div class="form-row" style="padding-left: 200px;">
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