package com.design.combining.ducks;

import com.design.combining.observer.observable.Observable;
import com.design.combining.observer.observer.Observer;
import lombok.extern.slf4j.Slf4j;

/**
 * 오리 호출기（사냥꾼이 오리를 찾을 때 쓰는 기계).
 */
@Slf4j
public class DuckCall implements Quackable {

    private final Observable observable;

    public DuckCall() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        log.info("꽉꽉");
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
