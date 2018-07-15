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
		<title>修改博客</title>
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>		
	</head>
	<body>
		<div class="container">
			<div class="col-lg-12 jumbotron">
				<form action="${pageContext.request.contextPath}/blog/uploadBlog" method="post" enctype = "multipart/form-data">
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>上传博客</em></h2>
						</div>
					</div>
					<!-- 公司 -->
				  <div class="form-row">
				    <div class="form-group col-md-4">
				      <label for="blogName" class="col-form-label" style="color: green;"><strong>博客名字</strong></label>
				      <input type="text" class="form-control" id="blogName" name="blogName" >
				    </div>

				  </div>
				  <div class="form-row">
				  	<!-- 姓名 -->
				    <div class="form-group col-md-3">
				      <label for="blogType" class="col-form-label" style="color: green;"><strong>类别</strong></label>
				      <select type="text" class="form-control" id="blogType" name="blogType" >
				      		<option value = "1" selected>请选择类别</option>
				      		<option value = "1" >技术</option>
				      		<option value = 2>随笔</option>
				      		<option value = "3">其他</option>
				      </select>
				    </div>
				    <div class = "form-group col-md-3">
				    	<label for = "blogFile" class = "col-form-label" style="color: green;">上传文件</label>
				    	<input type = "file" class = "form-control" id = "blogFile" name = "blogFile"/>
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