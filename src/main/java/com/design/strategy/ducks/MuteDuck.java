package com.design.strategy.ducks;

import com.design.strategy.behavior.impl.FlyNoWay;
import com.design.strategy.behavior.impl.MuteQuack;
import com.design.strategy.base.Duck;

public class MuteDuck extends Duck {

  public MuteDuck() {
    flyBehavior = new FlyNoWay();
    quackBehavior = new MuteQuack();
  }

  @Override
  public void display() {
    System.out.println("display : MuteDuck");
  }
}
