package com.ogl.spring.mvc.dao;


import com.ogl.spring.mvc.entity.Spittle;

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
