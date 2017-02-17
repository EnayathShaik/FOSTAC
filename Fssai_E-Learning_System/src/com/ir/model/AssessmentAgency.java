package com.ir.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="assessmentAgency")
public class AssessmentAgency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name= "aaId")
	private int aaId;
	private String aaName;
	private int aaRating;
	private Date createdDate;
	private int createdBy;
	public AssessmentAgency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAaId() {
		return aaId;
	}
	public void setAaId(int aaId) {
		this.aaId = aaId;
	}
	public String getAaName() {
		return aaName;
	}
	public void setAaName(String aaName) {
		this.aaName = aaName;
	}
	public int getAaRating() {
		return aaRating;
	}
	public void setAaRating(int aaRating) {
		this.aaRating = aaRating;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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
