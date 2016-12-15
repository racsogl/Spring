package com.ogl.web.controller.profile;

import com.ogl.web.form.ProfileForm;
import com.ogl.web.form.UserForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ProfileController controller;

    @Before
    public void showProfile() throws Exception {
        controller = new ProfileController();
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void showPagePerfil() throws Exception {
        mockMvc.perform(get("/profile/username"))
                .andExpect(model().attribute(ProfileForm.PROFILE_FORM_NAME, new ProfileForm()))
                .andExpect(view().name("profile/profile"));
    }


}