package com.poc.userrole.repository;

import org.springframework.stereotype.Repository;

import com.poc.userrole.domain.Roles;

@Repository
public interface RoleRepository extends BaseRepository<Roles, Integer> {

}
