package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.ProfitStatement;
import com.patience.service.ProfitStatementService;

@Service
@Transactional
public class ProfitStatementServiceImpl 
		extends DaoSupportImpl<ProfitStatement> implements ProfitStatementService{

}
