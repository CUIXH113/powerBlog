package com.patience.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.CheckSheet;
import com.patience.service.CheckSheetService;

/**
 * 备忘录服务层实现类
 * @author Administrator
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class CheckSheetServiceImpl 
	extends DaoSupportImpl<CheckSheet> implements CheckSheetService{
	
    
    
    @Override
	public List<CheckSheet> listCheckSheetByEnableAndStyle(int fileStyle, boolean enable) {
		String sql = "from CheckSheet c where c.fileStyle = ? and c.enableFlag = ?";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, fileStyle);
		query.setParameter(1, enable);
		return query.list();
	}
	
	@Override
	public List<CheckSheet> listCheckSheetByStyle(int fileStyle) {
		String sql = "from CheckSheet c where c.fileStyle = ?";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, fileStyle);
		return query.list();
	}
	
	@Override
	public List<CheckSheet> findEnableCheckSheet(boolean enable) {
		String sql = "from CheckSheet c where c.enableFlag = ?";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, enable);
		List<CheckSheet> list = query.list();
		return list;
	}


}
