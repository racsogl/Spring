package com.ogl.spring.mvc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SuperHeroDTO implements Serializable {

    private String name;

    private String alias;

    private String power;

    private Boolean selected;
}
