package com.design.adapter_facade.adapter.impl;

import com.design.adapter_facade.adapter.Turkey;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("골골");
    }

    @Override
    public void fly() {
        System.out.println("짧게 날고 있음");
    }
}
