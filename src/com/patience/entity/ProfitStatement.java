package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 利润表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_profitStatement")
public class ProfitStatement implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(mappedBy="profitStatement")
    private FinancialStatement financialStatement;
    
    /**
     * 营业收入
     */
    private double operatingIncome;
    /**
     * 营业成本
     */
    private double operatingCost;
    /**
     * 营业税金及附加
     */
    private double operatingTaxAndAdditional;
    /**
     * 营业费用
     */
    private double operatingExpenses;
    /**
     * 管理费用
     */
    private double managementFees;
    /**
     * 财务费用
     */
    private double financeCharges;
    /**
     *资产减值损失 
     */
    private double assetsImpairmentLoss;
    /**
     * 公允价值变动收益
     */
    private double benefitsOfFairValueChange;
    /**
     * 投资收益
     */
    private double  incomeFromInvestment;
    /**
     * 对联营企业和合营企业的的投资收益
     */
    private double jointVentureIncome;
    /**
     * 营业利润
     */
    private double operatingProfit;
    /**
     * 营业外收入
     */
    private double nonOperatingIncome;
    /**
     * 营业外支出
     */
    private double nonOperatingExpenditure;
    /**
     * 利润总额
     */
    private double totalProfit;
    /**
     * 所得税费用
     */
    private double incomeTaxExpense;
    /**
     * 净利润
     */
    private double netProfit;
    
    public ProfitStatement(double operatingIncome, double operatingCost, double operatingTaxAndAdditional, double operatingExpenses,
    		double managementFees, double financeCharges, double assetsImpairmentLoss, double benefitsOfFairValueChange,
    		double incomeFromInvestment, double jointVentureIncome, double operatingProfit, double nonOperatingIncome, 
    		double nonOperatingExpenditure, double totalProfit, double incomeTaxExpense, double netProfit, FinancialStatement financialStatement) {
    	
    	this.operatingIncome = operatingIncome;
    	this.operatingCost = operatingCost;
    	this.operatingTaxAndAdditional = operatingTaxAndAdditional;
    	this.operatingExpenses = operatingExpenses;
    	this.managementFees = managementFees;
    	this.financeCharges = financeCharges;
    	this.assetsImpairmentLoss = assetsImpairmentLoss;
    	this.benefitsOfFairValueChange = benefitsOfFairValueChange;
    	this.incomeFromInvestment = incomeFromInvestment;
    	this.jointVentureIncome = jointVentureIncome;
    	this.operatingProfit = operatingProfit;
    	this.nonOperatingIncome = nonOperatingIncome;
    	this.nonOperatingExpenditure = nonOperatingExpenditure;
    	this.totalProfit = totalProfit;
    	this.incomeTaxExpense = incomeTaxExpense;
    	this.netProfit = netProfit;
    	this.financialStatement = financialStatement;
    	
    }
    public FinancialStatement getFinancialStatement() {
		return financialStatement;
	}
	public void setFinancialStatement(FinancialStatement financialStatement) {
		this.financialStatement = financialStatement;
	}
	public ProfitStatement() {}
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getOperatingIncome() {
		return operatingIncome;
	}
	public void setOperatingIncome(double operatingIncome) {
		this.operatingIncome = operatingIncome;
	}
	public double getOperatingCost() {
		return operatingCost;
	}
	public void setOperatingCost(double operatingCost) {
		this.operatingCost = operatingCost;
	}
	public double getOperatingTaxAndAdditional() {
		return operatingTaxAndAdditional;
	}
	public void setOperatingTaxAndAdditional(double operatingTaxAndAdditional) {
		this.operatingTaxAndAdditional = operatingTaxAndAdditional;
	}
	public double getOperatingExpenses() {
		return operatingExpenses;
	}
	public void setOperatingExpenses(double operatingExpenses) {
		this.operatingExpenses = operatingExpenses;
	}
	public double getManagementFees() {
		return managementFees;
	}
	public void setManagementFees(double managementFees) {
		this.managementFees = managementFees;
	}
	public double getFinanceCharges() {
		return financeCharges;
	}
	public void setFinanceCharges(double financeCharges) {
		this.financeCharges = financeCharges;
	}
	public double getAssetsImpairmentLoss() {
		return assetsImpairmentLoss;
	}
	public void setAssetsImpairmentLoss(double assetsImpairmentLoss) {
		this.assetsImpairmentLoss = assetsImpairmentLoss;
	}
	public double getBenefitsOfFairValueChange() {
		return benefitsOfFairValueChange;
	}
	public void setBenefitsOfFairValueChange(double benefitsOfFairValueChange) {
		this.benefitsOfFairValueChange = benefitsOfFairValueChange;
	}
	public double getIncomeFromInvestment() {
		return incomeFromInvestment;
	}
	public void setIncomeFromInvestment(double incomeFromInvestment) {
		this.incomeFromInvestment = incomeFromInvestment;
	}
	public double getJointVentureIncome() {
		return jointVentureIncome;
	}
	public void setJointVentureIncome(double jointVentureIncome) {
		this.jointVentureIncome = jointVentureIncome;
	}
	public double getOperatingProfit() {
		return operatingProfit;
	}
	public void setOperatingProfit(double operatingProfit) {
		this.operatingProfit = operatingProfit;
	}
	public double getNonOperatingIncome() {
		return nonOperatingIncome;
	}
	public void setNonOperatingIncome(double nonOperatingIncome) {
		this.nonOperatingIncome = nonOperatingIncome;
	}
	public double getNonOperatingExpenditure() {
		return nonOperatingExpenditure;
	}
	public void setNonOperatingExpenditure(double nonOperatingExpenditure) {
		this.nonOperatingExpenditure = nonOperatingExpenditure;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	public double getIncomeTaxExpense() {
		return incomeTaxExpense;
	}
	public void setIncomeTaxExpense(double incomeTaxExpense) {
		this.incomeTaxExpense = incomeTaxExpense;
	}
	public double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(double netProfit) {
		this.netProfit = netProfit;
	}
	@Override
	public String toString() {
		return "ProfitStatement [id=" + id + ", operatingIncome=" + operatingIncome + ", operatingCost=" + operatingCost
				+ ", operatingTaxAndAdditional=" + operatingTaxAndAdditional + ", operatingExpenses="
				+ operatingExpenses + ", managementFees=" + managementFees + ", financeCharges=" + financeCharges
				+ ", assetsImpairmentLoss=" + assetsImpairmentLoss + ", benefitsOfFairValueChange="
				+ benefitsOfFairValueChange + ", incomeFromInvestment=" + incomeFromInvestment + ", jointVentureIncome="
				+ jointVentureIncome + ", operatingProfit=" + operatingProfit + ", nonOperatingIncome="
				+ nonOperatingIncome + ", nonOperatingExpenditure=" + nonOperatingExpenditure + ", totalProfit="
				+ totalProfit + ", incomeTaxExpense=" + incomeTaxExpense + ", netProfit=" + netProfit + "]";
	}
    
    
}
