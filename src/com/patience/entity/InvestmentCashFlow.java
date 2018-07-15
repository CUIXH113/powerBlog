package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 投资活动的现金流量表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_investmentCashFlow")
public class InvestmentCashFlow implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    /**
     * 所属于的现金流量表
     */
	@OneToOne(mappedBy="investmentCashFlow")
	private CashFlowStatement cashFlowStatement;
	/**
	 * 收回投资所收到的现金
	 */
	private double retractInvestIncomeAccptedCash;
	/**
	 * 取得投资收益所收到的现金
	 */
	private double gainInvestIncomeAcceptedCash;
	/**
	 * 处置固定资产，无形资产和其他长期资产所收到的
	 */
	private double intangibleAssetsIncome;
	/**
	 * 收到的其他的于投资活动有关的现金
	 */
	private double otherCashAboutInvest;
	/**
	 * 现金流入小计
	 */
	private double totalCashComeIn;
	/**
	 * 购建固定资产，无形资产，和其他长期资产所支付的现金
	 */
	private double otherAssetsPaiedCash;
	/**
	 * 投资或支付的现金
	 */
	private double investPaidCash;
	/**
	 * 支付其他与投资活动有关的现金
	 */
	private double otherPaiedCashAboutInvest;
	/**
	 * 现金流出小计
	 */
	private double totalCashGoOut;
	/**
	 * 投资活动产生的现金流量净额
	 */
	private double cashPureNumByInvest;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getRetractInvestIncomeAccptedCash() {
		return retractInvestIncomeAccptedCash;
	}
	public void setRetractInvestIncomeAccptedCash(double retractInvestIncomeAccptedCash) {
		this.retractInvestIncomeAccptedCash = retractInvestIncomeAccptedCash;
	}
	public double getGainInvestIncomeAcceptedCash() {
		return gainInvestIncomeAcceptedCash;
	}
	public void setGainInvestIncomeAcceptedCash(double gainInvestIncomeAcceptedCash) {
		this.gainInvestIncomeAcceptedCash = gainInvestIncomeAcceptedCash;
	}
	public double getIntangibleAssetsIncome() {
		return intangibleAssetsIncome;
	}
	public void setIntangibleAssetsIncome(double intangibleAssetsIncome) {
		this.intangibleAssetsIncome = intangibleAssetsIncome;
	}
	public double getOtherCashAboutInvest() {
		return otherCashAboutInvest;
	}
	public void setOtherCashAboutInvest(double otherCashAboutInvest) {
		this.otherCashAboutInvest = otherCashAboutInvest;
	}
	public double getTotalCashComeIn() {
		return totalCashComeIn;
	}
	public void setTotalCashComeIn(double totalCashComeIn) {
		this.totalCashComeIn = totalCashComeIn;
	}
	public double getOtherAssetsPaiedCash() {
		return otherAssetsPaiedCash;
	}
	public void setOtherAssetsPaiedCash(double otherAssetsPaiedCash) {
		this.otherAssetsPaiedCash = otherAssetsPaiedCash;
	}
	public double getInvestPaidCash() {
		return investPaidCash;
	}
	public void setInvestPaidCash(double investPaidCash) {
		this.investPaidCash = investPaidCash;
	}
	public double getOtherPaiedCashAboutInvest() {
		return otherPaiedCashAboutInvest;
	}
	public void setOtherPaiedCashAboutInvest(double otherPaiedCashAboutInvest) {
		this.otherPaiedCashAboutInvest = otherPaiedCashAboutInvest;
	}
	public double getTotalCashGoOut() {
		return totalCashGoOut;
	}
	public void setTotalCashGoOut(double totalCashGoOut) {
		this.totalCashGoOut = totalCashGoOut;
	}
	public double getCashPureNumByInvest() {
		return cashPureNumByInvest;
	}
	public void setCashPureNumByInvest(double cashPureNumByInvest) {
		this.cashPureNumByInvest = cashPureNumByInvest;
	}
	@Override
	public String toString() {
		return "InvestmentCashFlow [id=" + id + ", retractInvestIncomeAccptedCash=" + retractInvestIncomeAccptedCash
				+ ", gainInvestIncomeAcceptedCash=" + gainInvestIncomeAcceptedCash + ", intangibleAssetsIncome="
				+ intangibleAssetsIncome + ", otherCashAboutInvest=" + otherCashAboutInvest + ", totalCashComeIn="
				+ totalCashComeIn + ", otherAssetsPaiedCash=" + otherAssetsPaiedCash + ", investPaidCash="
				+ investPaidCash + ", otherPaiedCashAboutInvest=" + otherPaiedCashAboutInvest + ", totalCashGoOut="
				+ totalCashGoOut + ", cashPureNumByInvest=" + cashPureNumByInvest + "]";
	}
	
	
}
