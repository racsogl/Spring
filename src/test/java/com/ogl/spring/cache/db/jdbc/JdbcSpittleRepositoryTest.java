package com.ogl.spring.cache.db.jdbc;

import com.ogl.spring.cache.config.CacheConfig;
import com.ogl.spring.cache.db.SpittleRepository;
import com.ogl.spring.cache.domain.Spitter;
import com.ogl.spring.cache.domain.Spittle;
import com.ogl.spring.tecnicasavanzadasconexion.profiles.ProfileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheConfig.class)
public class JdbcSpittleRepositoryTest {

    private static final Logger LOGGER = getLogger(JdbcSpittleRepositoryTest.class);

    @Autowired
    private SpittleRepository spittleRepository;

    @Test
    public void test() {
        assertNotNull(spittleRepository);
    }//    @Test
//    public void count() throws Exception {
//
//    }
//
    @Test
    public void findRecent() throws Exception {
        LOGGER.debug("primera llamada");
        List<Spittle> recent = spittleRepository.findRecent();
        LOGGER.debug("segunda llamada");
        recent = spittleRepository.findRecent();

    }
//
//    @Test
//    public void findRecent1() throws Exception {
//
//    }
//
//    @Test
//    public void findOne() throws Exception {
//
//    }
//
//    @Test
//    public void findBySpitterId() throws Exception {
//
//    }
//
    @Test
    public void save() throws Exception {
        LOGGER.debug("save()");
        assertEquals(15, spittleRepository.count());
        Spitter spitter = spittleRepository.findOne(13).getSpitter();
        Spittle spittle = new Spittle(null, spitter, "Un Nuevo Spittle from Art", new Date());
        Spittle saved = spittleRepository.save(spittle);
        assertEquals(16, spittleRepository.count());

        assertNewSpittle(saved);

        assertNewSpittle(spittleRepository.findOne(16L));
        spittleRepository.findOne(2L);
        LOGGER.debug("Spittle Cache {} ", spittleRepository.findOne(13L));


    }

    private void assertNewSpittle(Spittle spittle) {
        assertEquals(16, spittle.getId().longValue());
    }
//
//    @Test
//    public void delete() throws Exception {
//
//    }

}