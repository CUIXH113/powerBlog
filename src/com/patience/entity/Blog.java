package com.patience.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 博客
 * @author mcl 2017-10-25
 */
@Entity
@Table(name = "t_blog")
public class Blog implements Serializable{
	
	private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long blogId;
    /**
     * 博客名字
     */
    private String blogName;
    /**
     * 浏览次数
     */
    private long viewCount;
    /**
     * 上传日期
     */
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date uploadDate;
    /**
     * 博客类别：1.技术。2.随笔。3.4.5.6.7.8，9.10
     */
    private int blogType;
    /**
     * 是否可显示
     */
    private boolean enableFlag;
    
    public Blog() {}
    public Blog(String blogName, int blogType, Date uploadDate, boolean enableFlag) {
    	this.blogName = blogName;
    	this.blogType = blogType;
    	this.uploadDate = uploadDate;
    	this.enableFlag = enableFlag;
    }
    
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public long getViewCount() {
		return viewCount;
	}
	public void setViewCount(long viewCount) {
		this.viewCount = viewCount;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public int getBlogType() {
		return blogType;
	}
	public void setBlogType(int blogType) {
		this.blogType = blogType;
	}
	
	public boolean getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(boolean enableFlag) {
		this.enableFlag = enableFlag;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName + ", viewCount=" + viewCount + ", uploadDate="
				+ uploadDate + ", blogType=" + blogType + ", enableFlag=" + enableFlag + "]";
	}
}
