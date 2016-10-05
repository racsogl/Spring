package com.ogl.spring.two.players;

import com.ogl.spring.two.soundsystem.CompactDisc;
import com.ogl.spring.two.soundsystem.MediaPlayer;
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
