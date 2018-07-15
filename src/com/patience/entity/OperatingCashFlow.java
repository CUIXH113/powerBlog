package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 经营活动的现金流量
 * @author Administrator
 *
 */
@Entity
@Table(name="t_operatingCashFlow")
public class OperatingCashFlow implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(mappedBy="operatingCashFlow")
	private CashFlowStatement cashFlowStatement;
	/**
	 * 销售商品和劳务所受到的现金
	 */
	private double sellGoodsAndServiceAcceptedCash;
	/**
	 * 受到的税费返还
	 */
	private double receivedTaxReturn;
	/**
	 * 受到的其他与经营活动有关的现金
	 */
	private double receivedOtherCashAboutOperating;
	/**
	 * 现金流入小计
	 */
	private double totalCashComeIn;
	/**
	 * 购买商品，接受劳务支付的现金
	 */
	private double paiedCashByBuyGoodsAndService;
	/**
	 * 支付给职工，以及为职工支付的现金
	 */
	private double paiedCashForEmployee;
	/**
	 * 支付的各项税费
	 */
	private double paiedKindsTaxes;
	/**
	 * 支付的其他与经营活动有关的现金
	 */
	private double paiedCashAboutOtherOperating;
	/**
	 * 现金流出小计
	 */
	private double totalCashGoOut;
	/**
	 * 经营活动产生的现金流量净额
	 */
	private double pureCashNumByOperating;
	
	public OperatingCashFlow() {}
	public OperatingCashFlow(double sellGoodsAndServiceAcceptedCash, double receivedTaxReturn, 
			double receivedOtherCashAboutOperating, double totalCashComeIn, 
			double  paiedCashByBuyGoodsAndService, double paiedCashForEmployee, 
			double  paiedKindsTaxes, double paiedCashAboutOtherOperating,
			double totalCashGoOut, double pureCashNumByOperating, CashFlowStatement cashFlowStatement) {
		
		this.sellGoodsAndServiceAcceptedCash = sellGoodsAndServiceAcceptedCash;
		this.receivedTaxReturn = receivedTaxReturn;
		this.receivedOtherCashAboutOperating = receivedOtherCashAboutOperating;
		this.totalCashComeIn = totalCashComeIn;
		this.paiedCashByBuyGoodsAndService = paiedCashAboutOtherOperating;
		this.paiedCashForEmployee = paiedCashForEmployee;
		this.paiedKindsTaxes = paiedKindsTaxes;
		this.paiedCashAboutOtherOperating = paiedCashAboutOtherOperating;
		this.totalCashGoOut = totalCashGoOut;
		this.pureCashNumByOperating = pureCashNumByOperating;
		this.cashFlowStatement = cashFlowStatement;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CashFlowStatement getCashFlowStatement() {
		return cashFlowStatement;
	}
	public void setCashFlowStatement(CashFlowStatement cashFlowStatement) {
		this.cashFlowStatement = cashFlowStatement;
	}
	public double getSellGoodsAndServiceAcceptedCash() {
		return sellGoodsAndServiceAcceptedCash;
	}
	public void setSellGoodsAndServiceAcceptedCash(double sellGoodsAndServiceAcceptedCash) {
		this.sellGoodsAndServiceAcceptedCash = sellGoodsAndServiceAcceptedCash;
	}
	public double getReceivedTaxReturn() {
		return receivedTaxReturn;
	}
	public void setReceivedTaxReturn(double receivedTaxReturn) {
		this.receivedTaxReturn = receivedTaxReturn;
	}
	public double getReceivedOtherCashAboutOperating() {
		return receivedOtherCashAboutOperating;
	}
	public void setReceivedOtherCashAboutOperating(double receivedOtherCashAboutOperating) {
		this.receivedOtherCashAboutOperating = receivedOtherCashAboutOperating;
	}
	public double getTotalCashComeIn() {
		return totalCashComeIn;
	}
	public void setTotalCashComeIn(double totalCashComeIn) {
		this.totalCashComeIn = totalCashComeIn;
	}
	public double getPaiedCashByBuyGoodsAndService() {
		return paiedCashByBuyGoodsAndService;
	}
	public void setPaiedCashByBuyGoodsAndService(double paiedCashByBuyGoodsAndService) {
		this.paiedCashByBuyGoodsAndService = paiedCashByBuyGoodsAndService;
	}
	public double getPaiedCashForEmployee() {
		return paiedCashForEmployee;
	}
	public void setPaiedCashForEmployee(double paiedCashForEmployee) {
		this.paiedCashForEmployee = paiedCashForEmployee;
	}
	public double getPaiedKindsTaxes() {
		return paiedKindsTaxes;
	}
	public void setPaiedKindsTaxes(double paiedKindsTaxes) {
		this.paiedKindsTaxes = paiedKindsTaxes;
	}
	public double getPaiedCashAboutOtherOperating() {
		return paiedCashAboutOtherOperating;
	}
	public void setPaiedCashAboutOtherOperating(double paiedCashAboutOtherOperating) {
		this.paiedCashAboutOtherOperating = paiedCashAboutOtherOperating;
	}
	public double getTotalCashGoOut() {
		return totalCashGoOut;
	}
	public void setTotalCashGoOut(double totalCashGoOut) {
		this.totalCashGoOut = totalCashGoOut;
	}
	public double getPureCashNumByOperating() {
		return pureCashNumByOperating;
	}
	public void setPureCashNumByOperating(double pureCashNumByOperating) {
		this.pureCashNumByOperating = pureCashNumByOperating;
	}
	@Override
	public String toString() {
		return "OperatingCashFlow [id=" + id + ", cashFlowStatement=" + cashFlowStatement
				+ ", sellGoodsAndServiceAcceptedCash=" + sellGoodsAndServiceAcceptedCash + ", receivedTaxReturn="
				+ receivedTaxReturn + ", receivedOtherCashAboutOperating=" + receivedOtherCashAboutOperating
				+ ", totalCashComeIn=" + totalCashComeIn + ", paiedCashByBuyGoodsAndService="
				+ paiedCashByBuyGoodsAndService + ", paiedCashForEmployee=" + paiedCashForEmployee
				+ ", paiedKindsTaxes=" + paiedKindsTaxes + ", paiedCashAboutOtherOperating="
				+ paiedCashAboutOtherOperating + ", totalCashGoOut=" + totalCashGoOut + ", pureCashNumByOperating="
				+ pureCashNumByOperating + "]";
	}
	
	
	
	
}
