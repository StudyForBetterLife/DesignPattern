package proxy.remote.state.impl;

import proxy.remote.GumballMachine;
import proxy.remote.state.State;

import java.util.Random;

public class HasQuarterState implements State {

    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine; // 직렬화를 원치않는 변수는 transient 키워드를 붙힌다.
    private final Random random = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전을 한 개만 넣어주세요");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전이 반환됩니다.");
        gumballMachine.setState(gumballMachine.getNoQuarter());
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌리셨습니다");
        int winner = random.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinner());
        } else {
            gumballMachine.setState(gumballMachine.getSold());
        }
    }

    @Override
    public void dispense() {
        System.out.println("알맹이를 내보낼 수 없습니다");
    }
}
