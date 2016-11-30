package com.ir.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DistrictForm {
	
	@NotNull
	private int districtId;
	@NotNull @Size(min=1 , max=100 , message="* error")
	private String DistrictName;
	@NotNull
	private int stateId;
	@NotNull
	private String status;
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return DistrictName;
	}
	public void setDistrictName(String districtName) {
		DistrictName = districtName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "DistrictForm [districtId=" + districtId + ", DistrictName=" + DistrictName + ", stateId=" + stateId
				+ ", status=" + status + "]";
	}
	public DistrictForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
