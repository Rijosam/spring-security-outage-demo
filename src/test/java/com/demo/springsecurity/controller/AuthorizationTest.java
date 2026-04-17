package com.demo.springsecurity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void testUnauthenticatedUser() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", roles = "ADMIN")
    public void testAuthenticatedUser() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk())
                .andExpect(content().string("USER :user"));
    }

}