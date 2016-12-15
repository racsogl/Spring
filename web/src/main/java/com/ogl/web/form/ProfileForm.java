package com.ogl.web.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class ProfileForm {

    public static final String PROFILE_FORM_NAME = "profileForm";

    private MultipartFile multipartFile;
}
