package com.design.strategy.behavior.impl;

import com.design.strategy.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("fly : FlyWithWings 날개로 파닥파닥");    
  }
  
}
