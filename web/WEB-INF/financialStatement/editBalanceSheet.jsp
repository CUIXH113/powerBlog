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
		<link rel="icon" href="${pageContext.request.contextPath }/images/bloglogo.jpg">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/blogcss/bootstrap.min.css">
		<script src="${pageContext.request.contextPath }/blogjs/jquery-3.2.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath }/blogjs/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container" >
				<form action="${pageContext.request.contextPath}/financialStatement/editBalanceSheet" method="post" >
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>资产负债表</em></h2>
							<%-- <input type = "text" name = "companyId" value = "${companyId}" hidden="true"/> --%>
							 <input type = "text" name = "balanceSheetId" value = "${balanceSheet.id}" hidden="true"/>
						</div>
					</div>
					<!-- 资产：1.流动资产 -->
					<div class = "form-row bg-primary">
						<h2>资产：流动资产</h2>
					</div>
				  <div class="form-row bg-light">
				    <div class="form-group col-md-2">
				      <label for="monetaryFund" class="col-form-label" style="color: green;"><strong>货币资金</strong></label>
				      <input type="text" class="form-control" id="monetaryFund" name="monetaryFund" value = "${balanceSheet.assets.liquidAssets.monetaryFund }">
				    </div>
 				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="accountsReceivable" class="col-form-label" style="color: green;"><strong>应收账款</strong></label>
				      <input type="text" class="form-control" id="accountsReceivable" name = "accountsReceivable" value = "${balanceSheet.assets.liquidAssets.accountsReceivable }">
				    </div>
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="receivableOther" class="col-form-label" style="color: green;"><strong>其他应收款</strong></label>
				    	<input type = "text" class = "form-control" id = "receivableOther" name = "receivableOther" value = "${balanceSheet.assets.liquidAssets.receivableOther }">
				    </div>

				  </div>
				 
				  <div class="form-row bg-light" >
			    	<div class = "form-group col-md-2" >
				    	<label for = "advancePayment" class = "col-form-label" style="color: green;"><strong>预付账款</strong></label>
				    	<input type = "text" class = "form-control" id = "advancePayment" name = "advancePayment" value = "${balanceSheet.assets.liquidAssets.advancePayment }"/>
				    </div>				  
				  	<!-- 姓名 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="inventory" class="col-form-label" style="color: green;"><strong>存贷</strong></label>
				      <input type="text" class="form-control" id="inventory" name="inventory" value = "${balanceSheet.assets.liquidAssets.inventory}">
				    </div>
				    <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="prepaidExpenses" class="col-form-label" style="color: green;"><strong>待摊费用</strong></label>
				    	<input type="text" class="form-control" id="prepaidExpenses" name="prepaidExpenses"  value = "${balanceSheet.assets.liquidAssets.prepaidExpenses}"  >
				    </div>
				       <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="otherLiquidAssets" class="col-form-label" style="color: green;"><strong>其他流动资产</strong></label>
				    	<input type="text" class="form-control" id="otherLiquidAssets" name="otherLiquidAssets"  value = "${balanceSheet.assets.liquidAssets.otherLiquidAssets}" >
				    </div>	
	
				  </div>
				   <!-- 非流动资产 -->
				<div class = "form-row bg-primary">
					<h2>资产：非流动资产</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "longTermInvestment" class = "col-form-label" style = "color: green;"><strong>长期投资</strong></label>
						<input type = "text" class = "form-control" id = "longTermInvestment" name = "longTermInvestment" value = "${balanceSheet.assets.noLiquidAssets.longTermInvestment}"  />
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "solidAssets" class = "col-form-label" style = "color: green;"><strong>固定资产</strong></label>
						<input type = "text" class = "form-control" id = "solidAssets" name = "solidAssets"  value = "${balanceSheet.assets.noLiquidAssets.solidAssets}" />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "otherAssets" class = "col-form-label" style = "color: green;"><strong>无形资产及其他非流动资产</strong></label>
						<input type = "text" class = "form-control" id = "otherAssets" name = "otherAssets"   value = "${balanceSheet.assets.noLiquidAssets.otherAssets}" />
					</div>
				</div>
				<div class = "form-row bg-primary">
					<h2>负债：流动负债</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "shortTermBorrowing" class = "col-form-label" style = "color: green;"><strong>短期借款</strong></label>
						<input type = "text" class = "form-control" id = "shortTermBorrowing" name = "shortTermBorrowing"  value = "${balanceSheet.liability.liquidDebt.shortTermBorrowing}"   />
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "accountsPayable" class = "col-form-label" style = "color: green;"><strong>应付账款</strong></label>
						<input type = "text" class = "form-control" id = "accountsPayable" name = "accountsPayable" value = "${balanceSheet.liability.liquidDebt.accountsPayable}"   />
					</div>
					
				</div>
				<div class = "form-row bg-light">
									
					<div class = "form-group col-md-3">
						<label for = "otherPayable" class = "col-form-label" style = "color: green;"><strong>其他应付款</strong></label>
						<input type = "text" class = "form-control" id = "otherPayable" name = "otherPayable"  value = "${balanceSheet.liability.liquidDebt.otherPayable}"   />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "deferredRevenue" class = "col-form-label" style = "color: green;"><strong>预收账款</strong></label>
						<input type = "text" class = "form-control" id = "deferredRevenue" name = "deferredRevenue"  value = "${balanceSheet.liability.liquidDebt.deferredRevenue}"  />
					</div>
					<div class = "form-group col-md-2">
						<label for = "otherDeferredRevenue" class = "col-form-label" style = "color: green;"><strong>短期借款</strong></label>
						<input type = "text" class = "form-control" id = "otherDeferredRevenue" name = "otherDeferredRevenue" value = "${balanceSheet.liability.liquidDebt.otherDeferredRevenue}"  />
					</div>					
				</div>				

				<div class = "form-row bg-primary">
					<h2>负债：非流动负债</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "longTermBorrow" class = "col-form-label" style = "color: green;"><strong>长期借款</strong></label>
						<input type = "text" class = "form-control" id = "longTermBorrow" name = "longTermBorrow"  value = "${balanceSheet.liability.nonLiquidDebt.longTermBorrow}" />
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "shouldPayBond" class = "col-form-label" style = "color: green;"><strong>应付债券</strong></label>
						<input type = "text" class = "form-control" id = "shouldPayBond" name = "shouldPayBond"  value = "${balanceSheet.liability.nonLiquidDebt.shouldPayBond}" />
					</div>
					
				</div>
				<div class = "form-row bg-light">			
					<div class = "form-group col-md-3">
						<label for = "longTermShouldPay" class = "col-form-label" style = "color: green;"><strong>长期应付款</strong></label>
						<input type = "text" class = "form-control" id = "longTermShouldPay" name = "longTermShouldPay" value = "${balanceSheet.liability.nonLiquidDebt.longTermShouldPay}"  />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "otherNonLiquidDebt" class = "col-form-label" style = "color: green;"><strong>其他非流动负债</strong></label>
						<input type = "text" class = "form-control" id = "otherNonLiquidDebt" name = "otherNonLiquidDebt" value = "${balanceSheet.liability.nonLiquidDebt.otherNonLiquidDebt}"  />
					</div>				
				</div>						
				<div class = "form-row bg-primary">
					<h2>负债：所有者权益</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-3">
						<label for = "paidInCapita" class = "col-form-label" style = "color: green;"><strong>实收资本</strong></label>
						<input type = "text" class = "form-control" id = "paidInCapita" name = "paidInCapita" value = "${balanceSheet.liability.ownerEquity.paidInCapita}"  />
					</div>	
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "capitalReserves" class = "col-form-label" style = "color: green;"><strong>资本公积</strong></label>
						<input type = "text" class = "form-control" id = "capitalReserves" name = "capitalReserves"  value = "${balanceSheet.liability.ownerEquity.capitalReserves}"  />
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "surplusReserves" class = "col-form-label" style = "color: green;"><strong>盈余公积</strong></label>
						<input type = "text" class = "form-control" id = "surplusReserves" name = "surplusReserves"  value = "${balanceSheet.liability.ownerEquity.surplusReserves}"  />
					</div>
					<div class = "form-group col-md-3">
						<label for = "retainedEarnings" class = "col-form-label" style = "color: green;"><strong>留存收益</strong></label>
						<input type = "text" class = "form-control" id = "retainedEarnings" name = "retainedEarnings"  value = "${balanceSheet.liability.ownerEquity.retainedEarnings}"  />
					</div>					
				</div>		
						
				  <div class="form-row bg-light">
				  		<div class="form-group col-md-3" align="left">
						  <button type="submit" class="btn btn-primary btn-lg">保存</button>
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