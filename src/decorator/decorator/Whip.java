package decorator.decorator;

import decorator.beverage.base.Beverage;
import decorator.decorator.base.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        // 장식하고 있는 객체(beverage)에 cost() 작업을 위임하여 리턴값을 구한뒤
        // 그 결과에 휘핑크림 가격을 사이즈게 맞게 추가로 계산
        return beverage.cost() + 0.15;
    }

    @Override
    public String getDescription() {
        // 장식하고 있는 객체(beverage)에 대한 설명에
        // 그 결과에 휘핑크림에 대한 설명을 추가로 붙힘
        return beverage.getDescription() + ", 휘핑크림";
    }
}
