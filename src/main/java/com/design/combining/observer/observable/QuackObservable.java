package com.design.combining.observer.observable;


import com.design.combining.observer.observer.Observer;

/**
 * 해당 인터페이스는 Quackable에서 구현하도록 한다.
 */
public interface QuackObservable {
    /**
     * Observer 등록 메소드.
     */
    void registerObserver(Observer observer);


    /**
     * Observer에게 연락을 돌리는 메소드.
     */
    void notifyObservers();
}
