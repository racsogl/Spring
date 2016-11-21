package com.ogl.spring.mvc.web.controller.jqgrid;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class JqGridControllerTest {

    @Test
    public void showData() throws Exception {
        JqGridController controller = new JqGridController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/jqgrid"))
                .andExpect(view().name("jqgrid/jqgridShowData"));

    }

}