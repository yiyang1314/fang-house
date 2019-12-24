package com.fanghouse.entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1814436757223903562L;
	private  Long newid	;      // 新闻编号，主键               
	private  String title	;      // 新闻标题                     
	private  String contentUrl;   //: 新闻内容的路径              
	private  Date publishTime;  //： 发布时间                   
	private  Long menuid	;      // 新闻的分类，需要与菜单表关联 
	private  String summary	;      // 新闻简介                     
	private  String newStatus;    // 新闻状态  
	private  String picpath;
	public Long getNewid() {
		return newid;
	}
	public void setNewid(Long newid) {
		this.newid = newid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	@Override
	public String toString() {
		return "News [newid=" + newid + ", title=" + title + ", contentUrl=" + contentUrl + ", publishTime="
				+ publishTime + ", menuid=" + menuid + ", summary=" + summary + ", newStatus=" + newStatus
				+ ", picpath=" + picpath + "]";
	}
	
	
	
}
