package com.east.service;

import com.east.model.Comment;
import com.east.model.Company;
import com.east.model.Employee;
import com.east.model.User;

public interface CommentService {
	
	void CreateComment (Employee employee, Company company, User use, Comment comment);
	Comment save(Comment comment);
}
