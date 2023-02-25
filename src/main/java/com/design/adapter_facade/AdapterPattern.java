package com.design.adapter_facade;

import com.design.adapter_facade.adapter.Duck;
import com.design.adapter_facade.adapter.Turkey;
import com.design.adapter_facade.adapter.TurkeyAdapter;
import com.design.adapter_facade.adapter.impl.MallardDuck;
import com.design.adapter_facade.adapter.impl.WildTurkey;


/**
 * Duck: 타겟 인터페이스
 * Turkey: adaptee 인터페이스
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        testDuck(mallardDuck);

        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        testDuck(turkeyAdapter);
    }

    /**
     * 클라이언트는 중간에 어댑터가 있는 사실을 모름
     */
    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
