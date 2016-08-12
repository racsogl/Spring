package com.ogl.spring.chapter.three.ambiguedad;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // designamos este bean como principal
@Qualifier("cold")
public class IceCream implements Dessert {
}
