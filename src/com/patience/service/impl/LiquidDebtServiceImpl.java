package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.LiquidDebt;
import com.patience.service.LiquidDebtService;
/**
 * 流动负债服务接口
 * @author Administrator
 *
 */
@Service
@Transactional
public class LiquidDebtServiceImpl 
		extends DaoSupportImpl<LiquidDebt> implements LiquidDebtService{

}
