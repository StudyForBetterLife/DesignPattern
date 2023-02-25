package proxy.remote;

import proxy.remote.state.State;
import proxy.remote.state.impl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    private static final long serialVersionUID = 2L; // serialVersionUID: UnicastRemoteObject가 Serializable을 구현하기 때문에 필요한 필드.
    private final State soldOut;
    private final State noQuarter;
    private final State hasQuarter;
    private final State sold;
    private final State winner;
    private State state;
    private int count = 0;
    private String location;

    // 슈퍼클래스 생성자가 어떤 예외를 던진다면 서브클래 스의 생성자도 그 예외를 선언해야 한다. (RemoteException)
    public GumballMachine(String location, int numberGumballs) throws RemoteException {
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
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
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
