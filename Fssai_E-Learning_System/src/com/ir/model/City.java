package com.ir.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="city")
public class City {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int cityId;
	@NotEmpty(message="Please select city")
	private String cityName;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="districtId")
	private District districtId;
	@NotEmpty(message="Please select status")
	private String status;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public District getDistrictId() {
		return districtId;
	}
	public void setDistrictId(District districtId) {
		this.districtId = districtId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
