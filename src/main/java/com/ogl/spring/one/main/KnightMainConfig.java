package com.ogl.spring.one.main;

import com.ogl.spring.one.config.KnightConfig;
import com.ogl.spring.one.service.Knight;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by ogl on 26/06/16.
 *
 * See @{@link Configuration}
 *
 * {@link FileSystemXmlApplicationContext}
 */
public class KnightMainConfig {

    public static void main (String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(KnightConfig.class);
        annotationConfigApplicationContext.refresh();

        Knight knight = annotationConfigApplicationContext.getBean(Knight.class);
        knight.embarkOnQuest();

        annotationConfigApplicationContext.close();
    }
}
