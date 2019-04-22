package com.poc.userrole.dto.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poc.userrole.dto.BaseDTO;

public class UserDTO implements BaseDTO {
    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private boolean erased;
    private RoleDTO role;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String token;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isErased() {
        return erased;
    }

    public void setErased(boolean erased) {
        this.erased = erased;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

}
