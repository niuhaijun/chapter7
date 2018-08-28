package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 正则方法切点切面
 */
public class RegexpMethodPointcutAdvisorTest {

  @Test
  public void regexp() {
    String configPath = "com/smart/advisor/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter1", Waiter.class);
    waiter.greetTo("John");
    waiter.serveTo("John");
  }
}
