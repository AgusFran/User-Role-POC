package com.poc.userrole.service.impl;

import org.springframework.stereotype.Service;

import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.dto.impl.RoleDTO;
import com.poc.userrole.service.GenericCrudService;

@Service
public class RoleService extends GenericCrudService<RoleDTO, Roles, Integer> {

}
