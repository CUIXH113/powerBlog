package com.patience.service.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.Company;
import com.patience.service.CompanyService;

/**
 * 公司服务接口实现
 * @author Administrator
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class CompanyServiceImpl extends DaoSupportImpl<Company> implements CompanyService{

	@Override
	public Company getByCompanyName(String companyName) {
		Query query = getSession().createQuery(
				"FROM Company WHERE companyName =?");
		query.setParameter(0, companyName);
		Company company = (Company) query.uniqueResult();
		return company;
	}

}
