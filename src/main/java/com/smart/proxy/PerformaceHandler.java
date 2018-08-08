package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformaceHandler implements InvocationHandler {

  private Object target;

  /**
   * 目标业务类
   *
   * @param target 目标类
   */
  public PerformaceHandler(Object target) {
    this.target = target;
  }

  /**
   * 将横切逻辑与业务逻辑编织在一起
   *
   * @param proxy 代理对象
   * @param method 放射方法对象
   * @param args 方法入参
   * @return 目标类方法返回值
   * @throws Throwable 异常
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
    /**
     * 通过反射方法调用业务类的目标方法
     */
    Object obj = method.invoke(target, args);
    PerformanceMonitor.end();
    return obj;
  }
}
