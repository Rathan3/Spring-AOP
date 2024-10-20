package com.learnspring.Springboot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(ValidationAspect.class);
    @Around("execution(* com.learnspring.Springboot_Rest.service.JobService.getJob(..)) && args(jobId)")
    public Object validate(ProceedingJoinPoint pjp,int jobId) throws  Throwable{
        if(jobId<0){
            jobId=-jobId;
            LOGGER.info("Value is negative and updated to positive updated value : "+jobId);
        }
        return pjp.proceed(new Object[] {jobId});
    }
}
