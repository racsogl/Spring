package com.ogl.spring.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import static org.slf4j.LoggerFactory.getLogger;

public class LogBackTest {

    @Test
    public void logBack() {
        Logger logger = getLogger(LogBackTest.class);
        logger.debug("Hello world");
    }

    @Test
    public void logBackInternalStateTest() {
        // assume SLF4J is bound to logback in the current environment
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);
    }

    /**
     * Por defecto el root logger su level es a DEBUG
     *
     * Si creamos un logger sin asignar un un level hereda el de root
     *
     * root debug debug
     * x    info   info
     * x.y  none   info
     * z    none   debug
     *
     *
     * metodos de impresion y seleccion de reglas
     *
     * TRACE < DEBUG < INFO <  WARN < ERROR
     *
     *
     level of
     request p	effective level q
            TRACE	DEBUG	INFO	WARN	ERROR	OFF
     TRACE	YES	    NO	    NO	    NO	    NO	    NO
     DEBUG	YES	    YES	    NO	    NO	    NO	    NO
     INFO	YES	    YES	    YES	    NO	    NO	    NO
     WARN	YES	    YES	    YES	    YES	    NO	    NO
     ERROR	YES	    YES	    YES	    YES	    YES	    NO

     *
     */
    @Test
    public void levelLog() {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) getLogger(getClass());
        logger.setLevel(Level.INFO);



        logger.warn("WARN ");

        long startTime = System.currentTimeMillis();
        for (float i = 0F; i < 15000000F; i++) {
            if (logger.isDebugEnabled()) {
                logger.debug("Debug");
            }
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        startTime = System.currentTimeMillis();
        for (int i =0; i < 150000; i++) {
            logger.debug("Debug");
        }
        endTime  = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);
/////////////
         startTime = System.currentTimeMillis();
        for (int i =0; i < 150000; i++) {
            if (logger.isDebugEnabled()) {
                logger.debug("Debug");
            }
        }
         endTime   = System.currentTimeMillis();
         totalTime = endTime - startTime;
        System.out.println(totalTime);

        startTime = System.currentTimeMillis();
        for (int i =0; i < 150000; i++) {
            logger.debug("Debug");
        }
        endTime  = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);


//////////

        startTime = System.currentTimeMillis();
        for (int i =0; i < 150000; i++) {
            if (logger.isDebugEnabled()) {
                logger.debug("Debug");
            }
        }
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);

        startTime = System.currentTimeMillis();
        for (int i =0; i < 150000; i++) {
            logger.debug("Debug");
        }
        endTime  = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);










        logger.debug("Debug");


        startTime = System.currentTimeMillis();
        if (logger.isDebugEnabled()) {
            logger.info("info");
        }
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime /1000;
        System.out.println(totalTime);


        startTime = System.currentTimeMillis();
        logger.info("info");
        endTime  = System.currentTimeMillis();
        totalTime = endTime - startTime /1000;
        System.out.println(totalTime);


    }
}