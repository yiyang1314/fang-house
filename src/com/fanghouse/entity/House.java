package com.fanghouse.entity;

import java.io.Serializable;

public class House implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2807915489343241295L;
	private  Long houseid	;      //  房产编号                    
	private  String title	;      //  标题                        
	private  String picpath	;      // 图片路径                     
	private  String summary	;      //房产简介                      
	private  String contentUrl;   // 内容路径                     
	private  Long menuid	;      // 所属类型的编号  
	private  String houseStatus;  // 状态
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}
	public House(Long houseid, String title, String picpath, String summary, String contentUrl, Long menuid) {
		super();
		this.houseid = houseid;
		this.title = title;
		this.picpath = picpath;
		this.summary = summary;
		this.contentUrl = contentUrl;
		this.menuid = menuid;
	}
	
	
	public Long getHouseid() {
		return houseid;
	}
	public void setHouseid(Long houseid) {
		this.houseid = houseid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}

	public String getHouseStatus() {
		return houseStatus;
	}
	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}
	@Override
	public String toString() {
		return "House [houseid=" + houseid + ", title=" + title + ", picpath=" + picpath + ", summary=" + summary
				+ ", contentUrl=" + contentUrl + ", menuid=" + menuid + ", houseStatus=" + houseStatus + "]";
	}
	
	
}
