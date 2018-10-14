package com.east.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.east.model.User;

public interface UserPagingRepository extends PagingAndSortingRepository<User, Long> {

}
