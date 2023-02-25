package proxy.remote.state.impl;

import proxy.remote.GumballMachine;
import proxy.remote.state.State;

public class SoldState implements State {
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 넣음");
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
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarter());
        } else {
            System.out.println("gumballs가 부족합니다");
            gumballMachine.setState(gumballMachine.getSoldOut());
        }
    }


}
