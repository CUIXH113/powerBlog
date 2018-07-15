package com.patience.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 非流动资产
 * @author Administrator
 *
 */
@Entity
@Table(name="t_nonLiquidAssets")
public class NonLiquidAssets implements Serializable{
    private static final long serialVersionUID = -6963485049921785517L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 长期投资
     */
    private double longTermInvestment;
    /**
     * 固定资产
     */
    private double solidAssets;
    /**
     * 无形资产及其他非流动资产
     */
    private double otherAssets;
    /**
     * 非流动资产合计
     */
    private double totalAssets;
    /**
     * 所属于的资产
     */
    @OneToOne(mappedBy="noLiquidAssets")
    private Assets assets;
    
//    public void initialTotalNum() {
//        this.totalAssets = longTermInvestment + solidAssets + otherAssets;
//    }
    
    public NonLiquidAssets() {}
    /**
     * 非流动资产
     * @param longterminvest ： 长期投资
     * @param solidassets ： 固定资产
     * @param otherassets ： 无形资产及其他非流动资产
     */
    public NonLiquidAssets(double longterminvest, 
            double solidassets, double otherassets) {
        this.longTermInvestment = longterminvest;
        this.solidAssets = solidassets;
        this.otherAssets = otherassets;
        this.totalAssets = longterminvest + solidassets + otherassets;
    }
    
    public void initialTotalNum() {
        
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getLongTermInvestment() {
        return longTermInvestment;
    }
    public void setLongTermInvestment(double longTermInvestment) {
        this.longTermInvestment = longTermInvestment;
    }
    public double getSolidAssets() {
        return solidAssets;
    }
    public void setSolidAssets(double solidAssets) {
        this.solidAssets = solidAssets;
    }
    public double getOtherAssets() {
        return otherAssets;
    }
    public void setOtherAssets(double otherAssets) {
        this.otherAssets = otherAssets;
    }
    public double getTotalAssets() {
        return totalAssets;
    }
    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }
    @Override
    public String toString() {
        return "NonLiquidAssets [id=" + id + ", longTermInvestment=" + longTermInvestment + ", solidAssets="
                + solidAssets + ", otherAssets=" + otherAssets + ", totalAssets=" + totalAssets + "]";
    }
    
    
    
}
