package com.poc.userrole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.userrole.dto.UserDTO;
import com.poc.userrole.mapper.UsersMapper;
import com.poc.userrole.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepo;

    private UsersMapper mapper;

    public void create(UserDTO user) {
        userRepo.save(mapper.toDomain(user));
    }

    public UserDTO read(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<UserDTO> readAll() {
        // TODO Auto-generated method stub
        
        return null;
    }

    public void update(UserDTO userDTO) {
        // TODO Auto-generated method stub

    }

    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setMapper(UsersMapper mapper) {
        this.mapper = mapper;
    }

}
