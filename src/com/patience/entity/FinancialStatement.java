package com.patience.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 财务报表
 * @author muchunlin
 *
 */
@Entity
@Table(name="t_financialSheet")
public class FinancialStatement implements Serializable{
    /**第一季度*/
	public static final int FIRST_QUERTER = 1;
	/**第二季度*/
	public static final int SECOND_QUARTER = 2;
	/**第三季度*/
	public static final int THIRD_QUARTER = 3;
	/**第四季度*/
	public static final int FOURTH_QUARTER = 4;
	/**半年报*/
	public static final int HALF_YEAR_QUARTER = 5;
	/**年报*/
	public static final int YEAR_STATEMENT = 6;
	
	
    private static final long serialVersionUID = -6963485049921785517L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    /**
     * 报表类型：1.季报，2.半年报;3.年报
     */
    private int sheetFlag;
    /**
     * 报表产生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 报表年份
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date statementDate;
    /**
     * 资产负债表
     */
    @OneToOne
    @JoinColumn(name="balanceSheetId")
    private BalanceSheet balanceSheet;
    /**
     * 利润表
     */
    @OneToOne
    @JoinColumn(name="profitStatementId")
    private ProfitStatement profitStatement;
    
    @OneToOne
    @JoinColumn(name="cashFlowStatementId")
    private CashFlowStatement cashFlowStatement;
    
    @ManyToOne
    @JoinColumn(name="companyId")
    private Company company;
    
    public FinancialStatement() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 财报构造方法
     * @param company ：公司
     * @param createTime ：表建立时期
     * @param statementDate ：表代表时期
     * @param sheetFlag ：表类型
     */
    public FinancialStatement(Company company, 
            Date createTime, Date statementDate) {
        this.createTime = createTime;
        this.company = company;
        this.statementDate = statementDate;
    }
    /**
     * 设置三张表
     * @param balanceSheet
     * @param cashFlowStatement
     * @param profitStatement
     */
    public void setThreeSheets(BalanceSheet balanceSheet,
            CashFlowStatement cashFlowStatement, 
            ProfitStatement profitStatement) {
        this.balanceSheet = balanceSheet;
        this.cashFlowStatement = cashFlowStatement;
        this.profitStatement = profitStatement;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    public int getSheetFlag() {
        return sheetFlag;
    }
    public void setSheetFlag(int sheetFlag) {
        this.sheetFlag = sheetFlag;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public ProfitStatement getProfitStatement() {
        return profitStatement;
    }

    public void setProfitStatement(ProfitStatement profitStatement) {
        this.profitStatement = profitStatement;
    }

    public CashFlowStatement getCashFlowStatement() {
        return cashFlowStatement;
    }

    public void setCashFlowStatement(CashFlowStatement cashFlowStatement) {
        this.cashFlowStatement = cashFlowStatement;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        this.statementDate = statementDate;
    }

    @Override
    public String toString() {
        return "FinancialStatement [id=" + id + ", sheetFlag=" + sheetFlag + ", createTime=" + createTime
                + ", statementDate=" + statementDate + ", balanceSheet=" + balanceSheet + ", profitStatement="
                + profitStatement + ", cashFlowStatement=" + cashFlowStatement + ", company=" + company + "]";
    }

}
