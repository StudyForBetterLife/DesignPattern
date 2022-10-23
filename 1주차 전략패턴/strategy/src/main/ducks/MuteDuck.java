package main.ducks;

import main.base.Duck;
import main.behavior.impl.FlyNoWay;
import main.behavior.impl.MuteQuack;

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
