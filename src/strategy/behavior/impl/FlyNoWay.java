package strategy.behavior.impl;

import strategy.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("fly : FlyNoWay 날 수 없음");
  }

}
