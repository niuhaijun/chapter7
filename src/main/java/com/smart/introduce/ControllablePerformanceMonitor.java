package com.smart.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor
    implements Monitorable, Testable {

  private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

  @Override
  public void setMonitorActive(boolean active) {
    MonitorStatusMap.set(active);
  }

  @Override
  public Object invoke(MethodInvocation mi) throws Throwable {
    Object obj = null;
    if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
      PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
      obj = super.invoke(mi);
      PerformanceMonitor.end();
    } else {
      obj = super.invoke(mi);
    }
    return obj;
  }

  @Override
  public void test() {
    System.out.println("dd");
  }
}
