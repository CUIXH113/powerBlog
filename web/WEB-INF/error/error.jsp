<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>http://muchunlin.com</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$("#testBtn").click(function () {
				$.get("http://localhost:8080/exercise/user/testJson",  function(data, textStatus) {
					alert("Json:"+data);
				});
			});
		});
	
	</script>
</head>
<body>
		<h1>登录失败</h1><br/>
		<a href="${pageContext.request.contextPath}/user/registerUI" >注册</a>
		<a href="testJson">测试Json数据</a><br/>
		<a href="testEchart">测试Echart</a>
		
		<input type="button" id="testBtn" value="测试json"/>
						
</body>
</html>