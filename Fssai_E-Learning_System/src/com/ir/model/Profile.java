package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int profileId;
	private String profileName;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileName=" + profileName + "]";
	}
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
