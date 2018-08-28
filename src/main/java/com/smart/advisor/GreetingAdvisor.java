package com.smart.advisor;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 静态方法匹配器切点切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

  /**
   * 切点方法匹配规则：只匹配名为greetTo的方法
   */
  public boolean matches(Method method, Class clazz) {
    return "greetTo".equals(method.getName());
  }

  /**
   * 切点类匹配规则：只匹配Waiter或者Waiter的子类。默认匹配所有类
   */
  public ClassFilter getClassFilter() {
    return new ClassFilter() {
      public boolean matches(Class clazz) {
        return Waiter.class.isAssignableFrom(clazz);
      }
    };

  }
}
