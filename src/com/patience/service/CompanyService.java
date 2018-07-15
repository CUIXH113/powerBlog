package com.patience.service;

import com.patience.base.DaoSupport;
import com.patience.entity.Company;

/**
 * 公司服务接口
 * @author Administrator
 *
 */
public interface CompanyService extends DaoSupport<Company>{

	Company getByCompanyName(String companyName);
}
