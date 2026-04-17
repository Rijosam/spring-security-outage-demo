package com.demo.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) {

      http.httpBasic(Customizer.withDefaults());
      http.addFilterBefore(new ValidationFilter(), BasicAuthenticationFilter.class);

      http.authorizeHttpRequests(auth ->
              auth.anyRequest().authenticated());

      var user = User.withUsername("rijo")
              .password("password")
              .roles("USER")
              .build();

      http.userDetailsService(new InMemoryUserDetailsManager(user));
      return http.build();
  }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}




