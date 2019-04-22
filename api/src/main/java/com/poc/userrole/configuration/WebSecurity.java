package com.poc.userrole.configuration;

import com.poc.userrole.service.impl.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private CredentialsService credentialsService;
    private JWTAuthorizationFilter authorizationFilter;
    private JWTAuthenticationFilter authenticationFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

        return source;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.credentialsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated().and()
                .addFilter(this.authenticationFilter)
                .addFilter(this.authorizationFilter);
    }

    @Bean
    @Qualifier("authManager")
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    public void setCredentialsService(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @Lazy
    @Autowired
    public void setAuthorizationFilter(JWTAuthorizationFilter authorizationFilter) {
        this.authorizationFilter = authorizationFilter;
    }

    @Lazy
    @Autowired
    public void setAuthenticationFilter(JWTAuthenticationFilter authenticationFilter) {
        this.authenticationFilter = authenticationFilter;
    }

}
