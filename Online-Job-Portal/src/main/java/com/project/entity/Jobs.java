package com.project.entity;

public class Jobs {
	
	private int id;
	private String title;
	private String decription;
	private String location;
	private String category;
	private String status;
	private String pdate; 
	
	
	
	public Jobs() {
		super();
	}
	
	
	public Jobs(String title, String decription, String location, String category, String status, String pdate) {
		super();
		this.title = title;
		this.decription = decription;
		this.location = location;
		this.category = category;
		this.status = status;
		this.pdate = pdate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

}
