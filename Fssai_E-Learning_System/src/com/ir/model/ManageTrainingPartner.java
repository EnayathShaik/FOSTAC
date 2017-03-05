package com.ir.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity @Table(name="manageTrainingPartner")
public class ManageTrainingPartner {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int manageTrainingPartnerId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String userId;
	
	@NotNull
	private String PAN;
	@NotNull
	private String trainingPartnerName;
	@NotNull
	private String websiteUrl;
	@NotNull
	private String headOfficeDataAddress1;
	@NotNull
	private String headOfficeDataAddress2;
	@NotNull
	private String pin;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="district")
	private District district;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="city")
	private City city;
	private String email;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="state")
	private State state;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="loginDetails")
	private LoginDetails loginDetails;
	public int getManageTrainingPartnerId() {
		return manageTrainingPartnerId;
	}
	public void setManageTrainingPartnerId(int manageTrainingPartnerId) {
		this.manageTrainingPartnerId = manageTrainingPartnerId;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getTrainingPartnerName() {
		return trainingPartnerName;
	}
	public void setTrainingPartnerName(String trainingPartnerName) {
		this.trainingPartnerName = trainingPartnerName;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getHeadOfficeDataAddress1() {
		return headOfficeDataAddress1;
	}
	public void setHeadOfficeDataAddress1(String headOfficeDataAddress1) {
		this.headOfficeDataAddress1 = headOfficeDataAddress1;
	}
	public String getHeadOfficeDataAddress2() {
		return headOfficeDataAddress2;
	}
	public void setHeadOfficeDataAddress2(String headOfficeDataAddress2) {
		this.headOfficeDataAddress2 = headOfficeDataAddress2;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
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
