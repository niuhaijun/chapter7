package com.smart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 */
public class GreetingInterceptor implements MethodInterceptor {

  /**
   * 横切逻辑
   *
   * @param invocation 该对象不仅封装了目标方法以及入参，还封装了目标方法所在的实例对象
   * @return 返回值
   * @throws Throwable 异常
   */
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    // 目标方法入参
    Object[] args = invocation.getArguments();
    String clientName = (String) args[0];
    System.out.println("How are you！Mr." + clientName + ".");
    Object obj = invocation.proceed();
    System.out.println("Please enjoy yourself!");
    return obj;
  }
}
