package main.ducks;

import main.base.Duck;
import main.behavior.impl.FlyWithWings;
import main.behavior.impl.LoudQuack;

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
