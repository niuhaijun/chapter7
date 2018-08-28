package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 动态切面
 */
public class DynamicAdvisorTest {

  @Test
  public void dynamic() {
    String configPath = "com/smart/advisor/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter2", Waiter.class);
    waiter.serveTo("Peter");
    waiter.greetTo("Peter");
    waiter.serveTo("Peter");
    waiter.greetTo("John");
  }
}
/*
调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.serveTo做静态检查.
调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.greetTo做静态检查.
调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.setSelfProxy做静态检查.
调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.toString做静态检查.
调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.clone做静态检查.

调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.serveTo做静态检查.
waiter serving Peter...

调用getClassFilter()对com.smart.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.smart.advisor.Waiter.greetTo做静态检查.
调用matches(method,clazz,args)对com.smart.advisor.Waiter.greetTo做动态检查.
waiter greet to Peter...

waiter serving Peter...

调用matches(method,clazz,args)对com.smart.advisor.Waiter.greetTo做动态检查.
com.smart.advisor.Waiter.greetTo
How are you！Mr.John.
waiter greet to John...
*/