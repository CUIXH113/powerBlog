package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.FinancialStatement;
import com.patience.service.FinancialStatementService;

/**
 * 财务报表服务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class FinancialStatementServiceImpl 
		extends DaoSupportImpl<FinancialStatement> implements FinancialStatementService{

}
