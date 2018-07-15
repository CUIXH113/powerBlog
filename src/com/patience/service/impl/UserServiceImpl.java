package com.patience.service.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.User;
import com.patience.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService{

    @Override
    public User findByLoginEmailAndPassword(String user_eamil, String password) {
        // 使用密码的MD5摘要进行对比
       // String md5Digest = DigestUtils.md5Hex(password);
        Query query = getSession().createQuery(//
                "FROM User u WHERE u.userEmail = ? AND u.userPassword = ?");//
        query.setParameter(0, user_eamil)//
             .setParameter(1, password);//
        User user = (User)query.uniqueResult();
        return user;
    }

}
