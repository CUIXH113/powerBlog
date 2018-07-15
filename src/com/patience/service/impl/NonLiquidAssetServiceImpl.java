package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.NonLiquidAssets;
import com.patience.service.NonLiquidAssetService;

/**
 * 非流动资产
 * @author Administrator
 *
 */
@Service
@Transactional
public class NonLiquidAssetServiceImpl 
    extends DaoSupportImpl<NonLiquidAssets> implements NonLiquidAssetService{

}
