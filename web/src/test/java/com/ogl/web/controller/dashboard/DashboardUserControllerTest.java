package com.ogl.web.controller.dashboard;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class DashboardUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private DashboardUserController controller;

    @Before
    public void setUp() throws Exception {
        controller = new DashboardUserController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void showDashboard() throws Exception {
        mockMvc.perform(get("/dashboard/userName"))
                .andExpect(status().isOk()).andExpect(view().name("dashboard/dashboard"));
    }

}