package com.poc.userrole.dto.impl;

import com.poc.userrole.dto.BaseDTO;

public class UserDTO implements BaseDTO {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;
    private RoleDTO role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

}
