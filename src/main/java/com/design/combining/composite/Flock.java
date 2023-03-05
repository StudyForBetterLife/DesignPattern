package com.design.combining.composite;

import com.design.combining.ducks.Quackable;
import com.design.combining.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> ducks = new ArrayList<>();

    /**
     * 안전하지만 투명성이 떨어지는 디자인이다.
     * - 클라이언트가 Quackable 객체를 추가하려는 객체가 Flock인지를 확실하게 알아야 하기 때문.
     */
    public void add(Quackable duck) {
        ducks.add(duck);
    }

    /**
     * 반복자 패턴 대신 enhanced for loop을 사용해도 된다.
     * 다만 컬랙션 속 엘리먼트를 변경할 경우, 반복자 패턴(iterator)를 사용해야 한다.
     * - for loop를 사용하면 ConcurrentModificationException가 발생하기 때문.
     */
    @Override
    public void quack() {
        for (Quackable duck : ducks) {
            duck.quack();
        }

    }

    @Override
    public void registerObserver(final Observer observer) {
        for (Quackable duck : ducks) {
            observer.update(duck);
        }

    }

    @Override
    public void notifyObservers() {

    }
}
