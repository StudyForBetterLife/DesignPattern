package decorator.beverage.base;

import decorator.beverage.enums.Size;

import java.util.EnumMap;

public abstract class Beverage {

    protected static final EnumMap<Size, Double> sizeCostMap;

    static {
        sizeCostMap = new EnumMap<>(Size.class);
        sizeCostMap.put(Size.TALL, 1.0);
        sizeCostMap.put(Size.GRANDE, 1.2);
        sizeCostMap.put(Size.VENTI, 1.5);
    }

    protected Size size = Size.TALL;
    protected String description = "제목 없음";

    // 추상 클래스에서 getDescription() 을 미리 구현됨.
    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    // cost() 는 서브 클래스에서 구현해야 함.
    public abstract double cost();
}
