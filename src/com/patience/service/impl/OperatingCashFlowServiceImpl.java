package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.OperatingCashFlow;
import com.patience.service.OperatingCashFlowService;

@Service
@Transactional
public class OperatingCashFlowServiceImpl 
		extends DaoSupportImpl<OperatingCashFlow> implements OperatingCashFlowService{

}
