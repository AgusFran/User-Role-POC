package com.poc.userrole.mapper.impl;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.dto.impl.UserResponseDTO;
import com.poc.userrole.mapper.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements GenericMapper<UserDTO, Users> {

    private RoleMapper mapper;

    public Users toDomain(UserDTO dto) {
        if (dto == null)
            return null;

        Users domain = new Users();

        domain.setId(dto.getId());
        domain.setPassword(dto.getPassword());
        domain.setUsername(dto.getUsername());
        domain.setAuthToken(dto.getToken());
        domain.setRole(mapper.toDomain(dto.getRole()));

        return domain;
    }

    public UserDTO toDTO(Users domain) {
        if (domain == null)
            return null;

        UserDTO dto = new UserDTO();

        dto.setId(domain.getId());
        dto.setPassword(domain.getPassword());
        dto.setUsername(domain.getUsername());
        dto.setToken(domain.getAuthToken());
        dto.setRole(mapper.toDTO(domain.getRole()));

        return dto;
    }

    public UserResponseDTO toResponse(Users domain) {
        if (domain == null)
            return null;

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(domain.getId());
        dto.setUsername(domain.getUsername());
        dto.setRole(mapper.toDTO(domain.getRole()));

        return dto;
    }

    @Autowired
    public void setMapper(RoleMapper mapper) {
        this.mapper = mapper;
    }

}
