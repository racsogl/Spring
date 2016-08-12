package com.ogl.spring.chapter.three.conditional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicNotExistsTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldBeNull() {
        assertFalse(context.containsBean("magicBean"));
    }
}

