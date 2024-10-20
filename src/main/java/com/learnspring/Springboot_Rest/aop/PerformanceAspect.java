package com.learnspring.Springboot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.learnspring.Springboot_Rest.service.JobService.getJob(..))")
    public Object getTime(ProceedingJoinPoint pjp) throws Throwable {
        long start=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long end=System.currentTimeMillis();
        LOGGER.info("Method "+pjp.getSignature().getName()+" executed in "+(end-start)+" ms");
        return obj;

    }
}
