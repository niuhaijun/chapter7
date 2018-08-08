package com.smart.proxy;

import java.lang.reflect.Proxy;
import org.testng.annotations.Test;

public class ForumServiceTest {

  /**
   * 业务类正常编码的测试
   */
  @Test
  public void noneProxy() {
    ForumService forumService = new ForumServiceImpl();
    forumService.removeForum(10);
    forumService.removeTopic(1012);
  }

  /**
   * 使用JDK动态代理
   */
  @Test
  public void jdkProxy() {
    ForumService target = new ForumServiceImpl();
    PerformaceHandler handler = new PerformaceHandler(target);
    ForumService proxy = (ForumService) Proxy.newProxyInstance(target
        .getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    proxy.removeForum(10);
    proxy.removeTopic(1012);
  }

  /**
   * 使用CGLib动态代理
   */
  @Test
  public void cglibProxy() {
    CglibProxy cglibProxy = new CglibProxy();
    ForumService forumService = (ForumService) cglibProxy.getProxy(ForumServiceImpl.class);
    forumService.removeForum(10);
    forumService.removeTopic(1023);
  }


}
