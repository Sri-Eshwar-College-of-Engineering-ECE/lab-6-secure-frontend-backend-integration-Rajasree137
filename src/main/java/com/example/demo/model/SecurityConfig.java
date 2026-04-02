package com.example.demo.model;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()              // login allowed
                        .requestMatchers("/api/admin").hasRole("ADMIN")       // only ADMIN
                        .requestMatchers("/api/user").hasAnyRole("USER","ADMIN") // USER + ADMIN
                        .anyRequest().authenticated()                         // others secured
                )
                .addFilterBefore(new JwtFilter(),
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}