package com.design.state.state.impl;

import com.design.state.context.GumballMachine;
import com.design.state.state.State;

public class WinnerState implements State {
    private final GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOut());
        } else {
            gumballMachine.releaseBall();
            System.out.println("축하합니다! 알맹이를 하나 더 받을 수 있어요");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarter());
            } else {
                System.out.println("더이상의 알맹이가 없습니다.");
                gumballMachine.setState(gumballMachine.getSoldOut());
            }
        }
    }
}
