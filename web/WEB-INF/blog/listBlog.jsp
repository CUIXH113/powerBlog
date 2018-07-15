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
		<title>博客列表</title>
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" style="padding-top: 20px;">
			<div class="form-row" align="center">
				<div class="form-group col-md-12">
					 <h2 class="display-4" style="color: green;"><em>博客文章列表</em></h2>
				</div>
			</div>
	         <div class="table-responsive">
	            <table class="table table-striped">
	              <thead>
	                <tr>
	                  <th>#ID</th>
	                  <th>博客名字</th>
	                  <th>浏览次数</th>
	                  <th>上传日期</th>
	                  <th>博客类别</th>
	                  <th>可用性</th>
	                  <th>操作</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items = "${blogs}" var = "blog">
		                <tr> 
		                  <td>${blog.blogId}</td>
		                  <td>${blog.blogName}</td>
		                  <td>${blog.viewCount}</td>
		                  <td>${blog.uploadDate}</td>
		                  <td>
		                  	<c:if test = "${blog.blogType == 1}">技术</c:if>
		                  	<c:if test= "${blog.blogType == 2}">随笔</c:if>
		                  	<c:if test= "${blog.blogType == 3}">其他</c:if>
		                  </td>
		                  <td>
		                  		<c:if test="${blog.enableFlag == true}">可用</c:if>
		                  		<c:if test="${blog.enableFlag == false}">不可用</c:if>
		                  </td>
		                  <td>
		                  	<a href = "${pageContext.request.contextPath}/blog/deleteBlog/${blog.blogId}">删除</a>
		                  	<span>&nbsp;|&nbsp;</span>
		                  	<c:if test="${blog.enableFlag == true}">
			                  	<a href = "${pageContext.request.contextPath}/blog/updateEnableFlag/${blog.blogId}/2">不可用</a>
		                  	</c:if>
		                  	<c:if test="${blog.enableFlag == false}">
			                  	<a href = "${pageContext.request.contextPath}/blog/updateEnableFlag/${blog.blogId}/1">可用</a>
		                  	</c:if>
		                  </td>
		                </tr>              	
	              	</c:forEach>
	 
	              </tbody>
	            </table>
	          </div>	
	       </div>	
	</body>
</html>