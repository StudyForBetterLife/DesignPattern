package com.design.adapter_facade.adapter;

/**
 * Duck 객체 대신 Turkey 객체를 사용하기 위해 적용할 어댑터
 * <p>
 * - Turkey : adaptee 인스턴스
 * - Duck : 타겟 인터페이스
 */
public class TurkeyAdapter implements Duck {

    private final Turkey turkey; // adaptee 인스턴스

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }


    /**
     * quack, fly : target request
     */
    @Override
    public void quack() {
        // translated request
        turkey.gobble();
    }

    @Override
    public void fly() {
        // translated request
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
