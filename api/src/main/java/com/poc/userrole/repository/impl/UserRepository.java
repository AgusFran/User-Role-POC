package com.poc.userrole.repository.impl;

import org.springframework.stereotype.Repository;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.repository.GenericRepository;

@Repository
public interface UserRepository extends GenericRepository<Users, Integer> {

}
