package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.FinancingActivitiyCashFlow;
import com.patience.service.FinancingActivitiyCashFlowService;

/**
 * 融资活动现金流服务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class FinancingActivitiyCashFlowServcieImpl 
		extends DaoSupportImpl<FinancingActivitiyCashFlow> implements FinancingActivitiyCashFlowService{

}
