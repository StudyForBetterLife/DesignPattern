package com.design.combining.observer.observer;

import com.design.combining.observer.observable.QuackObservable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        log.info("꽥꽥 학자: '{}'가 방금 소리를 내었다.", duck);
    }
}
