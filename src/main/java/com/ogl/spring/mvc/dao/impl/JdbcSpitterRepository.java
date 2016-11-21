package com.ogl.spring.mvc.dao.impl;

import com.ogl.spring.mvc.dao.SpitterRepository;
import com.ogl.spring.mvc.entity.Spitter;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    @Override
    public <T> T save(Spitter unsaved) {
        return null;
    }

    @Override
    public Spitter findByUserName(String userName) {
        Spitter spitter = new Spitter();
        spitter.setFirstName("Get from Repository");
        return spitter;
    }
}
