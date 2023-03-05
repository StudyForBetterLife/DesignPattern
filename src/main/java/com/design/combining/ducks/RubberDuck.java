package com.design.combining.ducks;

import com.design.combining.observer.observable.Observable;
import com.design.combining.observer.observer.Observer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RubberDuck implements Quackable {
    private final Observable observable;

    public RubberDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        log.info("삑삑");
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
