<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico">
    <title>httt://muchunlin.com</title>
    <!-- Bootstrap 核心 CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- 对于这个模板的自定义样式表 -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    <!--为了调试过程，不要复制成两行-->
    <script src="${pageContext.request.contextPath}/js/ie-emulation-modes-warning.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
   <div class="container">
        <div class="row">
            <div class="col-lg-12" >
                <form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/user/register" method="post">
                    <h2 class="page-header">欢迎注册</h2>
                    <div class="form-group">
                        <label>用户名</label>
                        <input class="form-control" name="userName"/>
                        <p class="help-block">请输入1-6位用户名，只能用数字或字母，区分大小写</p>
                    </div>
                    <div class="form-group">
                        <label>密  码</label>
                        <input class="form-control" name="userPassword" />
                    </div>
                    <div class="form-group">
                        <label>电  话</label>
                        <input class="form-control" name="userPhone" placeholder="请输入电话"/>
                    </div>
                    <div class="form-group input-group">
                        <input class="form-control" placeholder="电子邮箱地址" name="userEmail"/>
 <!--                        <span class="input-group-addon">@</span>
                        <select class="form-control">
                            <option vlaue = "163.com" selected>163.com</option>
                            <option value = "qq.com">qq.com</option>
                            <option value = "gmail.com">gmail.com</option>
                        </select> -->
                    </div>

                    <div class="form-group">
                        <label>性别</label>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="sex" id="optionsRadios1" value="man" checked>
                              	  男
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="sex" id="optionsRadios2" value="woman" checked>
                              	  女
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary" style="margin-right: 100px;">提交</button>
                    <button type="reset" class="btn btn-danger">取消</button>

                </form>
            </div>
        </div>
    </div>
</body>
</html>