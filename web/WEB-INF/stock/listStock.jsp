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
		<title>添加股价</title>
		<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath}/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">

			<div class="table-responsive">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>#id</th>
							<th>股票代码</th>
							<th>上市时间</th>
							<th>股票类型</th>
							<th>股票发行额</th>
							<th>当前股价</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stockList}" var="stock">
							<tr class="table-primary">
								<td>${stock[0]}</td>
								<td>${stock[1]}</td>
								<td>${stock[2]}</td>
								<td>
									<c:if test = "${stock[3] == 1}">美股</c:if>
									<c:if test = "${stock[3] == 2}">港股</c:if>
									<c:if test = "${stock[3] == 3}">沪股</c:if>
									<c:if test = "${stock[3] == 4}">深股</c:if>
								</td>	
								<td>${stock[4]}</td>
								<td>
									<c:choose>
										<c:when test = "${empty stock[5]}">
										</c:when>
										<c:otherwise>
											
											${stock[5]}
											<span>|</span>
											<a href="${pageContext.request.contextPath}/stock/listStockPrice/${stock[0]}">趋势</a>
											<span>|</span>																					
										</c:otherwise>
									</c:choose>
									<a href="${pageContext.request.contextPath}/stock/addStockPriceUI/${stock[0]}">添加</a>
								</td>
							</tr>
						</c:forEach>
				</table>
			
			</div>
		</div>
	</body>
</html>