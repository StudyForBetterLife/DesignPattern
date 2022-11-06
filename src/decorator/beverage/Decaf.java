package decorator.beverage;

import decorator.beverage.base.Beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "디카페인 커피"; // description 변수는 Beverage로부터 상속받음
    }

    @Override
    public double cost() {
        return 0.89 * sizeCostMap.get(super.getSize());
    }
}
