package com.design.combining.factory;

import com.design.combining.decorator.QuackCounter;
import com.design.combining.ducks.*;

/**
 * 클라이언트는 해당 팩토리 클래스로부터 만들어진 객체가 어떤식으로 만들어지는지 알 수 없다.
 * (QuackCounter 데코레이터로 감싼 Quackable 객체가 리턴 됨)
 */
public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
