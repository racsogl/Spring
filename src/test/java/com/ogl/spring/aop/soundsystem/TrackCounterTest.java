package com.ogl.spring.aop.soundsystem;

import com.ogl.spring.conexionbean.soundsystem.CompactDisc;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCounter() {
        System.out.println(compactDisc.getTittle());

        compactDisc.playTrack(1);
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(1);

        assertEquals(0, trackCounter.getPlayCount(0));
        assertEquals(3, trackCounter.getPlayCount(1));

    }

}