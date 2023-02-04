package state.state.impl;

import state.context.GumballMachine;
import state.state.State;

public class SoldOutState implements State {
    private final GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("매진 되었습니다");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("매진 되었습니다");
    }

    @Override
    public void turnCrank() {
        System.out.println("매진 되었습니다");
    }

    @Override
    public void dispense() {
        System.out.println("매진 되었습니다. 알맹이를 내보낼 수 없습니다");
    }

    @Override
    public void refill(int count) {
        gumballMachine.setState(gumballMachine.getNoQuarter());
    }
}
