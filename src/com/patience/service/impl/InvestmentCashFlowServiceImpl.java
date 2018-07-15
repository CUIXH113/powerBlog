package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.InvestmentCashFlow;
import com.patience.service.InvestmentCashFlowService;

@Service
@Transactional
public class InvestmentCashFlowServiceImpl 
		extends DaoSupportImpl<InvestmentCashFlow> implements InvestmentCashFlowService{

}
