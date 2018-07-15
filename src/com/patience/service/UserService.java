package com.patience.service;

import com.patience.base.DaoSupport;
import com.patience.entity.User;

public interface UserService extends DaoSupport<User>{

    /**
     * 根据登录名与密码查询用户
     * 
     * @param loginName
     * @param password
     *            明文密码
     * @return
     */
    User findByLoginEmailAndPassword(String loginName, String password);
 
}
