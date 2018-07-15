<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--允许缩放-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--不允许缩放-->
		<meta name="viewport" content="width=divice-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>添加资产负债表</title>
		<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath}blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" >
				<form action="${pageContext.request.contextPath}/financialStatement/configFinancialStatement" method="post" >
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>设置新增财报信息</em></h2>
							 <input type = "text" name = "companyId" value = "${companyId}" hidden="true"/>
						</div>
					</div>
				  <div class="form-row bg-light">
				    <div class="form-group col-md-2">
				      <label for="sheetFlag" class="col-form-label" style="color: green;"><strong>货币资金</strong></label>
				      <select  class="form-control" id="sheetFlag" name="sheetFlag">
				      	<option value = "1" selected>请选择财报类型</option>
				      	<option value = "1" >第一季度</option>
				      	<option value = "2" >第二季度</option>
				      	<option value = "3" >第三季度</option>
				      	<option value = "4" >第四季度</option>
				      	<option value = "5" >半年报</option>
				      	<option value = "6" >年报</option>
				      </select>
				    </div>
 				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="createTime" class="col-form-label" style="color: green;"><strong>应收账款</strong></label>
				      <input type="date" class="form-control" id="createTime" name = "createTime">
				    </div>
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="statementDate" class="col-form-label" style="color: green;"><strong>其他应收款</strong></label>
				    	<input type = "date" class = "form-control" id = "statementDate" name = "statementDate">
				    </div>

				  </div>
				 


						
				  <div class="form-row bg-light">
				  		<div class="form-group col-md-3" align="left">
						  <button type="submit" class="btn btn-primary btn-lg">保存</button>
				  		</div>
				  		<div class="form-group col-md-3" align="left">
						  <button type="reset" class="btn btn-lg btn-danger" >取消</button>
				  		</div>
				  </div>
				  <div class="form-row bg-light">
				  		<div class="form-group col-md-3" align="left">
						  <h1>&nbsp;</h1>
				  		</div>
				  		
				  </div>					
				</form>
		</div>
	</body>
</html>