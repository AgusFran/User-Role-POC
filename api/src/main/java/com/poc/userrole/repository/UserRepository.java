package com.poc.userrole.repository;

import com.poc.userrole.domain.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<Users, Integer> {

    Users findByUsername(String username);

}
