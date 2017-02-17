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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity @Table(name="AssessmentQuestion")
public class AssessmentQuestion {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int assessmentQuestionId;
	
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="CourseType")
	private CourseType CourseType;
	@OneToOne (cascade=CascadeType.ALL)  @JoinColumn(name="courseName")
	private CourseName courseName;
	private int questionNumber;
	private String questionTitle;
	private String questionHint;
	private int noOfOption;
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;
	private String optionFive;
	private String optionSix;
	private int correctAnswer;
	private String assessmentType;
	
	public int getAssessmentQuestionId() {
		return assessmentQuestionId;
	}
	public void setAssessmentQuestionId(int assessmentQuestionId) {
		this.assessmentQuestionId = assessmentQuestionId;
	}
	public CourseType getCourseType() {
		return CourseType;
	}
	public void setCourseType(CourseType courseType) {
		CourseType = courseType;
	}
	public CourseName getCourseName() {
		return courseName;
	}
	public void setCourseName(CourseName courseName) {
		this.courseName = courseName;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionHint() {
		return questionHint;
	}
	public void setQuestionHint(String questionHint) {
		this.questionHint = questionHint;
	}
	public int getNoOfOption() {
		return noOfOption;
	}
	public void setNoOfOption(int noOfOption) {
		this.noOfOption = noOfOption;
	}
	public String getOptionOne() {
		return optionOne;
	}
	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}
	public String getOptionTwo() {
		return optionTwo;
	}
	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}
	public String getOptionThree() {
		return optionThree;
	}
	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}
	public String getOptionFour() {
		return optionFour;
	}
	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}
	public String getOptionFive() {
		return optionFive;
	}
	public void setOptionFive(String optionFive) {
		this.optionFive = optionFive;
	}
	public String getOptionSix() {
		return optionSix;
	}
	public void setOptionSix(String optionSix) {
		this.optionSix = optionSix;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
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
