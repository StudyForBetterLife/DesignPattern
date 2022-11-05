package strategy.behavior.impl;

import strategy.behavior.QuackBehavior;

public class LoudQuack implements QuackBehavior  {

  @Override
  public void quack() {
    System.out.println("quack : LoudQuack 시끄럽게 꽥");    
  }
  
}
