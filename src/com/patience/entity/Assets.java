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
 * 资产
 * @author Administrator
 *
 */
@Entity
@Table(name="t_assets")
public class Assets implements Serializable{
    
    private static final long serialVersionUID = -6963485049921785517L;
    
    public Assets() {}
    
    public void initialTotalNum() {
        this.totalAssets = liquidAssets.getTotalLiquidAssets() + noLiquidAssets.getTotalAssets();
    }
    
    public Assets(LiquidAssets liquidAssets, NonLiquidAssets nonLiquidAssets, BalanceSheet balanceSheet) {
        this.liquidAssets = liquidAssets;
        this.noLiquidAssets = nonLiquidAssets;
        this.totalAssets = liquidAssets.getTotalLiquidAssets() + nonLiquidAssets.getTotalAssets();
        this.balancesheet = balanceSheet;
    }
    public BalanceSheet getBalancesheet() {
        return balancesheet;
    }

    public void setBalancesheet(BalanceSheet balancesheet) {
        this.balancesheet = balancesheet;
    }
    @OneToOne(mappedBy="assets")
    private BalanceSheet balancesheet;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 流动资产
     */
    @OneToOne
    @JoinColumn(name="liquidAssetsId")//主
    private LiquidAssets liquidAssets;
    
    /**
     * 非流动资产
     */
    @OneToOne
    @JoinColumn(name="nonLiquidAssetsId")
    private NonLiquidAssets noLiquidAssets;
    /**
     * 资产合计
     */
    private double totalAssets;
    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LiquidAssets getLiquidAssets() {
        return liquidAssets;
    }
    public void setLiquidAssets(LiquidAssets liquidAssets) {
        this.liquidAssets = liquidAssets;
    }
    public NonLiquidAssets getNoLiquidAssets() {
        return noLiquidAssets;
    }
    public void setNoLiquidAssets(NonLiquidAssets noLiquidAssets) {
        this.noLiquidAssets = noLiquidAssets;
    }
    public double getTotalAssets() {
        return totalAssets;
    }
    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    @Override
    public String toString() {
        return "Assets [id=" + id + ", liquidAssets=" + liquidAssets + ", noLiquidAssets=" + noLiquidAssets
                + ", totalAssets=" + totalAssets + "]";
    }
    
    
}
