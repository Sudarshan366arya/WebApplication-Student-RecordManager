package com.student.record.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "public")
public class Student implements java.io.Serializable {
	private int roll;
	private String name;
	private String batch;
	private String contact_no;
	
	public Student() {
	}

	public Student(int roll) {
		this.roll=roll;
	}

	public Student(int roll, String name, String batch, String contact_no) {
		this.roll= roll;
		this.name = name;
		this.batch = batch;
		this.contact_no = contact_no;
	}

	
	@Id
	@Column(name = "roll", unique = true, nullable = false)
	public int getRoll() {
		return this.roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "batch", length = 4)
	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch=batch;
	}

	@Column(name = "contact_no", length = 10)
	public String getContact_No() {
		return this.contact_no;
	}

	public void setContact_No(String contact_no) {
		this.contact_no = contact_no;
	}
}
