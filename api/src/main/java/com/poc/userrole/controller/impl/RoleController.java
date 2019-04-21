package com.poc.userrole.controller.impl;

import com.poc.userrole.controller.GenericCrudController;
import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.dto.impl.RoleDTO;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController extends GenericCrudController<RoleDTO, Roles, Integer> {

    public RoleController(GenericCrudService<RoleDTO, Roles, Integer> crudService) {
        super(crudService);
    }

}
