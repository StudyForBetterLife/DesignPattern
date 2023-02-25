package com.design.state.state;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    default void refill(int count) {
        System.out.println("알맹이가 매진되지 않았습니다");
    }
}
