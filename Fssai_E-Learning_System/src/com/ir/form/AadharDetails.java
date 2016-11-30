package com.ir.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AadharDetails {
	
	@NotEmpty @Size(min=12 , max=12 , message="error")
	private String aadharNumber;
	@NotEmpty @Size(min=1 , max=50 , message="error")
	private String name;
	@NotEmpty @Size(min=10 , max=10 , message="error")
	private String dob;
	private String gender;
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
