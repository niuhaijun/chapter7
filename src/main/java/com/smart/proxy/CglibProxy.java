package com.smart.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clazz) {
    enhancer.setSuperclass(clazz);//设置需要被代理的目标类
    enhancer.setCallback(this);
    return enhancer.create();//通过字节码技术动态创建子类实例
  }

  /**
   * 拦截父类，也就是目标类所有方法的调用。将横切逻辑与业务逻辑编织在一起
   * @param obj 目标类的对象
   * @param method 方法类方法的对象
   * @param args 动态入参
   * @param proxy 代理类实例
   * @return 方法返回值
   * @throws Throwable 异常
   */
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
    Object result = proxy.invokeSuper(obj, args);
    PerformanceMonitor.end();
    return result;
  }
}
