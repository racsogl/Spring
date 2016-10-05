package com.ogl.spring.tecnicasavanzadasconexion.conditional;

import org.junit.*;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MagicExistsTest {

    @ClassRule
    public static final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Autowired
    private AnnotationConfigApplicationContext context;

    @BeforeClass
    public static void setEnvironmetVariable() throws Exception {
        environmentVariables.set("magic", "magic");
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
        context.register(MagicConfig.class);
        context.refresh();
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void shouldNotBeNull() {
        assertTrue(context.containsBean("magicBean"));
    }

}
