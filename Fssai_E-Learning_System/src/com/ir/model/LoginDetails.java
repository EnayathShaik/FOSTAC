package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="loginDetails")
public class LoginDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	

	@NotNull
	private String loginId;
	@NotNull
	private String Password;
	private String Encrypted_Password;
	
	public String getEncrypted_Password() {
		return Encrypted_Password;
	}
	public void setEncrypted_Password(String encrypted_Password) {
		Encrypted_Password = encrypted_Password;
	}
	@NotNull
	private int profileId;
	
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoginDetailsUnique() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
