package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

/**
 * 测试前置增强
 */
public class BeforeAdviceTest {

  @Test
  public void before() {
    // 目标类对象
    Waiter target = new NaiveWaiter();
    // 前置增强
    BeforeAdvice advice = new GreetingBeforeAdvice();
    // 代理工厂
    ProxyFactory pf = new ProxyFactory();
    // 指定对接口进行代理
    pf.setInterfaces(target.getClass().getInterfaces());
    // 启动优化，使用Cglib2AopProxy代理
    pf.setOptimize(true);
    // 设置代理目标
    pf.setTarget(target);
    // 为代理目标添加增强
    pf.addAdvice(advice);
    // 生成代理对象
    Waiter proxy = (Waiter) pf.getProxy();
    proxy.greetTo("John");
    proxy.serveTo("Tom");
  }
}
