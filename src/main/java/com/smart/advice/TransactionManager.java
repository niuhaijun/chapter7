package com.smart.advice;

import java.lang.reflect.Method;
import org.springframework.aop.ThrowsAdvice;

/**
 * 异常抛出增强
 */
public class TransactionManager implements ThrowsAdvice {

  /**
   * ThrowsAdvice是一个标记接口， 方法名必须为afterThrowing，
   *
   * @param method 目标方法对象
   * @param args 目标方法入参，前三个入参要么全有，要么全没有
   * @param target 目标对象
   * @param ex 目标方法抛出的异常对象
   * @throws Throwable 异常
   */
  public void afterThrowing(Method method, Object[] args, Object target, Exception ex)
      throws Throwable {
    System.out.println("-----------");
    System.out.println("method:" + method.getName());
    System.out.println("抛出异常:" + ex.getMessage());
    System.out.println("成功回滚事务。");
  }
}
