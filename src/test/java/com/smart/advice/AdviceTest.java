package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdviceTest {

  // BeforeAdvice
  @Test
  public void testBeforeAdvice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter1", Waiter.class);
    waiter.greetTo("John");
  }

  // AfterAdvice
  @Test
  public void testAfterAdvice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter2", Waiter.class);
    waiter.serveTo("John");
  }

  // AfterAdvice and AfterAdvice
  @Test
  public void testAfterAdviceAndAfterAdvice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter3", Waiter.class);
    waiter.greetTo("Tom");
    waiter.serveTo("John");
  }

  // AroundAdvice
  @Test
  public void testAroundAdvice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    Waiter waiter = ctx.getBean("waiter4", Waiter.class);
    waiter.greetTo("Tom");
  }

  // ThrowsAdvice
  @Test
  public void testThrowsAdvice() {
    String configPath = "com/smart/advice/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    ForumService forumService = ctx.getBean("forumService", ForumService.class);
    try {
      forumService.removeForum(10);
    } catch (Exception e) {
      System.out.println(e.fillInStackTrace());
    }

    try {
      forumService.updateForum(new Forum());
    } catch (Exception e) {
      System.out.println(e.fillInStackTrace());
    }
  }
}
