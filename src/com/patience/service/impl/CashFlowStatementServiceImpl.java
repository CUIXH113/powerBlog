package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.CashFlowStatement;
import com.patience.service.CashFlowStatementService;

@Service
@Transactional
public class CashFlowStatementServiceImpl 
	extends DaoSupportImpl<CashFlowStatement> implements CashFlowStatementService{

}
