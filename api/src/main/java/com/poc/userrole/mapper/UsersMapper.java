package com.poc.userrole.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.userrole.domain.Users;
import com.poc.userrole.dto.UserDTO;

@Component
public class UsersMapper {

    private RoleMapper mapper;
    
    public Users toDomain(UserDTO dto) {
        Users domain = new Users();
        domain.setId(dto.getId());
        domain.setPass(dto.getPassword());
        domain.setUsername(dto.getUsername());

        return domain;
    }

    public UserDTO toDTO(Users domain) {
        UserDTO dto = new UserDTO();
        dto.setId(domain.getId());
        dto.setPassword(domain.getPass());
        dto.setUsername(domain.getUsername());

        dto.setRole(mapper.toDTO(domain.getRoleId()));
        
        return dto;
    }

    @Autowired
    public void setMapper(RoleMapper mapper) {
        this.mapper = mapper;
    }

}
