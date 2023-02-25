package com.design.combining.observer.observer;

import com.design.combining.observer.observable.QuackObservable;

public interface Observer {
    void update(QuackObservable duck);
}
