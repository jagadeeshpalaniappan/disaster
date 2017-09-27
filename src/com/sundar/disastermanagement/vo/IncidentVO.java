package com.sundar.disastermanagement.vo;


public class IncidentVO 
	{
	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String description;
	private IncidentTypeVO incidentType;
	private LocationVO location;
	private String Status;
	private boolean f=false;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public boolean isF() {
		return f;
	}
	public void setF(boolean f) {
		this.f = f;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IncidentTypeVO getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(IncidentTypeVO incidentType) {
		this.incidentType = incidentType;
	}
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
}
