package com.ogl.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

    /**
     * value Identifica los tipos de bean en los que deben introducirse la interfaz, todos
     * los que implementan la interfaz Performance, el + especifica cualquier subtipo de Performance,
     * no Performance propiamente dicha.
     *
     * defaultImpl identica la clase que proporciona la implementación para la introducción
     *
     * static especifica la interfaz que introducir
     *
     */
    @DeclareParents(value = "com.ogl.spring.aop.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
