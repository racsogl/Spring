package com.ogl.spring.chapter.two.radios;

import com.ogl.spring.chapter.two.soundsystem.Radio;
import org.springframework.stereotype.Component;

/**
 * Created by ogl on 20/05/16.
 */
@Component
public class RockFM implements Radio {

    private String cadena;

    public RockFM() {
        super();
    }

    public RockFM(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public void play() {
        System.out.println(cadena);
    }
}
