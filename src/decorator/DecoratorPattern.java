package decorator;

import decorator.beverage.DarkRoast;
import decorator.beverage.Espresso;
import decorator.beverage.HouseBlend;
import decorator.beverage.base.Beverage;
import decorator.beverage.enums.Size;
import decorator.decorator.Mocha;
import decorator.decorator.Soy;
import decorator.decorator.Whip;

public class DecoratorPattern {
    public static void main(String[] args) {
        decorating();
        decoratingWithSize();
    }

    private static void decorating() {
        final Beverage espresso = new Espresso();
        printBeverage(espresso);

        Beverage darkRoast = new DarkRoast();
        printBeverage(darkRoast); // 일반 다크 로스트 커피

        darkRoast = new Mocha(darkRoast); // mocha로 감싸기
        darkRoast = new Mocha(darkRoast); // mocha로 한 번 더 감싸기
        darkRoast = new Whip(darkRoast); // 휘핑크림 추가
        printBeverage(darkRoast); // 모카샷2 + 휘핑크림 추가한 다크 로스트 커피

        Beverage houseBlend = new HouseBlend();
        printBeverage(houseBlend); // 일반 하우스 블랜드 커피

        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        printBeverage(houseBlend); // 두유 + 모카샷 + 휘핑크림 추가한 블랜드 커피
    }

    private static void decoratingWithSize() {
        Beverage darkRoast = new DarkRoast();
        printBeverage(darkRoast); // 톨 사이즈의 다크 로스트 커피

        darkRoast.setSize(Size.VENTI);
        printBeverage(darkRoast); // 벤티 사이즈의 다크 로스트 커피

        darkRoast = new Mocha(darkRoast); // mocha로 감싸기
        darkRoast = new Mocha(darkRoast); // mocha로 한 번 더 감싸기
        darkRoast = new Whip(darkRoast); // 휘핑크림 추가
        printBeverage(darkRoast); // 모카샷2 + 휘핑크림 추가한 벤티 사이즈의 다크 로스트 커피
    }

    private static void printBeverage(Beverage beverage) {
        System.out.println(beverage.getSize() + ": " + beverage.getDescription() + " $" + beverage.cost());
    }
}
