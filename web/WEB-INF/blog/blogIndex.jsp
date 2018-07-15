<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--允许缩放-->
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<title>muchunlin</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<link href="${pageContext.request.contextPath }/blogcss/blog.css" rel="stylesheet">
		
		<style>
			a.one:link {text-decoration:none; color: black;}		
			a.one:visited {text-decoration: color: black;}
			a.one:hover {text-decoration:underline; color: black;}	
			a.one:active {color:#0000FF; color: black;}
			
			a.two:link {text-decoration: none; color: black;}
			a.two:visited {text-decoration: none; color: black;}
			a.two:hover {text-decoration: none; color: #428bca;}
			a.two:active {text-decoration: none; color: #428bca;}
			
			a.pagenum:link {text-decoration: none; color: black;}
			a.pagenum:visited {text-decoration: none; color: black;}
			a.pagenum:hover {text-decoration: none; color: black;}
			a.pagenum:active {text-decoration: none; color: black;}
			
			div.inline {float:left;}
		</style>
	</head>
<body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="nav">
          <a class="nav-link active" href="#">首页</a>
          <a class="nav-link" href="${pageContext.request.contextPath}/checkSheet/listSheetForGuest">备忘录</a>
          <a class="nav-link" href="#">Press</a>
          <a class="nav-link" href="#">New hires</a>
          <a class="nav-link" href="${pageContext.request.contextPath}/blog/about">关于</a>
        </nav>
      </div>
    </div>

  <!--   <div class="blog-header">
      <div class="container">
        <h1 class="blog-title">The Bootstrap Blog</h1>
        <p class="lead blog-description">An example blog template built with Bootstrap.</p>
      </div>
    </div> -->

    <div class="container">

      <div class="row">

        <div class="col-sm-9 blog-main">

          <div class="blog-post ">
	   		<h2 class="blog-post-title" align="center" ><a class="" href="${pageContext.request.contextPath}/blog/viewForwardBlog/1" target = "_blank" style="color: black; word-spacing: 4px;">分形算法生成树</a></h2>
            <p class="blog-post-meta" align="center" style="font-size: 14px">发表于 2017-09-28 by 穆春林</p>
			<br/>
            <p style="word-spacing: 4px">第一篇博客样板文章哈哈哈哈哈.</p>
            <br/><br/>
            <div class="text-center">
            	<a href="${pageContext.request.contextPath}/blog/viewForwardBlog/1" target = "_blank" class="btn btn-outline-primary text-center " >阅读全文>></a>
            </div>
 			
          </div><!-- /.blog-post -->

        <div class="blog-post ">
	   		<h2 class="blog-post-title" align="center" ><a class="" href="#" style="color: black; word-spacing: 4px;">分形算法生成树</a></h2>
            <p class="blog-post-meta" align="center" style="font-size: 14px">发表于 2017-09-28 by 穆春林</p>
			<br/>
            <p style="word-spacing: 4px">This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
            <br/><br/>
            <div class="text-center">
            	<a href="#" class="btn btn-outline-primary text-center " >阅读全文>></a>
            </div>
 			
          </div><!-- /.blog-post -->
          
          <div class="blog-post">
	   		<h2 class="blog-post-title" align="center" ><a class="" href="#" style="color: black; word-spacing: 4px;">分形算法生成树</a></h2>
            <p class="blog-post-meta" align="center" style="font-size: 14px">发表于 2017-09-28 by 穆春林</p>
			<br/>
            <p style="word-spacing: 4px">This blog post shows a few different types of content that's supported and styled with Bootstrap. Basic typography, images, and code are all supported.</p>
            <br/><br/>
            <div class="text-center">
            	<a href="#" class="btn btn-outline-primary text-center " >阅读全文>></a>
            </div>
          </div><!-- /.blog-post -->
 			<!-- 页码 -->
          <div class="blog-pagination" align="center" >
          	 <div class="btn-group mr-2" role="group" aria-label="First group" align="center" ><!--  -->
			    <a type="button" class="btn btn btn-light pagenum" href="#" style="border-style:dotted;border-color: white;">1</a>
			    <a type="button" class="btn btn-light pagenum" href="#" style="border-style:dotted;border-color: black;">2</a>
			    <a type="button" class="btn btn btn-light pagenum" href="#" style="border-style:dotted;border-color: white;">></a>
			  </div>
          </div> 

 <!--          <nav class="blog-pagination" style="text-align: center;">
           	<a class="btn btn-outline-secondary " href="#">第一页</a>
            <a class="btn btn-outline-primary" href="#">第二页</a>
           
          </nav> -->

        </div><!-- /.blog-main -->
		<!-- 右边div -->
        <div class="col-sm-3 offset-sm-1 blog-sidebar">
        	<div  class="align-bottom text-center" style="background-color: #428bca;margin: 0px; height: 120px">
        		<div style="padding: 30px">
  		       	   <h2  style="text-align: center; color: white;">powermcl
 					</h2>
        		</div>

        	</div>
       
          <div class="sidebar-module sidebar-module-inset">   
          	<br/>     	
            <div align="center">
            	<img alt="powermcl" src="${pageContext.request.contextPath }/images/myhead.jpg" style="width: 70%; border-style: solid; border-color: white;" align="middle">
            	<br/>
            	<h4 style="color: #428bca; padding-top: 16px;">chunlin</h4>
            	<h6>学习是一种生活方式</h6>
            </div>
            
            <br/>
            <div align="center" style="line-height: 6px;">
            	<h6 style="font-family: '宋体'"><strong>17</strong></h6>
            	<h6 style="font-family: '宋体'">日志</h6>
            </div>
            <br/>
            <div  class="inline"  align="center">
            	<span style="padding-right: 80px;">
            		<a  class="p-2 two" href="https://twitter.com/womuchunlin" target="_black" rel="noopener" aria-label="Twitter" >
            			<svg class="navbar-nav-svg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 499.36" focusable="false" style="height: 15%; width: 15%;">
            			<path d="M160.83 416.32c193.2 0 298.92-160.22 298.92-298.92 0-4.51 0-9-.2-13.52A214 214 0 0 0 512 49.38a212.93 212.93 0 0 1-60.44 16.6 105.7 105.7 0 0 0 46.3-58.19 209 209 0 0 1-66.79 25.37 105.09 105.09 0 0 0-181.73 71.91 116.12 116.12 0 0 0 2.66 24c-87.28-4.3-164.73-46.3-216.56-109.82A105.48 105.48 0 0 0 68 159.6a106.27 106.27 0 0 1-47.53-13.11v1.43a105.28 105.28 0 0 0 84.21 103.06 105.67 105.67 0 0 1-47.33 1.84 105.06 105.06 0 0 0 98.14 72.94A210.72 210.72 0 0 1 25 370.84a202.17 202.17 0 0 1-25-1.43 298.85 298.85 0 0 0 160.83 46.92" fill="currentColor"></path>
            			</svg>
            			
            		</a>
            	</span>
            	<span >
            		<a  class="p-2 two" href="https://github.com/womuchunlin" target="_black" rel="noopener" aria-label="GitHub" >
            			<svg class="navbar-nav-svg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 499.36" focusable="false" style="height: 15%; width: 15%;">
            			<path d="M256 0C114.64 0 0 114.61 0 256c0 113.09 73.34 209 175.08 242.9 12.8 2.35 17.47-5.56 17.47-12.34 0-6.08-.22-22.18-.35-43.54-71.2 15.49-86.2-34.34-86.2-34.34-11.64-29.57-28.42-37.45-28.42-37.45-23.27-15.84 1.73-15.55 1.73-15.55 25.69 1.81 39.21 26.38 39.21 26.38 22.84 39.12 59.92 27.82 74.5 21.27 2.33-16.54 8.94-27.82 16.25-34.22-56.84-6.43-116.6-28.43-116.6-126.49 0-27.95 10-50.8 26.35-68.69-2.63-6.48-11.42-32.5 2.51-67.75 0 0 21.49-6.88 70.4 26.24a242.65 242.65 0 0 1 128.18 0c48.87-33.13 70.33-26.24 70.33-26.24 14 35.25 5.18 61.27 2.55 67.75 16.41 17.9 26.31 40.75 26.31 68.69 0 98.35-59.85 120-116.88 126.32 9.19 7.9 17.38 23.53 17.38 47.41 0 34.22-.31 61.83-.31 70.23 0 6.85 4.61 14.81 17.6 12.31C438.72 464.97 512 369.08 512 256.02 512 114.62 397.37 0 256 0z" fill="currentColor" fill-rule="evenodd"></path>
            			</svg>
            			
            		</a>
            		
            	</span>
            	
            </div class="inline">
            	   	<span style="padding-right: 75px; padding-left: 8px; font-size: 16px;">Twitter</span>
            	   	<span style="font-size: 16px;">GitHub</span>
            <div>
            	
            </div>
            <br/><br/>
          </div>
         <!--  <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div> -->
         
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js" ></script>
    <script>window.jQuery || document.write('<script src="/powermclblog/blogjs/jquery.min.js"><\/script>')</script>
    <script src="${pageContext.request.contextPath }/blogjs/popper.min.js"></script>
    <script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath }/blogjs/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>