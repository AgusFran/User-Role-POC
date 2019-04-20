package com.poc.userrole.repository.impl;

import org.springframework.stereotype.Repository;

import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.repository.GenericRepository;

@Repository
public interface RoleRepository extends GenericRepository<Roles, Integer> {

}
