package com.hibernate.mapping.student;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name = "student_course", 
				joinColumns = { @JoinColumn(name = "student_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "course_id") 
	})
	private Set<Course> courses;
	
	public Student() {
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}
	
}