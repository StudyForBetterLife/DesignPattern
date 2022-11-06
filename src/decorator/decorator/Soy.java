package decorator.decorator;

import decorator.beverage.base.Beverage;
import decorator.decorator.base.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        // 장식하고 있는 객체(beverage)에 cost() 작업을 위임하여 리턴값을 구한뒤
        // 그 결과에 두유 가격을 사이즈게 맞게 추가로 계산
        return beverage.cost() + 0.11;
    }

    @Override
    public String getDescription() {
        // 장식하고 있는 객체(beverage)에 대한 설명에
        // 그 결과에 두유에 대한 설명을 추가로 붙힘
        return beverage.getDescription() + ", 두유";
    }
}
