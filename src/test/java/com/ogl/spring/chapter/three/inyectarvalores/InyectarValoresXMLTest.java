package com.ogl.spring.chapter.three.inyectarvalores;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

/**
 * Created by ogl on 21/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/chapter/three/inyectarvalores.xml")
public class InyectarValoresXMLTest {

    @Autowired
    private Valores valores;

    @Test
    public void notNullTest() {
        Assert.assertNotNull(valores);
    }

    @Test
    public void title() {
        Assert.assertFalse(StringUtils.isEmpty(valores.getTitle()));
    }

    @Test
    public void artist() {
        Assert.assertFalse(StringUtils.isEmpty(valores.getArtist()));
    }

}
