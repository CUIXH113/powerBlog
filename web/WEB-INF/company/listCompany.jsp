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
		<title>公司列表</title>
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		
		<div class="container">

			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>公司名字</th>
							<th>CEO</th>
							<th>股票</th>
							<th>财务报表</th>
							<th>操作</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${companyList}" var="company">
							<tr><!-- 公司名字 -->
								<td><a href = "${pageContext.request.contextPath}/company/editCompanyUI/${company[4]}">${company[0]}</a></td>
								<td><!-- ceo -->
									<a href = "${pageContext.request.contextPath}/company/editCompanyUI/${company[4]}">${company[1]}</a><!--  target = "_blank" -->
								</td>
								<td><!-- 股票 -->
									<c:choose>
										<c:when test = "${empty company[5]}">
											<a href = "${pageContext.request.contextPath}/stock/addStockUI/${company[4]}">添加</a>
											
										</c:when>
										<c:otherwise>
											<a href = "${pageContext.request.contextPath}/stock/showStock/${company[5]}">代码${company[2]}</a>|
											<a href = "${pageContext.request.contextPath}/stock/deleteStock/${company[4]}">删除</a> 
										</c:otherwise>
									</c:choose>
								</td>
								<td><!-- 财报 -->
									<c:choose>
										<c:when test="${empty company[3]}">
											<a href = "${pageContext.request.contextPath}/financialStatement/addFinancialStatement/${company[4]}">添加</a>
										</c:when>
										<c:otherwise>
											<a href = "${pageContext.request.contextPath}/financialStatement/addStatementUI/${company[4]}">数目${company[3]}</a>&nbsp|
											<a href = "${pageContext.request.contextPath}/financialStatement/addFinancialStatement/${company[4]}">&nbsp添加</a>
										</c:otherwise>
									</c:choose>
								</td>
								<td><!-- 操作 -->
									<a href = "${pageContext.request.contextPath}/company/delete/${company[4]}">删除</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				
				
				</table>
			</div>
			
		</div>
		
	</body>
</html>