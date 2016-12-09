package com.ogl.web.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping(value = "/profile/{userName}")
    public String showProfile(@PathVariable final String userName) {
        return "profile/profile";
    }
}
