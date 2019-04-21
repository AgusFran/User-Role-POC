package com.poc.userrole.service.impl;

import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.dto.impl.RoleDTO;
import com.poc.userrole.mapper.GenericMapper;
import com.poc.userrole.repository.GenericRepository;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericCrudService<RoleDTO, Roles, Integer> {

    public RoleService(GenericRepository<Roles, Integer> repo, GenericMapper<RoleDTO, Roles> mapper) {
        super(repo, mapper);
    }

}
