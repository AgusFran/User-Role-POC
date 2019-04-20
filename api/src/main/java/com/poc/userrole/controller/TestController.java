package com.poc.userrole.controller;

import com.poc.userrole.domain.Users;
import com.poc.userrole.dto.AuthDTO;
import com.poc.userrole.dto.UserDTO;
import com.poc.userrole.mapper.UsersMapper;
import com.poc.userrole.repository.RoleRepository;
import com.poc.userrole.service.SecurityService;
import com.poc.userrole.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private SecurityService service;
    private UserAuthService userAuthService;
    private UsersMapper usersMapper;
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public void login() {
        this.service.autoLogin("gio", "asd123");
    }

    @PostMapping("/register")
    public void register(@RequestBody AuthDTO user) {
        Users users = new Users();
        users.setUsername(user.getUsername());
        users.setPass(user.getPassword());
        users.setRoleId(this.roleRepository.getOne(user.getRoleId()));

        this.userAuthService.save(users);
    }

    @Autowired
    public void setService(SecurityService service) {
        this.service = service;
    }

    @Autowired
    public void setUserAuthService(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
