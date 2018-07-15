package com.patience.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;
import com.patience.entity.Blog;
import com.patience.entity.User;
import com.patience.service.BlogService;
import com.patience.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.swing.internal.plaf.basic.resources.basic;



@Controller
@Transactional
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @Resource
    private BlogService blogService;
    
    @ModelAttribute("user")
    public User getUser() {
        User user = new User();
        user.setUserName("1001");
        return user;
    }
    
    @ResponseBody
    @RequestMapping(value="/testJson", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<User> testJson() {
        System.err.println("testJson.........come in");
        List<User> list = new ArrayList<>();
        User user = userService.getById(1L);
        list.add(user);
        return list;
    }
    
    @RequestMapping("/test")
    public String testhtml() {
        System.err.println("testhtml()................");
        return "/test/test";
    }
    /**
     * 登录接口
     * @param user_email
     * @param passWord
     * @return
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView login(@RequestParam(value="user_email", required = true) String user_email,
            @RequestParam(value="password", required=true) String passWord) {
        System.out.println("user_eamil:"+user_email+"   password:"+passWord);
        User loginUser = userService.findByLoginEmailAndPassword(user_email, passWord);
        ModelAndView mav = new ModelAndView();
        if (loginUser == null) {
            System.out.println("loginuser is Null ");
            mav.setViewName("/error/error");
            mav.addObject("error", "登录失败");
        } else {
        	List<Blog> blogs = blogService.findAll();
        	if (blogs == null || blogs.isEmpty()) {
        		mav.addObject("blogs", new ArrayList<Blog>());
        	} else {
        		mav.addObject("blogs", blogs);
        	}
            mav.setViewName("/admin/dashboard");
            mav.addObject("user", loginUser);
            System.out.println("login user is exist :"+loginUser.getUserEmail());
        }
        return mav;
    }
    /**
     * 注册接口
     * @param user
     * @return
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String resigter(@ModelAttribute User user) {
        String viewString = null;
        if ( user == null ) {
            viewString = "/user/register";
        }
        else {
            //存入数据库
            user.setCreateTime(new Date());
            userService.save(user);
            viewString = "/user/login";
        }
        return viewString;
    }
   /**
    * 显示注册页面
    * @return
    */
    @RequestMapping("/registerUI")
    public String registerUI() {
        String viewName = "/user/register";
        return viewName;
    }
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/loginUI")
    public String loginUI() {
        String viewName = "/user/login";
        return viewName;
    }
}
