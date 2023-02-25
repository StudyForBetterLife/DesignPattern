package com.design.strategy.behavior.impl;

import com.design.strategy.behavior.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("fly : FlyRocketPowered 로켓 추진으로 날기");    
  }
  
}
