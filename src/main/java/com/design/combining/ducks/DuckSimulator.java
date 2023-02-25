package com.design.combining.ducks;

import com.design.combining.composite.Flock;
import com.design.combining.decorator.QuackCounter;
import com.design.combining.adapter.goose.Goose;
import com.design.combining.adapter.goose.GooseAdapter;
import com.design.combining.factory.AbstractDuckFactory;
import com.design.combining.factory.CountingDuckFactory;
import com.design.combining.observer.observer.Quackologist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulateAdapter();
        duckSimulator.simulateDecorator();
        duckSimulator.simulateFactory(new CountingDuckFactory());
        duckSimulator.simulateComposite(new CountingDuckFactory());
        duckSimulator.simulateObserver(new CountingDuckFactory());
    }

    private void simulateAdapter() {
        MallardDuck mallardDuck = new MallardDuck();
        RedheadDuck redheadDuck = new RedheadDuck();
        DuckCall duckCall = new DuckCall();
        RubberDuck rubberDuck = new RubberDuck();
        GooseAdapter gooseDuck = new GooseAdapter(new Goose()); // 어댑터로 Goose를 Duck으로 변환한다.

        log.warn("오리 시뮬레이션 게임 (+어댑터)\n");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    private void simulateDecorator() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        GooseAdapter gooseDuck = new GooseAdapter(new Goose()); // 어댑터로 Goose를 Duck으로 변환한다.

        log.warn("오리 시뮬레이션 게임 (+데코레이터)\n");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        log.info("오리가 소리를 낸 횟수 : {}번", QuackCounter.getNumberOfQuacks());
    }

    private void simulateFactory(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        GooseAdapter gooseDuck = new GooseAdapter(new Goose()); // 어댑터로 Goose를 Duck으로 변환한다.

        log.warn("오리 시뮬레이션 게임 (+추상 팩토리)\n");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        log.info("오리가 소리를 낸 횟수 : {}번", QuackCounter.getNumberOfQuacks());
    }

    private void simulateComposite(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        GooseAdapter gooseDuck = new GooseAdapter(new Goose()); // 어댑터로 Goose를 Duck으로 변환한다.

        log.warn("오리 시뮬레이션 게임 (+컴포지트 패턴)\n");

        final Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(gooseDuck);

        simulate(flock);

        log.info("오리가 소리를 낸 횟수 : {}번", QuackCounter.getNumberOfQuacks());
    }

    private void simulateObserver(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        GooseAdapter gooseDuck = new GooseAdapter(new Goose()); // 어댑터로 Goose를 Duck으로 변환한다.

        log.warn("오리 시뮬레이션 게임 (+옵저버 패턴)\n");

        final Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(gooseDuck);

        final Quackologist quackologist = new Quackologist();
        flock.registerObserver(quackologist);


        simulate(flock);

        log.info("오리가 소리를 낸 횟수 : {}번", QuackCounter.getNumberOfQuacks());
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
