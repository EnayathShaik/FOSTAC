package com.ir.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AssessmentQuestionForm {
	
	private int id;
	@NotNull
	private int courseTypeId;
	@NotNull
	private int courseName;
	@NotNull
	private int questionNumber;
	@NotNull @Size(min=0 , max = 500 , message="Please enter question")
	private String questionTitle;
	@NotNull @Size(min=0 , max = 500 , message="Please enter question hint")
	private String questionHint;
	@NotNull
	private int noOfOption;
	@NotNull @Size(min=1 , max = 100 , message="Please enter option One")
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;
	private String optionFive;
	private String optionSix;
	@NotNull
	private int correctAnswer;
	private int courseNameSearch;
	private int courseTypeSearch;
	
	
	public int getCourseNameSearch() {
		return courseNameSearch;
	}
	public void setCourseNameSearch(int courseNameSearch) {
		this.courseNameSearch = courseNameSearch;
	}
	public int getCourseTypeSearch() {
		return courseTypeSearch;
	}
	public void setCourseTypeSearch(int courseTypeSearch) {
		this.courseTypeSearch = courseTypeSearch;
	}
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public int getCourseName() {
		return courseName;
	}
	public void setCourseName(int courseName) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
