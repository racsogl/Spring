package com.ogl.spring.chapter.two.players;

import com.ogl.spring.chapter.two.soundsystem.CompactDisc;
import com.ogl.spring.chapter.two.soundsystem.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

  private CompactDisc cd;

  @Autowired
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
