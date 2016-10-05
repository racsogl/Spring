package com.ogl.spring.one.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by ogl on 14/05/16.
 */

@Configuration
@EnableAspectJAutoProxy
public class MinstrelConfig {

    @Bean
    public MinstrelAnotations minstrel() {
        return new MinstrelAnotations(System.out);
    }

}
