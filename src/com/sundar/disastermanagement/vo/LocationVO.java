package com.sundar.disastermanagement.vo;

public class LocationVO {
	private int locationID;
	private String villageName;
	private String villageTamilName;
	private int talukId;
	private int districtId;
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getVillageTamilName() {
		return villageTamilName;
	}
	public void setVillageTamilName(String villageTamilName) {
		this.villageTamilName = villageTamilName;
	}
	public int getTalukId() {
		return talukId;
	}
	public void setTalukId(int talukId) {
		this.talukId = talukId;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
}