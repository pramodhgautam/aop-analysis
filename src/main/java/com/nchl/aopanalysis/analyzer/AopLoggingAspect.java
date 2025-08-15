package com.nchl.aopanalysis.analyzer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AopLoggingAspect {

    @Around(
            "execution(* com.nchl.aopanalysis.analyzer.HelloWorld.greet(..)) || " +
                    "execution(* com.nchl.aopanalysis.analyzer.HelloWorld.main(..))"
    )
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[AOP] Entering " + joinPoint.getSignature().toShortString());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("[AOP] Exiting " + joinPoint.getSignature().toShortString() + " (took " + timeTaken + " ms)");
        return result;
    }

}
