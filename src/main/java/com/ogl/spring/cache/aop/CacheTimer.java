package com.ogl.spring.cache.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.util.StopWatch;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

@Aspect
public class CacheTimer {

    private static final Logger LOGGER = getLogger(CacheTimer.class);

    @Pointcut("execution(* com.ogl.spring.cache.db.SpittleRepository.*(..))")
    public void performanceCache() {}

    @Around("performanceCache()")
    public Object performance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = proceedingJoinPoint.proceed();

        stopWatch.stop();

        StringBuilder logMessage = new StringBuilder();
        logMessage.append(proceedingJoinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(proceedingJoinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = proceedingJoinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        logMessage.append(" execution time: ");
        logMessage.append(stopWatch.getTotalTimeMillis());
        logMessage.append(" ms");
        LOGGER.info(logMessage.toString());
        if (retVal instanceof Collection) {
            for (Object object: (Collection)retVal) {
                LOGGER.info(object.toString());
            }
        } else {
            LOGGER.info(retVal.toString());
        }
        return retVal;
    }

//    @AfterReturning(pointcut = "performanceCache()", returning = "retVal")
//    public void logAfterMethod(JoinPoint joinPoint, Object retVal) {
//        if (retVal instanceof Collection) {
//            for (Object object: (Collection)retVal) {
//                LOGGER.info(object.toString());
//            }
//        } else {
//            LOGGER.info(retVal.toString());
//        }
//    }

}
