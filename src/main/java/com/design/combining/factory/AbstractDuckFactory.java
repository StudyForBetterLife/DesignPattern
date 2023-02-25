package com.design.combining.factory;

import com.design.combining.ducks.Quackable;

/**
 * 해당 추상 클래스의 구상클래스(팩토리)로 다양한 종류의 객체를 만들 수 있다.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
