package com.poc.userrole.service.impl;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericCrudService<UserDTO, Users, Integer> {

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void createAll(List<UserDTO> dtos) {
        dtos.forEach(dto -> dto.setPassword(this.passwordEncoder.encode(dto.getPassword())));

        super.createAll(dtos);
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

}
