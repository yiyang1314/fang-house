package com.fanghouse.entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3679677320711541563L;
	private  Long userid;		//用户ID
	private  String loginname;	//用户名
	private  String loginpwd;	//密码
	private  String realname;	//真实姓名
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userid, String loginname, String loginpwd, String realname) {
		super();
		this.userid = userid;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.realname = realname;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", loginname=" + loginname + ", loginpwd=" + loginpwd + ", realname="
				+ realname + "]";
	}
	
	
	
}
