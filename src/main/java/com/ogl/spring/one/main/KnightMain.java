package com.ogl.spring.one.main;

import com.ogl.spring.one.service.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ogl on 26/06/16.
 */
public class KnightMain {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("META-INF/spring/chapter/one/slaydragonquest-context.xml");

        Knight knight = classPathXmlApplicationContext.getBean(Knight.class);
        knight.embarkOnQuest();

        classPathXmlApplicationContext.close();
    }
}
