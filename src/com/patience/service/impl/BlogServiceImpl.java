package com.patience.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patience.base.DaoSupportImpl;
import com.patience.entity.Blog;
import com.patience.service.BlogService;

/**
 * 博客服务层
 * @author mcl 2017-10-25
 *
 */
@Service
@Transactional
public class BlogServiceImpl extends DaoSupportImpl<Blog> implements BlogService{

}
