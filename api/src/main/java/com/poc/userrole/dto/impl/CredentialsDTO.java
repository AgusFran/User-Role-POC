package com.poc.userrole.dto.impl;

import com.poc.userrole.domain.impl.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

public class CredentialsDTO extends User {

    private Users user;

    public CredentialsDTO(Users users, Set<GrantedAuthority> grantedAuthorities) {
        super(users.getUsername(), users.getPassword(), grantedAuthorities);

        this.user = users;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
