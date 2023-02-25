package com.design.strategy.ducks;

import com.design.strategy.behavior.impl.FlyWithWings;
import com.design.strategy.behavior.impl.LoudQuack;
import com.design.strategy.base.Duck;

public class MallardDuck extends Duck {

  public MallardDuck() {
    flyBehavior = new FlyWithWings();
    quackBehavior = new LoudQuack();
  }

  @Override
  public void display() {
    System.out.println("display : MallardDuck");    
  }
  
}
