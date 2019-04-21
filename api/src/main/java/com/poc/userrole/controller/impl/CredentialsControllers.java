package com.poc.userrole.controller.impl;

import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.service.impl.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credentials")
public class CredentialsControllers {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CredentialsControllers(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping()
    public void create(@RequestBody UserDTO user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        this.userService.create(user);
    }

}
