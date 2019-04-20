package com.poc.userrole.mapper.impl;

import org.springframework.stereotype.Component;

import com.poc.userrole.domain.impl.Roles;
import com.poc.userrole.dto.impl.RoleDTO;
import com.poc.userrole.mapper.GenericMapper;

@Component
public class RoleMapper implements GenericMapper<RoleDTO, Roles> {

    public RoleDTO toDTO(Roles domain) {
        if (domain == null)
            return null;
        RoleDTO dto = new RoleDTO();

        dto.setId(domain.getId());
        dto.setDescription(domain.getDescription());

        return dto;
    }

    public Roles toDomain(RoleDTO dto) {
        if (dto == null)
            return null;

        Roles domain = new Roles();

        domain.setId(dto.getId());
        domain.setDescription(dto.getDescription());

        return domain;

    }

}
