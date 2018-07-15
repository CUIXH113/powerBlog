package com.patience.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 某一时刻的股价
 * @author Administrator
 *
 */
@Entity
@Table(name="t_stockPrice")
public class StockPrice implements Serializable{
    
    private static final long serialVersionUID = -6963485049921785517L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 当时的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date markDate;
    /**
     * 当时的股价
     */
    private double price;
    public Stock getStock() {
        return stock;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    /**
     * 对应的股票
     */
    @ManyToOne
    @JoinColumn(name="stockId")
    private Stock stock;
    
    public StockPrice() {
        // TODO Auto-generated constructor stub
    }
    public StockPrice(Date date, double price) {
        this.markDate = date;
        this.price = price;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getMarkDate() {
        return markDate;
    }
    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "StockPrice [id=" + id + ", markDate=" + markDate + ", price=" + price + "]";
    }
    
    

}
