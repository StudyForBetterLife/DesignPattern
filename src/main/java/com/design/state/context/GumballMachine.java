package com.design.state.context;

import com.design.state.state.State;
import com.design.state.state.impl.*;

public class GumballMachine {

    private final State soldOut;
    private final State noQuarter;
    private final State hasQuarter;
    private final State sold;
    private final State winner;
    private State state;
    private int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOut = new SoldOutState(this);
        noQuarter = new NoQuarterState(this);
        hasQuarter = new HasQuarterState(this);
        sold = new SoldState(this);
        winner = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarter;
        } else {
            state = soldOut;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void releaseBall() {
        System.out.println("알맹이를 내보내고 있습니다");
        if (count > 0) {
            count--;
        }
    }

    public void refill(int count) {
        this.count += count;
        System.out.println("리필 되었습니다. count=" + this.count);
        state.refill(count);
    }

    public int getCount() {
        return count;
    }

    public State getSoldOut() {
        return soldOut;
    }

    public State getNoQuarter() {
        return noQuarter;
    }

    public State getHasQuarter() {
        return hasQuarter;
    }

    public State getSold() {
        return sold;
    }

    public State getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state.getClass().getSimpleName() +
                ", count=" + count +
                '}';
    }
}
