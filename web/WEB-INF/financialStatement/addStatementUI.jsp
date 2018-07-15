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
		<title>财报列表</title>
		<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>		
	</head>
	<body>
		<div class = "container">
			<div class = "">
				<h1>${companyName}</h1>
			</div>
			<div class = "table-responsive">
				<table class = "table table-inverse">
					<thead>
						<tr>
							<th>#id</th>
							<th>财报类型</th>
							<th>创建日期</th>
							<th>报表年份</th>
							<th>资产负债表</th>
							<th>现金流量表</th>
							<th>利润表</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ids}" var="sheet">
							<tr>
								<td>${sheet[0]}</td>
								<td>
									<c:if test = "${sheet[4] == 1}">
										第一季度
									</c:if>
									<c:if test = "${sheet[4] == 2}">
										第二季度
									</c:if>
									<c:if test = "${sheet[4] == 3}">
										第三季度
									</c:if>
									<c:if test = "${sheet[4] == 4}">
										第四季度
									</c:if>
									<c:if test = "${sheet[4] == 5}">
										半年报
									</c:if>
									<c:if test = "${sheet[4] == 6}">
										年报
									</c:if>

								</td>
								<td>${sheet[5]}</td>
								<td>${sheet[6]}</td>
								<td>
									<c:choose>
										<c:when test = "${empty sheet[1]}">
											<a href = "${pageContext.request.contextPath}/financialStatement/addChildSheetUI/${companyId}/${sheet[0]}/1">添加</a>
										</c:when>
										<c:otherwise>
											<a href = "${pageContext.request.contextPath}/financialStatement/showSheet/1/${sheet[1]}" ><strong>ID:${sheet[1]}&nbsp</strong></a>|
											<a href = "${pageContext.request.contextPath}/financialStatement/deleteSheet/${sheet[0]}/1">删除</a>
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<c:choose>
										<c:when test = "${empty sheet[2]}">
											<a href = "${pageContext.request.contextPath}/financialStatement/addChildSheetUI/${companyId}/${sheet[0]}/2">添加</a>
										</c:when>
										<c:otherwise>
											<a href = "${pageContext.request.contextPath}/financialStatement/showSheet/2/${sheet[2]}"><strong>ID:${sheet[2]}&nbsp</strong></a>|
											<a href = "${pageContext.request.contextPath}/financialStatement/deleteSheet/${sheet[0]}/2">删除</a>
										</c:otherwise>
									</c:choose>
								</td>
								<%-- <td><a href = "${pageContext.request.contextPath}/company/showStock/${company.id}"></a>${sheet.stock.stockCode}</td> --%>
								<td>
									<c:choose>
										<c:when test="${empty sheet[3]}">
											<a href = "${pageContext.request.contextPath}/financialStatement/addChildSheetUI/${companyId}/${sheet[0]}/3">添加</a>
										</c:when>
										<c:otherwise>
											<a href = "${pageContext.request.contextPath}/financialStatement/showSheet/3/${sheet[3]}"><strong>ID:${sheet[3]}&nbsp</strong></a>|
											<a href = "${pageContext.request.contextPath}/financialStatement/deleteSheet/${sheet[0]}/3">删除</a>
											
										</c:otherwise>									
									</c:choose>
								</td>
								<td>
									<a href = "${pageContext.request.contextPath}/financialStatement/delete/${sheet[0]}">删除</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>			
				</table>
			</div>
		</div>
	</body>
</html>