package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.NonLiquidDebt;
import com.patience.service.NonLiquidDebtService;

/**
 * 非流动债务服务接口
 * @author Administrator
 *
 */
@Service
@Transactional
public class NonLiquidDebtServiceImpl 
		extends DaoSupportImpl<NonLiquidDebt> implements NonLiquidDebtService{

}
