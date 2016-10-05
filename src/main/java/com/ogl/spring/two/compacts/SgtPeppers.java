package com.ogl.spring.two.compacts;

import com.ogl.spring.two.soundsystem.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by ogl on 14/07/16.
 */
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public SgtPeppers() {
        super();
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
