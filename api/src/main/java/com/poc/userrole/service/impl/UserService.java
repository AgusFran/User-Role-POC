package com.poc.userrole.service.impl;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.dto.impl.UserResponseDTO;
import com.poc.userrole.mapper.impl.UsersMapper;
import com.poc.userrole.repository.GenericRepository;
import com.poc.userrole.service.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends GenericCrudService<UserDTO, Users, Integer> {

    private BCryptPasswordEncoder passwordEncoder;

    public UserService(GenericRepository<Users, Integer> repo, UsersMapper mapper) {
        super(repo, mapper);
    }

    @Override
    public void createAll(List<UserDTO> dtos) {
        dtos.forEach(dto -> dto.setPassword(this.passwordEncoder.encode(dto.getPassword())));

        super.createAll(dtos);
    }

    public List<UserResponseDTO> readAsResponses() {
        List<UserResponseDTO> all = new ArrayList<>();

        this.getRepository().findAll().forEach(one -> all.add(((UsersMapper) this.mapper).toResponse(one)));

        return all;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

}
