package com.ogl.spring.chapter.three.ambiguedad;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cookies implements Dessert {
}
