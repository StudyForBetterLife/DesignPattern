package com.design.combining.observer.observable;

import com.design.combining.observer.observer.Observer;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 등록 및 연락용 코드를 Observable 클래스에 캡슐화한다.
 * - Observable 객체를 QuackObservable 구상 클래스의 클래스 변수로 추가한다.
 */
@RequiredArgsConstructor
public class Observable implements QuackObservable {
    private final List<Observer> observers = new ArrayList<>();
    private final QuackObservable duck;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}
