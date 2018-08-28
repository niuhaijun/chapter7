package com.smart.advisor;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] args, Object obj) throws Throwable {
    String clientName = (String) args[0];
    System.out.println(obj.getClass().getName() + "." + method.getName());
    System.out.println("How are you！Mr." + clientName + ".");
  }
}
