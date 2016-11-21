package com.ogl.spring.mvc.dao;

import com.ogl.spring.mvc.entity.Spitter;

public interface SpitterRepository {
    <T> T save(Spitter unsaved);

    Spitter findByUserName(String userName);
}
