package com.sundar.disastermanagement.vo;

public class IncidentInchargeVO {
	private int inchargeID;
	private String name;
	private String mobile;
	private String email;
	private String designation;
	public int getInchargeID() {
		return inchargeID;
	}
	public void setInchargeID(int inchargeID) {
		this.inchargeID = inchargeID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
