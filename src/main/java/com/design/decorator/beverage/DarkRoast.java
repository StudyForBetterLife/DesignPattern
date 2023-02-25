package decorator.beverage;

import decorator.beverage.base.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "다크 로스트 커피"; // description 변수는 Beverage로부터 상속받음
    }

    @Override
    public double cost() {
        return 0.99 * sizeCostMap.get(super.getSize());
    }
}
