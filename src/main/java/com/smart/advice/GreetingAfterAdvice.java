package com.smart.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

  @Override
  public void afterReturning(Object returnObj, Method method, Object[] args,
      Object obj) throws Throwable {
    System.out.println("Please enjoy yourself!");
  }
}
