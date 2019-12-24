package com.fanghouse.entity;

import java.io.Serializable;


public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7319259926236649575L;
	private  Long menuid	;      //  菜单编号，主键              
	private  String menuName;      // 菜单名字                     
	private  Long parentid;      // 父菜单的编号                 
	private  String picpath	;      // 菜单的图片路径               
	private  String menuStatus;    //菜单状态   
	private  String menuUrl;       //菜单图片地址
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getMenuName() {
		return menuName;
	}
	
	
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setParentid(long l) {
		this.parentid = l;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	public Menu(Long menuid, String menuName, Long parentid, String picpath, String menuStatus) {
		super();
		this.menuid = menuid;
		this.menuName = menuName;
		this.parentid = parentid;
		this.picpath = picpath;
		this.menuStatus = menuStatus;
	}

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", menuName=" + menuName + ", parentid=" + parentid + ", picpath=" + picpath
				+ ", menuStatus=" + menuStatus + ", menuUrl=" + menuUrl + "]";
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
	
}
