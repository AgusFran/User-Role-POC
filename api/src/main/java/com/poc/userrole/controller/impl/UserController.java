package com.poc.userrole.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userrole.controller.GenericCrudController;
import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;

@RestController
@RequestMapping("users")
public class UserController extends GenericCrudController<UserDTO, Users, Integer> {

}
