<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN" class="no-js">
<head>

<meta charset="utf-8">
<title>www.muchunlin.cn</title>
<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="登录">
<meta name="author" content="powermcl">

<!-- CSS -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/supersized.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/tooltips.js"></script>
<!-- <script src="/powermclblog/js/login.js"></script> -->
</head>

<body>

	<div class="page-container">
		<div class="main_box">
			<div class="login_box">
				<div class="login_logo">
					<img src="${pageContext.request.contextPath}/images/bloglogo.jpg" >
				</div>
			
				<div class="login_form">
					<form action="${pageContext.request.contextPath}/user/login" id="login_form" method="post">
						<div class="form-group">
							<label for="j_username" class="t">邮　箱：</label> 
							<input id="user_email" value="" name="user_email" type="text" class="form-control x319 in" 
							autocomplete="off"><!-- autocomplete="off" -->
						</div>
						<div class="form-group">
							<label for="j_password" class="t">密　码：</label> 
							<input id="password" value="" name="password" type="password" 
							class="password form-control x319 in">
						</div>
<!-- 						<div class="form-group">
							 <label for="j_captcha" class="t">验证码：</label>
							 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
							<img id="captcha_img" alt="点击更换" title="点击更换" src="images/captcha.jpeg" class="m">
						</div> -->
<!-- 						<div class="form-group">
							<label class="t"></label>
							<label for="j_remember" class="m">
							<input id="j_remember" type="checkbox"  value="true">&nbsp;记住登陆账号!</label>
						</div> -->
						<div class="form-group space">
							<label class="t"></label>　　　
							<button type="submit"  id="submit_btn" 
							class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
							<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
						</div>
					</form>
				</div>
			</div>
			<div class="bottom">Copyright &copy; 2016 - 2017 <a href="#">系统登陆</a></div>
		</div>
	</div>
	
	<!-- Javascript -->
	
	<script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/supersized-init.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
	<!-- <div style="text-align:center;">
	<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
	</div> -->
</body>
</html>