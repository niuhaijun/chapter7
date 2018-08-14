package com.smart.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 引介增强
 */
public class IntroduceTest {

  @Test
  public void testIntroductionInterceptor() {
    String configPath = "com/smart/introduce/beans.xml";
    ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
    ForumService forumService = (ForumService) ctx.getBean("forumService");
    forumService.removeForum(10);
    forumService.removeTopic(1022);

    System.out.println("===============================");

    Monitorable moniterable = (Monitorable) forumService;
    moniterable.setMonitorActive(true);
    forumService.removeForum(10);
    forumService.removeTopic(1022);
  }
}
