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
		<title>文件下载列表页面</title>
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" style="padding-top: 20px;">
			<div class="form-row" align="center">
				<div class="form-group col-md-12">
					 <h2 class="display-4" style="color: green;"><em>备忘录下载列表</em></h2>
				</div>
			</div>
			<!-- 公司 -->
			<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>文件名</th>
								<th>文件大小</th>
								<th>文件类别</th>
								<th>上传日期</th>
								<th>游客是否可下载</th>
								<th>下载次数</th>
								<th>操作|可下载性</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items = "${sheets}" var = "sheet">
								<tr>
									<td><a download = "${sheet.name}" href = "${pageContext.request.contextPath}/checkSheet/download/${sheet.id}">${sheet.name}</a></td>
									<td><a>${sheet.fileSize}kb</a></td>
									<td>
										<c:if test="${sheet.classification == 1}">Java</c:if>
										<c:if test="${sheet.classification == 2}">数据库</c:if>
										<c:if test="${sheet.classification == 3}">算法</c:if>
										<c:if test="${sheet.classification == 4}">前端</c:if>
										<c:if test="${sheet.classification == 5}">其他</c:if>
									</td>
									<td>${sheet.uploadTime}</td>
									<td>
										<c:choose>
											<c:when test = "${sheet.enableFlag == true}">
												可下载
											</c:when>
											<c:otherwise>
												不可
											</c:otherwise>
											
										</c:choose>
										
										
									</td>
									<td>${sheet.downloadNum}</td>
									<td>
										<a href = "${pageContext.request.contextPath}/checkSheet/deleteSheet/${sheet.id}">删除</a>|
										<c:if test="${sheet.enableFlag == true}">
											<a href = "${pageContext.request.contextPath}/checkSheet/enableFlag/${sheet.id}/0">不可用</a>										
										</c:if>
										<c:if test="${sheet.enableFlag == false}">
											<a href = "${pageContext.request.contextPath}/checkSheet/enableFlag/${sheet.id}/1">可用</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
	
			<div class="modal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Modal title</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p>Modal body text goes here.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary">Save changes</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
		
	</body>
</html>