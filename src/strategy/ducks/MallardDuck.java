package strategy.ducks;

import strategy.behavior.impl.FlyWithWings;
import strategy.behavior.impl.LoudQuack;
import strategy.base.Duck;

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
