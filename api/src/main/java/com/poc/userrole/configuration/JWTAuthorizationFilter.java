package com.poc.userrole.configuration;

import com.poc.userrole.dto.impl.UserDTO;
import com.poc.userrole.helper.Constants;
import com.poc.userrole.service.impl.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {

            Claims claims = Jwts.parser()
                    .setSigningKey(new SecretKeySpec(DatatypeConverter.parseBase64Binary(Constants.SIGN_KEY), SignatureAlgorithm.HS512.getJcaName()))
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();

            Integer userID = claims.get("userID", Integer.class);

            UserDTO user = this.userService.read(userID);

            if (token.replace("Bearer ", "").equals(user.getToken())) {
                return new UsernamePasswordAuthenticationToken(userID, null, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(req, res);

            return;
        }

        UsernamePasswordAuthenticationToken authentication = this.getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(req, res);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
