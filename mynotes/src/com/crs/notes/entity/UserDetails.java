package com.crs.notes.entity;

/**
 * user_details表的实体类
 * @author RS
 *
 */
public class UserDetails {
	private Integer userDetailsId;
	private String userNickName;
	private String userSex;
	private String userBirthday;
	private String userDesc;
	private Integer userId;
	
	
	public Integer getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 构造方法
	 */
	public UserDetails(Integer userDetailsId, String userNickName, String userSex, String userBirthday, String userDesc,
			Integer userId) {
		super();
		this.userDetailsId = userDetailsId;
		this.userNickName = userNickName;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userDesc = userDesc;
		this.userId = userId;
	}
	public UserDetails() {
		super();
	}
	
}
