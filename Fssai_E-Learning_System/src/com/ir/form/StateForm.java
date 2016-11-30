package com.ir.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class StateForm {
	
	@NotNull
	private int stateId;
	@NotEmpty
	@Size(min=1 , max = 100, message="Please enter state name")
	private String stateName;
	@NotNull
	private String status;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StateForm [stateId=" + stateId + ", stateName=" + stateName + ", status=" + status + "]";
	}
	
	
	

}
