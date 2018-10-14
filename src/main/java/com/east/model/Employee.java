package com.east.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 9027834625L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	
	public Employee() {}
	
	public Employee (User user, Company company) {
		this.user = user;
		this.company = company;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne(mappedBy = "employee", cascade=CascadeType.ALL)
	@JsonIgnore
	private Comment comment;
	
	private String firstNameEmployee;
	private String lastNameEmployee;
	private String genderEmployee;
	private String jobposition;
	private String sarary;
	private boolean invice = false;
	private String inviceDate;
	private String startJobDate;
	private String endJobDate;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

	public String getFirstNameEmployee() {
		return firstNameEmployee;
	}

	public void setFirstNameEmployee(String firstNameEmployee) {
		this.firstNameEmployee = firstNameEmployee;
	}

	public String getLastNameEmployee() {
		return lastNameEmployee;
	}

	public void setLastNameEmployee(String lastNameEmployee) {
		this.lastNameEmployee = lastNameEmployee;
	}

	public String getGenderEmployee() {
		return genderEmployee;
	}

	public void setGenderEmployee(String genderEmployee) {
		this.genderEmployee = genderEmployee;
	}

	public String getSarary() {
		return sarary;
	}


	public boolean isInvice() {
		return invice;
	}

	public void setInvice(boolean invice) {
		this.invice = invice;
	}

	public void setSarary(String sarary) {
		this.sarary = sarary;
	}

	public String getInviceDate() {
		return inviceDate;
	}

	public void setInviceDate(String inviceDate) {
		this.inviceDate = inviceDate;
	}

	public String getStartJobDate() {
		return startJobDate;
	}

	public void setStartJobDate(String startJobDate) {
		this.startJobDate = startJobDate;
	}

	public String getEndJobDate() {
		return endJobDate;
	}

	public void setEndJobDate(String endJobDate) {
		this.endJobDate = endJobDate;
	}

	public String getJobposition() {
		return jobposition;
	}

	public void setJobposition(String jobposition) {
		this.jobposition = jobposition;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
	
	
	
	
}
