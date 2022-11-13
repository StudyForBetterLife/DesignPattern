package decorator.beverage;

import decorator.beverage.base.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "에스프레소"; // description 변수는 Beverage로부터 상속받음
    }

    @Override
    public double cost() {
        return 1.99 * sizeCostMap.get(super.getSize());
    }
}
