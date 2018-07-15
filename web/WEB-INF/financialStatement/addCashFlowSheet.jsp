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
				<form action="${pageContext.request.contextPath}/financialStatement/addCashFlowSheet" method="post" >
					<div class="form-row" align="center">
						<div class="form-group col-md-12">
							 <h2 class="display-4" style="color: green;"><em>新增现金流量表</em></h2>
							 <input type = "text" name = "companyId" value = ${companyId} hidden="true"/>
							 <input type = "text" name = "statementId" value = ${statementId} hidden="true"/>
						</div>
					</div>
					<!-- 经营活动的现金流量 -->
					<div class = "form-row bg-primary">
						<h2>经营活动的现金流量</h2>
					</div>
				  <div class="form-row bg-light">
				    <div class="form-group col-md-2">
				      <label for="sellGoodsAndServiceAcceptedCash" class="col-form-label" style="color: green;"><strong>销售商品和劳务所受到的现金</strong></label>
				      <input type="text" class="form-control" id="sellGoodsAndServiceAcceptedCash" name="sellGoodsAndServiceAcceptedCash">
				    </div>
 				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="receivedTaxReturn" class="col-form-label" style="color: green;"><strong>受到的税费返还</strong></label>
				      <input type="text" class="form-control" id="receivedTaxReturn" name = "receivedTaxReturn">
				    </div>
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="receivedOtherCashAboutOperating" class="col-form-label" style="color: green;"><strong>受到的其他与经营活动有关的现金</strong></label>
				    	<input type = "text" class = "form-control" id = "receivedOtherCashAboutOperating" name = "receivedOtherCashAboutOperating">
				    </div>

				  </div>
				 
				  <div class="form-row bg-light" >
			    	<div class = "form-group col-md-2" >
				    	<label for = "advancePayment" class = "col-form-label" style="color: green;"><strong>现金流入小计</strong></label>
				    	<input type = "text" class = "form-control" id = "advancePayment" name = "totalCashComeIn"/>
				    </div>				  
				  	<!-- 姓名 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				      <label for="paiedCashByBuyGoodsAndService" class="col-form-label" style="color: green;"><strong>购买商品，接受劳务支付的现金</strong></label>
				      <input type="text" class="form-control" id="paiedCashByBuyGoodsAndService" name="paiedCashByBuyGoodsAndService">
				    </div>
				    <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="paiedCashForEmployee" class="col-form-label" style="color: green;"><strong>支付给职工，以及为职工支付的现金</strong></label>
				    	<input type="text" class="form-control" id="paiedCashForEmployee" name="paiedCashForEmployee">
				    </div>
				       <!-- 年龄 -->
				    <div class="form-group col-md-2" style = "margin-left: 40px;">
				    	<label for="支付的各项税费" class="col-form-label" style="color: green;"><strong>支付的各项税费</strong></label>
				    	<input type="text" class="form-control" id="paiedKindsTaxes" name="paiedKindsTaxes">
				    </div>	
	
				  </div>

				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "paiedCashAboutOtherOperating" class = "col-form-label" style = "color: green;"><strong>支付的其他与经营活动有关的现金</strong></label>
						<input type = "text" class = "form-control" id = "paiedCashAboutOtherOperating" name = "paiedCashAboutOtherOperating"/>
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "totalCashGoOut" class = "col-form-label" style = "color: green;"><strong>现金流出小计</strong></label>
						<input type = "text" class = "form-control" id = "totalCashGoOut" name = "totalCashGoOut"/>
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "pureCashNumByOperating" class = "col-form-label" style = "color: green;"><strong>经营活动产生的现金流量净额</strong></label>
						<input type = "text" class = "form-control" id = "pureCashNumByOperating" name = "pureCashNumByOperating"/>
					</div>
				</div>
				<div class = "form-row bg-primary">
					<h2>投资活动的现金流量表</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "shortTermBorrowing" class = "col-form-label" style = "color: green;"><strong>收回投资所收到的现金</strong></label>
						<input type = "text" class = "form-control" id = "retractInvestIncomeAccptedCash" name = "retractInvestIncomeAccptedCash"/>
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "gainInvestIncomeAcceptedCash" class = "col-form-label" style = "color: green;"><strong>取得投资收益所收到的现金</strong></label>
						<input type = "text" class = "form-control" id = "gainInvestIncomeAcceptedCash" name = "gainInvestIncomeAcceptedCash"/>
					</div>
					
				</div>
				<div class = "form-row bg-light">
									
					<div class = "form-group col-md-3">
						<label for = "intangibleAssetsIncome" class = "col-form-label" style = "color: green;"><strong>处置固定资产，无形资产和其他长期资产所收到的</strong></label>
						<input type = "text" class = "form-control" id = "intangibleAssetsIncome" name = "intangibleAssetsIncome"/>
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "otherCashAboutInvest" class = "col-form-label" style = "color: green;"><strong>收到的其他的于投资活动有关的现金</strong></label>
						<input type = "text" class = "form-control" id = "otherCashAboutInvest" name = "otherCashAboutInvest"/>
					</div>
					<div class = "form-group col-md-2">
						<label for = "totalCashComeIn" class = "col-form-label" style = "color: green;"><strong>现金流入小计</strong></label>
						<input type = "text" class = "form-control" id = "totalCashComeIn" name = "totalCashComeIn"/>
					</div>					
				</div>				

				<div class = "form-row bg-light">
					<div class = "form-group col-md-2">
						<label for = "longTermBorrow" class = "col-form-label" style = "color: green;"><strong>购建固定资产，无形资产，和其他长期资产所支付的现金</strong></label>
						<input type = "text" class = "form-control" id = "otherAssetsPaiedCash" name = "otherAssetsPaiedCash"/>
					</div>
					<div class = "form-group col-md-2" style = "margin-left: 40px;">
						<label for = "investPaidCash" class = "col-form-label" style = "color: green;"><strong>投资或支付的现金</strong></label>
						<input type = "text" class = "form-control" id = "investPaidCash" name = "investPaidCash"/>
					</div>
					
				</div>
				<div class = "form-row bg-light">			
					<div class = "form-group col-md-3">
						<label for = "otherPaiedCashAboutInvest" class = "col-form-label" style = "color: green;"><strong>支付其他与投资活动有关的现金</strong></label>
						<input type = "text" class = "form-control" id = "otherPaiedCashAboutInvest" name = "otherPaiedCashAboutInvest"/>
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "totalCashGoOut" class = "col-form-label" style = "color: green;"><strong>现金流出小计</strong></label>
						<input type = "text" class = "form-control" id = "totalCashGoOut" name = "totalCashGoOut"/>
					</div>	
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "cashPureNumByInvest" class = "col-form-label" style = "color: green;"><strong>投资活动产生的现金流量净额</strong></label>
						<input type = "text" class = "form-control" id = "cashPureNumByInvest" name = "cashPureNumByInvest"/>
					</div>									
				</div>						
				<div class = "form-row bg-primary">
					<h2>融资活动现金流</h2>
				</div>
				<div class = "form-row bg-light">
					<div class = "form-group col-md-3">
						<label for = "absorbInvestmentCash" class = "col-form-label" style = "color: green;"><strong>吸收投资所受到的现金</strong></label>
						<input type = "text" class = "form-control" id = "absorbInvestmentCash" name = "absorbInvestmentCash"/>
					</div>	
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "borrowingCash" class = "col-form-label" style = "color: green;"><strong>借款所受到的现金</strong></label>
						<input type = "text" class = "form-control" id = "borrowingCash" name = "borrowingCash"/>
					</div>
					<div class = "form-group col-md-3" style = "margin-left: 40px;">
						<label for = "otherCashAboutFinancing" class = "col-form-label" style = "color: green;"><strong>收到的其他与筹资活动有关的现金</strong></label>
						<input type = "text" class = "form-control" id = "otherCashAboutFinancing" name = "otherCashAboutFinancing"/>
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