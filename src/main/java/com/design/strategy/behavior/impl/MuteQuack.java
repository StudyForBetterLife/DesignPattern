package com.design.strategy.behavior.impl;

import com.design.strategy.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("quack : MuteQuack 울지 않음");    
  }
  
}
