package com.poc.userrole.dto.impl;

import com.poc.userrole.dto.BaseDTO;

public class UserResponseDTO implements BaseDTO {

    private int id;
    private String username;
    private boolean erased;
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
