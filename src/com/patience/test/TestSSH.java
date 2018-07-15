package com.patience.test;



import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.patience.entity.Company;
import com.patience.entity.Stock;
import com.patience.entity.User;
/**
 * SSH测试类
 * @author mcl
 *
 */
public class TestSSH {
    
    private ApplicationContext ctx = null;

    @Test
    public void testNew() {

    }
    @Test
    public void testDataSource() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=======================>"+ctx);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("|||||||||||||||||||||||"+dataSource.toString());
        try {
            System.out.println("------------------"+dataSource.getConnection().toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
        System.out.println("sessionFactory:"+sessionFactory);
        
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        User user = new User("123", "张三", "powermcl@163.com", "18231193328",  new Date(), "男");
        session.save(user);
        
//        Company company = new Company();
//        company.setCompanyName("阿里巴巴");
//        Stock stock = new Stock();
//        stock.setMarketListingTime(new Date().getTime());
//        stock.setStockCode("alibaba");
//        stock.setStockFlag(1);
//        
//        company.setStock(stock);
//        stock.setCompany(company);
//        session.save(company);
//        session.save(stock);
        
        tx.commit();
        session.close();
        
    }
}
