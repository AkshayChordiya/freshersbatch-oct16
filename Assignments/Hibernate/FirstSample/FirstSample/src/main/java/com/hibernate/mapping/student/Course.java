package com.hibernate.mapping.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="name")
	private String name;
	
	public Course() {
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + "]";
	}
	
}
