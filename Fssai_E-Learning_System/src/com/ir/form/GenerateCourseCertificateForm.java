package com.ir.form;

public class GenerateCourseCertificateForm {
	
	private int courseType;
	private int courseName ;
	private String batchCode;
	private String certificateId;
	private String mainCertificateId;
	

	
	public int getCourseType() {
		return courseType;
	}
	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
		this.courseName = courseName;
	}
	
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	public String getMainCertificateId() {
		return mainCertificateId;
	}
	public void setMainCertificateId(String mainCertificateId) {
		this.mainCertificateId = mainCertificateId;
	}
	
	
	

}
