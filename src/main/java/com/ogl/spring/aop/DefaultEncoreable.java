package com.ogl.spring.aop;

public class DefaultEncoreable implements Encoreable {

    @Override
    public void performEncore() {
        System.out.println("performEncore");
    }
}
