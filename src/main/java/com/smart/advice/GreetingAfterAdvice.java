package com.smart.advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

  /**
   * 横切逻辑
   *
   * @param returnObj 目标实例方法返回的结果
   * @param method 目标类的方法
   * @param args 目标实例方法的入参
   * @param obj 目标类实例
   * @throws Throwable 异常
   */
  @Override
  public void afterReturning(Object returnObj, Method method, Object[] args,
      Object obj) throws Throwable {
    System.out.println("Please enjoy yourself!");
  }
}
