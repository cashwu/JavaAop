package com.cashwu.javaaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author cash.wu
 * @since 2024/04/17
 */
@Aspect
@Order(1)
public class SecurityAspect {

    private final Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(ToLog)")
    public void logForAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info(SecurityAspect.class + " : method calling");

        Object proceed = joinPoint.proceed();

        logger.info(SecurityAspect.class + " : method executed and returned : " + proceed);
    }
}
