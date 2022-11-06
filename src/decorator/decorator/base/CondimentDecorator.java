package decorator.decorator.base;

import decorator.beverage.base.Beverage;
import decorator.beverage.enums.Size;

/**
 * 첨가물
 */
public abstract class CondimentDecorator extends Beverage {
    /**
     * 각 데코레이터가 감쌀 음료를 나타내는 Beverage 객체를 저장할 인스턴스 변수.
     * 모든 Beverage의 구상 클래스를 담기 위해 "Beverage"라는 슈퍼클래스 유형을 사용한다.
     * <p>
     * Wrapping 하여 데코레이팅한다.
     */
    protected Beverage beverage;

    @Override
    public abstract String getDescription();

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
