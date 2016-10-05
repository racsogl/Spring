package com.ogl.spring.five.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spitter {

    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String userName;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    @Email
    private String email;

    public Spitter(String userName, String firstName, String lastName, String password, String email) {
        this(null, userName, firstName, lastName, password, email);
    }
}

