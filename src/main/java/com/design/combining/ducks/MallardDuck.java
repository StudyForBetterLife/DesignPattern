package com.design.combining.ducks;

import com.design.combining.observer.observable.Observable;
import com.design.combining.observer.observer.Observer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MallardDuck implements Quackable {
    private final Observable observable;

    public MallardDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        log.info("꽥꽥");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
