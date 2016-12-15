package com.ogl.web.controller.profile;

import com.ogl.web.form.ProfileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class ProfileController implements ServletContextAware {


    private ServletContext context;

    @GetMapping(value = "/profile/{userName}")
    public String showProfile(@PathVariable final String userName, final Model model) {
        model.addAttribute(ProfileForm.PROFILE_FORM_NAME, new ProfileForm());
        return "profile/profile";
    }

    @PostMapping(value = "/profile/upload")
    public String uploadFile(@Valid final ProfileForm profileForm, final BindingResult bindingResult, final HttpServletRequest request) throws IOException {
        if (0 == profileForm.getMultipartFile().getSize()) {
            bindingResult.rejectValue("multipartFile", "profile.upload");

        }

        if (bindingResult.hasErrors()) {
            return "profile/profile";
        }

        profileForm.getMultipartFile().transferTo(new File(profileForm.getMultipartFile().getOriginalFilename()));
        return "redirect:/profile/username";


    }

    @Autowired
    @Override
    public void setServletContext(ServletContext servletContext) {
        context = servletContext;

    }
}
