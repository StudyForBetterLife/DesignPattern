package main.behavior.impl;

import main.behavior.QuackBehavior;

public class LoudQuack implements QuackBehavior  {

  @Override
  public void quack() {
    System.out.println("quack : LoudQuack 시끄럽게 꽥");    
  }
  
}
