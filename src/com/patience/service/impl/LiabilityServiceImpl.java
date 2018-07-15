package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.Liability;
import com.patience.service.LiabilityService;

@Service
@Transactional
public class LiabilityServiceImpl extends DaoSupportImpl<Liability> implements LiabilityService{

}
