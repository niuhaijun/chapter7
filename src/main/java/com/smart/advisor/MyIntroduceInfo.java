package com.smart.advisor;

import com.smart.introduce.Monitorable;
import org.springframework.aop.support.IntroductionInfoSupport;

public class MyIntroduceInfo extends IntroductionInfoSupport {

  public MyIntroduceInfo() {
    super();
    super.publishedInterfaces.add(Monitorable.class);
  }
}
