package com.demo.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) {

      http.httpBasic(Customizer.withDefaults());
      http.authorizeHttpRequests(auth ->
              auth.requestMatchers("/api/**").authenticated()
                      .anyRequest().denyAll());
      return http.build();
  }
}




