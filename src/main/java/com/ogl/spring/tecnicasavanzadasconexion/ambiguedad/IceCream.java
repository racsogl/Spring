package com.ogl.spring.tecnicasavanzadasconexion.ambiguedad;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary // designamos este bean como principal
@Qualifier("cold")
public class IceCream implements Dessert {
}
