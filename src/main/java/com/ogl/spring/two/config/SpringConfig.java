package com.ogl.spring.two.config;

import com.ogl.spring.two.compacts.SgtPeppers;
import com.ogl.spring.two.players.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ogl on 14/07/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.ogl.spring.chapter.two.compacts"}) //@ComponentScan(basePackages = {"com.ogl.spring.chapter.two.compacts"}) //
public class SpringConfig {

    @Bean
    public CDPlayer cdPlayer() {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(new SgtPeppers());
        return cdPlayer;
    }
}
