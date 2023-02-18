package proxy.gumball.state.impl;

import proxy.gumball.GumballMachine;
import proxy.gumball.state.State;

public class SoldOutState implements State {
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;

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
}
