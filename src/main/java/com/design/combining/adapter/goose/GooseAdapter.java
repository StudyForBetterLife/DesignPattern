package com.design.combining.adapter.goose;

import com.design.combining.ducks.Quackable;
import com.design.combining.observer.observable.Observable;
import com.design.combining.observer.observer.Observer;

/**
 * Duck 자리에 Goose 인스턴스가 호환될 수 있도록 어댑터를 활용한다.
 */
public class GooseAdapter implements Quackable {
    private final Goose goose;
    private final Observable observable;

    public GooseAdapter(final Goose goose) {
        this.goose = goose;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
    }

    @Override
    public void registerObserver(final Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
