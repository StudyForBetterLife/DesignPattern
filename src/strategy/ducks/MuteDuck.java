package strategy.ducks;

import strategy.behavior.impl.FlyNoWay;
import strategy.behavior.impl.MuteQuack;
import strategy.base.Duck;

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
