package com.east.repository;

import org.springframework.data.repository.CrudRepository;

import com.east.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
