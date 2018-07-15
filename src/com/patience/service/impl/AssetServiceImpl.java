package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.Assets;
import com.patience.service.AssetService;

@Service
@Transactional
public class AssetServiceImpl extends DaoSupportImpl<Assets> implements AssetService{

}
