package main;

import main.base.Duck;
import main.behavior.impl.FlyRocketPowered;
import main.ducks.MallardDuck;
import main.ducks.MuteDuck;

public class App {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display(); // display : MallardDuck
        mallardDuck.performFly(); // fly : FlyWithWings 날개로 파닥파닥
        mallardDuck.performQuack(); // quack : LoudQuack 시끄럽게 꽥

        Duck muteDuck = new MuteDuck();
        muteDuck.display(); // display : MuteDuck
        muteDuck.performFly(); // fly : FlyNoWay 날 수 없음
        muteDuck.performQuack(); // quack : MuteQuack 울지 않음

        muteDuck.setFlyBehavior(new FlyRocketPowered());
        muteDuck.performFly(); // fly : FlyRocketPowered 로켓 추진으로 날기
    }
}
