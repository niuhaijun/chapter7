package com.smart.introduce;

public class MethodPerformance {

  private long begin;
  private long end;
  private String serviceMethod;

  public MethodPerformance(String serviceMethod) {
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
