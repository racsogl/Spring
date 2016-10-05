package com.ogl.spring.chapter.five.dao;


import com.ogl.spring.chapter.five.entity.Spittle;

import java.util.List;

public interface SpittleRepository {
    /**
     *
     * @param max id máximo  de cualquier spittle
     * @param count numero de objetos a devolver
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    Spittle findById(Long id);

    void save(Spittle spittle);
}
