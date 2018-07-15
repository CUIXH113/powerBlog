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
 * 流动资产
 * @author Administrator
 *
 */
@Entity
@Table(name="t_liquidAssets")
public class LiquidAssets implements Serializable{
    
    private static final long serialVersionUID = -6963485049921785517L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 货币资金
     */
    private double monetaryFund;
    /**
     * 应收账款
     */
    private double accountsReceivable;
    /**
     * 其他应收款
     */
    private double receivableOther;
    /**
     * 预付账款
     */
    private double advancePayment;
    /**
     * 存货
     */
    private double inventory;
    /**
     * 待摊费用
     */
    private double prepaidExpenses;
    /**
     * 其他流动资产
     */
    private double otherLiquidAssets;
    /**
     * 所属于的资产
     */
    @OneToOne(mappedBy="liquidAssets")
    private Assets assets;
    /**
     * 流动资产合计
     */
    private double totalLiquidAssets;
    
    public void initialTotalNum() {
        this.totalLiquidAssets = monetaryFund + accountsReceivable + receivableOther
                + advancePayment + inventory + prepaidExpenses + otherLiquidAssets;   
    }
    
    
    public LiquidAssets() {
        
    }
    
    public LiquidAssets(double moneyFund, double accouneReceiveable, double receiveableOther,
            double advicePayment, double inventory, Assets assets,
            double prepaidExpenses, double otherLiquidAssets){
        this.monetaryFund = moneyFund;
        this.accountsReceivable = accouneReceiveable;
        this.receivableOther = receiveableOther;
        this.advancePayment = advicePayment;
        this.inventory = inventory;
        this.prepaidExpenses = prepaidExpenses;
        this.otherLiquidAssets = otherLiquidAssets;
        this.totalLiquidAssets = moneyFund + accouneReceiveable + receiveableOther
                + advicePayment + inventory + prepaidExpenses + otherLiquidAssets;
        this.assets = assets;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getMonetaryFund() {
        return monetaryFund;
    }
    public void setMonetaryFund(double monetaryFund) {
        this.monetaryFund = monetaryFund;
    }
    public double getAccountsReceivable() {
        return accountsReceivable;
    }
    public void setAccountsReceivable(double accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }
    public double getReceivableOther() {
        return receivableOther;
    }
    public void setReceivableOther(double receivableOther) {
        this.receivableOther = receivableOther;
    }
    public double getAdvancePayment() {
        return advancePayment;
    }
    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }
    public double getInventory() {
        return inventory;
    }
    public void setInventory(double inventory) {
        this.inventory = inventory;
    }
    public double getPrepaidExpenses() {
        return prepaidExpenses;
    }
    public void setPrepaidExpenses(double prepaidExpenses) {
        this.prepaidExpenses = prepaidExpenses;
    }
    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public double getTotalLiquidAssets() {
        return totalLiquidAssets;
    }

    public void setTotalLiquidAssets(double totalLiquidAssets) {
        this.totalLiquidAssets = totalLiquidAssets;
    }

    public double getOtherLiquidAssets() {
        return otherLiquidAssets;
    }
    public void setOtherLiquidAssets(double otherLiquidAssets) {
        this.otherLiquidAssets = otherLiquidAssets;
    }

    @Override
    public String toString() {
        return "LiquidAssets [id=" + id + ", monetaryFund=" + monetaryFund + ", accountsReceivable="
                + accountsReceivable + ", receivableOther=" + receivableOther + ", advancePayment=" + advancePayment
                + ", inventory=" + inventory + ", prepaidExpenses=" + prepaidExpenses + ", otherLiquidAssets="
                + otherLiquidAssets + ", assets=" + assets + ", totalLiquidAssets=" + totalLiquidAssets + "]";
    }
 
    
}
