package com.ogl.spring.chapter.one.aop.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.PrintStream;

@Aspect
public class MinstrelAnotations {

    private PrintStream stream;

    public MinstrelAnotations(PrintStream stream) {
        this.stream = stream;
    }

    @Before("execution(* *.embarkOnQuest(..))")
    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }

    @After("execution(* *.embarkOnQuest(..))")
    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight " +
                "did embark on a quest!");
    }

}
