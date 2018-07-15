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
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items = "${sheets}" var = "sheet">
								<tr>
									<td>${sheet.name}</td>
									<td>${sheet.fileSize}kb</td>
									<td>
										<a download = "${sheet.name}" href = "${pageContext.request.contextPath}/WEB-INF/checkSheetFile/${sheet.classification}/${sheet.name}">下载</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
	</div>
		
	</body>
</html>