package com.patience.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 备忘录实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_checkSheet")
public class CheckSheet implements Serializable{
	
    private static final long serialVersionUID = -6963485049921785517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    /**
     * 文件名字
     */
    private String name;
    
    /**
     * 文件大小
     */
    private double fileSize;
    /**
     * 类别1.java;2.数据库；3.算法；4其他
     */
    private int classification;
    /**
     * 文件上传日期
     */
    private Date uploadTime;
    /**
     * 下载次数
     */
    private long downloadNum;
    /**
     * 是否可以下载
     */
    private boolean enableFlag; 
    /**
     * 
     * @param name
     * @param fileSize
     * @param classification
     */
    
    public CheckSheet(String name, double fileSize, int classification) {
    	this.name = name;
    	this.fileSize = fileSize;
    	this.classification = classification;
    }
    
    public CheckSheet() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public int getClassification() {
		return classification;
	}

	public void setClassification(int classification) {
		this.classification = classification;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public long getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(long downloadNum) {
		this.downloadNum = downloadNum;
	}

	public boolean isEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(boolean enableFlag) {
		this.enableFlag = enableFlag;
	}

	@Override
	public String toString() {
		return "CheckSheet [id=" + id + ", name=" + name + ", fileSize=" + fileSize + ", classification="
				+ classification + "]";
	}


	
}
