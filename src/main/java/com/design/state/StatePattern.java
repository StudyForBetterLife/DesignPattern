package com.design.state;

import com.design.state.context.GumballMachine;

public class StatePattern {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        for (int i = 0; i < 10; i++) {
            System.out.println(gumballMachine);
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            if (gumballMachine.getCount() == 0) {
                gumballMachine.refill(10);
            }
        }

    }
}
