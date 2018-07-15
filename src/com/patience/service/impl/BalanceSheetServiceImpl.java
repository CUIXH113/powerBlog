package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.BalanceSheet;
import com.patience.service.BalanceSheetService;

/**
 * 资产负债表服务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
public class BalanceSheetServiceImpl 
		extends DaoSupportImpl<BalanceSheet> implements BalanceSheetService{

}
