package com.ir.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordForm {
	
	@NotEmpty @Size(min=6 , max=8 , message="wrong password")
	private String password;

	@NotEmpty @Size(min=6 , max=8 , message="wrong password")
	private String newPassword;
	private String oldPassword;
	private String confirmPwd;
	private String loginid;
	private String loginidd;
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	
	
	
	public String getLoginidd() {
		return loginidd;
	}

	public void setLoginidd(String loginidd) {
		this.loginidd = loginidd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
