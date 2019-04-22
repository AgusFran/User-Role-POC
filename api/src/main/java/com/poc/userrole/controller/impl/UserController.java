package com.poc.userrole.controller.impl;

import com.poc.userrole.controller.GenericCrudController;
import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends GenericCrudController<UserDTO, Users, Integer> {

    public UserController(GenericCrudService<UserDTO, Users, Integer> crudService) {
        super(crudService);
    }

}
