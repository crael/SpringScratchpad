package com.aa.selfservice.cs.scratchpad.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/*
 * A simple implementation of various Advice interfaces to print text to the console.  This demonstrates
 * using AOP for logging without having to explicitly add logging calls to the method in question.
 */
public class DoSomethingAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor  {

	@Override
	public void before(Method m, Object[] args, Object target)
			throws Throwable {
		System.out.format("*****   BEFORE CALL: %s.%s(%f, %f)%n",
				target.getClass().getName(),
				m.getName(),
				(double)args[0],
				(double)args[1]);
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method m = invocation.getMethod();
		Object[] args = invocation.getArguments();
		Object target = invocation.getThis();
		
		System.out.format("*****   AROUND CALL: %s.%s(%f, %f)%n",
				target.getClass().getName(),
				m.getName(),
				(double)args[0],
				(double)args[1]);
		
		Object returnValue = invocation.proceed();
		
		System.out.format("***** AROUND RETURN: %s.%s(%f, %f) = %f%n",
				target.getClass().getName(),
				m.getName(),
				(double)args[0],
				(double)args[1],
				(double)returnValue);

		return returnValue;
	}

	@Override
	public void afterReturning(Object returnValue, Method m, Object[] args, Object target) 
			throws Throwable {
		System.out.format("***** AFTER RETURN: %s.%s(%f, %f) = %f%n",
				target.getClass().getName(),
				m.getName(),
				(double)args[0],
				(double)args[1],
				(double)returnValue);
	}
}
