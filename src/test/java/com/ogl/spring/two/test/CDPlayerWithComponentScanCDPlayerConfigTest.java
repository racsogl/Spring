package com.ogl.spring.two.test;

import com.ogl.spring.conexionbean.compacts.BlankDisc;
import com.ogl.spring.conexionbean.config.CDPlayerConfig;
import com.ogl.spring.conexionbean.players.CDPlayer;
import com.ogl.spring.conexionbean.soundsystem.CompactDisc;
import com.ogl.spring.conexionbean.soundsystem.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ogl on 14/07/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerWithComponentScanCDPlayerConfigTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    @Qualifier("mediaPlayerBlankDisc")
    private MediaPlayer mediaPlayer;

    @Autowired
    @Qualifier("blankDisc")
    private CompactDisc compactDisc;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull("should not be null", compactDisc);
    }

    @Test
    public void playMediaPlayer() {
        mediaPlayer.play();
        assertTrue("should be instanceof BlankDisc", ((CDPlayer) mediaPlayer).getCd() instanceof BlankDisc);
    }
}
