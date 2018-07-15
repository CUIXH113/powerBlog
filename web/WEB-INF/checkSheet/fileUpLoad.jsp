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
		<title>文件上产页面</title>
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="col-lg-12 jumbotron">
				
				<form action="${pageContext.request.contextPath}/checkSheet/uploadFile" class="form-group" 
					method="post" enctype = "multipart/form-data">
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>上传文件</em></h2>
						</div>
					</div>
					<!-- 公司 -->
				  <div class="form-row">
				   <!--  <div class="form-group col-md-3">
				      <label for="fileName" class="col-form-label" style="color: green;"><strong>文件名字</strong></label>
				      <input type="text" class="form-control" id="fileName" name="fileName" >
				    </div> -->
				    <div class="form-group col-md-2" style = "padding-left: 20px;">
				    	<label for = "fileStyle" class = "col-form-label" style="color: green;"><strong>文件分类</strong></label>
				  		<div id="stockFlag">
					      <select  class="custom-select" name="fileStyle">
					      		<option selected="selected" value="1">请选择文件类型</option>
					      		<option value="1">java</option>
					      		<option value="2">数据库</option>
					      		<option value="3">算法</option>
					      		<option value="4">其他</option>
					      </select>
				      	</div>
				    </div>
				    
				    <div class="form-group col-md-3" style = "padding-top: 32px; padding-left: 20px;">
				      <!-- <label for="uploadFile" class="col-form-label"><strong>选择文件</strong></label> -->
				      <input type="file" class="form-control" id="uploadFile" name="uploadFile" >
				    </div>
				  </div>
				  <div class="form-row">

				  </div>
				  <div class="form-row">
				  		<div class="form-group col-md-3" align="left" style = " padding-left: 20px;">
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