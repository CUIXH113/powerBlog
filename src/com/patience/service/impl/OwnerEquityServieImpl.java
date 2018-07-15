package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.OwnerEquity;
import com.patience.service.OwnerEquityService;
/**
 * 所有者权益
 * @author Administrator
 *
 */
@Service
@Transactional
public class OwnerEquityServieImpl 
		extends DaoSupportImpl<OwnerEquity> implements OwnerEquityService{

}
