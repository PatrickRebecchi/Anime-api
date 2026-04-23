package com.patrick.animex.config;

import com.patrick.animex.security.JwtFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()

                        .requestMatchers(HttpMethod.GET, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.GET, "/anime/**").permitAll()

                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/anime/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/anime/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/anime/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                // 🔥 ESSENCIAL
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}