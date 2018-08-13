package com.smart.introduce;

/**
 * 目标类需要实现的接口
 */
public interface Monitorable {

  /**
   * 控制业务类性能监视功能的激活和关闭状态
   *
   * @param active 取值为true时,激活。反之关闭
   */
  void setMonitorActive(boolean active);
}
