package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdviceTest {

  @Test
  public void advice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter", Waiter.class);
    waiter.greetTo("John");
  }
}
