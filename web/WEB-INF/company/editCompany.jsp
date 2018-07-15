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
<!-- 			<div class="col-lg-12 jumbotron" align="center">
				<h2>公司列表</h2>
			</div> -->
			<div class="col-lg-12 jumbotron">
				
				<form action="${pageContext.request.contextPath}/company/updateCompany" method="post">
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>修改公司信息</em></h2>
						</div>
					</div>
					<!-- 公司 -->
				  <div class="form-row">
				    <div class="form-group col-md-4">
				    	<input type="hidden" id="id" name="companyId" value="${company.id}" hidden="true"/>
				      <label for="companyName" class="col-form-label" style="color: green;"><strong>公司名字</strong></label>
				      <input type="text" class="form-control" id="companyName" name="companyName" value="${company.companyName}">
				    </div>

				  </div>
				  <div class="form-row">
				  	<!-- 姓名 -->
				    <div class="form-group col-md-3">
				    	<input id="ceoId" type="hidden"  name="id" value="${company.ceo.id}"/>
				      <label for="ceoName" class="col-form-label" style="color: green;"><strong>CEO姓名</strong></label>
				      <input type="text" class="form-control" id="ceoName" name="name" value="${company.ceo.name}">
				    </div>
				    <!-- 年龄 -->
				    <div class="form-group col-md-2">
				    	<label for="" class="col-form-label" style="color: green;"><strong>CEO年龄</strong></label>
				    	<input type="text" class="form-control" id="cdoAge" name="age" value="${company.ceo.age}">
				    </div>
				    <!-- 性别 -->
				    <div class="form-group col-md-2" align="center">
				    	<label for="sexBlock" class="col-form-label" style="color: green;"><strong>CEO性别</strong></label>
						<div id="sexBlock" style="padding-top: 10px;">
					    	<label class="custom-control custom-radio">
							  <input id="man" name="sex" type="radio" value="男" class="custom-control-input">
							  <span class="custom-control-indicator"></span>
							  <span class="custom-control-description">男</span>
							</label>
							<label class="custom-control custom-radio">
							  <input id="woman" name="sex" type="radio" value="女" class="custom-control-input">
							  <span class="custom-control-indicator"></span>
							  <span class="custom-control-description">女</span>
							</label>
				    	</div>
				    </div>
				   </div>
				  <div class = "form-row"> 
				    <!-- 家乡 -->
				    <div class="form-group col-md-5">
				      <label for="ceoHomeTown" class="col-form-label" style="color: green; "><strong>CEO家乡</strong></label>
				      <input type="text" class="form-control" id="ceoHomeTown" name="homeTown" value="${company.ceo.homeTown}">
				    </div>
				  	
				    <!-- 大学 -->
				    <div class="form-group col-md-5">
				      <label for="university" class="col-form-label" style="color: green; "><strong>大学</strong></label>
				      <input type="text" class="form-control" id="university" name="university" value = "${company.ceo.university }">
				    </div>

				    <!-- 研究生 -->
				    <div class="form-group col-md-5">
				      <label for="postGraduate" class="col-form-label" style="color: green; "><strong>研究生学校</strong></label>
				      <input type="text" class="form-control" id="postGraduate" name="postGraduate" value = "${company.ceo.postGraduate }">
				    </div>				    		
				    <!-- 博士 -->
				    <div class="form-group col-md-5">
				      <label for="doctorSchool" class="col-form-label" style="color: green; "><strong>博士学校</strong></label>
				      <input type="text" class="form-control" id="doctorSchool" name="doctorSchool" value = "${company.ceo.doctorSchool }">
				    </div>	

		    		<!-- 学历 -->
				    <div class="form-group col-md-5">
				      <label for="education" class="col-form-label" style="color: green; "><strong>学历</strong></label>
				      <input type="text" class="form-control" id="education" name="education" value = "${company.ceo.education }">
				    </div>
				  </div>  
				   
				  	
				  	
				 
				  <div class="form-group">
				    <label for="description" class="col-form-label" style="color: green; "><strong>CEO介绍</strong></label>
				    <textarea class="form-control" id="description" name="description" rows="3" >${company.ceo.description}</textarea>
				  </div>
				  
				  <div class="form-row">
				  		<div class="form-group col-md-3" align="left">
						  <button type="submit" class="btn btn-primary btn-lg">保存</button>
				  		</div>
				  		<div class="form-group col-md-3" align="left">
						  <button type="reset" class="btn btn-lg btn-danger" >取消</button>
				  		</div>
				  </div>

				</form>
			</div>	
		</div>
	</body>
</html>