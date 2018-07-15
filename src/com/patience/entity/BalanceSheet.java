package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 资产负债表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_balanceSheet")
public class BalanceSheet implements Serializable{
    
    private static final long serialVersionUID = -6963485049921785517L;
    
    /**
     * 财务报表
     */
    @OneToOne(mappedBy="balanceSheet")
    private FinancialStatement financialStatement;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 资产
     */
    @OneToOne
    @JoinColumn(name="assetsId")
    private Assets assets;
    
    /**
     * 负债
     */
    @OneToOne
    @JoinColumn(name="liabilityId")
    private Liability liability;
    
    public BalanceSheet() {}
    
    public BalanceSheet(Assets assets, Liability liability, FinancialStatement financialStatement) {
        this.assets = assets;
        this.liability = liability;
        this.financialStatement = financialStatement;
    }

    public FinancialStatement getFinancialStatement() {
        return financialStatement;
    }

    public void setFinancialStatement(FinancialStatement financialStatement) {
        this.financialStatement = financialStatement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    @Override
    public String toString() {
        return "BalanceSheet [id=" + id + ", assets=" + assets + ", liability=" + liability + "]";
    }
    
    
    
   
    
    
}
