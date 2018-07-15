package com.patience.service;

import java.util.List;

import com.patience.base.DaoSupport;
import com.patience.entity.CheckSheet;

public interface CheckSheetService extends DaoSupport<CheckSheet>{

   
	/**
	 * 通过可用性和备忘录类型查找
	 * @return
	 */
	List<CheckSheet> listCheckSheetByEnableAndStyle(int fileStyle, boolean enable);
	/**
	 * 按文件类型查找备忘录
	 * @param fileStyle
	 * @return
	 */
	List<CheckSheet> listCheckSheetByStyle(int fileStyle);
	/**
	 * 查找有效或无效的备忘录
	 * @param enable
	 * @return
	 */
	List<CheckSheet> findEnableCheckSheet(boolean enable);
}
