package com.ogl.spring.chapter.one.main;

import com.ogl.spring.chapter.one.service.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ogl on 26/06/16.
 */
public class KnightAopMain {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext(
                        "META-INF/spring/chapter/one/slaydragonquest-context.xml",
                        "META-INF/spring/chapter/one/aop-context.xml");

        Knight knight = classPathXmlApplicationContext.getBean(Knight.class);
        knight.embarkOnQuest();

        classPathXmlApplicationContext.close();
    }
}
