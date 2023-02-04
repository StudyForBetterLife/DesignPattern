package state.state.impl;

import state.context.GumballMachine;
import state.state.State;

public class NoQuarterState implements State {
    private final GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 넣음");
        gumballMachine.setState(gumballMachine.getHasQuarter());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전을 넣어 주세요");
    }

    @Override
    public void turnCrank() {
        System.out.println("동전을 넣어 주세요");
    }

    @Override
    public void dispense() {
        System.out.println("동전을 넣어 주세요");
    }
}
