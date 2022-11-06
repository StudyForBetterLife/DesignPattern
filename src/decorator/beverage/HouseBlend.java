package decorator.beverage;

import decorator.beverage.base.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "하우스 블렌드 커피"; // description 변수는 Beverage로부터 상속받음
    }

    @Override
    public double cost() {
        return 0.89 * sizeCostMap.get(super.getSize());
    }
}
