package main.base;

import main.behavior.FlyBehavior;
import main.behavior.QuackBehavior;

public abstract class Duck {
  protected FlyBehavior flyBehavior; // 레퍼런스 변수
  protected QuackBehavior quackBehavior;

  protected Duck() {}
  public abstract void display();

  public void performFly() {
    flyBehavior.fly(); // 레퍼런스 변수에 위임
  }

  public void performQuack() {
    quackBehavior.quack();
  }

  public void swim() {
    System.out.println("모든 오리는 물에 뜬다.");
  }

  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
