package com.poc.userrole.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userrole.controller.GenericCrudController;
import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.dto.impl.RoleDTO;

@RestController
@RequestMapping("roles")
public class RoleController extends GenericCrudController<RoleDTO, Roles, Integer> {

}
