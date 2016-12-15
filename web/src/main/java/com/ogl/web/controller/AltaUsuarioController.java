package com.ogl.web.controller;

import com.ogl.web.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AltaUsuarioController {

    private static final String VIEW_USER_CREATE = "altaUsuario";

    @GetMapping(value = "/usuario")
    public String showPageAltaUsuario(final Model model) {
        model.addAttribute("userForm", new UserForm());
        return VIEW_USER_CREATE;
    }

    @PostMapping(value = "/usuario")
    public String registrarUsuario(@Valid final UserForm userForm, final BindingResult result) {
        if (result.hasErrors()) {
            //return "redirect:/usuario"; si el post y el get tienen distinto path
            return VIEW_USER_CREATE;
        }

        return "redirect:/dashboard/userName";
    }
}
