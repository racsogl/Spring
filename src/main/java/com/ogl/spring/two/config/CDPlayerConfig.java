package com.ogl.spring.two.config;

import com.ogl.spring.two.compacts.BlankDisc;
import com.ogl.spring.two.compacts.SgtPeppers;
import com.ogl.spring.two.players.CDPlayer;
import com.ogl.spring.two.soundsystem.CompactDisc;
import com.ogl.spring.two.soundsystem.MediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ogl on 20/07/16.
 */
@Configuration
public class CDPlayerConfig {

    @Bean(name = "lonelyHeartsClub")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean(name = "blankDisc")
    public CompactDisc blankDisc() {
        return new BlankDisc("Title", "Artist");
    }

//    public CompactDisc randomBeatlesCD() {
//        int choice = (int) Math.floor(Math.random() * 4);
//
//        switch (choice) {
//            case 0:
//                return new SgtPeppers();
//                break;
//            case 1:
//                return new WhiteAlbum();
//                break;
//            case 2:
//                return new HardDaysNight();
//                break;
//            default:
//                return new Revolver();
//        }
//    }

    @Bean(name="mediaPlayerSgtPeppers")
    public MediaPlayer mediaPlayerSgtPeppers() {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(sgtPeppers());
        return cdPlayer;
    }

    @Bean(name="mediaPlayerBlankDisc")
    public MediaPlayer mediaPlayerBlankDisc() {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(blankDisc());
        return cdPlayer;
    }

}
