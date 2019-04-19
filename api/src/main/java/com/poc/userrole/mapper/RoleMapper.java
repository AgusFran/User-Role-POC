package com.poc.userrole.mapper;

import org.springframework.stereotype.Component;

import com.poc.userrole.domain.Roles;
import com.poc.userrole.dto.RoleDTO;

@Component
public class RoleMapper {

    public RoleDTO toDTO(Roles domain) {
        RoleDTO dto = new RoleDTO();

        dto.setId(domain.getId());
        dto.setDescription(domain.getDescription());

        return dto;
    }

    public Roles toDomain(RoleDTO dto) {
        Roles domain = new Roles();

        domain.setId(dto.getId());
        domain.setDescription(dto.getDescription());

        return domain;

    }

}
