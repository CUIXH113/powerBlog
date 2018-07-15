package com.patience.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 股票
 * @author Administrator
 *
 */
@Entity
@Table(name="t_stock")
public class Stock implements Serializable{

    private static final long serialVersionUID = -6963485049921785517L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 股价list
     */
    @OneToMany(mappedBy="stock")
    private Collection<StockPrice> stockPriceList;
    /**
     * 上市时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date marketListingTime;
    /**
     * 股票发行量
     */
    private double totalStockNum;
    /**
     * 发行量单位：1.万，2.十万，3.百万，4.千万，5.亿
     */
    private int unit;
    /**
     * 1.美股；2.港股；3.沪；4.深；5.美1，；6.美2；
     */
    private int stockFlag;
    /**
     * 股票所属公司
     */
    @OneToOne(mappedBy="stock")
    private Company company;
    
    public Stock(String stockCode, Date marketListingTime, double totalStockNum,
    		int unit, int stockFlag) {
    	this.stockCode = stockCode;
    	this.marketListingTime = marketListingTime;
    	this.totalStockNum = totalStockNum;
    	this.unit = unit;
    	this.stockFlag = stockFlag;
    }
    
    public Stock() {}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getStockCode() {
        return stockCode;
    }
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Collection<StockPrice> getStockPriceList() {
        return stockPriceList;
    }
    public void setStockPriceList(Collection<StockPrice> stockPriceList) {
        this.stockPriceList = stockPriceList;
    }
  
    public Date getMarketListingTime() {
        return marketListingTime;
    }
    public void setMarketListingTime(Date marketListingTime) {
        this.marketListingTime = marketListingTime;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public double getTotalStockNum() {
        return totalStockNum;
    }
    public void setTotalStockNum(double totalStockNum) {
        this.totalStockNum = totalStockNum;
    }
    public int getStockFlag() {
        return stockFlag;
    }
    public void setStockFlag(int stockFlag) {
        this.stockFlag = stockFlag;
    }
  
    public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockCode=" + stockCode + ", stockPriceList=" + stockPriceList
				+ ", marketListingTime=" + marketListingTime + ", totalStockNum=" + totalStockNum + ", unit=" + unit
				+ ", stockFlag=" + stockFlag + ", company=" + company + "]";
	}
    
}
