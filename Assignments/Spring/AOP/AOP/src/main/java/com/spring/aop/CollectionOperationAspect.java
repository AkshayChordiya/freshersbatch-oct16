package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CollectionOperationAspect {
	
	@Pointcut("execution(* com.spring.aop.CollectionOperation.*(..))")
	public void collectionPointCut() {}
	
	@Around("collectionPointCut()")
	public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long currentTimeMillis = System.nanoTime();
		Object object = joinPoint.proceed();
		System.out.println("Execution time for " + joinPoint.getSignature() + " " + (System.nanoTime() - currentTimeMillis));
		return object;
	}
}
