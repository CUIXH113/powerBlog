package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 现金流量表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_cashFlowStatement")
public class CashFlowStatement implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    public CashFlowStatement() {}
    public CashFlowStatement(FinancialStatement financialStatement, 
            OperatingCashFlow operatingCashFlow, 
            InvestmentCashFlow investmentCashFlow, 
            FinancingActivitiyCashFlow financingActivitiyCashFlow) {
        
        this.financialStatement  = financialStatement;
        this.operatingCashFlow = operatingCashFlow;
        this.investmentCashFlow = investmentCashFlow;
        this.financingActivitiyCashFlow = financingActivitiyCashFlow;
        this.totalCashFlow = 0.0;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(mappedBy="cashFlowStatement")
	private FinancialStatement financialStatement;
	/**
	 * 经营活动产生的现金流量
	 */
	@OneToOne
	@JoinColumn(name="operatingCashFlowId")
	private OperatingCashFlow operatingCashFlow;
	/**
	 * 投资活动产生的现金流量
	 */
	@OneToOne
	@JoinColumn(name="investmentCashFlowId")
	private InvestmentCashFlow investmentCashFlow;	
	/**
	 * 融资活动产生的现金流量
	 */
	@OneToOne
	@JoinColumn(name="financingActivitiyCashFlowId")
	private FinancingActivitiyCashFlow financingActivitiyCashFlow;
	/**
	 * 现金流量总和
	 */
	private double totalCashFlow;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public FinancialStatement getFinancialStatement() {
        return financialStatement;
    }
    public void setFinancialStatement(FinancialStatement financialStatement) {
        this.financialStatement = financialStatement;
    }
    public OperatingCashFlow getOperatingCashFlow() {
        return operatingCashFlow;
    }
    public void setOperatingCashFlow(OperatingCashFlow operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
    }
    public InvestmentCashFlow getInvestmentCashFlow() {
        return investmentCashFlow;
    }
    public void setInvestmentCashFlow(InvestmentCashFlow investmentCashFlow) {
        this.investmentCashFlow = investmentCashFlow;
    }
    public FinancingActivitiyCashFlow getFinancingActivitiyCashFlow() {
        return financingActivitiyCashFlow;
    }
    public void setFinancingActivitiyCashFlow(FinancingActivitiyCashFlow financingActivitiyCashFlow) {
        this.financingActivitiyCashFlow = financingActivitiyCashFlow;
    }
    public double getTotalCashFlow() {
        return totalCashFlow;
    }
    public void setTotalCashFlow(double totalCashFlow) {
        this.totalCashFlow = totalCashFlow;
    }
    @Override
    public String toString() {
        return "CashFlowStatement [id=" + id + ", financialStatement=" + financialStatement + ", operatingCashFlow="
                + operatingCashFlow + ", investmentCashFlow=" + investmentCashFlow + ", financingActivitiyCashFlow="
                + financingActivitiyCashFlow + ", totalCashFlow=" + totalCashFlow + "]";
    }
	
	
}
