package com.poc.userrole.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.userrole.dto.impl.CredentialsDTO;
import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.dto.impl.AuthRequestDTO;
import com.poc.userrole.helper.Constants;
import com.poc.userrole.service.impl.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Component
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthRequestDTO user = new ObjectMapper().readValue(request.getInputStream(), AuthRequestDTO.class);

            return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        CredentialsDTO credentials = (CredentialsDTO) auth.getPrincipal();

        String token = Jwts.builder()
                .setIssuedAt(new Date())
                .claim("userID", credentials.getUser().getId())
                .setSubject(credentials.getUsername())
                .signWith(SignatureAlgorithm.HS512, new SecretKeySpec(DatatypeConverter.parseBase64Binary(Constants.SIGN_KEY), SignatureAlgorithm.HS512.getJcaName()))
                .compact();

        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer" + " " + token);

        UserDTO user = this.userService.read(credentials.getUser().getId());
        user.setToken(token);

        this.userService.createOrUpdate(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("authManager")
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

}
