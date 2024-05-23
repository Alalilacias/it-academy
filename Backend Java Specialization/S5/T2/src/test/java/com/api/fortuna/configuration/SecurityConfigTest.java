package com.api.fortuna.configuration;

import com.api.fortuna.FortunaApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO fix and finish.
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FortunaApplication.class, TestSecurityConfig.class})
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void securityFilterChain() throws Exception {
        mockMvc.perform(get("/auth/login"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/swagger-ui/index.html"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testAuthenticatedAccess() throws Exception {
        mockMvc.perform(get("/players/ranking"))
                .andExpect(status().isOk());
    }
    @Test
    void testUnauthenticatedAccess() throws Exception {
        mockMvc.perform(get("/players/ranking"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    @WithMockUser(roles = "ADMIN")
    void testValidAdminAccess() throws Exception {
        mockMvc.perform(get("/admins/getAll"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser
    void testInvalidAdminAccess() throws Exception {
        mockMvc.perform(delete("/delete/5"))
                .andExpect(status().isForbidden());
    }
}