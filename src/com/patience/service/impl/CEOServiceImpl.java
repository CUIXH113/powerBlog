package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.CEO;
import com.patience.service.CEOService;

/**
 * CEO 服务层接口实现
 * @author Administrator
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class CEOServiceImpl extends DaoSupportImpl<CEO> implements CEOService{

	
}
