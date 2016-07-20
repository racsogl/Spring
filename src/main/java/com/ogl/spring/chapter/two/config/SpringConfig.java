package com.ogl.spring.chapter.two.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ogl on 14/07/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.ogl.spring.chapter.two.compacts", "com.ogl.spring.chapter.two.players"})
public class SpringConfig {
}
