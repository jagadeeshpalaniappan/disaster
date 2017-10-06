package com.sundar.disastermanagement.vo;

import java.util.Date;

public class IncidentVO 
	{
	private long userId;
	private String name;
	private String mobile;
	private String description;
	private IncidentTypeVO incidentType;
	private LocationVO location;
	private String taluk;
	private String action;
	private boolean msgStatus;
	private Date date=new Date();
	private boolean f=false;
	
	public boolean isF() {
		return f;
	}
	public void setF(boolean f) {
		this.f = f;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public boolean isMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(boolean msgStatus) {
		this.msgStatus = msgStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
}
