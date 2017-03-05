package com.ir.model;

import java.io.Serializable;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="coursename")
public class CourseName implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int coursenameid;
	private String coursename;
	@OneToOne (cascade=CascadeType.ALL)  
	@JoinColumn(name="coursetypeid")
	private CourseType courseTypeS;
	private String courseduration;
	private String status;
	private int createdby;
	private int updatedby;
	private String paidunpaid;
	private Date createddate;
	private String courseCode;
	private String online;
	private String classroom;
	private String modeOfTraining;
	@Column(columnDefinition="int default 0")
	private int seqNo;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;
	
	
	public int getCoursenameid() {
		return coursenameid;
	}
	public void setCoursenameid(int coursenameid) {
		this.coursenameid = coursenameid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	public String getCourseduration() {
		return courseduration;
	}
	public void setCourseduration(String courseduration) {
		this.courseduration = courseduration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public int getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}
	public String getPaidunpaid() {
		return paidunpaid;
	}
	public void setPaidunpaid(String paidunpaid) {
		this.paidunpaid = paidunpaid;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the modeOfTraining
	 */
	public String getModeOfTraining() {
		return modeOfTraining;
	}
	/**
	 * @param modeOfTraining the modeOfTraining to set
	 */
	public void setModeOfTraining(String modeOfTraining) {
		this.modeOfTraining = modeOfTraining;
	}
	/**
	 * @return the courseType
	 */
	public CourseType getCourseTypeS() {
		return courseTypeS;
	}
	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseTypeS(CourseType courseTypeS) {
		this.courseTypeS = courseTypeS;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
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
