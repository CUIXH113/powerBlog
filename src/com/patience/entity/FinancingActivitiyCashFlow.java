package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 融资活动现金流
 * @author Administrator
 *
 */
@Entity
@Table(name="t_financingActivityCashFlow")
public class FinancingActivitiyCashFlow implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(mappedBy="financingActivitiyCashFlow")
	private CashFlowStatement cashFlowStatement;
	/**
	 * 吸收投资所受到的现金
	 */
	private double absorbInvestmentCash;
	/**
	 * 借款所受到的现金
	 */
	private double borrowingCash;
	/**
	 * 收到的其他与筹资活动有关的现金
	 */
	private double otherCashAboutFinancing;
	/**
	 * 小计
	 */
	private double totalfinancialActivityCashFlow;
	
	public void initialTotalNum() {
		this.totalfinancialActivityCashFlow = absorbInvestmentCash
				+ borrowingCash + otherCashAboutFinancing;
	}
	
	public FinancingActivitiyCashFlow(double absorbInvestmentCash, double borrowingCash, double otherCashAboutFinancing) {
		this.absorbInvestmentCash = absorbInvestmentCash;
		this.borrowingCash = borrowingCash;
		this.otherCashAboutFinancing = otherCashAboutFinancing;
		this.totalfinancialActivityCashFlow = absorbInvestmentCash
				+ borrowingCash + otherCashAboutFinancing;
	}
	
	public FinancingActivitiyCashFlow( ) {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAbsorbInvestmentCash() {
		return absorbInvestmentCash;
	}
	public void setAbsorbInvestmentCash(double absorbInvestmentCash) {
		this.absorbInvestmentCash = absorbInvestmentCash;
	}
	public double getBorrowingCash() {
		return borrowingCash;
	}
	public void setBorrowingCash(double borrowingCash) {
		this.borrowingCash = borrowingCash;
	}
	public double getOtherCashAboutFinancing() {
		return otherCashAboutFinancing;
	}
	public void setOtherCashAboutFinancing(double otherCashAboutFinancing) {
		this.otherCashAboutFinancing = otherCashAboutFinancing;
	}
	public double getTotalfinancialActivityCashFlow() {
		return totalfinancialActivityCashFlow;
	}
	public void setTotalfinancialActivityCashFlow(double totalfinancialActivityCashFlow) {
		this.totalfinancialActivityCashFlow = totalfinancialActivityCashFlow;
	}
	@Override
	public String toString() {
		return "FinancingActivitiyCashFlow [id=" + id + ", absorbInvestmentCash=" + absorbInvestmentCash
				+ ", borrowingCash=" + borrowingCash + ", otherCashAboutFinancing=" + otherCashAboutFinancing
				+ ", totalfinancialActivityCashFlow=" + totalfinancialActivityCashFlow + "]";
	}
	

}
