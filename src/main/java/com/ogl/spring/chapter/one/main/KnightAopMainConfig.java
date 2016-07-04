package com.ogl.spring.chapter.one.main;

import com.ogl.spring.chapter.one.aop.config.MinstrelConfig;
import com.ogl.spring.chapter.one.config.KnightConfig;
import com.ogl.spring.chapter.one.service.Knight;
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
public class KnightAopMainConfig {

    public static void main (String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(KnightConfig.class);
        annotationConfigApplicationContext.register(MinstrelConfig.class);
        annotationConfigApplicationContext.refresh();

        Knight knight = annotationConfigApplicationContext.getBean(Knight.class);
        knight.embarkOnQuest();

        annotationConfigApplicationContext.close();
    }
}
