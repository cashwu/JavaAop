package com.cashwu.javaaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
@Order(2)
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.cashwu.javaaop.*.*.*(..))")
    //    @Around("execution(* com.cashwu.javaaop.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature()
                                     .getName();
        Object[] args = joinPoint.getArgs();

        logger.info("method : " + methodName + ", with parameters : " + Arrays.asList(args) + " will be execute");

        Comment comment = new Comment();
        comment.setText("another comment");

        Object[] newArgs = {comment};

        Object proceed = joinPoint.proceed(newArgs);

        logger.info("method executed and returned : " + proceed);

        return "FAILED ~";
    }

    @Around("@annotation(ToLog)")
    public void logForAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature()
                                     .getName();
        Object[] args = joinPoint.getArgs();

        logger.info("method : " + methodName + ", with parameters : " + Arrays.asList(args) + " will be execute");

        Comment comment = new Comment();
        comment.setText("another comment");

        Object[] newArgs = {comment};

        Object proceed = joinPoint.proceed(newArgs);

        logger.info("method executed and returned : " + proceed);
    }

    @AfterReturning(value = "@annotation(ToLogBefore)",
                    returning = "returnedValue")
    public void logForAfterReturn(Object returnedValue) {

        logger.info("method executed and returned : " + returnedValue);
    }
}
