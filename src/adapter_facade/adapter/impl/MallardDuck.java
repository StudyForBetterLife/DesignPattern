package adapter_facade.adapter.impl;

import adapter_facade.adapter.Duck;

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("꽥");
    }

    @Override
    public void fly() {
        System.out.println("날고 있음");
    }
}
