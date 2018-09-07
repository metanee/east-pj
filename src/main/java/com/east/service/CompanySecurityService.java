package com.east.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.east.model.Company;
import com.east.repository.CompanyRepository;

@Service
public class CompanySecurityService implements UserDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Company company = companyRepository.findByUsername(username);
		if(null == company) {
			LOG.warn("Username {} not found", username);
			throw new UsernameNotFoundException("Username"+username+"not found");
		}
		return company;
	}
	}

