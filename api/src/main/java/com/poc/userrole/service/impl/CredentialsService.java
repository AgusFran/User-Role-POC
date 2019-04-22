package com.poc.userrole.service.impl;

import com.poc.userrole.domain.impl.Users;
import com.poc.userrole.dto.impl.CredentialsDTO;
import com.poc.userrole.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class CredentialsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepository.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getDescription()));

        return new CredentialsDTO(user, grantedAuthorities);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
