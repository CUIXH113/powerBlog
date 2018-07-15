package com.patience.entity;

import java.io.Serializable;
import java.security.acl.Owner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 所有者权益
 * @author Administrator
 *
 */
@Entity
@Table(name="t_ownerEquity")
public class OwnerEquity implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 实收资本
     */
    private double paidInCapita;
    /**
     * 资本公积
     */
    private double capitalReserves;
    /**
     * 盈余公积
     */
    private double surplusReserves;
    /**
     * 留存收益
     */
    private double retainedEarnings;
    /**
     * 所有者权益总和
     */
    private double totalOwnerEquity;
    /**
     * 所属于的负债
     */
    @OneToOne(mappedBy="ownerEquity")
    private Liability liability;
    
    public OwnerEquity(){}
    
    public void initialTotalNum() {
        this.totalOwnerEquity = paidInCapita + capitalReserves
                + surplusReserves + retainedEarnings;
    }
    
    public OwnerEquity(double paidincapita, double capitalreserves, 
            double surplusreserves,  double retainedearnings, Liability liability) {
        this.paidInCapita = paidincapita;
        this.capitalReserves = capitalreserves;
        this.surplusReserves = surplusreserves;
        this.retainedEarnings = retainedearnings;
        this.liability = liability;
        this.totalOwnerEquity = paidincapita + capitalreserves
                + surplusreserves + retainedearnings;
    }
    public Liability getLiability() {
        return liability;
    }

    public void setLiability(Liability liability) {
        this.liability = liability;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getPaidInCapita() {
        return paidInCapita;
    }
    public void setPaidInCapita(double paidInCapita) {
        this.paidInCapita = paidInCapita;
    }
    public double getCapitalReserves() {
        return capitalReserves;
    }
    public void setCapitalReserves(double capitalReserves) {
        this.capitalReserves = capitalReserves;
    }
    public double getSurplusReserves() {
        return surplusReserves;
    }
    public void setSurplusReserves(double surplusReserves) {
        this.surplusReserves = surplusReserves;
    }
    public double getRetainedEarnings() {
        return retainedEarnings;
    }
    public void setRetainedEarnings(double retainedEarnings) {
        this.retainedEarnings = retainedEarnings;
    }
    public double getTotalOwnerEquity() {
        return totalOwnerEquity;
    }
    public void setTotalOwnerEquity(double totalOwnerEquity) {
        this.totalOwnerEquity = totalOwnerEquity;
    }

    @Override
    public String toString() {
        return "OwnerEquity [id=" + id + ", paidInCapita=" + paidInCapita + ", capitalReserves=" + capitalReserves
                + ", surplusReserves=" + surplusReserves + ", retainedEarnings=" + retainedEarnings
                + ", totalOwnerEquity=" + totalOwnerEquity + ", liability=" + liability + "]";
    }
  
    
    
}
