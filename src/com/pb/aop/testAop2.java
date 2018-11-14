package com.pb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class testAop2 {
    
	@Before("execution(* com.pb.model.*.*(..))")
	public void test() {
		System.out.println("注解执行aop");
	}
}
