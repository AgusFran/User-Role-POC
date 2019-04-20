package com.poc.userrole.service.impl;

import org.springframework.stereotype.Service;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.service.GenericCrudService;

@Service
public class UserService extends GenericCrudService<UserDTO, Users, Integer> {

}
