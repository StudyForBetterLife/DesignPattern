package factory.pizzastore;

import factory.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(Pizza.PizzaType pizzaType) {
        final Pizza pizza = createPizza(pizzaType);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // pizza 인스턴스를 만드는 작업은 팩토리 메소드에서 처리하도록 함.
    // 구상 클래스마다 서로 다른 피자를 만들기 위해 abstract으로 선언
    protected abstract Pizza createPizza(Pizza.PizzaType pizzaType);
}
