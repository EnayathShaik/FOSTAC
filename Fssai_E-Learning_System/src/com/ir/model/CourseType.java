package com.ir.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courseType")
public class CourseType {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int CourseTypeId;
	private String CourseType;
	public int getCourseTypeId() {
		return CourseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		CourseTypeId = courseTypeId;
	}
	public String getCourseType() {
		return CourseType;
	}
	public void setCourseType(String courseType) {
		CourseType = courseType;
	}
	
	
}
