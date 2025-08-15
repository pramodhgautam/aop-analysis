package com.nchl.aopanalysis.analyzer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AopLoggingAspect {

    @Around("execution(* HelloWorld.greet(..))")
    public Object logAndTime(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().toShortString();
        long start = System.nanoTime();
        System.out.println("[AOP] Entering " + methodName);

        Object result = pjp.proceed();

        long elapsed = System.nanoTime() - start;
        System.out.println("[AOP] Exiting " + methodName + " (took " + elapsed / 1_000_000 + " ms)");
        return result;
    }
}
