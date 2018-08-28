package com.smart.advisor;

import com.smart.aop.BeanSelfProxyAware;

public class Waiter implements BeanSelfProxyAware {

  private Waiter waiter;

  @Override
  public void setSelfProxy(Object object) {
    waiter = (Waiter) object;
  }

  public void serveTo(String name) {
    System.out.println("waiter serving " + name + "...");
  }

  public void greetTo(String name) {
    System.out.println("waiter greet to " + name + "...");
  }
}
