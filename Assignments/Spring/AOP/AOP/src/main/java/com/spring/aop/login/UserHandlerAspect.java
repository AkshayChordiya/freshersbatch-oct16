package com.spring.aop.login;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UserHandlerAspect {
	
	private long totalTime;

	@Pointcut("execution(* com.spring.aop.login.UserHandler.register(..))")
	public void handleRegister() {}
	
	@Pointcut("execution(* com.spring.aop.login.UserHandler.login(..))")
	public void handleLogin() {}
	
	@Pointcut("execution(* com.spring.aop.login.UserHandler.logout(..))")
	public void handleLogout() {}
	
	@Around("handleRegister()")
	public Object doingRegisteration(ProceedingJoinPoint joinPoint) throws Throwable {
		String username = (String) joinPoint.getArgs()[0];
		if (username.length() < 3) {
			System.out.println("Username should be minimum of 3 chars");
			return null;
		} else {
			Object object = joinPoint.proceed();
			return object;
		}
	}
	
	@Around("handleLogin()")
	public Object doingLogin(ProceedingJoinPoint joinPoint) throws Throwable {
		String username = (String) joinPoint.getArgs()[0];
		if (username.length() < 3) {
			System.out.println("Username should be minimum of 3 chars");
			return null;
		} else {
			totalTime = System.currentTimeMillis();
			Object object = joinPoint.proceed();
			return object;
		}
	}
	
	@After("handleLogout()")
	public void doLogout(JoinPoint joinPoint) {
		System.out.println("Audit = " + (System.currentTimeMillis() - totalTime) + "ms");
	}
	
	@AfterThrowing(pointcut="handleLogout()", throwing="ex")
	public void loginFailed(JoinPoint joinPoint, Throwable ex) {
		System.out.println(ex.getMessage());
	}
}
