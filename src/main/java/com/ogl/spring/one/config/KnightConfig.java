package com.ogl.spring.one.config;

import com.ogl.spring.one.service.BraveKnight;
import com.ogl.spring.one.service.Knight;
import com.ogl.spring.one.service.Quest;
import com.ogl.spring.one.service.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ogl on 27/06/16.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
