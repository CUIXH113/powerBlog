package com.patience.controller;

import com.patience.entity.Blog;
import com.patience.entity.User;
import com.patience.service.BlogService;
import com.patience.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * 博客控制层
 * @author mcl 2017-10-25
 *
 */
@Controller
@Transactional
@RequestMapping("/blog")
public class BlogController {



	@Resource
	private BlogService blogService;
	/**
	 * 用户服务
	 */
	@Resource
	private UserService userService;
	/**
	 * 获取spring默认的request
	 */
	
	@Resource
	private HttpServletRequest request;
	
	
	private static final String BLOG = "blog";
	private static final String BLOGS = "blogs";
	private static final String BLOG_ID = "blogId";
	private static final String UPLOAD_BLOG = "uploadBlog";
	private static final String LIST_BLOG = "listBlog";
	private static final String BLOG_FILE = "blogFile";
	private static final String BLOG_PATH = "WEB-INF/blogFile/"; 
	private static final String REDIRECT = "redirect:";
	private static final String LINE_FLAG = "/";
	
	private static final int ENABLE_FLAG_TRUE = 1;
	private static final int ENABLE_FLAG_FALSSE = 2;
	
	@RequestMapping("/uploadBlogUI/{userEmail}/{userPass}")
	public String uploadBlogUI(@PathVariable("userEmail") String userEmail,
			@PathVariable("userPass") String userPass) {
		System.err.println("userEmail=====;"+userEmail+";;;userPass===="+userPass);
		User user = userService.findByLoginEmailAndPassword(userEmail, userPass);
		//if (user != null) {//校验成功
			System.err.println("===============================kkkkkkkkkkkkkkkkkkkkkko");
			return new StringBuilder()
					.append(LINE_FLAG).append(BLOG)
					.append(LINE_FLAG).append(UPLOAD_BLOG)
					.toString();
		//}
//		return new StringBuilder()
//				.append(LINE_FLAG).append("error")
//				.append(LINE_FLAG).append("error")
//				.toString();
	}
	/**
	 * 上传博客文章
	 * @param blog
	 * @param blogFile
	 * @return
	 */
	@RequestMapping("/uploadBlog")
	public String uploadBlog(@ModelAttribute Blog blog,
			@RequestParam(BLOG_FILE) MultipartFile blogFile) {
	
		if (!blogFile.isEmpty()) {

			blog.setEnableFlag(true);
			blog.setUploadDate(new Date());
			blog.setViewCount(0L);
			int index = blogFile.getOriginalFilename().indexOf(".");
			blog.setBlogName(blogFile.getOriginalFilename().substring(0, index));
			blogService.save(blog);
			
			
			StringBuilder pathBuilder = new StringBuilder();
			pathBuilder.append(request.getSession().getServletContext()
					.getRealPath(LINE_FLAG));
			pathBuilder.append(BLOG_PATH).append(blog.getBlogType());
			pathBuilder.append(LINE_FLAG).append(BLOG).append(blog.getBlogId()).append(".jsp");
			try {
				blogFile.transferTo(new File(pathBuilder.toString()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		return new StringBuilder(REDIRECT)
				.append(LINE_FLAG).append(BLOG)
				.append(LINE_FLAG).append(LIST_BLOG).toString();
	}
	/**
	 * 显示所有bolg
	 * @return
	 */
	@RequestMapping("/listBlog")
	public ModelAndView listBlog() {
		List<Blog> list = blogService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(BLOGS, list);
		StringBuilder vBuilder = new StringBuilder();
		vBuilder.append(LINE_FLAG).append(BLOG)
				.append(LINE_FLAG).append(LIST_BLOG);
		modelAndView.setViewName(vBuilder.toString());
		return modelAndView;
	}
	/**
	 * 博客跳转
	 * @param blogId
	 * @return
	 */
	@RequestMapping("/viewForwardBlog/{blogId}")
	public String viewForwardBlog(@PathVariable(BLOG_ID) long blogId) {
	    long id = blogId;
	    long limit = id + 100;
	    Blog blog = null;
	    while (((blog = blogService.getById(id)) == null 
	            || blog.getEnableFlag() == false) && id < limit) {
	        id++;
	    }
	    //阅读次数加1
		long count = blog.getViewCount();
		count++;
	    blog.setViewCount(count);
	    blogService.update(blog);
	    
	    StringBuilder vBuilder = new StringBuilder();
	    vBuilder.append(LINE_FLAG).append(BLOG_FILE)
	        .append(LINE_FLAG).append(blog.getBlogType())
	        .append(LINE_FLAG).append(BLOG).append(id);
		
		return vBuilder.toString();
	}

	/**
	 * 根据id删除博客
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteBlog/{blogId}")
	public String deleteBlog(@PathVariable(BLOG_ID) long id) {
	    
	    blogService.delete(id);
	    return new StringBuilder().append(REDIRECT)
               .append(LINE_FLAG).append(BLOG)
               .append(LINE_FLAG).append(LIST_BLOG).toString();
	}
    
    /**
     * 更新blog的可用性 
     * @param id
     * @param enableFlag 1.true ； 2.false
     * @return
     */
    @RequestMapping("/updateEnableFlag/{blogId}/{enableFlag}")
    public String updateEnableFlag(@PathVariable(BLOG_ID) long id,
    		@PathVariable("enableFlag") int enableFlag) {
    	Blog blog = blogService.getById(id);
    	if (enableFlag == ENABLE_FLAG_TRUE) {
    		blog.setEnableFlag(true);    		
    	} else if (enableFlag == ENABLE_FLAG_FALSSE) {
    		blog.setEnableFlag(false);
    	}
    	blogService.update(blog);
	    return new StringBuilder().append(REDIRECT)
	               .append(LINE_FLAG).append(BLOG)
	               .append(LINE_FLAG).append(LIST_BLOG).toString();
    }
	
}
