package com.ir.form;

public class RegionForm {

	private int districtId;
	private String regionName;
	private int stateId;
	private int cityId;
	private String status;
	

	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	@Override
	public String toString() {
		return "RegionForm [districtId=" + districtId + ", regionName=" + regionName + "]";
	}
	public RegionForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
