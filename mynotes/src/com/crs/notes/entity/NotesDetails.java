package com.crs.notes.entity;

/**
 * notes_details表的具体类
 * @author RS
 *
 */
public class NotesDetails {
	private int notesDetailsId;
	private String notesTitle;
	private String notesDesc;
	private String publisherNickName;
	private int publisherId;
	private String addTime;
	private String lastTime;
	private String jurisdiction;
	private int notesLikes;
	private int notesGroupId;
	
	/**
	 * 对应的get和set方法
	 */
	public int getNotesDetailsId() {
		return notesDetailsId;
	}
	public void setNotesDetailsId(int notesDetailsId) {
		this.notesDetailsId = notesDetailsId;
	}
	public String getNotesTitle() {
		return notesTitle;
	}
	public void setNotesTitle(String notesTitle) {
		this.notesTitle = notesTitle;
	}
	public String getNotesDesc() {
		return notesDesc;
	}
	public void setNotesDesc(String notesDesc) {
		this.notesDesc = notesDesc;
	}
	public String getPublisherNickName() {
		return publisherNickName;
	}
	public void setPublisherName(String publisherNickName) {
		this.publisherNickName = publisherNickName;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
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
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public int getNotesLikes() {
		return notesLikes;
	}
	public void setNotesLikes(int notesLikes) {
		this.notesLikes = notesLikes;
	}
	public int getNotesGroupId() {
		return notesGroupId;
	}
	public void setNotesGroupId(int notesGroupId) {
		this.notesGroupId = notesGroupId;
	}
	
	/**
	 * 构造方法
	 */
	public NotesDetails(String notesTitle, String publisherNickName) {
		super();
		this.notesTitle = notesTitle;
		this.publisherNickName = publisherNickName;
	}	
	public NotesDetails(String publisherNickName, int publisherId) {
		super();
		this.publisherNickName = publisherNickName;
		this.publisherId = publisherId;
	}
	public NotesDetails(String notesTitle, String notesDesc, String publisherNickName, int publisherId, String addTime,
			String lastTime, String jurisdiction, int notesGroupId) {
		super();
		this.notesTitle = notesTitle;
		this.notesDesc = notesDesc;
		this.publisherNickName = publisherNickName;
		this.publisherId = publisherId;
		this.addTime = addTime;
		this.lastTime = lastTime;
		this.jurisdiction = jurisdiction;
		this.notesGroupId = notesGroupId;
	}
	public NotesDetails() {
		super();
	}	
}
