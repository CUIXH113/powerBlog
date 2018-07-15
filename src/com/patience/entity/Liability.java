package com.patience.entity;

import java.io.Serializable;
import java.security.acl.Owner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 负债
 * @author Administrator
 *
 */
@Entity
@Table(name="t_liability")
public class Liability implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    /**
     * 所属于的资产负债表
     */
    @OneToOne(mappedBy="liability")
    private BalanceSheet balancesheet;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 流动负债
     */
    @OneToOne
    @JoinColumn(name="liquidDebtId")
    private LiquidDebt liquidDebt;
    /**
     * 非流动负债
     */
    @OneToOne
    @JoinColumn(name="nonLiquidDebtId")
    private NonLiquidDebt nonLiquidDebt;
    /**
     * 所有者权益
     */
    @OneToOne
    @JoinColumn(name="ownerEquityId")
    private OwnerEquity ownerEquity;
    /**
     * 负债合计
     */
    private double totalLiability;
    
    public Liability(){}
    public Liability(LiquidDebt liquidDebt, NonLiquidDebt nonLiquidDebt, 
            OwnerEquity ownerEquity, BalanceSheet balanceSheet) {
        this.liquidDebt = liquidDebt;
        this.nonLiquidDebt = nonLiquidDebt;
        this.ownerEquity = ownerEquity;
        this.totalLiability = liquidDebt.getTotalLiquidDebt() 
                + nonLiquidDebt.getTotalNonLiquidDebt()
                + ownerEquity.getTotalOwnerEquity();
        this.balancesheet = balanceSheet;
    }
    
    public BalanceSheet getBalancesheet() {
        return balancesheet;
    }
    public void setBalancesheet(BalanceSheet balancesheet) {
        this.balancesheet = balancesheet;
    }
    public double getTotalLiability() {
        return totalLiability;
    }
    public void setTotalLiability(double totalLiability) {
        this.totalLiability = totalLiability;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LiquidDebt getLiquidDebt() {
        return liquidDebt;
    }
    public void setLiquidDebt(LiquidDebt liquidDebt) {
        this.liquidDebt = liquidDebt;
    }
    public NonLiquidDebt getNonLiquidDebt() {
        return nonLiquidDebt;
    }
    public void setNonLiquidDebt(NonLiquidDebt nonLiquidDebt) {
        this.nonLiquidDebt = nonLiquidDebt;
    }
    public OwnerEquity getOwnerEquity() {
        return ownerEquity;
    }
    public void setOwnerEquity(OwnerEquity ownerEquity) {
        this.ownerEquity = ownerEquity;
    }
    @Override
    public String toString() {
        return "Liability [id=" + id + ", liquidDebt=" + liquidDebt + ", nonLiquidDebt=" + nonLiquidDebt
                + ", ownerEquity=" + ownerEquity + ", totalLiability=" + totalLiability + "]";
    }
  
    
    
}
