package com.ogl.spring.chapter.five.dao.impl;

import com.ogl.spring.chapter.five.dao.SpitterRepository;
import com.ogl.spring.chapter.five.dao.SpittleRepository;
import com.ogl.spring.chapter.five.entity.Spitter;
import com.ogl.spring.chapter.five.entity.Spittle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
