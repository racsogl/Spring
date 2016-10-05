package com.ogl.spring.five.dao;

import com.ogl.spring.five.entity.Spitter;

public interface SpitterRepository {
    <T> T save(Spitter unsaved);

    Spitter findByUserName(String userName);
}
