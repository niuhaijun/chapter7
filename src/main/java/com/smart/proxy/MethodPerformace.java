package com.smart.proxy;

/**
 * 记录开始执行时间，执行完毕时间
 */
public class MethodPerformace {

  private long begin;
  private long end;
  private String serviceMethod;

  public MethodPerformace(String serviceMethod) {
    reset(serviceMethod);
  }

  public void printPerformace() {
    end = System.currentTimeMillis();
    long elapse = end - begin;
    System.out.println(serviceMethod + "花费" + elapse + "毫秒。");
  }

  public void reset(String serviceMethod) {
    this.serviceMethod = serviceMethod;
    this.begin = System.currentTimeMillis();
  }
}
