package com.ogl.spring.tecnicasavanzadasconexion.inyectarvalores;

import com.ogl.spring.conexionbean.compacts.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by ogl on 21/08/16.
 */
@Configuration
@PropertySource("classpath:/config/tecnicasavanzadasconexion.properties")
public class SpringConfig {

    @Autowired
    private Environment environment;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                environment.getProperty("disc.title"),
                environment.getProperty("disc.artist"));
    }
}
