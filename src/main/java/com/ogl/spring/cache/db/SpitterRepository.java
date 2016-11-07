package com.ogl.spring.cache.db;

import com.ogl.spring.cache.domain.Spitter;

import java.util.List;

public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();

}
