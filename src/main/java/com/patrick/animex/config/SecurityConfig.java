package com.patrick.animex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
                        .requestMatchers(HttpMethod.GET, "/anime/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/anime/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/anime/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/anime/**").hasRole("ADMIN")

                        .anyRequest().authenticated());

        return http.build();
    }

}