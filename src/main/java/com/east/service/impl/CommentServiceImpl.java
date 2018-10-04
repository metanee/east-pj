package com.east.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.model.Comment;
import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;
import com.east.repository.CommentRepository;
import com.east.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public void CreateComment(Employee employee, Company company, User user, Comment comment) {
		comment.setCompany(company);
		comment.setUser(user);
		comment.setEmployee(employee);
		company.getCommentList().add(comment);
		user.getCommentList().add(comment);
		save(comment);
		
	
		
	}

	@Override
	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

}
