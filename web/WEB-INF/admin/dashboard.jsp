<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="后台首页">
    <meta name="author" content="powermcl">
    <link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">

    <title>后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/blogcss/dashboard.css" rel="stylesheet">
  </head>

  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">后台管理</a>
      <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/" target = "_blank">博客主页 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Settings</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Help</a>
          </li>
        </ul>
        <form class="form-inline mt-2 mt-md-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
			<div class="dropdown" align="left" style="padding: 10px;">
			  <button class="btn btn-lg btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			   公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <a class="dropdown-item" href="${pageContext.request.contextPath }/company/addCompanyUI" target="_blank">新增公司</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath }/company/listCompany" target="_blank">公司列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			  </div>
			</div>
			
			<div class="dropdown" align="left" style="padding: 10px;">
			  <button class="btn btn-lg btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    股票&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <!-- <a class="dropdown-item" href="/powermclblog/stock/addStockUI" target="_blank">新增股票&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> -->
			    <a class="dropdown-item" href="${pageContext.request.contextPath }/stock/listStock" target="_blank">股票列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
			  </div>
			</div>
			
			
			<div class="dropdown" align="left" style="padding: 10px;">
			  <button class="btn btn-lg btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    备忘录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/checkSheet/uploadFileUI" target="_blank">文件上传</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/checkSheet/updateFile" target="_blank">文件修改</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/checkSheet/listCheckSheet" target="_blank">文件列表</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/checkSheet/listCheckSheetByCondition/1" target="_blank">可用列表</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/checkSheet/listCheckSheetByCondition/0" target="_blank">不可用列表</a>
			  </div>
			</div>
			
			<div class="dropdown" align="left" style="padding: 10px;">
			  <button class="btn btn-lg btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    博客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/listBlog" target="_blank">博客列表</a>
			    <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/uploadBlogUI/${user.userEmail}/${user.userPassword}" target="_blank">博客上传</a>
			  </div>
			</div>			
        
        </nav>

        <main class="col-sm-9 ml-sm-auto col-md-10 pt-3" role="main">
        
          <h1>后台管理</h1>

          <section class="row text-center placeholders">
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="200" height="200" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <div class="text-muted">Something else</div>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" width="200" height="200" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="200" height="200" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" width="200" height="200" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </section>

          <h2>数据分析</h2>
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
 
                </tr>
              </thead>
              <tbody>
              	<%-- <c:choose>
              		<c:when test=""></c:when>
              	</c:choose> --%>
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
	                </tr>              	
              	</c:forEach>
 
              </tbody>
            </table>
          </div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath }/blogjs/jquery.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath }/blogjs/popper.min.js"></script>
    <script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath }/blogjs/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
