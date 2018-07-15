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
							<th>资产负债表</th>
							<th>现金流量表</th>
							<th>利润表</th>
							<th>操作</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${statements}" var="statement">
							<tr>
								<td><a href = "${pageContext.request.contextPath}/financialStatement/editCompanyUI/${company.id}" target="_blank">${company.companyName}</a></td>
								<td>
					
									<a href = "${pageContext.request.contextPath}/financialStatement/getCeo/${company.id}">${company.ceo.name}</a>
								</td>
								<td><a href = "${pageContext.request.contextPath}/financialStatement/getStock/${company.id}"></a>${company.stock.stockCode}</td>
								<td>
									<c:when test="${company.financialStatements != null}">
										<a href = "${pageContext.request.contextPath}/financialStatement/listFinancialStatement/${company['id']}">添加</a>
									</c:when>
									<c:otherwise>
										<a href = "${pageContext.request.contextPath}/financialStatement/addFinancialStatement/${company['id']}">添加</a>
									</c:otherwise>
								</td>
								<td>
									<a href = "${pageContext.request.contextPath}/company/delete/${company.id}">删除</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				
				
				</table>
			</div>
			
		</div>		
	</body>
</html>