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
