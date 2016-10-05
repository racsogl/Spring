package com.ogl.spring.one.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.*;

/**
 * Created by ogl on 22/06/16.
 */
public class BraveKnightTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BraveKnightTest.class);

    @Test
    public void embarkOnQuest() throws Exception {
        Quest mockQuest = mock(Quest.class);

        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();

        LOGGER.debug("logger");
    }

}