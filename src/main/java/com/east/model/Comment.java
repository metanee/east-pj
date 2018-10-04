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

@Entity
@Table(name = "comments")
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 9027834855L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;
	
	public Comment() {}
	
	public Comment (User user, Company company) {
		this.user = user;
		this.company = company;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	private String commentcription;

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	public String getCommentcription() {
		return commentcription;
	}

	public void setCommentcription(String commentcription) {
		this.commentcription = commentcription;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
 



}
