package com.ogl.spring.chapter.five.dao.impl;

import com.ogl.spring.chapter.five.dao.SpittleRepository;
import com.ogl.spring.chapter.five.entity.Spittle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> result = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            result.add(i, new Spittle("Spittle".concat(String.valueOf(i)), new Date()));
        }

        return result;

    }

    @Override
    public Spittle findById(Long id) {
        return null;
    }
}
