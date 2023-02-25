package com.design.combining.decorator;

import com.design.combining.ducks.Quackable;
import com.design.combining.observer.observer.Observer;
import lombok.RequiredArgsConstructor;

/**
 * decorator인 QuackCounter는
 * 어댑터와 마찬가지로 타깃 인터페이스(Quackable)을 구현해야 한다.
 */
@RequiredArgsConstructor
public class QuackCounter implements Quackable {
    private final Quackable duck;
    static int numberOfQuacks;

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registerObserver(final Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
