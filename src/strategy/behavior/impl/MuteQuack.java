package strategy.behavior.impl;

import strategy.behavior.QuackBehavior;

public class MuteQuack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("quack : MuteQuack μΈμ§ μμ");    
  }
  
}
