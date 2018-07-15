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
		<title>添加资产负债表</title>
		<link rel="icon" href="${pageContext.request.contextPath}/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath}/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" >
				<form action="${pageContext.request.contextPath}/financialStatement/editProfitStatement" method="post" >
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>修改利润表</em></h2>
							 <%-- <input type = "text" name = "statementId" value = "${statementId}" hidden="true"/> --%>
							 <input type = "text" name = "id" value = "${profitSheetId}" hidden="true"/>
						</div>
					</div>
				
				  <div class="form-row bg-light">
				    <div class="form-group col-md-2">
				      <label for="operatingIncome" class="col-form-label" style="color: green;"><strong>营业收入</strong></label>
				      <input type="text" class="form-control" id="operatingIncome" name="operatingIncome" value = "${profitSheet.operatingIncome }">
				    </div>
 				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="operatingCost" class="col-form-label" style="color: green;"><strong>营业成本</strong></label>
				      <input type="text" class="form-control" id="operatingCost" name = "operatingCost" value = "${profitSheet.operatingCost }" >
				    </div>
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="operatingTaxAndAdditional" class="col-form-label" style="color: green;"><strong>营业税金及附加</strong></label>
				    	<input type = "text" class = "form-control" id = "operatingTaxAndAdditional" name = "operatingTaxAndAdditional" value = "${profitSheet.operatingTaxAndAdditional }"  >
				    </div>

				  </div>
				 
				  <div class="form-row bg-light" >
			    	<div class = "form-group col-md-2" >
				    	<label for = "operatingExpenses" class = "col-form-label" style="color: green;"><strong>营业费用</strong></label>
				    	<input type = "text" class = "form-control" id = "operatingExpenses" name = "operatingExpenses" value = "${profitSheet.operatingExpenses }"  />
				    </div>				  
				  	<!-- 姓名 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="managementFees" class="col-form-label" style="color: green;"><strong>管理费用</strong></label>
				      <input type="text" class="form-control" id="managementFees" name="managementFees"  value = "${profitSheet.managementFees }" >
				    </div>
				    <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="financeCharges" class="col-form-label" style="color: green;"><strong>财务费用</strong></label>
				    	<input type="text" class="form-control" id="financeCharges" name="financeCharges" value = "${profitSheet.financeCharges }"  >
				    </div>
				       <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="assetsImpairmentLoss" class="col-form-label" style="color: green;"><strong>资产减值损失</strong></label>
				    	<input type="text" class="form-control" id="assetsImpairmentLoss" name="assetsImpairmentLoss" value = "${profitSheet.assetsImpairmentLoss }"  >
				    </div>	
	
				  </div>
				
				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "benefitsOfFairValueChange" class = "col-form-label" style = "color: green;"><strong>公允价值变动收益</strong></label>
						<input type = "text" class = "form-control" id = "benefitsOfFairValueChange" name = "benefitsOfFairValueChange" value = "${profitSheet.benefitsOfFairValueChange }"  />
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "incomeFromInvestment" class = "col-form-label" style = "color: green;"><strong>投资收益</strong></label>
						<input type = "text" class = "form-control" id = "incomeFromInvestment" name = "incomeFromInvestment" value = "${profitSheet.incomeFromInvestment }"  />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "jointVentureIncome" class = "col-form-label" style = "color: green;"><strong>对联营企业和合营企业的的投资收益</strong></label>
						<input type = "text" class = "form-control" id = "jointVentureIncome" name = "jointVentureIncome" value = "${profitSheet.jointVentureIncome }"  />
					</div>
				</div>

				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "operatingProfit" class = "col-form-label" style = "color: green;"><strong>营业利润</strong></label>
						<input type = "text" class = "form-control" id = "operatingProfit" name = "operatingProfit" value = "${profitSheet.operatingProfit }"  />
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "nonOperatingIncome" class = "col-form-label" style = "color: green;"><strong>营业外收入</strong></label>
						<input type = "text" class = "form-control" id = "nonOperatingIncome" name = "nonOperatingIncome" value = "${profitSheet.nonOperatingIncome }"  />
					</div>
					
				</div>
				<div class = "form-row bg-light">
									
					<div class = "form-group col-md-3">
						<label for = "nonOperatingExpenditure" class = "col-form-label" style = "color: green;"><strong>营业外支出</strong></label>
						<input type = "text" class = "form-control" id = "nonOperatingExpenditure" name = "nonOperatingExpenditure" value = "${profitSheet.nonOperatingExpenditure }"  />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "totalProfit" class = "col-form-label" style = "color: green;"><strong>利润总额</strong></label>
						<input type = "text" class = "form-control" id = "totalProfit" name = "totalProfit"  value = "${profitSheet.totalProfit }" />
					</div>
					<div class = "form-group col-md-2">
						<label for = "incomeTaxExpense" class = "col-form-label" style = "color: green;"><strong>所得税费用</strong></label>
						<input type = "text" class = "form-control" id = "incomeTaxExpense" name = "incomeTaxExpense" value = "${profitSheet.incomeTaxExpense }"  />
					</div>					
				</div>				

				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "netProfit" class = "col-form-label" style = "color: green;"><strong>净利润</strong></label>
						<input type = "text" class = "form-control" id = "netProfit" name = "netProfit" value = "${profitSheet.netProfit }" />
					</div>
				</div>	
				  <div class="form-row bg-light">
				  		<div class="form-group col-md-3" align="left">
						  <button type="submit" class="btn btn-primary btn-lg">修改</button>
				  		</div>
				  		<div class="form-group col-md-3" align="left">
						  <button type="reset" class="btn btn-lg btn-danger" >取消</button>
				  		</div>
				  </div>
				  <div class="form-row bg-light">
				  		<div class="form-group col-md-3" align="left">
						  <h1>&nbsp;</h1>
				  		</div>
				  		
				  </div>					
				</form>
		</div>
	</body>
</html>