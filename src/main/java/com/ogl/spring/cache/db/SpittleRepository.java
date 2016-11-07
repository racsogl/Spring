package com.ogl.spring.cache.db;

import com.ogl.spring.cache.domain.Spittle;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SpittleRepository {

    long count();

    @Cacheable("spittleCache")
    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    @Cacheable("spittleCache") // almacenamos los resultados
    Spittle findOne(long id);

    @CachePut(value = "spittleCache", key = "#result.id")
    Spittle save(Spittle spittle);

    @Cacheable("spittleCache")
    List<Spittle> findBySpitterId(long spitterId);

    @CacheEvict(value = "spittleCache", condition = "")
    void delete(long id);

}
