package com.crs.notes.entity;

/**
 * 账户信息(account表)的实体类
 * @author RS
 *
 */
public class Account {
	
	private Integer userId;
	private String userName;
	private String userPassword;
	private Integer identify;
	
	/**
	 * 对应的get和set方法
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getIdentify() {
		return identify;
	}
	public void setIdentify(Integer identify) {
		this.identify = identify;
	}
	
	/**
	 * 构造方法
	 */
	public Account(Integer userId, String userName, String userPassword, Integer identify) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.identify = identify;
	}
	public Account() {
		super();
	} 
			
}
