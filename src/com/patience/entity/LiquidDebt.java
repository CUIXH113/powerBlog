package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 流动负债
 * @author Administrator
 *
 */
@Entity
@Table(name="t_liquidDebt")
public class LiquidDebt implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 短期借款
     */
    private double shortTermBorrowing;
    /**
     * 应付账款
     */
    private double accountsPayable;
    /**
     * 其他应付款
     */
    private double otherPayable;
    /**
     * 预收账款
     */
    private double deferredRevenue;
    /**
     * 其他预收款
     */
    private double otherDeferredRevenue;
    /**
     * 流动负债总和
     */
    private double totalLiquidDebt;
    /**
     * 属于此负债
     */
    @OneToOne(mappedBy="liquidDebt")
    private Liability liability;
    
    public void initialTotalNum() {
        this.totalLiquidDebt = shortTermBorrowing + accountsPayable 
                + otherPayable + otherDeferredRevenue + deferredRevenue;
    }
    
    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    public LiquidDebt(){}
    
    public LiquidDebt(double shorttermborrowing, double accountspayable, double otherpayable,
            double deferredrevenue, double otherdeferredrevenue, Liability liability) {
        this.shortTermBorrowing = shorttermborrowing;
        this.accountsPayable = accountspayable;
        this.otherPayable = otherpayable;
        this.otherDeferredRevenue = otherdeferredrevenue;
        this.deferredRevenue = deferredrevenue;
        this.totalLiquidDebt = shorttermborrowing + accountspayable 
                + otherpayable + otherdeferredrevenue + deferredrevenue;
        this.liability = liability;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getShortTermBorrowing() {
        return shortTermBorrowing;
    }
    public void setShortTermBorrowing(double shortTermBorrowing) {
        this.shortTermBorrowing = shortTermBorrowing;
    }
    public double getAccountsPayable() {
        return accountsPayable;
    }
    public void setAccountsPayable(double accountsPayable) {
        this.accountsPayable = accountsPayable;
    }
    public double getOtherPayable() {
        return otherPayable;
    }
    public void setOtherPayable(double otherPayable) {
        this.otherPayable = otherPayable;
    }
    public double getDeferredRevenue() {
        return deferredRevenue;
    }
    public void setDeferredRevenue(double deferredRevenue) {
        this.deferredRevenue = deferredRevenue;
    }
    public double getOtherDeferredRevenue() {
        return otherDeferredRevenue;
    }
    public void setOtherDeferredRevenue(double otherDeferredRevenue) {
        this.otherDeferredRevenue = otherDeferredRevenue;
    }
    public double getTotalLiquidDebt() {
        return totalLiquidDebt;
    }
    public void setTotalLiquidDebt(double totalLiquidDebt) {
        this.totalLiquidDebt = totalLiquidDebt;
    }

    @Override
    public String toString() {
        return "LiquidDebt [id=" + id + ", shortTermBorrowing=" + shortTermBorrowing + ", accountsPayable="
                + accountsPayable + ", otherPayable=" + otherPayable + ", deferredRevenue=" + deferredRevenue
                + ", otherDeferredRevenue=" + otherDeferredRevenue + ", totalLiquidDebt=" + totalLiquidDebt
                + ", liability=" + liability + "]";
    }
  
    
    
}
