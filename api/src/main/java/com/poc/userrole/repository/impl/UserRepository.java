package com.poc.userrole.repository.impl;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.repository.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<Users, Integer> {

    Users findByUsername(String username);

}
