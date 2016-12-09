package com.ogl.web.controller;

import com.ogl.web.form.UserForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class AltaUsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private AltaUsuarioController controller;

    @Before
    public void setUp() throws Exception {
        controller = new AltaUsuarioController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void showPageAltaUsuario() throws Exception {
        mockMvc.perform(get("/usuario"))
                .andExpect(model().attribute("userForm", new UserForm()))
                .andExpect(view().name("altaUsuario"));
    }

    @Test
    public void registrarUsuarioFormHasErrors() throws Exception {
        mockMvc.perform(post("/usuario")
                .param("userName", "")
                .param("password", ""))
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("userForm"))
                .andExpect(model().attributeHasFieldErrors("userForm", "userName"))
                .andExpect(model().attributeHasFieldErrors("userForm", "password"))
                .andExpect(view().name("altaUsuario"));
    }

    @Test
    public void registrarUsuario() throws Exception {
        mockMvc.perform(post("/usuario")
                .param("userName", "user")
                .param("password", "password"))
                .andExpect(status().is3xxRedirection());
    }
}

