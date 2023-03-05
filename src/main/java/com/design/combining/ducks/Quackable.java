package com.design.combining.ducks;

import com.design.combining.observer.observable.QuackObservable;

public interface Quackable extends QuackObservable {
    void quack();
}
