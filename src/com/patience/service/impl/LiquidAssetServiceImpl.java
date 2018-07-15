package com.patience.service.impl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.LiquidAssets;
import com.patience.service.LiquidAssetService;

/**
 * 流动资产
 * @author Administrator
 *
 */
@Service
@Transactional
public class LiquidAssetServiceImpl 
    extends DaoSupportImpl<LiquidAssets> implements LiquidAssetService{

}
