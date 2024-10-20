package com.learnspring.Springboot_Rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggerAspect.class);

    @Before("execution(* com.learnspring.Springboot_Rest.service.JobService.getJob(..))")
    public void log(JoinPoint jp){
        LOGGER.info("Method called before "+jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.learnspring.Springboot_Rest.service.JobService.getJob(..))")
    public void logAfter(JoinPoint jp){
        LOGGER.info("Method called after returning "+jp.getSignature().getName());
    }

}
