package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class StaticMethodMatcherPointcutAdvisorTest {

  @Test
  public void staticMethod() {
    String configPath = "com/smart/advisor/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter =  ctx.getBean("waiter", Waiter.class);
    Seller seller =ctx.getBean("seller", Seller.class);
    waiter.greetTo("John");
    waiter.serveTo("John");
    seller.greetTo("John");
  }
}
