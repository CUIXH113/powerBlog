package com.patience.entity;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 非流动负债
 * @author Administrator
 *
 */
@Entity
@Table(name="t_nonLiquidDebt")
public class NonLiquidDebt implements Serializable{

    public NonLiquidDebt() {}
    
    public NonLiquidDebt(double longtermborrow, double shouldpaybond, 
            double longtermshouldpay,  double othernonliquiddebt, Liability liability) {
        this.longTermBorrow = longtermborrow;
        this.shouldPayBond = shouldpaybond;
        this.longTermShouldPay = longtermshouldpay;
        this.otherNonLiquidDebt = othernonliquiddebt;
        this.totalNonLiquidDebt = longtermborrow + shouldpaybond
                + longtermshouldpay + othernonliquiddebt;
        this.liability = liability;
    }
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 长期借款
     */
    private double longTermBorrow;
    /**
     * 应付债券
     */
    private double shouldPayBond;
    /**
     * 长期应付款
     */
    private double longTermShouldPay;
    /**
     * 其他非流动负债
     */
    private double otherNonLiquidDebt;
    /**
     * 非流动负债总和
     */
    private double totalNonLiquidDebt;
    /**
     * 所属于的负债
     */
    @OneToOne(mappedBy="nonLiquidDebt")
    private Liability liability;
    
    public void initialTotalNum() {
        this.totalNonLiquidDebt = longTermBorrow + shouldPayBond
                + longTermShouldPay + otherNonLiquidDebt;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    public double getLongTermBorrow() {
        return longTermBorrow;
    }
    public void setLongTermBorrow(double longTermBorrow) {
        this.longTermBorrow = longTermBorrow;
    }
    public double getShouldPayBond() {
        return shouldPayBond;
    }
    public void setShouldPayBond(double shouldPayBond) {
        this.shouldPayBond = shouldPayBond;
    }
    public double getLongTermShouldPay() {
        return longTermShouldPay;
    }
    public void setLongTermShouldPay(double longTermShouldPay) {
        this.longTermShouldPay = longTermShouldPay;
    }
    public double getOtherNonLiquidDebt() {
        return otherNonLiquidDebt;
    }
    public void setOtherNonLiquidDebt(double otherNonLiquidDebt) {
        this.otherNonLiquidDebt = otherNonLiquidDebt;
    }
    public double getTotalNonLiquidDebt() {
        return totalNonLiquidDebt;
    }
    public void setTotalNonLiquidDebt(double totalNonLiquidDebt) {
        this.totalNonLiquidDebt = totalNonLiquidDebt;
    }

    @Override
    public String toString() {
        return "NonLiquidDebt [id=" + id + ", longTermBorrow=" + longTermBorrow + ", shouldPayBond=" + shouldPayBond
                + ", longTermShouldPay=" + longTermShouldPay + ", otherNonLiquidDebt=" + otherNonLiquidDebt
                + ", totalNonLiquidDebt=" + totalNonLiquidDebt + ", liability=" + liability + "]";
    }
  
    
    
}
