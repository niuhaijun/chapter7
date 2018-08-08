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
    // 被代理的目标业务类
    ForumService target = new ForumServiceImpl();
    // 将目标业务类与横切代码编织在一起
    PerformaceHandler handler = new PerformaceHandler(target);
    ForumService proxy = (ForumService) Proxy.newProxyInstance(
        target.getClass().getClassLoader(),//类加载器
        target.getClass().getInterfaces(),//创建代理实例所需实现的一组接口
        handler);//整合了业务逻辑与横切逻辑的编织器对象
    proxy.removeForum(10);
    proxy.removeTopic(1012);
  }

  /**
   * 使用CGLib动态代理
   */
  @Test
  public void cglibProxy() {
    CglibProxy cglibProxy = new CglibProxy();
    // 通过动态生成子类的方式创建代理类
    ForumService forumService = (ForumService) cglibProxy.getProxy(ForumServiceImpl.class);
    forumService.removeForum(10);
    forumService.removeTopic(1023);
  }


}
