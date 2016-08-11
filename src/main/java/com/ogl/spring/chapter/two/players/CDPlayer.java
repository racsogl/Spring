package com.ogl.spring.chapter.two.players;

import com.ogl.spring.chapter.two.soundsystem.CompactDisc;
import com.ogl.spring.chapter.two.soundsystem.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

//    @Autowired
//    @Qualifier("lonelyHeartsClub")
    private CompactDisc cd;

    public CDPlayer() {
        super();
    }

    public void play() {
        cd.play();
    }

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

}
