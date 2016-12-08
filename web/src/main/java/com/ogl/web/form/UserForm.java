package com.ogl.web.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserForm {

    @NotNull
    @Size(min = 4, max = 12, message = "{userName.size}")
    private String userName;

    @NotNull
    @Size(min = 8, max = 12, message = "{password.size}")
    private String password;
}
