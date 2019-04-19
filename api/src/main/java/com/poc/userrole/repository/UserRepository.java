package com.poc.userrole.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.poc.userrole.domain.Users;

@Repository
public interface UserRepository extends BaseRepository<Users, BigDecimal> {

}
