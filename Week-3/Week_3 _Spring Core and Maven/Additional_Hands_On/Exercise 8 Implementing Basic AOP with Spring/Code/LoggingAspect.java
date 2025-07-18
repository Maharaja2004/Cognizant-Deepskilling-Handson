package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.library.service.BookService.addBook(..))")
	public void logBefore(JoinPoint jp) {
		System.out.println("LOG Before Method:"+jp.getSignature().getName());
	}
	
	@After("execution (* com.library.service.BookService.addBook(..))")
     public void logAfter(JoinPoint jp) {
		System.out.println("LOG After Method:"+jp.getSignature().getName());
	}
}
