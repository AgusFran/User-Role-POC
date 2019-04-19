package com.poc.userrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userrole.dto.UserDTO;
import com.poc.userrole.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService service;

    @PostMapping("create")
    public void create(@RequestBody UserDTO userDTO) {
        this.service.create(userDTO);
    }

    @GetMapping("read")
    public List<UserDTO> readAll() {
        return this.service.readAll();
    }

    @GetMapping("read/{id}")
    public UserDTO read(@PathVariable("id") String id) {
        return this.service.read(id);
    }

    @PostMapping("update")
    public void update(@RequestBody UserDTO userDTO) {
        this.service.update(userDTO);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable("id") String id) {
        this.service.delete(id);
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

}
