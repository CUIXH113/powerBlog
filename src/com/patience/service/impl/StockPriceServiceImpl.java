package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.StockPrice;
import com.patience.service.StockPriceService;
/**
 * 估价服务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class StockPriceServiceImpl 
	extends DaoSupportImpl<StockPrice> 	implements StockPriceService{

}
