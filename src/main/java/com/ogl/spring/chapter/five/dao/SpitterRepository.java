package com.ogl.spring.chapter.five.dao;

import com.ogl.spring.chapter.five.entity.Spitter;

public interface SpitterRepository {
    <T> T save(Spitter unsaved);

    Spitter findByUserName(String userName);
}
