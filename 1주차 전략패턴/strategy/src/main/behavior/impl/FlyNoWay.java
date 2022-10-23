package main.behavior.impl;

import main.behavior.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

  @Override
  public void fly() {
    System.out.println("fly : FlyNoWay 날 수 없음");
  }

}
