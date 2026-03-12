package com.sd.sdshop.apis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())          // disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/api/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/products").permitAll()  // open your APIs
                        .requestMatchers(HttpMethod.GET,"/register").permitAll()  // open your APIs
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // keep basic auth if you want

        return http.build();
    }
}