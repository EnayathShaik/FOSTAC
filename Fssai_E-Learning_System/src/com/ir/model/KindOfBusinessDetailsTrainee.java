package com.ir.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="kindOfBusinessDetailsTrainee")
public class KindOfBusinessDetailsTrainee {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="personalInformationTraineeId")
	@NotNull
	private int userid;
	
	@NotNull(message="Please select your kind of business type !")
	private int kindOfBusiness;
	@NotNull(message="Please enter your company name ! !")
	private String companyName;
	@NotNull(message="Please enter your designation !")
	private String designation;
	@NotNull
	private String bussAddressLine1;
	@NotNull
	private String bussAddressLine2;
	@NotNull
	private int bussState;
	@NotNull
	private int bussCity;
	
	@NotNull
	private String bussPincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getKindOfBusiness() {
		return kindOfBusiness;
	}
	public void setKindOfBusiness(int kindOfBusiness) {
		this.kindOfBusiness = kindOfBusiness;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBussAddressLine1() {
		return bussAddressLine1;
	}
	public void setBussAddressLine1(String bussAddressLine1) {
		this.bussAddressLine1 = bussAddressLine1;
	}
	public String getBussAddressLine2() {
		return bussAddressLine2;
	}
	public void setBussAddressLine2(String bussAddressLine2) {
		this.bussAddressLine2 = bussAddressLine2;
	}
	public int getBussState() {
		return bussState;
	}
	public void setBussState(int bussState) {
		this.bussState = bussState;
	}
	public int getBussCity() {
		return bussCity;
	}
	public void setBussCity(int bussCity) {
		this.bussCity = bussCity;
	}
	
	public String getBussPincode() {
		return bussPincode;
	}
	public void setBussPincode(String bussPincode) {
		this.bussPincode = bussPincode;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	
}
