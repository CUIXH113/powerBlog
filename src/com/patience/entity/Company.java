package com.patience.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_company")
public class Company implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6963485049921785517L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * 公司名字
     */
    private String companyName;
    /**
     * CEO
     */
    @OneToOne
    @JoinColumn(name="ceoId")
    private CEO ceo;

    /**
     * 公司股票
     */
    
    @OneToOne
    @JoinColumn(name="stockId")
    private Stock stock;
    /**
     * 财务报表ids
     */
    @OneToMany(mappedBy="company")
    private Collection<FinancialStatement> financialStatements;
    
    public Company() {
    }
    
    public  Company(String name, Stock stock, Collection<FinancialStatement> financialStatements) {
        this.companyName = name;
        this.stock = stock;
        this.financialStatements = financialStatements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Collection<FinancialStatement> getFinancialStatements() {
        return financialStatements;
    }

    public void setFinancialStatements(Collection<FinancialStatement> financialStatements) {
        this.financialStatements = financialStatements;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", companyName=" + companyName + ", ceo=" + ceo + ", stock=" + stock
                + ", financialStatements=" + financialStatements + "]";
    }  
}