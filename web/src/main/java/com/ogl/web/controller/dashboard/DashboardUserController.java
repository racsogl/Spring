package com.ogl.web.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardUserController {

    @GetMapping(value = "/dashboard/{userName}")
    public String showDashboard(@PathVariable final String userName, final Model model) {
        model.addAttribute("userName", userName);
        return "dashboard/dashboard";
    }


}
