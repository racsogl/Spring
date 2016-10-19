package com.ogl.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
En XML
xmlns y xsi de aop
<aop:aspectj-autoproxy />
Es necesario anotar el Bean como @Aspect
*/
@Configuration
@EnableAspectJAutoProxy // Habilitamos los proxys automáticos de AspectJ.
@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Encoreable encoreable() {
        return new DefaultEncoreable();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
