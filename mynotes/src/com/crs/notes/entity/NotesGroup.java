package com.crs.notes.entity;

/**
 * news_group表的具体类
 * @author RS
 *
 */
public class NotesGroup {
	private int notesGroupId;
	private String groupName;
	private String addTime;
	private String lastTime;
	private int adminId;
	
	/**
	 * 构造方法
	 */
	public int getNotesGroupId() {
		return notesGroupId;
	}
	public void setNotesGroupId(int notesGroupId) {
		this.notesGroupId = notesGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	@Override
		public String toString() {
			return groupName;
		}
	public NotesGroup(String groupName, String addTime, String lastTime, int adminId) {
		super();
		this.groupName = groupName;
		this.addTime = addTime;
		this.lastTime = lastTime;
		this.adminId = adminId;
	}
	public NotesGroup() {
		super();
	}
}
