package com.ogl.spring.tecnicasavanzadasconexion.inyectarvalores;

import com.ogl.spring.conexionbean.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ogl on 21/08/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class InyectarValoresTest {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void propertiesTest() {
        compactDisc.play();
    }

}
