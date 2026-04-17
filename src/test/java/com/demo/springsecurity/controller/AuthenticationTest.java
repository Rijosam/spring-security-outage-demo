package com.demo.springsecurity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class AuthenticationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAuthenticationWithValidUser() throws Exception {
        mockMvc.perform(
                get("/api/user")
                .with(httpBasic("rijo", "password")))
                .andExpect(status().isOk());
    }

    @Test
    void testAuthenticationWithInValidUser() throws Exception {
        mockMvc.perform(
                        get("/api/user")
                        .with(httpBasic("rijo", "wrong-password")))
                .andExpect(status().isUnauthorized());
    }

}
