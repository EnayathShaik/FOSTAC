package com.ir.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePassword {
	
	@NotEmpty @Size(min=7 , max=8 , message="wrong password")
	private String oldPassword;

	@NotEmpty @Size(min=7 , max=8 , message="wrong password")
	private String newPassword;
	
	private String loginid;

	private String confirmPwd;


	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	

}
