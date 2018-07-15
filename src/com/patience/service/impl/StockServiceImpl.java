package com.patience.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.Stock;
import com.patience.service.StockService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class StockServiceImpl extends DaoSupportImpl<Stock> implements StockService{

  

}
