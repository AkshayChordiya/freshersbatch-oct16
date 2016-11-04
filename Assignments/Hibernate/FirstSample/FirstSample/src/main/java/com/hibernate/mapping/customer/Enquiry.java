package com.hibernate.mapping.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry")
public class Enquiry {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="issue")
	private String issue;
	
	public Enquiry() {
	}

	public Enquiry(String issue) {
		super();
		this.issue = issue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	@Override
	public String toString() {
		return "Enquiry [id=" + id + ", issue=" + issue + "]";
	}
	
}
